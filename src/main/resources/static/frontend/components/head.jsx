import React from 'react';  //引入react组件
import '../scss/head.scss';
var Head = React.createClass({

    render: function () {
        return (
            <div id="fragment_head_content">
                <div id="nav_div">
                    <ul id="fragment_head_nav">
                        <li id="fragment_head_nav_logo">
                            <span id="logo_v">V</span><span id="logo_m">M</span>
                        </li>
                        <li id="user_li">
                            <ul id="user_ul">
                                <li>
                                    <a id="headImg_a" href="#">
                                        <img id="headImg_img" src="/frontend/image/head.png"/>
                                    </a>
                                </li>

                                <li>
                                    <a id="username" href="#">

                                        刘二狗和张狗蛋

                                    </a>
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