
import React from 'react';  //引入react组件
import MsgDialog from "./fragment_msg_dialog";
import '../scss/index.scss';
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

    render: function () {
        var movieItems = this.props.movies.map(function (item) {
            return <li className="movie_item" key={item.id}>
                <div className="movie_img_div">
                    <a href="">
                        <img src={item.imgUrl}/>
                    </a>
                </div>
                <div className="movie_info_div">
                    <div>
                        <a className="movie_name_a" href="">{item.name}</a>

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
        });
        return <ul id="movies_list_ul">
            {movieItems}
            <li className="clear"></li>
        </ul>;
    }
});
/*一组电影tag*/
var MovieTagGroup = React.createClass({
    render: function () {
        var tagGroupStyleClass = "currt";
        if(this.props.selected == undefined || this.props.selected==false){
            tagGroupStyleClass="";
        }
        return (
            <div id={this.props.movieTagGroupId} className="type_item">
                <label>
                    {this.props.movieTagGroupName}:
                </label>
                <ul>
                    <li onClick={()=>{this.props.handleClickTag(undefined,this.props.movieTagGroupId)}} className={tagGroupStyleClass}>
                        <a href="javascript:void(0);">
                            全部
                        </a>
                    </li>
                    {
                        this.props.movieTags.map(function (item) {
                            var tagStyleClass = "currt";
                            if(item.selected == undefined || item.selected==false){
                                tagStyleClass="";
                            }
                            return (
                                <li key={item.id} id={item.id}  onClick={()=>{this.props.handleClickTag(item.id,this.props.movieTagGroupId)}} className={tagStyleClass}>
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

    render: function () {
        return (
            <div>
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

var IndexCenter = React.createClass({


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
    getMovie(callfun){
        {/*获取电影列表*/}


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
                this.refs.index_msg_dialog.showMsg(result.msg);
                return ;
            }

            var state = this.state;
            state.movies.list = result.data.list;
            state.movies.total = result.data.total;
            this.setState(state);

            //adjust movie list ui
            this.adjustMovieListUI();


            //callfun
            callfun!=undefined&&callfun();
        }.bind(this));
    },
    getTagGroup(callfun){
        {/*获取电影标签分组*/}
        this.serverRequest = $.get(this.props.tagGroupSource, function (result) {
            var state = this.state;
            state.movieTagGroup = result.data.list;

            //default select tag group id

            for(var i = 0;i<state.movieTagGroup.length;i++){
                var g = state.movieTagGroup[i];
                g.selected = true;
            }

            this.setState(state);
//                c(state);
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
        var state = {movieSearchBtnText:"搜索",lastKeyword:"",movieSearchTimer:undefined,movieTagGroup: [], movies: {keyword:"",total: 0, list: [], page: 1, size: 10,orderType:"desc"},orderByOptions:orderByOptions};

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

        //replace state
        var state = this.state;
        state.movieTagGroup = groups;

        this.setState(state);
//            c(this.state);

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
    handleSearch:function(sec){
        //等待sec后自动执行搜索
        if(sec == undefined || sec<=0){
            this.clearMovieSearchTimer();
            this.search(this.refs.keyword.value);
        }else{
            this.clearMovieSearchTimer();
            //稍后执行
            this.state.movieSearchTimer = setTimeout(function (){
                this.search(this.refs.keyword.value);
            }.bind(this),sec);
        }


    },
    clearMovieSearchTimer:function(){
        if(this.state.movieSearchTimer){
            clearTimeout(this.state.movieSearchTimer);
        }
    },
    handleSearchInputKeyUp:function(e){
        if(e.keyCode == 13 ){
            this.handleSearch(0);
        }
    },
    search:function(keyword){
        //if keyword same ,do not search
        if(this.state.lastKeyword == keyword){
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
                    <MovieTagGroupList handleClickTag={this.handleClickTag}
                                       movieTagGroup={this.state.movieTagGroup}/>
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
                            <input id="fragment_head_nav_search_text"  onChange={()=>{this.handleSearch(1000)}} onKeyUp={this.handleSearchInputKeyUp} ref="keyword" placeholder="请输入关键字"/>
                            <input id="fragment_head_nav_search_btn" onClick={()=>{this.handleSearch(0)}} ref="movieSearchBtn" type="button" value={this.state.movieSearchBtnText}/>
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
                        <MoviesDisplayer movies={this.state.movies.list}/>

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
export default IndexCenter;   //将App组件导出