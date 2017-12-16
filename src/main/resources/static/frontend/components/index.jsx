
import React from 'react';  //引入react组件
import '../scss/index.scss';
import MovieListPage from "./movie_list_page";
import Head from "./head";
import Tail from "./tail";
var Index = React.createClass({
    getInitialState:function(){
        var state = {nowPage:1,pageMap:{1:<MovieListPage tagGroupSource="/tagGroup/list" movieSource="/movie/list"/>}};

        return state;
    },
    render: function () {
        var page = this.state.pageMap[this.state.nowPage];
        return (
            <div id="index">
                <Head/>
                {page}
                <Tail/>
            </div>
        );
    }
});

export default Index;   //将App组件导出