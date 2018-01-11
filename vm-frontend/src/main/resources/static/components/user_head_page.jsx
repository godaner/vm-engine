import React from "react"; //引入react组件
import {BrowserRouter, HashRouter, Link, Route, Switch} from "react-router-dom";
import "../scss/user_head_page.scss";
/*用户头像页面*/
var UserHeadPage = React.createClass({
    getInitialState: function () {
        return {
            // userId: this.props.match.params.userId,
            uploadTempHeadImgTip: "正在读取头像",
            saveHeadImg: "正在保存头像",
            getInfoFailure: "获取信息失败",
            userHeadImgFileTooMax: "文件过大,最大允许 : " + (userHeadUploadConfig.fileMaxsize / 1024) + " kb",
            userHeadImgFileExtError: "文件类型错误,允许的文件类型 : " + userHeadUploadConfig.fileTypes,
            userHeadImgFileIsEmpty: "请选择一个文件",
            serverTempHeadImgFileName: "",//服务器临时保存的用户头像的filename，如a.png
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
    validateHeadImgFileOnSubmit(headImgFile){
        if (isUndefined(headImgFile) || isUndefined(headImgFile.size)) {
            throw this.state.userHeadImgFileIsEmpty;
        }
    },
    validateHeadImgFileOnChoice(headImgFile){

        // c(headImgFile);

        //unselect, size
        if (isUndefined(headImgFile) || isUndefined(headImgFile.size)) {
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
    getHeadImgInput(){
        return $(this.refs.headImgInput);
    },
    getHeadImgFile(){
        return this.getHeadImgInput().get(0).files[0];
    },
    uploadTempHeadImg(callfun){


        var headImgInput = this.getHeadImgInput();
        var headImgFile = this.getHeadImgFile();
        //validateHeadImgFileOnChoice
        try {
            this.validateHeadImgFileOnChoice(headImgFile)
        } catch (e) {
            window.EventsDispatcher.closeLoading();
            window.EventsDispatcher.showMsgDialog(e);

            // clear input #file
            headImgInput.val("");
            //back self original img
            this.previewHeadImg(this.state.user.ImgUrl);
            return;
        }

        window.EventsDispatcher.showLoading(this.state.uploadTempHeadImgTip);

        var formData = new FormData();
        formData.append("headImg", headImgFile);
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
                //获取服务器暂存图片访问地址
                this.previewHeadImg(result.data.tempHeadImgUrl);
                //获取服务器暂存图片名
                this.updateServerTempHeadImgFileName(result.data.serverTempHeadImgFileName);
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
    updateServerTempHeadImgFileName(serverTempHeadImgFileName){
        var state = this.state;
        state.serverTempHeadImgFileName = serverTempHeadImgFileName;
        this.setState(state);
    },
    saveHeadImg(){

        var headImgInput = this.getHeadImgInput();
        var headImgFile = this.getHeadImgFile();
        try {
            this.validateHeadImgFileOnSubmit(headImgFile);
        } catch (e) {
            window.EventsDispatcher.closeLoading();
            window.EventsDispatcher.showMsgDialog(e);
            return;
        }

        window.EventsDispatcher.showLoading(this.state.saveHeadImg);

        var userId = this.state.user.id;
        const url = "/user/" + userId + "/update/img?userId="+userId+"&serverCacheFileName="+this.state.serverTempHeadImgFileName;
        ajax.put({
            url: url,
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
    render: function () {
        return (
            <div id="user_head_content" className="clearfix">

                <div id="head_upload">

                    <div id="head_upload_to_middle_div">
                        <img src=""
                             id="headImgPreview"
                             ref="headImgPreview"/>
                        <input type="file"
                               ref="headImgInput"
                               name="headImgInput"
                               id="headImgInput"
                               onChange={() => {
                                   this.uploadTempHeadImg()
                               }}/>
                        <div id="headImgSaveBtn_to_middle_div">
                            <input type="button"
                                   id="headImgSaveBtn"
                                   ref="headImgSaveBtn"
                                   onClick={() => {
                                       this.saveHeadImg()
                                   }}
                                   value="保存"
                            />
                        </div>
                    </div>

                </div>
                <div id="head_preview">
                    <p>头像预览 : </p>
                    <img ref="headImgPreview0"
                         id="headImgPreview0"
                         src=""/>
                    80x
                    <img ref="headImgPreview1"
                         id="headImgPreview1"
                         src=""/>
                    50x
                    <img ref="headImgPreview2"
                         id="headImgPreview2"
                         src=""/>
                    30x
                </div>

                <div id="tip">
                    <p>在这里可以上传您的头像</p>
                </div>
            </div>
        );
    }
});
export default UserHeadPage;