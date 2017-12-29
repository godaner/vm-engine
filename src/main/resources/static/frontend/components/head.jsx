import React from 'react';  //引入react组件
import {Switch, BrowserRouter, HashRouter, Route, Link, withRouter} from 'react-router-dom';
import Websocket from 'react-websocket';
import LoginDialog from "./login_dialog";
import RegistDialog from "./regist_dialog";
import '../scss/head.scss';
var Head = React.createClass({

    getInitialState: function () {
        return {
            logouting: "正在注销...",
            logoutSuccess: "注销成功",
            logoutFailure: "注销失败",
            user: {},//默认为空对象
            wsUrl:""
        };
    },
    componentDidMount: function () {
    },
    showLoginDialog: function () {
        this.refs.login_dialog.showLoginDialog();
    },
    closeLoginDialog: function () {
        this.refs.login_dialog.closeLoginDialog();
    },
    onLoginSuccess: function (user) {

        this.updateStateUser(user);
    },
    showRegistDialog: function () {
        this.refs.regist_dialog.showRegistDialog();
    },
    closeRegistDialog: function () {
        this.refs.regist_dialog.closeRegistDialog();
    },
    onRegistSuccess: function (user) {
        this.updateStateUser(user);
    },
    updateStateUser(user){
        //when login success reset user
        var state = this.state;
        if (isEmpty(user)) {
            state.user = {};
            state.wsUrl = "";
        }else{
            state.user = user;
            state.wsUrl = WS_URL_PREFIX + "/ws/user/login/"+user.id;
        }
        this.setState(state);
    },
    logout: function () {
        //show loading dialog
        window.VmFrontendEventsDispatcher.showLoading(this.state.logouting);

        const url = "/user/logout";

        ajax.put({
            url: url,
            onBeforeRequest: function () {

            }.bind(this),
            onResponseStart: function () {
                //close loading dialog
                window.VmFrontendEventsDispatcher.closeLoading();
            }.bind(this),
            onResponseSuccess: function (result) {

                window.VmFrontendEventsDispatcher.showMsgDialog(this.state.logoutSuccess);
                //update user in state
                this.updateStateUser({});
            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(this.state.logoutFailure);
            }.bind(this),
            onResponseEnd: function () {
            }.bind(this)
        });


    },
    handleWsOnMessage:function (msg) {
        const result = JSON.parse(msg);
        c(result);
    },
    render: function () {
        const location = {
            pathname: "/user/" + this.state.user.id
        };
        //在线
        var loginStatus = function () {
            return (
                <span>
                    <li>
                        <a id="headImg_a" href="#">
                            <img id="headImg_img" src={this.state.user.imgUrl}/>
                        </a>
                    </li>
                    <li>
                        <Link id="username" to={location}>

                            {this.state.user.username}

                        </Link>
                    </li>
                    <li>
                    <a href="javascript:void(0);" onClick={this.logout}>注销</a>
                    </li>
                </span>
            );
        }.bind(this);
        //离线
        var logoutStatus = function () {
            return (
                <span>

                    <li>
                        <a href="javascript:void(0);" onClick={this.showLoginDialog}>登录</a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" onClick={this.showRegistDialog}>注册</a>
                    </li>
                </span>
            );
        }.bind(this);
        return (
            <div id="fragment_head_content">
                <div id="nav_div">
                    <ul id="fragment_head_nav">
                        <li id="fragment_head_nav_logo">
                            <Link to="/">
                                <span id="logo_v">V</span><span id="logo_m">M</span>
                            </Link>
                        </li>
                        <li id="user_li">
                            <ul id="user_ul">


                                {isEmpty(this.state.user) ? logoutStatus() : loginStatus()}

                            </ul>
                        </li>

                    </ul>

                </div>
                {/*与nav_div同高,用于填充nav_div脱离文档流后的空白*/}
                <div id="blank_div"></div>
                {/*登录框*/}
                <LoginDialog ref="login_dialog" onLoginSuccess={this.onLoginSuccess}/>
                {/*注册框*/}
                <RegistDialog ref="regist_dialog" onRegistSuccess={this.onRegistSuccess}/>
                {/*Websocket*/}
                {isEmpty(this.state.user)?<span></span>:<Websocket url={this.state.wsUrl}
                    onMessage={this.handleWsOnMessage.bind(this)}/>}
            </div>
        );
    }
});

export default withRouter(Head);   //将App组件导出