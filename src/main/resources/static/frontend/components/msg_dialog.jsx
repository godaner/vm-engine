import React from 'react';  //引入react组件
import "../scss/msg_dialog.scss"

var MsgDialog = React.createClass({
    getInitialState: function () {
        var state = {dialogClassName:""
        };
        return state;
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
    showMsg: function (msg) {
        if(msg == null || msg ==undefined){
            msg = "无消息";
        }
        //middle show
        this.dialogToMiddle();

        //set it's message
        $(this.refs.dialog_body).find("#msg_p").html(msg);
        //show it
        this.fadeIn();
    },
    fadeIn: function () {

        var state = this.state;
        $(this.refs.content).fadeIn();
        state.dialogClassName = "block animated headShake";
        this.setState(state);

        // c(this.state);

    },
    fadeOut: function () {
        var state = this.state;
        state.dialogClassName = "animated bounceOut";
        $(this.refs.content).fadeOut();
        this.setState(state);
    },
    close:function(){
        this.fadeOut();
    },
    adjustUI: function () {
        {
            /*调整样式*/
        }
        this.dialogToMiddle();

    },
    dialogToMiddle:function(){
        var dialog = $(this.refs.dialog);
        var body_w = document.body.clientWidth;
        var body_h = document.body.clientHeight;
        var dialog_w = dialog.width();
        var dialog_h = dialog.height();
        c(body_w);
        c(body_h);
        c(dialog_w);
        c(dialog_h);
        var left = (body_w - dialog_w) / 2;
        var top = (body_h - dialog_h) / 2;
        dialog.css("margin-left", left+"px");
        dialog.css("margin-top", top+"px");
    },
    render: function () {
        return (
            <div id="fragment_msg_dialog_content" ref="content">
                <div id="dialog" className={this.state.dialogClassName} ref="dialog">
                    <div id="body" ref="dialog_body">
                        <span id="msg_p">{this.props.msg}</span>
                        <a id="close_btn" href="javascript:void(0);" onClick={this.fadeOut}>取消</a>
                    </div>

                </div>
            </div>

        );
    }
});

export default MsgDialog;   //将App组件导出
