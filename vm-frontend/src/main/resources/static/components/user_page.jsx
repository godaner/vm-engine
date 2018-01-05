import React from 'react';  //引入react组件
import {Switch, BrowserRouter, HashRouter, Route, Link, NavLink, withRouter,Redirect} from 'react-router-dom';
import PlainPanelTitle from "./plain_panel_title";
import UserBasicInfoPage from "./user_basic_info_page";
import UserHeadPage from "./user_head_page";

import "../scss/user_page.scss";
/*用户个人中心*/
var UserPage = React.createClass({
    getInitialState: function () {
        return {
            userId: this.props.match.params.userId
        };
    },
    componentDidMount(){
        // checkUserOnlineStatus();
    },
    protectUserPage:function(callfun){
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
                if(isEmpty(result.data.user)){
                    this.props.history.replace("/");
                }
            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(this.state.getInfoFailure);
            }.bind(this),
            onResponseEnd: function () {
                //callfun
                if (callfun != undefined) {
                    callfun()
                }
            }.bind(this)
        });
    },
    render: function () {

        // this.protectUserPage();

        var basicInfoUrl = "/user/" + this.state.userId+"/basicInfo";
        var resetPwdUrl = "/user/" + this.state.userId+"/resetPwd";
        return (
            <div id="user_info" className="defaultPanel">
                <PlainPanelTitle title={this.state.title}/>
                <HashRouter>
                    <div id="content"
                         className="clearfix">
                        <div id="nav">
                            <ul id="nav_ul">

                                <li>
                                    <NavLink to={basicInfoUrl}
                                             activeClassName="active">
                                        基本信息
                                    </NavLink>
                                </li>
                                <li>
                                    <NavLink to={resetPwdUrl}
                                             activeClassName="active">
                                        修改密码
                                    </NavLink>
                                </li>
                            </ul>
                        </div>
                        <div id="displayer">
                            <Switch>
                                <Route exact path='/user/:userId/basicInfo' component={UserBasicInfoPage}/>
                                <Route exact path='/user/:userId/head' component={UserHeadPage}/>
                            </Switch>
                        </div>
                    </div>
                </HashRouter>
            </div>
        );
    }
});
export default withRouter(UserPage);