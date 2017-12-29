import React from 'react';  //引入react组件
import {Switch, BrowserRouter, HashRouter, Route, Link, withRouter} from 'react-router-dom';
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
        checkUserOnlineStatus();
    },
    render: function () {
        return (
            <div id="user_info" className="defaultPanel">
                <PlainPanelTitle title={this.state.title}/>
                <HashRouter>
                    <div id="content"
                         className="clearfix">
                        <div id="nav">
                            nav
                        </div>
                        <div id="displayer">
                            <Switch>
                                <Route exact path='/user/:userId' component={UserBasicInfoPage}/>
                            </Switch>
                        </div>
                    </div>
                </HashRouter>
            </div>
        );
    }
});
export default withRouter(UserInfoPage);