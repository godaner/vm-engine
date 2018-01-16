import ReactDOM from 'react-dom';
import React from 'react';
import {Layout, Menu, Breadcrumb, Icon} from 'antd';
const {Header, Content, Footer, Sider} = Layout;
const SubMenu = Menu.SubMenu;
import {Switch, BrowserRouter, HashRouter, Route} from 'react-router-dom';


import "antd/dist/antd.css";
import '../scss/head.scss';
import "./events_dispatcher";

var Index = React.createClass({
    getInitialState: function () {
        return {};
    },
    render: function () {
        //set now page's props
        return (

            <div id="head">
                <div key="1" style={{fontSize:25,color:'#22B9FF', paddingLeft:16}}>
                    VM后台管理系统
                </div>
                <div key="2" style={{color:'#22B9FF'}}>
                    登录
                </div>
            </div>
        );
    }
});

export default Index;   //将App组件导出
