import React from 'react';  //引入react组件
import "../scss/img_upload.scss";
/**
 * 图片上传组件
 */
var ImgUpload = React.createClass({
    getInitialState: function () {

        return {
            config:this.props.config,
            uploadTempImgUrl: this.props.uploadTempImgUrl,
            saveImgUrl: this.props.saveImgUrl
        };
    },
    render: function () {
        return;
    }
});
export default ImgUpload;