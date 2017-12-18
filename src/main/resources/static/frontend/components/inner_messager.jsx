import React from 'react';  //引入react组件
import '../scss/inner_messager.scss';

var InnerMessager = React.createClass({
    getInitialState: function () {

        var state = {};


        //default tip
        var defaultTip = "正在加载";
        if (this.props.defaultTip != undefined && this.props.defaultTip != null) {
            defaultTip = this.props.defaultTip;
        }

        //init state
        state = {defaultTip:defaultTip,tip: "", cacheTip: "", tipPoint: ".", tipPointMaxNum: 4, tipPointNum: 0, timer: undefined};
        return state;

    },
    componentDidMount: function () {
        //when ui loaded start show loop tip
        this.startLoopShowTipTimer(this.state.defaultTip);

    },
    stopLoopShowTipTimer: function () {
        //clear interval timer and clear the tip
        var state = this.state;
        if (state.timer != undefined) {
            clearInterval(state.timer);
            state.timer = undefined;
        }
        state.tip = "";
        state.cacheTip = "";
        this.setState(state);
    },
    startLoopShowTipTimer: function (msg) {
        //set tip in state
        var state = this.state;
        state.tip = state.cacheTip = msg;
        this.setState(state);

        //set timer in state
        state = this.state;
        state.timer = setInterval(function () {
            var state = this.state;
            var tip = state.tip;
            if (state.tipPointNum >= state.tipPointMaxNum) {
                tip = state.cacheTip;
                state.tipPointNum = 0;
            }
            tip = tip + state.tipPoint;

            state.tipPointNum = state.tipPointNum + 1;

            state.tip = tip;

            this.setState(state);
        }.bind(this), 500);
        this.setState(state);
    },
    componentWillUnmount: function () {
        //clear interval timer
        this.stopLoopShowTipTimer();
    },
    showMsg(msg) {

        //stop loop show tip
        this.stopLoopShowTipTimer();


        //start loop show tip
        if (msg != undefined && msg != "") {
            this.startLoopShowTipTimer(msg);
        }


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