import ReactDOM from 'react-dom';
import React from 'react';
import {Switch, BrowserRouter, HashRouter, Route} from 'react-router-dom';
import FilmmakerInfoPage from "./filmmaker_info_page";
import {EventEmitter} from 'events';
import '../scss/index.scss';
import MovieListPage from "./movie_list_page";
import MovieInfoPage from "./movie_info_page";
import Head from "./head";
import Tail from "./tail";
import MsgDialog from "./msg_dialog";
import Loading from "./loading";
import UserPage from "./user_page";
import "./events_dispatcher";

var Index = React.createClass({
    getInitialState: function () {
        return {};
    },
    render: function () {
        //set now page's props
        return (
            <div id="index">
                <HashRouter>
                    <div>
                        {
                            /*头部*/
                        }
                        <Head/>
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
                            <Route exact path='/filmmaker/:filmmakerId' component={FilmmakerInfoPage}/>
                            {/*包括/user/online/basicInfo,/user/online/resetPwd等*/}
                            <Route path='/user/online' component={UserPage}/>
                        </Switch>
                        {
                            /*尾部*/
                        }
                        <Tail/>
                        {
                            /*信息弹出框*/
                        }
                        <MsgDialog ref="msg_dialog"/>
                        {
                            /*信息弹出框*/
                        }
                        <Loading/>
                    </div>
                </HashRouter>
            </div>
        );
    }
});

export default Index;   //将App组件导出
