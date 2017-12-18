import React from 'react';  //引入react组件
import '../scss/inner_messager.scss';

var InnerMessager = React.createClass({
    getInitialState: function () {

        var state = {};
        var tip = "正在加载";
        if (this.props.tip != undefined && this.props.tip != "") {
            tip = this.props.tip;
        }
        state = {tip: tip,cacheTip:"",tipPoint:".",tipPointMaxNum:4,tipPointNum:0,timer:undefined};
return state;

    },
    componentDidMount: function () {
        this.state.timer = setInterval(function(){
            var state = this.state;
            var tip = state.tip;
            if(this.state.tipPointNum>=this.state.tipPointMaxNum){
                tip = this.state.cacheTip;
                state.tipPointNum = 0;
            }
            tip = tip + this.state.tipPoint;

            state.tipPointNum = state.tipPointNum+1;

            state.tip = tip;

            this.setState(state);
        }.bind(this),500);

    },
    componentWillUnmount:function() {
        clearInterval(this.state.timer);
    },
    showMsg(msg) {
        if (msg == undefined||msg == "") {
            msg = "";
            state.cacheTip = "";
            clearInterval(this.state.timer);
        }
        var state = this.state;
        state.cacheTip = msg;
        state.tip = msg;
        this.setState(state);

    },
    hide(){
        showMsg();
    },
    hideMsg(){
        showMsg();
    },
    render: function () {
        return (
            <div id="tip">{this.state.tip}</div>
        );
    }
});

export default InnerMessager;   //将App组件导出