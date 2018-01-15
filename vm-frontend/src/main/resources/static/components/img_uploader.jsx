import React from 'react';  //引入react组件
import "../scss/img_uploader.scss";
/**
 * 图片上传组件
 */
var ImgUpload = React.createClass({
    getInitialState: function () {

        // var config = {
        //     fileTypes: ["jpg", "png"],
        //     fileMaxsize: 1024 * 1024 * 2,//1M
        //     saveImgUrl:"/online/img",//服务器接受x,y,w,h,fileId等参数,返回newImgUrl
        //     uploadTempImgUrl:"/online/img/temp",//服务器接受imgFile,返回tempImgUrl和fileId
        //      defaultDisplayImg:"/img/1?width=11&t=1321321"
        // };
        var config = this.props.config;
        return {
            config: config,
            uploadTempImgTip: "正在读取头像",
            saveImg: "正在保存头像",
            userImgFileTooMax: "文件过大,最大允许 : " + (config.fileMaxsize / 1024) + " kb",
            userImgFileExtError: "文件类型错误,允许的文件类型 : " + config.fileTypes,
            userImgFileIsEmpty: "请选择一个文件",
            userImgUpdateSuccess: "头像更新成功",
            willUpdatedImgInfo: {
                fileId: undefined//服务器临时保存的用户头像的filename，如a.png，如果为undefined，那么将禁止其更新头像
            },
            $imgPreview: undefined,
        };
    },
    componentDidMount(){
        this.previewImg(this.state.config.defaultDisplayImg);
    },
    validateImgFileOnSubmit(){
        //服务器未接收到相关的图片缓存
        if (isUndefined(this.state.willUpdatedImgInfo.fileId)) {
            throw this.state.userImgFileIsEmpty;
        }
    },
    validateImgFileOnChoice(imgFile){

        // c(imgFile);

        //unselect, size
        if (isUndefined(imgFile) || isUndefined(imgFile.size)) {
            throw this.state.userImgFileIsEmpty;
        }
        if (imgFile.size > this.state.config.fileMaxsize) {
            throw this.state.userImgFileTooMax;
        }
        var ext = getFileNameExt(imgFile.name);
        if (!this.state.config.fileTypes.contains(ext)) {
            throw this.state.userImgFileExtError;
        }

    },

    getImgInput(){
        return $(this.refs.imgInput);
    },
    getImgFile(){
        return this.getImgInput().get(0).files[0];
    },
    updateStateImgPreview($imgPreview){
        var state = this.state;
        state.$imgPreview = $imgPreview;
        this.setState(state);
    },
    previewImg(imgUrl){

        var updateWillUpdateUserImgInfo = function (e) {

            var $imageBoxData = this.state.willUpdatedImgInfo;

            $imageBoxData.x = Math.round(e.x);
            $imageBoxData.y = Math.round(e.y);

            $imageBoxData.height = Math.round(e.height);
            $imageBoxData.width = Math.round(e.width);

            $imageBoxData.rotate = Math.round(e.rotate);
            $imageBoxData.scaleX = Math.round(e.scaleX);
            $imageBoxData.scaleY = Math.round(e.scaleY);


            var state = this.state;
            state.willUpdatedImgInfo = $imageBoxData;
            this.setState(state);

            return $imageBoxData;
        }.bind(this);


        var $previews = $('.preview');
        //cropper options
        var options = {
            aspectRatio: 1 / 1,
            viewMode: 2,
            ready: function (e) {
                console.log(e.type);

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

                updateWillUpdateUserImgInfo(e);

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
                c(e.type, e.ratio);
            }
        };
        if (isUndefined(this.state.$imgPreview)) {
            var $imgPreview = $(this.refs.imgPreview);
            //init cropper
            $imgPreview.cropper(options);
            this.updateStateImgPreview($imgPreview);
        }
        this.state.$imgPreview.cropper("replace", imgUrl);

    },
    uploadTempImg(callfun){


        var imgInput = this.getImgInput();
        var imgFile = this.getImgFile();
        //validateImgFileOnChoice
        try {
            this.validateImgFileOnChoice(imgFile)
        } catch (e) {
            // window.EventsDispatcher.closeLoading();
            window.EventsDispatcher.showMsgDialog(e);

            // clear input #file
            // this.clearImgInput();
            //back self original img
            // this.previewImg(this.state.user.ImgUrl);
            return;
        }

        window.EventsDispatcher.showLoading(this.state.uploadTempImgTip);

        var formData = new FormData();
        formData.append("img", imgFile);
        // var userId = this.state.user.id;
        const url = this.state.config.uploadTempImgUrl;
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
                //更新服务器暂存图片访问地址
                this.previewImg(timestamp(result.data.tempImgUrl));
                //更新服务器暂存图片名
                this.updateTempFileId(result.data.fileId);

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
    updateTempFileId(fileId){
        var state = this.state;
        state.willUpdatedImgInfo.fileId = fileId;
        this.setState(state);
    },
    clearImgInput(){
        this.getImgInput().val("");
    },
    saveImg(callfun){

        // var imgInput = this.getImgInput();
        // var imgFile = this.getImgFile();
        try {
            this.validateImgFileOnSubmit();
        } catch (e) {
            // window.EventsDispatcher.closeLoading();
            window.EventsDispatcher.showMsgDialog(e);
            return;
        }

        window.EventsDispatcher.showLoading();

        // var userId = this.state.user.id;
        const url = this.state.config.saveImgUrl;
        var data = this.state.willUpdatedImgInfo;
        // data.serverCacheFileName = this.state.serverTempImgFileName;
        ajax.put({
            url: url,
            data: data,
            loadingMsg: this.state.saveImg,
            onBeforeRequest: function () {

            }.bind(this),
            onResponseStart: function () {
                window.EventsDispatcher.closeLoading();

            }.bind(this),
            onResponseSuccess: function (result) {

                // c("result");
                // c(result);
                this.props.onUpdateImgSuccess(result);
                // this.previewImg(result.data.tempImgUrl);

                window.EventsDispatcher.showMsgDialog(this.state.userImgUpdateSuccess);

                // clear temp filename
                this.updateTempFileId(undefined);

                //preview new img
                this.previewImg(timestamp(result.data.newImgUrl));

                this.clearImgInput();

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
            <div id="img_uploader" className="clearfix">

                <div id="img_upload">

                    <div id="img_upload_to_middle_div">
                        <div id="imgPreviewWrapper"
                             ref="imgPreviewWrapper">
                            <img src=""
                                 id="imgPreview"
                                 ref="imgPreview"/>
                        </div>


                        <div id="btns_div">
                            <input type="file"
                                   ref="imgInput"
                                   name="img"
                                   id="imgInput"
                                   onChange={() => {
                                       this.uploadTempImg()
                                   }}/>
                            <input type="button"
                                   className="operateBtn"
                                   id="uploadTempImgBtn"
                                   value="选择图片"
                                   onClick={() => {
                                       this.refs.imgInput.click();
                                   }}/>
                            <input type="button"
                                   className="operateBtn"
                                   id="imgSaveBtn"
                                   ref="imgSaveBtn"
                                   onClick={() => {
                                       this.saveImg()
                                   }}
                                   value="保存"
                            />
                        </div>
                    </div>

                </div>
                <div id="head_preview">
                    <p>预览 : </p>
                    <div id="imgPreview0">
                        <div className="preview"/>
                        80x
                    </div>
                    <div id="imgPreview1">
                        <div className="preview"/>
                        50x
                    </div>
                    <div id="imgPreview2">
                        <div className="preview"/>
                        30x
                    </div>
                </div>
            </div>
        )

    }
});
export default ImgUpload;