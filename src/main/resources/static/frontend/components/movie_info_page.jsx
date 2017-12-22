import React from 'react';  //引入react组件
import '../scss/movie_info_page.scss';
/*import '../plugin/video-js/css/video-js.css';*/
import ActorsList from './actors_list';
import InnerMessager from './inner_messager';
import Director from "./director";
import TagsOfMovie from "./tags_of_movie";
import FlexText from "./flex_text";
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
            movieDescriptionTextLength: 100,
            movie: {},
            targetMovieId: this.props.match.params.movieId
        };
    },
    componentDidMount: function () {
        //get movie
        this.getMovie();
        //add resize event listener
        window.addEventListener('resize', this.onWindowResize);

        this.initMoviePlayer();
    },
    initMoviePlayer:function(){
        //打开自动播放
        var myPlayer = videojs('movie-player');
        c(myPlayer);
        videojs("movie-player").ready(function(){
            var myPlayer = this;
            myPlayer.play();
        });
    },
    componentWillUnmount: function () {
        window.removeEventListener('resize', this.onWindowResize);
    },

    onWindowResize: function () {
        this.adjustUI();
    },
    lazyLoadImg: function () {
        lazyLoad();
    },
    adjustUI: function () {

    },

    getMovie: function (callfun) {
        //show tip
        this.showTip(this.state.whenMovieIsLoading);


        var movieId = this.state.targetMovieId;


        //get movie info
        const url = this.props.match.url;
        // c(url);
        this.serverRequest = $.get(url, function (result) {


            //close tip
            this.showTip();

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
    showTip(msg, loop) {
        this.refs.innerMessager.showMsg(msg, loop);
    },
    updateMovieDescription(text){
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

                <div id="movie_player">

                    <div className="m">
                        <video
                            id="movie-player"
                            className="video-js"
                            controls
                            preload="auto"
                            poster="//vjs.zencdn.net/v/oceans.png"
                            data-setup='{}'>
                            <source src="http://vjs.zencdn.net/v/oceans.mp4" type="video/mp4"></source>
                            <source src="http://vjs.zencdn.net/v/oceans.webm" type="video/webm"></source>
                            <source src="http://vjs.zencdn.net/v/oceans.ogv" type="video/ogg"></source>
                            <p className="vjs-no-js">
                                To view this video please enable JavaScript, and consider upgrading to a
                                web browser that
                                <a href="http://videojs.com/html5-video-support/" target="_blank">
                                    supports HTML5 video
                                </a>
                            </p>
                        </video>
                    </div>

                </div>
            </div>
        );
    }
});


export default MovieInfoPage;