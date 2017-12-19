import ReactDOM from 'react-dom';
import React from 'react';
import {Switch, BrowserRouter,HashRouter, Route} from 'react-router-dom';
{
    /*import { createHistory, useBasename } from 'history';*/
}
import '../scss/index.scss';
import MovieListPage from "./movie_list_page";
import MovieInfoPage from "./movie_info_page";
import Head from "./head";
import Tail from "./tail";

var Index = React.createClass({
    getInitialState: function () {


        return null;
    },
    render: function () {
        //set now page's props
        return (
            <div id="index">
                <Head/>

                <HashRouter>
                    <Switch>
                        <Route exact path='/'
                               render={() => (
                                   <MovieListPage tagGroupSource="/tagGroup/list"
                                                  movieSource="/movie/list"/>
                               )}/>
                        <Route exact path='/movie/list'
                               render={() => (
                                   <MovieListPage tagGroupSource="/tagGroup/list"
                                                  movieSource="/movie/list"/>
                               )}/>
                        <Route exact path='/movie/:movieId' component={MovieInfoPage}/>
                    </Switch>

                </HashRouter>
                <Tail/>
            </div>
        );
    }
});

export default Index;   //将App组件导出