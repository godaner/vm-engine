import React from 'react';  //引入react组件
import "../scss/msg_dialog.scss"
import "./events_dispatcher";

var MsgDialog = React.createClass({
    getInitialState: function () {
        var closeText = "确认";
        if (!isEmpty(this.props.closeText)) {
            closeText = this.props.closeText;
        }
        var state = {
            closeText: closeText,
            dialogClassName: "",
            onCloseCallfun: undefined
        };
        return state;
    },
    componentDidMount: function () {
        window.addEventListener('resize', this.onWindowResize)

        //adjust ui
        this.adjustUI();

        //add events
        this.registEvents();


    },
    registEvents: function () {
        window.event.on('showMsgDialog', (msg, onCloseCallfun) => {
            //set onCloseCallfun to state
            var state = this.state;
            state.onCloseCallfun = onCloseCallfun;
            this.setState(state);


            this.showMsg(msg);
        })
        window.event.on('closeMsgDialog', () => {
            this.close();
        })
    },
    componentWillUnmount: function () {
        window.removeEventListener('resize', this.onWindowResize)
    },
    onWindowResize: function () {
        this.adjustUI();
    },
    showMsg: function (msg) {
        if (msg == null || msg == undefined) {
            msg = "无消息";
        }

        //set it's message
        $(this.refs.msg_p).html(msg);
        //show it
        this.fadeIn();

        //close btn get focus ，for enter 13 to close dialog
        $(this.refs.close_btn).focus();

    },
    close: function () {

        this.fadeOut();


        //callfun
        var onCloseCallfun = this.state.onCloseCallfun;
        if (!isEmpty(onCloseCallfun)) {
            onCloseCallfun();
        }


    },
    fadeIn: function () {
        //不直接使用
        var state = this.state;
        $(this.refs.content).fadeIn();
        state.dialogClassName = "block animated headShake";
        this.setState(state);

        // c(this.state);

    },
    fadeOut: function () {
        //不直接使用
        var state = this.state;
        state.dialogClassName = "animated bounceOut";
        $(this.refs.content).fadeOut();
        this.setState(state);
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
    handleCloseBtnKeyUp: function (e) {
        if (e.keyCode === 13) {
            this.close();
        }
    },
    render: function () {
        return (
            <div id="fragment_msg_dialog_content"
                 ref="content">
                <div id="dialog"
                     className={this.state.dialogClassName}
                     ref="dialog">
                    <div id="body">
                        <span id="msg_p"
                              ref="msg_p">
                            {this.props.msg}
                        </span>
                        <span id="split">
                            |
                        </span>
                        <a id="close_btn"
                           ref="close_btn"
                           href="javascript:void(0);"
                           onClick={this.close}
                           onKeyUp={this.handleCloseBtnKeyUp}>
                            {this.state.closeText}
                        </a>
                    </div>

                </div>
            </div>

        );
    }
});

export default MsgDialog;   //将App组件导出
