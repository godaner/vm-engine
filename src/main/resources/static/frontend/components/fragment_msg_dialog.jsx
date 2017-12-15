import React from 'react';  //引入react组件

var MsgDialog = React.createClass({
    getInitialState:function(){
        return null;
    },
    componentDidMount: function () {
        window.addEventListener('resize', this.onWindowResize)
        this.adjustUI();
    },
    componentWillUnmount:function() {
        window.removeEventListener('resize', this.onWindowResize)
    },
    onWindowResize:function () {
        this.adjustUI();

    },
    adjustUI:function (){
        {/*调整样式*/}
        var body_w = document.body.clientWidth;
        var body_h = document.body.clientHeight;
        var dialog = $(this.refs.dialog);
        var dialog_h = dialog.height();
        var dialog_w = dialog.width();
        var top_bottom = (body_h -dialog_h)/2;
        var left_right = (body_w -dialog_w)/2;
        {/*设置外边距*/}
        var margin = top_bottom +"px "+left_right +"px";
        dialog.css("margin",margin);
    },
    render:function(){
        return (
            <div id="dialog" ref="dialog">
                <div id="head">
                    <div>信息</div>
                    <div id="close">X</div>
                </div>
                <div id="body">
                    {this.props.msg}
                </div>

            </div>
        );
    }
});

export default MsgDialog;   //将App组件导出
