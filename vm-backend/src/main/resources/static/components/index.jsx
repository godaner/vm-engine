import ReactDOM from 'react-dom';
import React from 'react';
import {Switch, BrowserRouter, HashRouter, Route} from 'react-router-dom';
import {EventEmitter} from 'events';
import '../scss/index.scss';
// import Head from "./head";
// import Tail from "./tail";
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
                        {/*<Head/>*/}
                        <Switch>
                            {/*<Route exact path='/'*/}
                                   {/*render={() => (*/}
                                       {/*<MovieListPage tagGroupSource="/tagGroup/list"*/}
                                                      {/*movieSource="/movie/list"/>*/}
                                   {/*)}/>*/}

                        </Switch>
                        {
                            /*尾部*/
                        }
                        {/*<Tail/>*/}
                        {
                            /*信息弹出框*/
                        }
                        {/*<MsgDialog ref="msg_dialog"/>*/}
                        {
                            /*信息弹出框*/
                        }
                        {/*<Loading/>*/}
                    </div>
                </HashRouter>
            </div>
        );
    }
});

export default Index;   //将App组件导出
