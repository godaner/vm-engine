import React from "react"; //引入react组件
import {BrowserRouter, HashRouter, Link, Route, Switch} from "react-router-dom";
import "../scss/user_head_page.scss";
/*用户头像页面*/
var UserHeadPage = React.createClass({
    getInitialState: function () {
        return {
            userId: this.props.match.params.userId
        };
    },
    componentDidMount(){
    },
    preImg(e){
        preImg($(e.target),$(this.refs.headImgPreview));
        preImg($(e.target),$(this.refs.headImgPreview0));
        preImg($(e.target),$(this.refs.headImgPreview1));
        preImg($(e.target),$(this.refs.headImgPreview2));
    },
    render: function () {
        return (
            <div id="user_head_content" className="clearfix">

                <div id="head_upload">
                    <input type="file"
                           ref="imgChoiceBtn"
                           value="选择图片"/>
                    <img src=""
                         id="headImgPreview"
                         ref="headImgPreview"/>
                    <input type="button"
                           ref="headSubmitBtn"
                           onChange={this.preImg}
                           value="上传"/>
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