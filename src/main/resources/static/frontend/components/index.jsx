
import React from 'react';  //引入react组件
import '../scss/index.scss';
import MovieListPage from "./movie_list_page";
import Head from "./head";
import Tail from "./tail";
var Index = React.createClass({

    render: function () {
        return (
            <div id="index">
                <Head/>
                <MovieListPage tagGroupSource="/tagGroup/list" movieSource="/movie/list"/>
                <Tail/>
            </div>
        );
    }
});

export default Index;   //将App组件导出