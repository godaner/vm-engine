import React from "react"; //引入react组件
import {BrowserRouter, HashRouter, Link, Route, Switch} from "react-router-dom";
import Dater from "./dater";
import "../scss/user_basic_info_page.scss";
/*用户基本信息页面*/
var UserBasicInfoPage = React.createClass({
    getInitialState: function () {
        // c(props);
        return {
            // userId: this.props.match.params.userId,
            getInfoFailure: "获取信息失败",
            title: "用户个人信息",
            updateUserBasicInfoSuccess:"更新用户信息成功",
            updateUserBasicInfoFailure:"更新用户信息失败",
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
                // c(result);
                var u = result.data.user;
                // var u = {
                //     birthday: 0,
                //     createTime: 1515394557,
                //     description: 6666,
                //     id: 37,
                //     imgUrl: "/user/img/-1",
                //     "password": "",
                //     "sex": 3,
                //     "status": 1,
                //     "updateTime": 1515394557,
                //     "username": "root"
                //
                // };
                //update user in state
                this.updateStateUser(u);


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
    handleBirthdayChange: function (date) {
        c("handleBirthdayChange");

        this.updateUserBirthday(date.getTime() / 1000);

    },
    updateUserBirthday(birthday){
        var user = this.state.user;
        user.birthday = birthday;
        this.updateStateUser(user);
    },
    updateUserBasicInfo:function (callfun) {
        // c(this.props);
        const url = "/user/online/update";
        ajax.put({
            url: url,
            data:this.state.user,
            onBeforeRequest: function () {

            }.bind(this),
            onResponseStart: function () {

            }.bind(this),
            onResponseSuccess: function (result) {
                var u = result.data.user;
                //update user in state
                this.updateStateUser(u);
                window.VmFrontendEventsDispatcher.showMsgDialog(this.state.updateUserBasicInfoSuccess);

            }.bind(this),
            onResponseFailure: function (result) {
                window.VmFrontendEventsDispatcher.showMsgDialog(this.state.updateUserBasicInfoFailure);
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
        var t = parseInt(this.state.user.birthday);
        var birthday = new Date(t * 1000);
        return (
            <div id="user_basic_info_content" className="clearfix">
                <div id="basic_info">
                    <form>
                        <div id="displayer">
                            <div id="username_div" className="info_item clearfix">
                                <label>昵称 : </label>
                                <span className="split"></span>
                                <span className="content">
                                    <input value={this.state.user.username}/>
                                </span>
                            </div>
                            <div id="sex_div" className="info_item clearfix">
                                <label>性别 : </label>
                                <span className="split"></span>
                                <span className="content">
                                    <select selected={this.state.user.sex}>
                                        <option value="1">男</option>
                                        <option value="2">女</option>
                                        <option value="3">保密</option>
                                    </select>
                                 </span>
                            </div>
                            <div id="birthday_div" className="info_item clearfix">
                                <label>生日 : </label>
                                <span className="split"></span>
                                <span className="content">
                                    {/*日期组件*/}
                                    <Dater defaultDate={birthday}
                                           onDateChange={this.handleBirthdayChange}/>

                                 </span>
                            </div>
                            <div id="description_div" className="info_item clearfix">
                                <label>描述 : </label>
                                <span className="split"></span>
                                <span className="content">
                                     <textarea placeholder="请输入描述信息"
                                               value={this.state.user.description}>
                                     </textarea>
                                 </span>
                            </div>
                            <div id="confirm_div">
                                <input type="button"
                                       onClick={this.updateUserBasicInfo}
                                       value="确定"/>
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