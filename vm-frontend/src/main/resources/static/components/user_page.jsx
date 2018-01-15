import React from 'react';  //引入react组件
import {Switch, BrowserRouter, HashRouter, Route, Link, NavLink, withRouter, Redirect} from 'react-router-dom';
import PlainPanelTitle from "./plain_panel_title";
import UserBasicInfoPage from "./user_basic_info_page";
import UserHeadPage from "./user_head_page";

import "../scss/user_page.scss";
/*用户个人中心*/
var UserPage = React.createClass({
        getInitialState: function () {
            return {

                basicInfoUrl: "/user/online/basicInfo",
                headUrl: "/user/online/head"
                // userId: this.props.match.params.userId
            };
        },
        componentDidMount(){

        },
        backToHomePage: function () {
            this.props.history.replace("/");
        },
        preventIllegalAccess: function (callfun) {
            // 监测用户是否在没有登录的情况下直接访问本页面
            const url = "/user/online";
            ajax.get({
                url: url,
                onBeforeRequest: function () {

                }.bind(this),
                onResponseStart: function () {

                }.bind(this),
                onResponseSuccess: function (result) {
                    //用户不在线
                    var u = result.data.user;
                    if (isUndefined(u) ||
                        isEmptyObj(u)) {
                        this.backToHomePage();
                    }
                }.bind(this),
                onResponseFailbackToHomePageure: function (result) {
                    this.backToHomePage();
                    window.VmFrontendEventsDispatcher.showMsgDialog(this.state.getInfoFailure, function () {

                    });
                }.bind(this),
                onResponseEnd: function () {
                    //callfun
                    if (callfun != undefined) {
                        callfun()
                    }
                }.bind(this),
                onRequestError: function () {
                    this.backToHomePage();
                }.bind(this)
            })
        },
        render: function () {
            //是否为非法进入,即用户未登录的情况下进入
            // this.preventIllegalAccess();

            return (
                <div id="user_info" className="defaultPanel">
                    <PlainPanelTitle title={this.state.title}/>
                    <HashRouter>
                        <div id="content"
                             className="clearfix">
                            <div id="nav">
                                <ul id="nav_ul">

                                    <li>
                                        <NavLink to={this.state.basicInfoUrl}
                                                 activeClassName="active">
                                            基本信息
                                        </NavLink>
                                    </li>
                                    <li>
                                        <NavLink to={this.state.headUrl}
                                                 activeClassName="active">
                                            头像修改
                                        </NavLink>
                                    </li>
                                </ul>
                            </div>
                            <div id="displayer">
                                <Switch>
                                    <Route exact path={this.state.basicInfoUrl} component={UserBasicInfoPage}/>
                                    <Route exact path={this.state.headUrl} component={UserHeadPage}/>
                                </Switch>
                            </div>
                        </div>
                    </HashRouter>
                </div>
            );
        }
    })
;
export default withRouter(UserPage);