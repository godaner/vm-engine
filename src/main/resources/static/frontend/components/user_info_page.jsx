import React from 'react';  //引入react组件
import {Link} from 'react-router-dom';
import "../scss/user_info_page.scss";
/*用户信息界面展示*/
var UserInfoPage = React.createClass({
    getInitialState: function () {
        return {
            userId: this.props.match.params.userId,
            userUrl: this.props.match.url
        };
    },
    componentDidMount(){
        this.getUserBasicInfo();
    },
    getUserBasicInfo: function () {
        const url = this.state.userUrl;
        $.get(url, function (result) {
            // c(result);
            if (fail(result.code)) {
                window.VmFrontendEventsDispatcher.showMsgDialog("获取信息失败");
                return;
            }

        }.bind(this));
    },
    render: function () {
        return <div>UserInfoPage</div>;
    }
});
export default UserInfoPage;