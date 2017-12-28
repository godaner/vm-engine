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
    render: function () {
        return <div>UserInfoPage</div>;
    }
});
export default UserInfoPage;