import React from 'react';  //引入react组件
import "../scss/movie_player.scss";
import InnerMessager from './inner_messager';
import PlainPanelTitle from "./plain_panel_title";
/*电影播放器展示*/
var MoviePlayer = React.createClass({
    getInitialState: function () {


        return {
            whenPlayerIsLoading: "正在加载视频资源",
            moviePlayerPanelTitle: "电影播放"
        };
    }, componentDidMount: function () {
        //get movie versions
        this.getMovieSrcVersion();

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
        this.adjustMoviePlayerUI();
    },
    adjustMoviePlayerUI: function () {
        //set player's height by width
        var m_player = $(this.refs.m_player);

        var w = m_player.width();
        var h = w / 1.5;
        m_player.height(h);
    },
    movieSharpness: function (data) {
        //1代表标清，2代表高清，3代表超清
        if (data == 1) {
            return "标清";
        }
        if (data == 2) {
            return "高清";
        }
        if (data == 3) {
            return "超清";
        }
    },
    getMovieSrcVersion: function (callfun) {
        var url = "/movie/version/" + this.props.targetMovieId + "?orderBy=weight&orderType=desc";
        ajax.get({
            url: url,
            onBeforeRequest: function () {

            }.bind(this),
            onResponseStart: function () {
                //cancel tip
                this.showTip();
            }.bind(this),
            onResponseSuccess: function (result) {
                var versionsInfo = result.data.versions;
                var videos = [];
                for (var i = 0; i < versionsInfo.length; i++) {
                    var version = versionsInfo[i];
                    videos.push([version.srcUrl, 'video/mp4', this.movieSharpness(version.sharpness), version.weight]);
                }
                //init movie player
                var options = {};
                options.poster = result.data.posterUrl;
                options.video = videos;
                //init movie player
                this.initPlayer(options);
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
    initPlayer(options) {
        var videoObject = {
            container: '#m_player',//“#”代表容器的ID，“.”或“”代表容器的class
            variable: 'player',//该属性必需设置，值等于下面的new chplayer()的对象
            poster: options.poster,//封面图片
            autoplay: false,//默认自动播放
            volume: 1.0,//初始化音量
            flashplayer: true,//如果强制使用flashplayer则设置成true
            video: options.video//视频地址http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4

        };
        var player = new ckplayer(videoObject);

    },
    showTip(msg, loop){
        this.refs.player_inner_messager.showMsg(msg, loop);
    },
    render: function () {

        return (
            <div id="m">
                <PlainPanelTitle title={this.state.moviePlayerPanelTitle}/>
                <InnerMessager defaultTip={this.state.whenPlayerIsLoading}
                               ref="player_inner_messager"/>
                <div id="m_player"
                     ref="m_player"></div>
            </div>
        );
    }
});
export default MoviePlayer;