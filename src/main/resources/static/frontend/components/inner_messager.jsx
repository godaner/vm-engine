import React from 'react';  //引入react组件
import '../scss/inner_messager.scss';
var InnerMessager = React.createClass({
    getInitialState:function(){
      var state = {tip:this.props.tip};
      return state;
    },
    showMsg(msg){
        if(msg == undefined){
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