import ReactDOM from 'react-dom';
import React from 'react';
import {Layout, Menu, Breadcrumb, Icon, Form, Input, Button, Checkbox} from 'antd';
const FormItem = Form.Item;
const {Header, Content, Footer, Sider} = Layout;
const SubMenu = Menu.SubMenu;
import {Switch, BrowserRouter, HashRouter, Route} from 'react-router-dom';


import "antd/dist/antd.css";
import '../scss/head.scss';
import "./events_dispatcher";

var Head = React.createClass({
    getInitialState: function () {
        return {};
    },
    showLoginDialog(){
        window.EventsDispatcher.showLoginDialog();
    },
    render: function () {
        //set now page's props
        return (

            <div id="head">
                <div style={{fontSize: 25, color: '#22B9FF', float: 'left'}}>
                    VM后台管理系统
                </div>
                <div style={{color: '#22B9FF', float: 'right'}}>
                    <span onClick={this.showLoginDialog}
                          style={{cursor: 'pointer'}}>
                        登录
                    </span>
                </div>
            </div>
        );
    }
});

export default Head;   //将App组件导出
