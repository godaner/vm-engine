import React from 'react';  //引入react组件
import {Switch, BrowserRouter, HashRouter, Route, Link, NavLink, withRouter} from 'react-router-dom';
import PlainPanelTitle from "./plain_panel_title";
import UserBasicInfoPage from "./user_basic_info_page";
import "../scss/user_info_page.scss";
/*用户个人中心*/
var UserInfoPage = React.createClass({
    getInitialState: function () {
        return {
            userId: this.props.match.params.userId
        };
    },
    componentDidMount(){
        // checkUserOnlineStatus();
    },
    render: function () {
        var basicInfoUrl = "/user/basicInfo/" + this.state.userId;
        var resetPwdUrl = "/user/resetPwd/" + this.state.userId;
        return (
            <div id="user_info" className="defaultPanel">
                <PlainPanelTitle title={this.state.title}/>
                <HashRouter>
                    <div id="content"
                         className="clearfix">
                        <div id="nav">
                            <ul id="nav_ul">

                                <li>
                                    <NavLink to={basicInfoUrl}
                                             activeClassName="active">
                                        基本信息
                                    </NavLink>
                                </li>
                                <li>
                                    <NavLink to={resetPwdUrl}
                                             activeClassName="active">
                                        修改密码
                                    </NavLink>
                                </li>
                            </ul>
                        </div>
                        <div id="displayer">
                            <Switch>
                                <Route exact path='/user/basicInfo/:userId' component={UserBasicInfoPage}/>
                                <Route exact path='/user/resetPwd/:userId' component={UserBasicInfoPage}/>
                            </Switch>
                        </div>
                    </div>
                </HashRouter>
            </div>
        );
    }
});
export default withRouter(UserInfoPage);