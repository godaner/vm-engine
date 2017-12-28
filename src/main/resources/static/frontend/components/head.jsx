import React from 'react';  //引入react组件
import {Link} from 'react-router-dom';
import LoginDialog from "./login_dialog";
import RegistDialog from "./regist_dialog";
import '../scss/head.scss';
var Head = React.createClass({

    getInitialState: function () {
        return {
            user: {}//默认为空对象
        };
    },
    componentDidMount: function () {
        this.getOnlineUser();
    },
    getOnlineUser: function () {
        const url = "/user/online";
        $.get(url, function (result) {

            if (fail(result.code)) {

                window.VmFrontendEventsDispatcher.showMsgDialog(result.msg);
                return;
            }

            var state = this.state;
            if (isEmpty(result.data.user)) {
                state.user = {};
            } else {
                state.user = result.data.user;
            }

            this.setState(state);

        }.bind(this));
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

        state.user = user;

        this.setState(state);
    },
    logout:function(){
        const url = "/user/logout";
        $.ajax({
            url: url,
            type: 'PUT',
            success: function (result) {
                // c(result);
                if(fail(result.code)){
                    window.VmFrontendEventsDispatcher.showMsgDialog("注销失败");
                    return ;
                }
                window.VmFrontendEventsDispatcher.showMsgDialog("注销成功");
                //update user in state
                this.updateStateUser({});

            }.bind(this)
        });
    },
    render: function () {
        const location = {
            pathname: "/user/" + this.state.user.id
        };

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
            </div>
        );
    }
});

export default Head;   //将App组件导出