import React from "react"; //引入react组件
import {BrowserRouter, HashRouter, Link, Route, Switch} from "react-router-dom";
import "../scss/user_basic_info_page.scss";
/*用户基本信息页面*/
var UserBasicInfoPage = React.createClass({
    getInitialState: function () {
        // c(props);
        return {
            userId: this.props.match.params.userId,
            getInfoFailure: "获取信息失败",
            title: "用户个人信息",
            user: {}
        };
    },
    componentDidMount(){
        this.getUserBasicInfo();
    },
    updateStateUser: function (user) {
        if (isEmpty(user)) {
            user = {};
        }
        var state = this.state;
        state.user = user;
        this.setState(state);
    },
    getUserBasicInfo: function (callfun) {
        // c(this.props);
        const url = "/user/online";
        ajax.get({
            url: url,
            onBeforeRequest: function () {

            }.bind(this),
            onResponseStart: function () {

            }.bind(this),
            onResponseSuccess: function (result) {


                //update user in state
                this.updateStateUser(result.data.user);
            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(this.state.getInfoFailure);
            }.bind(this),
            onResponseEnd: function () {
                //callfun
                if (callfun != undefined) {
                    callfun()
                }
            }.bind(this)
        });


    },
    render: function () {
        return (
            <div id="user_basic_info">
                UserBasicPage
                <form>
                    <div id="displayer">
                        <div className="info_item">
                            <label>昵称 : </label>
                            <span>
                     <input value={this.state.user.username}/>
                     </span>
                        </div>
                        <div className="info_item">
                            <label>性别 : </label>
                            <span>
                     <input value={this.state.user.sex}/>
                     </span>
                        </div>
                    </div>
                </form>
            </div>
        );
    }
});
export default UserBasicInfoPage;