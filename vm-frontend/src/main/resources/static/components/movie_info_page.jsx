import React from 'react';  //引入react组件
import '../scss/movie_info_page.scss';
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

var MovieInfoPage = React.createClass({
    getInitialState: function () {
        //init state
        return {
            movieDescriptionTitle: "电影简介 : ",
            whenMovieIsLoading: "加载电影信息",
            movieDescriptionTextLength: 100,
            movie: {},
            movieUrl:this.props.match.url,//请求电影基本信息的url
            targetMovieId: this.props.match.params.movieId,
            //thisMovieFilmmakerIds:undefined,
            //thisMovieTagIds:undefined,
            aboutFilmmakersMovies: undefined,
            aboutFilmmakersMoviesPage: {
                size: 10,
                start: 0,
                orderBy: "score",
                orderType: "desc"
            },
            aboutTagsMovies: undefined,
            aboutTagsMoviesPage: {
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

        //get movie
        this.getMovieBasicInfo();

        //adjust ui
        this.adjustUI();

    },
    componentWillUnmount: function () {
        window.removeEventListener('resize', this.onWindowResize);

    },
    componentDidUpdate:function(){
        // c("componentDidUpdate");
    },
    componentWillReceiveProps:function (props) {
        //Link to!!!当点击某个Link标签时,路由会接受到一个新的props；但是如果跳转的是同一个页面,那么对不起，不会跳转，需要手动重置路由
        if(!isEmpty(this.props.match.url)){
            this.props.history.push('/empty');
            setTimeout(() => {
                this.props.history.replace(this.props.match.url);
            },1);
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
    getMovieBasicInfo: function (callfun) {


        // var movieId = this.state.targetMovieId;


        //get movie info
        const url = this.state.movieUrl;


        ajax.get({
            url: url,
            onBeforeRequest: function () {
                //show tip
                this.showMovieInfoTip(this.state.whenMovieIsLoading);
            }.bind(this),
            onResponseStart: function () {
                //close tip
                this.showMovieInfoTip();
            }.bind(this),
            onResponseSuccess: function (result) {

                var state = this.state;

                //set movie info to state

                state.movie = result.data.movie;

                this.setState(state);

                //update movie description
                // this.updateMovieDescription(state.movie.description);

                //lazy load img
                this.lazyLoadImg();

            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(result.msg);
            }.bind(this),
            onResponseEnd:function(){
                // c(this.state)
                //callfun
                if (callfun != undefined) {
                    callfun()
                }
            }.bind(this)
        });


    },
    showMovieInfoTip(msg, loop) {
        this.refs.innerMessager.showMsg(msg, loop);
    },
    loadingAboutTagsMovies: function () {
        this.refs.aboutTagsMovies_MoviesDisplayer.loadingMoviesTip();
    },
    hideAboutTagsMovies: function () {
        this.refs.aboutTagsMovies_MoviesDisplayer.hideMovieTip();
    },
    noAboutTagsMovies: function () {
        this.refs.aboutTagsMovies_MoviesDisplayer.noMoviesTip();
    },
    getAboutTagsMovies: function (movieTags) {
        // c(movieTags);
        if(isEmptyList(movieTags)){

            this.noAboutTagsMovies();
            return ;
        }


        //get filmmakerIds
        var tagIds = [];
        for (var i = 0; i < movieTags.length; i++) {
            tagIds.push(movieTags[i].id);
        }
        // c(tagIds);
        //ajax
        var orderBy = this.state.aboutTagsMoviesPage.orderBy;
        var orderType = this.state.aboutTagsMoviesPage.orderType;
        var size = this.state.aboutTagsMoviesPage.size;
        var start = this.state.aboutTagsMoviesPage.start;

        var url = "/movie/about/tag?orderBy="+orderBy
            +"&orderType="+orderType
            +"&size="+size
            +"&start="+start
            +"&excludeMovieId="+this.state.targetMovieId;
        url = contactUrlWithArray(url, "tagIds", tagIds);
        ajax.get({
            url: url,
            onBeforeRequest: function () {
                //show tip
                this.loadingAboutTagsMovies();
            }.bind(this),
            onResponseStart: function () {
                //close tip
                this.hideAboutTagsMovies();
            }.bind(this),
            onResponseSuccess: function (result) {

                if(isEmptyList(result.data.movies)){
                    this.noAboutTagsMovies();
                    return ;
                }

                var state = this.state;

                //set movie info to state

                state.aboutTagsMovies = result.data.movies;

                this.setState(state);

                //lazy load img
                this.lazyLoadImg();

            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(result.msg);
            }.bind(this)
        });

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
    getAboutFilmmakerMovies(movieFilmmakers){
        if(isEmptyList(movieFilmmakers)){

            this.noAboutFilmmakerMovies();
            return ;
        }


        //get filmmakerIds
        var ids = [];
        for (var i = 0; i < movieFilmmakers.length; i++) {
            ids.push(movieFilmmakers[i].id);
        }
        //ajax
        var orderBy = this.state.aboutFilmmakersMoviesPage.orderBy;
        var orderType = this.state.aboutFilmmakersMoviesPage.orderType;
        var size = this.state.aboutFilmmakersMoviesPage.size;
        var start = this.state.aboutFilmmakersMoviesPage.start;


        var url = "/movie/about/filmmaker?orderBy="+orderBy
            +"&orderType="+orderType
            +"&size="+size
            +"&start="+start
            +"&excludeMovieId="+this.state.targetMovieId;
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

                var state = this.state;

                //set movie info to state

                state.aboutFilmmakersMovies = result.data.movies;

                this.setState(state);

                //lazy load img
                this.lazyLoadImg();

            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(result.msg);
            }.bind(this)
        });

    },
    render: function () {

        //format releaseTime
        var releaseTime = timeFormatter.formatDate(this.state.movie.releaseTime);

        return (
            <div id="movie_info_content">
                <div id="basic_info">


                    <div className="clearfix" id="movie_info_displayer">

                        <div id="movie_img">
                            <img src={MOVIE_LOADING_IMG} data-original={this.state.movie.imgUrl}/>
                        </div>
                        <div id="movie_text">
                            <ul id="text_ul">
                                <InnerMessager defaultTip={this.state.whenMovieIsLoading}
                                               ref="innerMessager"/>
                                <li id="name_li">
                                    电影 : <a href="javascript:void(0);">{this.state.movie.name}</a>
                                </li>
                                <li>
                                    别名 : <a href="javascript:void(0);">{this.state.movie.alias}</a>
                                </li>
                                <li>
                                    上映时间 : <a href="javascript:void(0);">{releaseTime}</a>
                                </li>

                                <li>
                                    时长 : <a href="javascript:void(0);">{this.state.movie.movieTime}</a> 分钟
                                </li>

                                <li>
                                    评分 : <a href="javascript:void(0);">{this.state.movie.score}</a>
                                </li>

                                <li>

                                    <Director director={this.state.movie.director}/>

                                </li>
                                <li>
                                    <ActorsList actors={this.state.movie.actors}/>
                                </li>

                                <li>
                                    总播放数 : <a href="javascript:void(0);">{this.state.movie.watchNum}</a> 次
                                </li>

                                <li id="description_li">
                                    {/*电影简介 : <a href="javascript:void(0);">{this.state.movie.description}</a>*/}
                                    <FlexText title={this.state.movieDescriptionTitle}
                                              text={this.state.movie.description}
                                              maxTextLength={this.state.movieDescriptionTextLength}/>
                                </li>

                                <li id="tags_li">
                                    <TagsOfMovie movieId={this.state.targetMovieId}
                                                 onLoadDataSuccess={this.getAboutTagsMovies}></TagsOfMovie>
                                </li>
                            </ul>
                        </div>

                    </div>

                </div>

                <div id="movie_player" className="clearfix">

                    <div id="m_wrapper" ref="m_wrapper">
                        <MoviePlayer targetMovieId={this.state.targetMovieId}/>
                    </div>
                    <div id="split"></div>
                    <div id="actors_details_div_wrapper">
                        <div id="actors_details_div">
                            <FilmmakersDetailsArea movieId={this.state.targetMovieId}
                                                   onLoadDataSuccess={this.getAboutFilmmakerMovies}/>
                        </div>
                    </div>

                </div>
                <div id="about_filmmakers_movies">
                    <PlainPanelTitle title="电影人相关"/>
                    <MoviesDisplayer movies={this.state.aboutFilmmakersMovies}
                                     ref="aboutFilmmakersMovies_MoviesDisplayer"/>
                </div>
                <div id="about_tags_movies">
                    <PlainPanelTitle title="标签相关"/>
                    <MoviesDisplayer movies={this.state.aboutTagsMovies}
                                     ref="aboutTagsMovies_MoviesDisplayer"/>
                </div>

            </div>
        );
    }
});


export default MovieInfoPage;
