import React from 'react';  //引入react组件
import {Link} from 'react-router-dom';
import "../scss/regist_dialog.scss";
/*注册框*/
var RegistDialog = React.createClass({
    getInitialState: function () {
        return {
            dialogClassName: "",
            registFailure:"注册失败",
            registSuccess:"注册成功",
            registing:"正在注册,请稍等..."
        };
    },
    componentDidMount: function () {
        window.addEventListener('resize', this.onWindowResize)

        //adjust ui
        this.adjustUI();

    },
    componentWillUnmount: function () {
        window.removeEventListener('resize', this.onWindowResize)
    },
    onWindowResize: function () {
        this.adjustUI();
    },
    adjustUI: function () {
        {
            /*调整样式*/
        }
        this.dialogToMiddle();

    },
    dialogToMiddle: function () {
        //垂直居中
        var dialog = $(this.refs.dialog);
        var content = $(this.refs.content);
        var dialog_h = dialog.height();
        var content_h = content.height();
        var top = (content_h - dialog_h) / 2;
        dialog.css("margin-top", top + "px");
    },
    showRegistDialog: function () {
        //show it
        this.fadeIn();

        //adjust ui
        this.adjustUI();

        //get focus
        $(this.refs.username).focus();
    },
    closeRegistDialog: function () {
        //hide it
        this.fadeOut();
    },
    fadeIn: function () {

        var state = this.state;
        $(this.refs.content).fadeIn();
        state.dialogClassName = "block animated bounceIn";
        this.setState(state);

        // c(this.state);

    },
    fadeOut: function () {
        var state = this.state;
        state.dialogClassName = "animated bounceOut";
        $(this.refs.content).fadeOut();
        this.setState(state);
    },
    regist: function () {



        var username = $(this.refs.username).val();
        var password = $(this.refs.password).val();
        const url = "/user/regist?username=" + username + "&password=" + password;

        ajax.put({
            url: url,
            onBeforeRequest:function(){

                //close login dialog
                this.closeRegistDialog();

                //show loading dialog
                window.VmFrontendEventsDispatcher.showLoading(this.state.registing);

            }.bind(this),
            onResponseStart: function () {
                //close loading
                window.VmFrontendEventsDispatcher.closeLoading();
            }.bind(this),
            onResponseSuccess: function (result) {
                //hide regist dialog
                this.closeRegistDialog();

                //show msg dialog
                window.VmFrontendEventsDispatcher.showMsgDialog(this.state.registSuccess);

                //callfun
                this.props.onRegistSuccess(result.data.user);
            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(this.state.registFailure,function(){
                    this.showRegistDialog();
                }.bind(this));
            }.bind(this)
        });

    },
    handlePasswordKeyUp: function (e) {
        if (e.keyCode === 13) {
            this.regist();
        }
    },
    render: function () {
        return <div id="regist_dialog_content" ref="content">
            <div id="dialog" className={this.state.dialogClassName} ref="dialog">
                <div id="head" className="clearfix">
                    <div id="title_div">注册</div>
                    <div id="close_div">
                        <a href="javascript:void(0);" onClick={this.closeRegistDialog}>X</a>
                    </div>
                </div>
                <div id="body">
                    <div id="regist_form">
                        <div id="username_div">
                            <input id="username_input"
                                   type="text"
                                   ref="username"
                                   placeholder="username"/>
                        </div>
                        <div id="password_div">
                            <input id="password_input"
                                   type="password"
                                   ref="password"
                                   onKeyUp={this.handlePasswordKeyUp}
                                   placeholder="password"/>
                        </div>
                        <div id="regist_btn_div">
                            <input id="regist_btn_input"
                                   type="button"
                                   value="注册"
                                   onClick={this.regist}/>
                        </div>

                    </div>
                </div>

            </div>
        </div>;
    }
});
export default RegistDialog;