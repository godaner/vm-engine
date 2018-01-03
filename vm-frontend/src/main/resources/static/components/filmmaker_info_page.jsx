import React from 'react';  //引入react组件
import '../scss/filmmaker_info_page.scss';
import ActorsList from './actors_list';
import InnerMessager from './inner_messager';
import Director from "./director";
import TagsOfMovie from "./tags_of_movie";
import FlexText from "./flex_text";
import FilmmakersDetailsArea from "./filmmakers_details_area";
import MoviePlayer from "./movies_player";
import MoviesDisplayer from "./movies_displayer";
import MsgDialog from "./msg_dialog";
import PlainPanelTitle from "./plain_panel_title";
import "./events_dispatcher";
/*import '../../../public/js/ckplayer/ckplayer/ckplayer.js';*/
/*电影人详情展示页面*/
var FilmmakerInfoPage = React.createClass({
    getInitialState: function () {
        //init state
        // c(this.props.match.params.filmmakerId);
        return {
            whenFilmmakerInfoIsLoading: "正在加载电影人信息",
            filmmakerDescriptionTextLength: 150,
            filmmakerDescriptionTitle: "电影人描述 : ",
            filmmaker: {},//初次渲染需要一个空对象,而不是一个undefined
            filmmakerUrl: this.props.match.url,
            filmmakerId: this.props.match.params.filmmakerId,
            aboutFilmmakersMovies: undefined,
            aboutFilmmakersMoviesPage: {
                size: 10,
                start: 0,
                orderBy: "score",
                orderType: "desc"
            }

        };
    },
    componentDidMount: function () {
        //add resize event listener
        window.addEventListener('resize', this.onWindowResize);

        //get filmmaker
        this.getFilmmakerBasicInfo();

        //get about filmmaker movies
        this.getAboutFilmmakerMovies([this.state.filmmakerId]);

        //adjust ui
        this.adjustUI();

    },
    componentWillUnmount: function () {
        window.removeEventListener('resize', this.onWindowResize);

    },
    componentDidUpdate: function () {
        // c("componentDidUpdate");
    },
    componentWillReceiveProps: function (props) {
        //Link to!!!当点击某个Link标签时,路由会接受到一个新的props；但是如果跳转的是同一个页面,那么对不起，不会跳转，需要手动重置路由
        if (!isEmpty(this.props.match.url)) {
            this.props.history.push('/empty');
            setTimeout(() => {
                this.props.history.replace(this.props.match.url);
            }, 1);
        }

    },
    onWindowResize: function () {
        this.adjustUI();
    },
    adjustUI: function () {

    },
    lazyLoadImg: function () {
        lazyLoad();
    },

    getFilmmakerBasicInfo: function (callfun) {

        //get movie info
        const url = this.state.filmmakerUrl;

        ajax.get({
            url: url,
            onBeforeRequest: function () {
                //show tip
                this.showFilmmakerTip(this.state.whenFilmmakerInfoIsLoading);

            }.bind(this),
            onResponseStart: function () {
                //close tip
                this.showFilmmakerTip();
            }.bind(this),
            onResponseSuccess: function (result) {
                var state = this.state;

                //set movie info to state

                state.filmmaker = result.data.filmmaker;

                this.setState(state);


                //lazy load img
                this.lazyLoadImg();
            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(result.msg);
            }.bind(this),
            onResponseEnd: function () {
                //callfun
                if (callfun != undefined) {
                    callfun()
                }
            }.bind(this)
        });

    },
    showFilmmakerTip(msg, loop) {
        this.refs.innerMessager.showMsg(msg, loop);
    },

    loadingAboutFilmmakerMovies: function () {
        this.refs.aboutFilmmakersMovies_MoviesDisplayer.loadingMoviesTip();
    },
    hideAboutFilmmakerMovies: function () {
        this.refs.aboutFilmmakersMovies_MoviesDisplayer.hideMovieTip();
    },
    noAboutFilmmakerMovies: function () {
        this.refs.aboutFilmmakersMovies_MoviesDisplayer.noMoviesTip();
    },
    getAboutFilmmakerMovies(movieFilmmakerIds){

        if (isEmptyList(movieFilmmakerIds)) {
            this.noAboutFilmmakerMovies();
            return;
        }


        //set ids
        var ids = movieFilmmakerIds;
        //ajax
        var orderBy = this.state.aboutFilmmakersMoviesPage.orderBy;
        var orderType = this.state.aboutFilmmakersMoviesPage.orderType;
        var size = this.state.aboutFilmmakersMoviesPage.size;
        var start = this.state.aboutFilmmakersMoviesPage.start;


        var url = "/movie/about/filmmaker?orderBy=" + orderBy
            + "&orderType=" + orderType
            + "&size=" + size
            + "&start=" + start;
        url = contactUrlWithArray(url, "filmmakerIds", ids);


        ajax.get({
            url: url,
            onBeforeRequest: function () {

                //show tip
                this.loadingAboutFilmmakerMovies();

            }.bind(this),
            onResponseStart: function () {
                //close tip
                this.hideAboutFilmmakerMovies();
            }.bind(this),
            onResponseSuccess: function (result) {
                if (isEmptyList(result.data.movies)) {
                    this.noAboutFilmmakerMovies();
                    return;
                }
                var state = this.state;

                //set movie info to state

                state.aboutFilmmakersMovies = result.data.movies;

                this.setState(state);

                //lazy load img
                this.lazyLoadImg();
            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(result.msg);
            }.bind(this),
            onResponseEnd: function () {
            }.bind(this)
        });
    },
    render: function () {
        var birthday = timeFormatter.formatDate(this.state.filmmaker.birthday);
        return (
            <div id="movie_info_content">
                <div id="basic_info">


                    <div className="clearfix" id="movie_info_displayer">

                        <div id="filmmaker_img">
                            <img src={FILMMAKER_LOADING_IMG} data-original={this.state.filmmaker.imgUrl}/>
                        </div>
                        <div id="filmmaker_text">
                            <ul id="text_ul">
                                <InnerMessager defaultTip={this.state.whenFilmmakerInfoIsLoading}
                                               ref="innerMessager"/>
                                <li id="name_li">
                                    电影人 : <a title={this.state.filmmaker.name}
                                             href="javascript:void(0);">{this.state.filmmaker.name}</a>
                                </li>
                                <li>
                                    别名 : <a href="javascript:void(0);">{this.state.filmmaker.alias}</a>
                                </li>
                                <li>
                                    血型 : <a href="javascript:void(0);">{this.state.filmmaker.bloodType}</a>
                                </li>

                                <li>
                                    职业 : <a href="javascript:void(0);">{this.state.filmmaker.profession}</a>
                                </li>

                                <li>
                                    星座 : <a href="javascript:void(0);">{this.state.filmmaker.constellation}</a>
                                </li>
                                <li>
                                    性别 : <a href="javascript:void(0);">{this.state.filmmaker.sex}</a>
                                </li>

                                <li>
                                    生日 : <a href="javascript:void(0);">{birthday}</a>
                                </li>
                                <li>
                                    国家 : <a href="javascript:void(0);">{this.state.filmmaker.country}</a>
                                </li>


                                <li id="description_li">
                                    {/*电影简介 : <a href="javascript:void(0);">{this.state.movie.description}</a>*/}
                                    <FlexText title={this.state.filmmakerDescriptionTitle}
                                              text={this.state.filmmaker.description}
                                              maxTextLength={this.state.filmmakerDescriptionTextLength}/>
                                </li>
                            </ul>
                        </div>

                    </div>

                </div>


                <div id="about_filmmakers_movies">
                    <PlainPanelTitle title="电影人相关"/>
                    <MoviesDisplayer movies={this.state.aboutFilmmakersMovies}
                                     ref="aboutFilmmakersMovies_MoviesDisplayer"/>
                </div>

            </div>
        );
    }
});


export default FilmmakerInfoPage;
