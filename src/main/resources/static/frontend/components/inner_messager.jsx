import React from 'react';  //引入react组件
import '../scss/inner_messager.scss';

var InnerMessager = React.createClass({
    getInitialState: function () {

        var state = {};
        var tip = "正在加载...";
        if (this.props.tip != undefined && this.props.tip != "") {
            tip = this.props.tip;
        }
        state = {tip: tip};
        return state;

    },
    showMsg(msg) {
        if (msg == undefined) {
            msg = "";
        }
        var state = this.state;
        state.tip = msg;
        this.setState(state);
    },
    render: function () {
        return (
            <div id="tip">{this.state.tip}</div>
        );
    }
});

export default InnerMessager;   //将App组件导出