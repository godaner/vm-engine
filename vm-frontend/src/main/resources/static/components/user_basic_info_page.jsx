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
        const url = "/user/" + this.state.userId;
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
            <div id="user_basic_info_content" className="clearfix">
                <div id="basic_info">
                    <form>
                        <div id="displayer">
                            <div className="info_item clearfix">
                                <label>昵称 : </label>
                                <span>
                                    <input value={this.state.user.username}/>
                                </span>
                            </div>
                            <div id="sex_div" className="info_item clearfix">
                                <label>性别 : </label>
                                <span>
                                    <select value={this.state.user.sex}>
                                        <option value="1">男</option>
                                        <option value="2">女</option>
                                        <option value="3">保密</option>
                                    </select>
                                 </span>
                            </div>
                            <div id="birthday_div" className="info_item clearfix">
                                <label>生日 : </label>
                                <span>
                                    <select id="year">

                                    </select>年

                                    <select id="month">

                                    </select>月

                                    <select id="day">

                                    </select>日

                                 </span>
                            </div>
                            <div id="description_div" className="info_item clearfix">
                                <label>描述 : </label>
                                <span>
                                     <textarea placeholder="请输入描述信息">

                                     </textarea>
                                 </span>
                            </div>
                        </div>
                    </form>
                </div>
                <div id="tip">
                    请您完善账户基本信息
                </div>

            </div>
        );
    }
});
export default UserBasicInfoPage;