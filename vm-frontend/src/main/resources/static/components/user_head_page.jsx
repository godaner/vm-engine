import React from "react"; //引入react组件
import {BrowserRouter, HashRouter, Link, Route, Switch} from "react-router-dom";
import "../scss/user_head_page.scss";
import ImgUploader from "./img_uploader";


/*用户头像页面*/
var UserHeadPage = React.createClass({
    getInitialState: function () {
        var config = {
            fileTypes: ["jpg", "png"],
            fileMaxsize: 1024 * 1024 * 2,//2M
            saveImgUrl:"/user/img",
            uploadTempImgUrl:"/user/img/temp"
        };
        return {
            config: config,
            // userId: this.props.match.params.userId,
            getInfoFailure: "获取信息失败",
            userHeadRequestWidth: 300,
            user: {}
        };
    },
    componentDidMount(){
        this.getOnlineUser();
    },

    updateStateUser: function (user) {
        if (isEmpty(user)) {
            user = {};
        }
        var state = this.state;
        state.user = user;
        this.setState(state);
    },
    getOnlineUser(callfun){
        // c(this.props);
        const url = "/user/online";
        ajax.get({
            url: url,
            onBeforeRequest: function () {

            }.bind(this),
            onResponseStart: function () {

            }.bind(this),
            onResponseSuccess: function (result) {
                var u = result.data.user;
                //update user in state
                this.updateStateUser(u);
                this.previewHeadImg(u.imgUrl + "?width=" + this.state.userHeadRequestWidth + "&t=" + Date.now());

            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(this.state.getInfoFailure);
            }.bind(this),
            onResponseEnd: function () {
                //callfun
                if (callfun != undefined) {
                    callfun()
                }
            }.bind(this, callfun)
        });
    },
    getUserHeadUploader(){
        return this.refs.userHeadUploader;
    },
    previewHeadImg(imgUrl){
        this.getUserHeadUploader().previewImg(imgUrl);
    },
    onUpdateImgSuccess(result){
        window.EventsDispatcher.onUpdateHeadImgSuccess(result.data.user);
    },
    render: function () {
        return (
            <div id="user_head_content" className="clearfix">

                <div id="react_img_uploader">
                    <ImgUploader ref="userHeadUploader"
                                 config={this.state.config}
                                 onUpdateImgSuccess={this.onUpdateImgSuccess}/>
                </div>

                <div id="tip">
                    <p>在这里可以上传您的头像</p>
                </div>
            </div>
        );
    }
});
export default UserHeadPage;