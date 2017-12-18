
import React from 'react';  //引入react组件
import {Link} from 'react-router-dom';
import MsgDialog from "./msg_dialog";
import InnerMessager from "./inner_messager";
import '../scss/movie_list_page.scss';
import 'animate.css';
var Pager = React.createClass({

    render: function () {
        return (
            <div id="movie_list_pager_div">
                <ul id="movie_list_pager_ul">
                    <li className="pager_li">
                        <a href="javascript:void(0);" onClick={()=>{this.props.handlePageChange(-1)}}>上一页</a>
                    </li>
                    <li className="pager_li currt">
                        <a href="javascript:void(0);">{this.props.page}</a>
                    </li>
                    <li className="pager_li">
                        <a href="javascript:void(0);" onClick={()=>{this.props.handlePageChange(1)}}>下一页</a>
                    </li>
                </ul>
            </div>
        );
    }
});

/*电影展示-演员展示*/
var ActorsList = React.createClass({
    render: function () {

        return (
            <ul >
                <li>主演：</li>
                {
                    this.props.actors.map((item,index)=>{
                        return <li key={item.id}><a href="">{item.name}</a>&nbsp;</li>;
                    })
                }

            </ul>
        );
    }
});
/*电影展示*/
var MoviesDisplayer = React.createClass({

    showMsg(msg,loop){
        this.refs.innerMessager.showMsg(msg,loop);
    },
    render: function () {

        var movieItems = this.props.movies.map(function (item) {
            var linkToUrl = "/movie/"+item.id;
            // but you can use a location instead
            const location = {
                pathname: '/movie/'+item.id,
                state: { fromDashboard: true }
            }

            // history.push(location);
            // history.replace(location)
            return <li className="movie_item animated flipInX" key={item.id}>
                <div className="movie_img_div">


                    <Link to={location}>
                        <img src={item.imgUrl}/>
                    </Link>
                </div>
                <div className="movie_info_div">
                    <div>
                        <Link to={linkToUrl} className="movie_name_a">{item.name}</Link>

                    </div>
                    <div className="movie_actor_list_div">

                        <ActorsList actors={item.actors}/>
                    </div>


                    <div>


                        导演：<a  href="">{item.director==null?"无":item.director.name}</a>
                    </div>
                    <div>
                        评分：{item.score}
                    </div>

                    <div>
                        播放：{item.watchNum}次
                    </div>
                </div>

            </li>;
        }.bind(this));
        return <ul id="movies_list_ul">
            <InnerMessager ref="innerMessager"/>
            {movieItems}
            <li className="clear"></li>
        </ul>;
    }
});
/*一组电影tag*/
var MovieTagGroup = React.createClass({
    render: function () {
        var tagGroupStyleClass = "";
        if(this.props.selected != undefined && this.props.selected){
            tagGroupStyleClass = "currt";
        }
        return (
            <div id={this.props.movieTagGroupId} className="type_item">
                <label>
                    {this.props.movieTagGroupName}:
                </label>
                <ul>
                    <li className={tagGroupStyleClass} onClick={()=>{this.props.handleClickTag(undefined,this.props.movieTagGroupId)}} >
                        <a href="javascript:void(0);">
                            全部
                        </a>
                    </li>
                    {
                        this.props.movieTags.map(function (item) {
                            var tagStyleClass = "";
                            if(item.selected != undefined && item.selected){
                                tagStyleClass = "currt";
                            }
                            return (
                                <li key={item.id} id={item.id} className={tagStyleClass}  onClick={()=>{this.props.handleClickTag(item.id,this.props.movieTagGroupId)}}>
                                    <a href="javascript:void(0);">
                                        {item.name}
                                    </a>
                                </li>
                            );
                        }.bind(this))
                    }


                </ul>
            </div>);
    }
});
/*电影标签列表*/
var MovieTagGroupList = React.createClass({
    showMsg(msg,loop){
        this.refs.innerMessager.showMsg(msg,loop);
    },
    render: function () {
        return (
            <div>

                {/*<div id="tagTip">{this.props.tip}</div>*/}
                <InnerMessager ref="innerMessager"/>

                {
                    this.props.movieTagGroup.map(function (item) {
                        return (
                            <MovieTagGroup key={item.id}
                                           handleClickTag={this.props.handleClickTag}
                                           movieTagGroupId={item.id}
                                           movieTagGroupName={item.name}
                                           selected={item.selected}
                                           movieTags={item.items}/>
                        );
                    }.bind(this))
                }
            </div>
        );
    }
});

var MovieListPage = React.createClass({


    componentDidMount: function () {
        this.getTagGroup(this.getMovie);
        window.addEventListener('resize', this.onWindowResize)
    },
    componentWillUnmount:function() {
        window.removeEventListener('resize', this.onWindowResize)
    },
    onWindowResize:function () {
        this.adjustMovieListUI();
    },
    adjustMovieListUI:function (){
        {/*设置电影列表样式*/}
        var width = $($(".movie_img_div a img")[0]).css("width");

        var height = parseInt(width)*1.5;
        height = height.toString()+"px";
        $(".movie_img_div a img").css("height",height)
    },
    showMovieTip(msg,loop){
        if(msg == undefined){
            msg = "";
        }
        this.refs.moviesDisplayer.showMsg(msg,loop);
    },
    getMovie(callfun){
        {/*获取电影列表*/}

        //tip
        this.showMovieTip("正在加载");


        {/*collect params*/}
        var movies = this.state.movies;
        var page = movies.page;
        var size = movies.size;
        var orderType = movies.orderType;
        var start = (page-1)*size;
        var keyword = movies.keyword;

        {/*collect param => orderBy*/}
        var orderBy;
        for(var i = 0;i<this.state.orderByOptions.length;i++){
            if(this.state.orderByOptions[i].selected){
                orderBy = this.state.orderByOptions[i].id;
                break;
            }
        }

        {/*collect param => selected tag group ids and tags id*/}
        var tagGroupIds = [];
        var tagIds = [];
        for(var i = 0;i<this.state.movieTagGroup.length;i++){
            var g = this.state.movieTagGroup[i];
            if(g.selected){
                tagGroupIds.push(g.id);
            }else{
                for(var j = 0;j<g.items.length;j++){
                    var tag = g.items[j];
                    if(tag.selected){
                        tagIds.push(tag.id);
                    }
                }
            }
        }


        var url = this.props.movieSource + "?page="+page+"&start="+start+"&size="+size+"&orderBy="+orderBy+"&orderType="+orderType+"&keyword="+keyword;
        url = contactUrlWithArray(url,"tagGroupIds",tagGroupIds);
        url = contactUrlWithArray(url,"tagIds",tagIds);
        this.serverRequest = $.get(url , function (result) {
            // c(result);
            if(result.code == 10000){
                this.showDialogMsg(result.msg);
                this.showMovieTip();
                return ;
            }

            var state = this.state;
            state.movies.list = result.data.list;
            state.movies.total = result.data.total;
            this.setState(state);

            //if have not movies
            if(state.movies.list.length==undefined || state.movies.list.length == 0){
                this.showMovieTip("无相关电影",false);
            }else{
                this.showMovieTip();
            }

            //adjust movie list ui
            this.adjustMovieListUI();


            //callfun
            callfun!=undefined&&callfun();
        }.bind(this));
    },
    showDialogMsg(msg){
        this.refs.index_msg_dialog.showMsg(msg);
    },
    showTagTip(msg,loop){
        if(msg == undefined){
            msg = "";
        }
        this.refs.movieTagGroupList.showMsg(msg,loop);
    },
    getTagGroup(callfun){
        //set tip
        this.showTagTip("正在加载");
        {/*获取电影标签分组*/}
        this.serverRequest = $.get(this.props.tagGroupSource, function (result) {
            var state = this.state;
            state.movieTagGroup = result.data.list;


            if(result.code == 10000){
                this.showDialogMsg(result.msg);
                this.showMovieTip();
                return ;
            }


            //set tip

            if(state.movieTagGroup==undefined||state.movieTagGroup.length == 0) {
                this.showTagTip("无相关标签",false);
            }else{
                this.showTagTip();
            }

            //default select tag group id

            for(var i = 0;i<state.movieTagGroup.length;i++){
                var g = state.movieTagGroup[i];
                g.selected = true;
            }

            this.setState(state);


            //callfun
            callfun();
        }.bind(this));
    },
    getInitialState: function () {
//            var movieTagGroup = [{
//                id: 1,
//                name: '地区',
//                items: [{id: 1, name: '大四川'}]
//            }, {
//                id: 2122,
//                name: '类型',
//                items: [{id: 1, name: '小惊悚'}]
//            }];
//
//            var movies = [];
//            for (var i = 0; i < 11; i++) {
//                movies.push({
//                    id: i,
//                    movieName: '海绵宝宝',
//                    actors: [{id: '1', name: '刘德华1'}, {id: '2', name: '刘德华2'}],
//                    playNum: 666
//                });
//            }


        var orderByOptions = [{id:"score",name:"最高评分",selected:true},{id:"watch_num",name:"最多播放",selected:false},{id:"release_time",name:"最新上映",selected:false}];
        var state = {movieTip:"正在加载...",movieSearchBtnText:"搜索",lastKeyword:"",movieSearchTimer:undefined,movieTagGroup: [], movies: {keyword:"",total: 0, list: [], page: 1, size: 10,orderType:"desc"},orderByOptions:orderByOptions};

        return state;

    },
    handlePageChange(movePage){
        var newPage = this.state.movies.page + movePage;
//            c(this.state.movies.total-(this.state.movies.size*(newPage-1))<=0);
        if (newPage <= 0 || this.state.movies.total-(this.state.movies.size*(newPage-1))<=0) {
            return;
        }
        //更新page
        var state = this.state;
        state.movies.page = newPage;
        this.setState(state);
        this.getMovie();
    },
    handleClickTag:function(selectedTagId,selectedTagGroupId){
        {/*点击标签事件*/}
//            c("handleClickTag");
//            c(selectedTagId);
//            c(selectedTagGroupId);
        var groups = this.state.movieTagGroup;
        if(selectedTagId==undefined){
            {/*单纯选择某个标签组*/}
            for (var i=0;i<groups.length;i++) {
                var g = groups[i];
                if(g.id == selectedTagGroupId){
                    g.selected = true;
                    for(var j = 0;j<g.items.length;j++){
                        var tag = g.items[j];
                        tag.selected = false;
                    }
                }
            }
        }else{
            {/*选择某个标签组下的某个标签*/}
            for (var i=0;i<groups.length;i++) {
                var g = groups[i];
                if (g.id == selectedTagGroupId) {
                    g.selected = false;
                    {/*找到指定标签组*/}
                    for(var j = 0;j<g.items.length;j++){
                        var tag = g.items[j];
                        if(selectedTagId == tag.id){
                            tag.selected = true;
                        }else{
                            tag.selected = false;
                        }
                    }
                    break;
                }
            }

        }

        //get react state
        var state = this.state;
        //set movie list page
        state.movies.page = 1;
        //set tag group
        state.movieTagGroup = groups;

        //set react state
        this.setState(state);

        //refresh movies list
        this.getMovie();

    },
    sortMovie(orderById){
        {/*collect param => orderBy*/}
        var orderByOptions = this.state.orderByOptions;
        var orderBy;
        for(var i = 0;i<orderByOptions.length;i++){
            if(orderByOptions[i].id==orderById){
                orderByOptions[i].selected = true;
            }else{
                orderByOptions[i].selected = false;
            }
        }

        //更新page
        var state = this.state;
        state.orderByOptions = orderByOptions;
        this.setState(state);
        this.getMovie();
    },
    clearMovieSearchTimer:function(){
        if(this.state.movieSearchTimer){
            clearTimeout(this.state.movieSearchTimer);
        }
    },
    handleSearchInputChange:function(){


        //clear search timer
        this.clearMovieSearchTimer();
        //稍后执行
        this.state.movieSearchTimer = setTimeout(function (){
            this.searchMovie();
        }.bind(this),1000);


    },
    handleSearchInputKeyUp:function(e){
        if(e.keyCode == 13 ){
            //clear search timer
            this.clearMovieSearchTimer();

            //search movie
            this.searchMovie();
        }
    },
    handleClickSearchBtn:function(){

        //clear search timer
        this.clearMovieSearchTimer();

        //search movie
        this.searchMovie();
    },
    searchMovie:function(){
        //get keyword
        var keyword = this.refs.keyword.value;

        //if keyword same ,do not search
        if(this.state.lastKeyword == keyword){
            this.refs.index_msg_dialog.showMsg("重复搜索");
            return ;
        }
        var oldMovieSearchBtnText = this.state.movieSearchBtnText;

        var state = this.state;
        //set the movieSearchBtnText in state
        state.movieSearchBtnText = "搜索中...";

        //set the keyword in state
        state.movies.keyword = keyword;
        //search page 1
        state.movies.page = 1;
        //update state
        this.setState(state);
        this.getMovie(function(){
            // movieSearchBtn.val(movieSearchBtnOdlText);

            //save this keyword
            this.state.lastKeyword = keyword;
            setTimeout(function(){
                var state = this.state;
                //update movieSearchBtnText in state
                state.movieSearchBtnText = oldMovieSearchBtnText;
                this.setState(state)
            }.bind(this,oldMovieSearchBtnText),100);

        }.bind(this,keyword,oldMovieSearchBtnText));
    },
    render: function () {
        return (
            <div id="fragment_index_center_content">
                <div id="movie_type_div">

                    {/*电影标签列表*/}
                    <MovieTagGroupList tip={this.state.tagTip}
                                       handleClickTag={this.handleClickTag}
                                       movieTagGroup={this.state.movieTagGroup}
                                       ref="movieTagGroupList"/>
                </div>
                <div id="movie_list_div">
                    <div id="head">
                        <div id="sort_div">
                            <ul id="sort_ways">
                                <label>排序：</label>

                                {
                                    this.state.orderByOptions.map((item,index)=>{
                                        var clsName = "";
                                        if(item.selected){
                                            clsName = "currt";
                                        }

                                        return <li key={item.id} onClick={()=>{this.sortMovie(item.id)}} className={clsName} >
                                            <a href="javascript:void(0);" >{item.name}</a>
                                        </li>;
                                    })
                                }


                            </ul>
                        </div>
                        <div id="search_div">
                            <input id="fragment_head_nav_search_text"  onChange={()=>{this.handleSearchInputChange()}} onKeyUp={this.handleSearchInputKeyUp} ref="keyword" placeholder="请输入关键字"/>
                            <input id="fragment_head_nav_search_btn" onClick={()=>{this.handleClickSearchBtn()}} ref="movieSearchBtn" type="button" value={this.state.movieSearchBtnText}/>
                        </div>
                        <div id="total_div">
                            共
                            <span id="totalNum">
                                        {this.state.movies.total}
                                    </span>
                            个结果
                        </div>
                        {/*清空float*/}

                        <div className="clear"></div>
                    </div>
                    <div id="line"></div>
                    <div id="movies_display_div">
                        {/*电影展示*/}
                        <MoviesDisplayer movies={this.state.movies.list}
                                         ref="moviesDisplayer"/>

                        {/*电影分页*/}
                        <Pager handlePageChange={this.handlePageChange} page={this.state.movies.page}/>
                    </div>
                </div>
                {
                    /*信息框*/
                }
                <MsgDialog ref="index_msg_dialog"/>
            </div>
        );
    }

});
export default MovieListPage;   //将App组件导出