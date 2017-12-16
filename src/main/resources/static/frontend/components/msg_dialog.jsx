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
        //set it's message
        $(this.refs.dialog_body).html(msg);
        //show it
        this.fadeIn();
    },
    fadeIn: function () {

        var state = this.state;
        $(this.refs.content).fadeIn();
        state.dialogClassName = "block animated zoomIn";
        this.setState(state);

        c(this.state);

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
        {
            /*设置外边距*/
        }
        var dialog = $(this.refs.dialog);
        var dialogPadding = dialog.css("padding").replace("px","");
        var body_w = document.body.clientWidth;
        var body_h = document.body.clientHeight;
        var dialog_w = dialog.width();
        var dialog_h = dialog.height();
        var left = (body_w - dialog_w) / 2 - 2*dialogPadding;
        var top = (body_h - dialog_h) / 2 - 2*dialogPadding;
        dialog.css("margin-left", left+"px");
        dialog.css("margin-top", top+"px");
    },
    render: function () {
        return (
            <div id="fragment_msg_dialog_content" ref="content">
                <div id="dialog" className={this.state.dialogClassName} ref="dialog">
                    <div id="head">
                        <div>信息</div>
                        <div id="close" onClick={this.close}>X</div>
                    </div>
                    <div id="body" ref="dialog_body">
                        {this.props.msg}
                    </div>

                </div>
            </div>

        );
    }
});

export default MsgDialog;   //将App组件导出
