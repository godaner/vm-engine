import React from 'react';  //引入react组件
import '../scss/movie_info_page.scss';
import ActorsList from './actors_list';
import InnerMessager from './inner_messager';
import Director from "./director";
import TagsOfMovie from "./tags_of_movie";
import FlexText from "./flex_text";
import ActorsDetailsArea from "./actors_details_area";
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
            whenPlayerIsLoading:"正在加载电影资源",
            movieDescriptionTextLength: 100,
            movie: {},
            targetMovieId: this.props.match.params.movieId
        };
    },
    componentDidMount: function () {
        //get movie
        this.getMovie();

        this.getMovieSrcVersion();
        //add resize event listener
        window.addEventListener('resize', this.onWindowResize);

        this.adjustUI();


    },
    movieSharpness:function(data){
        //1代表标清，2代表高清，3代表超清
        if(data == 1){
            return "标清";
        }
        if(data == 2){
            return "高清";
        }
        if(data == 3){
            return "超清";
        }
    },
    getMovieSrcVersion:function(){
        var url = "/movie/version/"+this.state.targetMovieId+"?orderBy=weight&orderType=desc";
        this.serverRequest = $.get(url, function (result) {
            var versionsInfo = result.data.versions;
            var videos = [];
            for(var i = 0;i<versionsInfo.length;i++){
                var version = versionsInfo[i];
                videos.push([version.srcUrl,'video/mp4',this.movieSharpness(version.sharpness),version.weight]);
            }
            //init movie player
            var options = {};
            options.poster = result.data.posterUrl;
            options.video = videos;
            //init movie player
            this.initPlayer(options);

            //cancel tip
            this.showMoviePlayerTip();

        }.bind(this));

    },
    initPlayer(options) {
        var videoObject = {
            container: '#m_player',//“#”代表容器的ID，“.”或“”代表容器的class
            variable: 'player',//该属性必需设置，值等于下面的new chplayer()的对象
            poster:options.poster,//封面图片
            autoplay: false,//默认自动播放
            volume:1.0,//初始化音量
            flashplayer:true,//如果强制使用flashplayer则设置成true
            video: options.video//视频地址http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4

        };
        var player = new ckplayer(videoObject);

    },
    onWindowResize: function () {
        this.adjustUI();
    },
    adjustUI: function () {
        this.adjustMoviePlayerUI();
    },
    adjustMoviePlayerUI: function () {
        //set player's height by width
        var m = $(this.refs.m);
        var player = $(this.refs.m_player);
        var w = player.width();
        var h = w / 1.5;
        m.height(h);
        player.height(h);
    },
    componentWillUnmount: function () {
        window.removeEventListener('resize', this.onWindowResize);
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
    showMoviePlayerTip(msg, loop) {
        this.refs.player_inner_messager.showMsg(msg, loop);
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

                    <div id="m" ref="m">
                        <InnerMessager defaultTip={this.state.whenPlayerIsLoading}
                                       ref="player_inner_messager"/>
                        <div id="m_player"
                             ref="m_player"></div>
                    </div>
                    <div id="actors_details_div">
                        <ActorsDetailsArea movieId={this.state.targetMovieId}/>
                    </div>

                </div>
            </div>
        );
    }
});


export default MovieInfoPage;