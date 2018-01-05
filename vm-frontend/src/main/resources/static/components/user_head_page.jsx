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
        this.getUserBasicInfo();
    },

    render: function () {
        return (
            <div id="user_head_content">
                UserHeadPage
            </div>
        );
    }
});
export default UserHeadPage;