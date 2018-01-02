import React from 'react';  //引入react组件
import '../scss/inner_messager.scss';
/*内部信息显示*/
var InnerMessager = React.createClass({
    getInitialState: function () {

        var state = {};


        //default tip
        var defaultTip = "正在加载";
        if (!isEmpty(this.props.defaultTip)) {
            defaultTip = this.props.defaultTip;
        }

        //init state
        state = {defaultTip:defaultTip,tip: "", cacheTip: "", tipPoint: ".", tipPointMaxNum: 4, tipPointNum: 0, timer: undefined};
        return state;

    },
    componentDidMount: function () {
        //when ui loaded , start show loop tip
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
    staticShowTip:function(msg){
        var state = this.state;
        state.tip = msg;
        this.setState(state);
    },
    componentWillUnmount: function () {
        //clear interval timer
        this.stopLoopShowTipTimer();
    },
    //当msg为空,将隐藏;
    //当msg不为空,loop为false,字体不会循环展示;为true或者undefined,字体循环展示;
    showMsg(msg,loop) {
        //loop default is true

        if(undefined == loop){
            loop = true;
        }

        //stop loop show tip
        this.stopLoopShowTipTimer();

        //start loop show tip
        if (msg != undefined && msg != "") {

            if(loop){
                this.startLoopShowTipTimer(msg);
            }else{
                this.staticShowTip(msg);

            }
        }

    },
    showDefaultMsg(loop) {
        this.showMsg(this.getDefaultMsg(),loop);

    },
    getDefaultMsg:function(){
        return this.state.defaultTip;
    },
    hide(){
        this.showMsg();
    },
    hideMsg(){
        this.showMsg();
    },
    render: function () {
        return (
            <div id="tip">{this.state.tip}</div>
        );
    }
});

export default InnerMessager;   //将App组件导出