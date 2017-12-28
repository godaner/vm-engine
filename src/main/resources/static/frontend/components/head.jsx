import React from 'react';  //引入react组件
import {Link} from 'react-router-dom';
import '../scss/head.scss';
var Head = React.createClass({

    getInitialState: function () {
        return {
            user: {}//默认为空对象
        };
    },
    componentDidMount: function () {
        this.getOnlineUser();
    },
    getOnlineUser: function () {
        const url = "/user/online";
        $.get(url, function (result) {

            if(fail(result.code)){

                window.VmFrontendEventsDispatcher.showMsgDialog(result.msg);
                return ;
            }

            var state = this.state;
            if(isEmpty(result.data.user)){
                state.user = {};
            }else{
                state.user = result.data.user;
            }

            this.setState(state);

        }.bind(this));
    },
    render: function () {
        const location = {
            pathname: "/user/" + this.state.user.id
        };
        return (
            <div id="fragment_head_content">
                <div id="nav_div">
                    <ul id="fragment_head_nav">
                        <li id="fragment_head_nav_logo">
                            <Link to="/">
                                <span id="logo_v">V</span><span id="logo_m">M</span>
                            </Link>
                        </li>
                        <li id="user_li">
                            <ul id="user_ul">
                                <li>
                                    <a id="headImg_a" href="#">
                                        <img id="headImg_img" src="/frontend/image/head.png"/>
                                    </a>
                                </li>

                                <li>
                                    <Link id="username" to={location}>

                                        刘二狗和张狗蛋

                                    </Link>
                                </li>
                                <li>
                                    <a href="#">注销</a>
                                </li>

                            </ul>
                        </li>

                    </ul>

                </div>
                {/*与nav_div同高,用于填充nav_div脱离文档流后的空白*/}
                <div id="blank_div"></div>
            </div>
        );
    }
});

export default Head;   //将App组件导出