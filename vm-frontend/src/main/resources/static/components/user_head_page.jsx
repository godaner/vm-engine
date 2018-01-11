import React from "react"; //引入react组件
import {BrowserRouter, HashRouter, Link, Route, Switch} from "react-router-dom";
import "../scss/user_head_page.scss";
/*用户头像页面*/
var UserHeadPage = React.createClass({
    getInitialState: function () {
        return {
            // userId: this.props.match.params.userId,
            uploadTempHeadImgTip: "正在上传头像",
            getInfoFailure: "获取信息失败",
            userHeadImgFileTooMax: "文件过大,最大允许 : " + userHeadUploadConfig.fileMaxsize + " kb",
            userHeadImgFileExtError: "文件类型错误,允许的文件类型 : " + userHeadUploadConfig.fileTypes,
            userHeadImgFileIsEmpty: "不能是空文件",
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
                this.previewHeadImg(u.imgUrl);

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
    validateHeadImgFile(headImgFile){

        c(headImgFile);
        //size
        if (isUndefined(headImgFile.size)) {
            throw this.state.userHeadImgFileIsEmpty;
        }
        if (headImgFile.size > userHeadUploadConfig.fileMaxsize) {
            throw this.state.userHeadImgFileTooMax;
        }
        var ext = getFileNameExt(headImgFile.name);
        if (!userHeadUploadConfig.fileTypes.contains(ext)) {
            throw this.state.userHeadImgFileExtError;
        }

    },
    uploadTempHeadImg(callfun){

        window.EventsDispatcher.showLoading(this.state.uploadTempHeadImgTip);
        var headImg = $(this.refs.headImg).get(0).files[0];
        //validateHeadImgFile
        try {
            this.validateHeadImgFile(headImg)
        } catch (e) {
            window.EventsDispatcher.closeLoading();
            window.EventsDispatcher.showMsgDialog(e);
            $(this.refs.headImg).val("");
            return;
        }


        var formData = new FormData();
        formData.append("headImg", headImg);
        var userId = this.state.user.id;
        const url = "/user/" + userId + "/img/upload/temp";
        ajax.post({
            url: url,
            data: formData,
            enctype: 'multipart/form-data',
            contentType: false, //必须false才会避开jQuery对 formdata 的默认处理 XMLHttpRequest会对 formdata 进行正确的处理
            processData: false, //必须false才会自动加上正确的Content-Type
            onBeforeRequest: function () {

            }.bind(this),
            onResponseStart: function () {
                window.EventsDispatcher.closeLoading();

            }.bind(this),
            onResponseSuccess: function (result) {
                this.previewHeadImg(result.data.tempHeadImgUrl);
            }.bind(this),
            onResponseFailure: function (result) {

            }.bind(this),
            onResponseEnd: function () {
                //callfun
                if (callfun != undefined) {
                    callfun()
                }
            }.bind(this),
            onRequestError: function () {

            }.bind(this)
        })
    },
    previewHeadImg(tempHeadImgUrl){
        $(this.refs.headImgPreview).attr("src", tempHeadImgUrl);
        $(this.refs.headImgPreview0).attr("src", tempHeadImgUrl);
        $(this.refs.headImgPreview1).attr("src", tempHeadImgUrl);
        $(this.refs.headImgPreview2).attr("src", tempHeadImgUrl);
    },

    render: function () {
        return (
            <div id="user_head_content" className="clearfix">

                <div id="head_upload">

                    <form id="headImgForm"
                          ref="headImgForm"
                          method="post"
                          encType="multipart/form-data">

                        <img src=""
                             id="headImgPreview"
                             ref="headImgPreview"/>
                        <input type="file"
                               ref="headImg"
                               name="headImg"
                               onChange={() => {
                                   this.uploadTempHeadImg()
                               }}/>

                        <input type="button"
                               ref="headSubmitBtn"
                        />
                    </form>
                </div>
                <div id="head_preview">
                    <img ref="headImgPreview0"
                         id="headImgPreview0"
                         src=""/>
                    <img ref="headImgPreview1"
                         id="headImgPreview1"
                         src=""/>
                    <img ref="headImgPreview2"
                         id="headImgPreview2"
                         src=""/>
                </div>
            </div>
        );
    }
});
export default UserHeadPage;