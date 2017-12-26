import React from 'react';  //引入react组件
import '../scss/movie_info_page.scss';
import ActorsList from './actors_list';
import InnerMessager from './inner_messager';
import Director from "./director";
import TagsOfMovie from "./tags_of_movie";
import FlexText from "./flex_text";
import ActorsDetailsArea from "./actors_details_area";
import MoviePlayer from "./movie_player";
import PlainPanelTitle from "./plain_panel_title";
/*import '../../../public/js/ckplayer/ckplayer/ckplayer.js';*/

var MovieInfoPage = React.createClass({
    getInitialState: function () {
        //init state
        return {
            whenThereHaveNotActor: "无演员",
            whenThereHaveNotDirector: "无导演",
            whenMovieIsLoading: "正在加载电影信息",
            whenThereHaveNotTag: "无标签",
            whenTagIsLoading: "正在加载标签信息",
            movieDescriptionTitle: "电影简介 : ",
            whenPlayerIsLoading: "正在加载电影资源",
            movieDescriptionTextLength: 100,
            moviePlayerPanelTitle: "电影播放",
            movie: {},
            targetMovieId: this.props.match.params.movieId
        };
    },
    componentDidMount: function () {
        //get movie
        this.getMovie();

        //add resize event listener
        window.addEventListener('resize', this.onWindowResize);

        this.adjustUI();


    },
    componentWillUnmount: function () {
        window.removeEventListener('resize', this.onWindowResize);
    },
    onWindowResize: function () {
        this.adjustUI();
    },
    adjustUI: function () {

    },
    lazyLoadImg: function () {
        lazyLoad();
    },

    getMovie: function (callfun) {
        //show tip
        this.showMovieInfoTip(this.state.whenMovieIsLoading);


        var movieId = this.state.targetMovieId;


        //get movie info
        const url = this.props.match.url;
        // c(url);
        this.serverRequest = $.get(url, function (result) {


            //close tip
            this.showMovieInfoTip();

            if (fail(result.code)) {
                return;
            }

            var state = this.state;

            //set movie info to state

            state.movie = result.data.movie;

            this.setState(state);

            //update movie description
            this.updateMovieDescription(state.movie.description);

            //lazy load img
            this.lazyLoadImg();


            // c(this.state)
            //callfun
            if (callfun != undefined) {
                callfun()
            }
        }.bind(this));
    },
    showMovieInfoTip(msg, loop) {
        this.refs.innerMessager.showMsg(msg, loop);
    },
    updateMovieDescription(text) {
        this.refs.flex_text.updateText(text);
    },
    render: function () {

        //format releaseTime
        var releaseTime = timeFormatter.formatDate(this.state.movie.releaseTime);

        return (
            <div id="movie_info_content">
                <div id="basic_info">


                    <div className="clearfix" id="movie_info_displayer">

                        <div id="movie_img">
                            <img src={LOADING_IMG} data-original={this.state.movie.imgUrl}/>
                        </div>
                        <div id="movie_text">
                            <ul id="text_ul">
                                <li id="name_li">
                                    <InnerMessager defaultTip={this.state.whenMovieIsLoading}
                                                   ref="innerMessager"/>
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

                                    <Director whenThereHaveNotDirector={this.state.whenThereHaveNotDirector}
                                              director={this.state.movie.director}/>

                                </li>
                                <li>
                                    <ActorsList whenThereHaveNotActor={this.state.whenThereHaveNotActor}
                                                actors={this.state.movie.actors}/>
                                </li>

                                <li>
                                    总播放数 : <a href="javascript:void(0);">{this.state.movie.watchNum}</a> 次
                                </li>

                                <li id="description_li">
                                    {/*电影简介 : <a href="javascript:void(0);">{this.state.movie.description}</a>*/}
                                    <FlexText ref="flex_text"
                                              title={this.state.movieDescriptionTitle}
                                              des={this.state.movie.description}
                                              maxTextLength={this.state.movieDescriptionTextLength}/>
                                </li>

                                <li id="tags_li">
                                    <TagsOfMovie movieId={this.state.targetMovieId}
                                                 whenThereHaveNotTag={this.state.whenThereHaveNotTag}
                                                 whenTagIsLoading={this.state.whenTagIsLoading}></TagsOfMovie>
                                </li>
                            </ul>
                        </div>

                    </div>

                </div>

                <div id="movie_player" className="clearfix">

                    <div id="m_wrapper" ref="m_wrapper">
                        <MoviePlayer whenPlayerIsLoading=""
                                     moviePlayerPanelTitle=""
                                     targetMovieId={this.state.targetMovieId}/>
                    </div>
                    <div id="split"></div>
                    <div id="actors_details_div_wrapper">
                        <div id="actors_details_div">
                            <ActorsDetailsArea movieId={this.state.targetMovieId}/>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
});


export default MovieInfoPage;