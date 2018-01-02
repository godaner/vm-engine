import React from 'react';  //引入react组件
import {Link} from 'react-router-dom';
import "../scss/loading.scss";
/*等待展示*/
var Loading = React.createClass({
    getInitialState: function () {
        return {
            dialogClassName: "",
            nowMsg:"",
            defaultMsg:"请稍等..."
        };
    },
    componentDidMount: function () {

        window.addEventListener('resize', this.onWindowResize)

        //adjust ui
        this.adjustUI();

        //regist events
        this.registEvents();


    },
    registEvents:function () {
        window.event.on('showLoading',(msg)=>{
            this.showLoading(msg);
        })
        window.event.on('closeLoading',()=>{
            this.closeLoading();
        })
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
    updateStateNowMsg:function (msg) {
      var state = this.state;
      state.nowMsg = msg;
      this.setState(state);
    },
    showLoading(msg){
        //choice msg
        if(isEmpty(msg)){
            this.updateStateNowMsg(this.state.defaultMsg);
        }else{
            this.updateStateNowMsg(msg);
        }

        //show it
        this.fadeIn();

        //adjust ui
        this.adjustUI();
    },

    closeLoading(){

        //show it
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
    render: function () {

        return (
            <div id="loading_content"
                 ref="content">
                <div id="dialog"
                     ref="dialog"
                     className={this.state.dialogClassName}>
                    <img src="/image/loading.gif"/>
                    <div>
                        {this.state.nowMsg}
                    </div>
                </div>
            </div>
        );
    }
});
export default Loading;