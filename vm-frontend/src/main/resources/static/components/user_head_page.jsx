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
            userHeadImgUpdateSuccess: "头像更新成功",
            willUpdateUserHeadImgInfo:{
                serverTempHeadImgFileName:""//服务器临时保存的用户头像的filename，如a.png
            },
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
                this.previewHeadImg(u.imgUrl + "?width=300&t=" + Date.now());

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
    previewHeadImg(tempHeadImgUrl){

        var buildImageBoxDataByCropEvent = function (e) {

            var $imageBoxData = {};

            $imageBoxData.x = Math.round(e.x);
            $imageBoxData.y = Math.round(e.y);

            $imageBoxData.height = Math.round(e.height);
            $imageBoxData.width = Math.round(e.width);

            $imageBoxData.rotate = Math.round(e.rotate);
            $imageBoxData.scaleX = Math.round(e.scaleX);
            $imageBoxData.scaleY = Math.round(e.scaleY);
            //leave serverTempHeadImgFileName
            $imageBoxData.serverTempHeadImgFileName = this.state.willUpdateUserHeadImgInfo.serverTempHeadImgFileName;



            var state = this.state;
            state.willUpdateUserHeadImgInfo = $imageBoxData;
            this.setState(state);

            return $imageBoxData;
        }.bind(this);

        var $headImgPreview = $(this.refs.headImgPreview);
        //设置src
        $headImgPreview.cropper('destroy').attr('src', tempHeadImgUrl);

        var $previews = $('.preview');
        //options
        var options = {
            aspectRatio: 1 / 1,
            viewMode: 2,
        };
        // create cropper
        $headImgPreview.on({
            ready: function (e) {
                console.log(e.type);

                //写入预览图片
                var $clone = $(this).clone().removeClass('cropper-hidden');

                $clone.css({
                    display: 'block',
                    width: '100%',
                    minWidth: 0,
                    minHeight: 0,
                    maxWidth: 'none',
                    maxHeight: 'none'
                });

                $previews.css({
                    width: '100%',
                    overflow: 'hidden'
                }).html($clone);
            },
            cropstart: function (e) {
                console.log(e.type, e.action);
            },
            cropmove: function (e) {
                console.log(e.type, e.action);
            },
            cropend: function (e) {
                console.log(e.type, e.action);
            },
            crop: function (e) {

                buildImageBoxDataByCropEvent(e);

                var imageData = $(this).cropper('getImageData');

                var previewAspectRatio = e.width / e.height;
                $previews.each(function () {
                    var $preview = $(this);
                    var previewWidth = $preview.width();
                    var previewHeight = previewWidth / previewAspectRatio;
                    var imageScaledRatio = e.width / previewWidth;

                    $preview.height(previewHeight).find('img').css({
                        width: imageData.naturalWidth / imageScaledRatio,
                        height: imageData.naturalHeight / imageScaledRatio,
                        marginLeft: -e.x / imageScaledRatio,
                        marginTop: -e.y / imageScaledRatio
                    });
                });
            },
            zoom: function (e) {
                console.log(e.type, e.ratio);
            }
        }).cropper(options);

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
        // var userId = this.state.user.id;
        const url = "/user/online/img/upload/temp";
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
                this.previewHeadImg(result.data.tempHeadImgUrl+"&t=" + Date.now());
                //获取服务器暂存图片名
                this.updateServerTempHeadImgFileName(result.data.serverTempHeadImgFileName);

                // this.initCropper();

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
    updateServerTempHeadImgFileName(serverTempHeadImgFileName){
        var state = this.state;
        state.willUpdateUserHeadImgInfo.serverTempHeadImgFileName = serverTempHeadImgFileName;
        this.setState(state);
    },
    saveHeadImg(callfun){

        var headImgInput = this.getHeadImgInput();
        var headImgFile = this.getHeadImgFile();
        try {
            this.validateHeadImgFileOnSubmit(headImgFile);
        } catch (e) {
            window.EventsDispatcher.closeLoading();
            window.EventsDispatcher.showMsgDialog(e);
            return;
        }

        window.EventsDispatcher.showLoading();

        // var userId = this.state.user.id;
        const url = "/user/online/update/img";
        var data = this.state.willUpdateUserHeadImgInfo;
        // data.serverCacheFileName = this.state.serverTempHeadImgFileName;
        ajax.put({
            url: url,
            data:data,
            loadingMsg: this.state.saveHeadImg,
            onBeforeRequest: function () {

            }.bind(this),
            onResponseStart: function () {
                window.EventsDispatcher.closeLoading();

            }.bind(this),
            onResponseSuccess: function (result) {
                this.previewHeadImg(result.data.tempHeadImgUrl);

                window.EventsDispatcher.showMsgDialog(this.state.userHeadImgUpdateSuccess);

                window.EventsDispatcher.onUpdateHeadImgSuccess(result.data.user);

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
                        <div id="headImgPreviewWrapper"
                             ref="headImgPreviewWrapper">
                            <img src=""
                                 id="headImgPreview"
                                 ref="headImgPreview"/>
                        </div>
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
                    <div id="headImgPreview0">
                        <div className="preview"/>
                        80x
                    </div>
                    <div id="headImgPreview1">
                        <div className="preview"/>
                        50x
                    </div>
                    <div id="headImgPreview2">
                        <div className="preview"/>
                        30x
                    </div>
                </div>

                <div id="tip">
                    <p>在这里可以上传您的头像</p>
                </div>
            </div>
        );
    }
});
export default UserHeadPage;