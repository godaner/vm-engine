import React from 'react';  //引入react组件
import '../scss/index.scss';
import MovieListPage from "./movie_list_page";
import MovieInfoPage from "./movie_info_page";
import Head from "./head";
import Tail from "./tail";

var Index = React.createClass({
    getInitialState: function () {
        var state = {
            pageId: 1,//display this page
            pageData: {movieId:1},//displayed page's data
            pageMap: {
                2: <MovieListPage pageDispatch={this.pageDispatch}
                                  getNowPageProps={this.getNowPageProps}
                                  tagGroupSource="/tagGroup/list"
                                  movieSource="/movie/list"/>,
                1: <MovieInfoPage pageDispatch={this.pageDispatch}
                                  getNowPageProps={this.getNowPageProps}
                                  movieSource="/movie"/>
            }
        };

        return state;
    },
    pageDispatch(dispatchInfo) {

        //change page
        var state = this.state;

        state.pageId = dispatchInfo.pageId;

        //set page data
        state.pageData = dispatchInfo.pageData;

        this.setState(state);

    },
    getNowPageProps: function () {
        return this.state.pageData;
    },
    render: function () {
        var page = this.state.pageMap[this.state.pageId];
        //set now page's props
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