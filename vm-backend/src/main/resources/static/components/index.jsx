import ReactDOM from 'react-dom';
import React from 'react';
import {Layout, Menu, Breadcrumb, Icon} from 'antd';
const {Header, Content, Footer, Sider} = Layout;
const SubMenu = Menu.SubMenu;
import {Switch, BrowserRouter, HashRouter, Route} from 'react-router-dom';
import {EventEmitter} from 'events';
import "antd/dist/antd.css";
import '../scss/index.scss';
// import Head from "./head";
// import Tail from "./tail";
import "./events_dispatcher";

var Index = React.createClass({
    getInitialState: function () {
        return {};
    },
    onCollapse(collapsed){
        // console.log(collapsed);
        this.setState({collapsed});
    },
    render: function () {
        //set now page's props
        return (
            <HashRouter>
                <Layout style={{minHeight: '100vh'}}>
                    <Sider
                        collapsible
                        collapsed={this.state.collapsed}
                        onCollapse={this.onCollapse}
                    >
                        <div className="logo"/>
                        <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
                            <SubMenu
                                key="userMenu"
                                title={<span><Icon type="user"/><span>用户管理</span></span>}
                            >
                                <Menu.Item key="1">信息管理</Menu.Item>
                                <Menu.Item key="2">登录记录</Menu.Item>
                                {/*<Menu.Item key="5">Alex</Menu.Item>*/}
                            </SubMenu>
                            <SubMenu
                                key="adminMenu"
                                title={<span><Icon type="lock"/><span>管理员管理</span></span>}
                            >
                                <Menu.Item key="3">信息管理</Menu.Item>
                                <Menu.Item key="4">登录记录</Menu.Item>
                            </SubMenu>
                            <SubMenu
                                key="movieMenu"
                                title={<span><Icon type="play-circle-o"/><span>电影管理</span></span>}
                            >
                                <Menu.Item key="5">信息管理</Menu.Item>
                            </SubMenu>
                            {/*<Menu.Item key="2">*/}
                                {/*<Icon type="desktop"/>*/}
                                {/*<span>视频管理</span>*/}
                            {/*</Menu.Item>*/}


                        </Menu>
                    </Sider>
                    <Layout>
                        <Header style={{background: '#fff', padding: 0}}/>
                        <Content style={{margin: '0 16px'}}>
                            <Breadcrumb style={{margin: '16px 0'}}>
                                <Breadcrumb.Item>User</Breadcrumb.Item>
                                <Breadcrumb.Item>Bill</Breadcrumb.Item>
                            </Breadcrumb>
                            <div style={{padding: 24, background: '#fff', minHeight: 360}}>
                                Bill is a cat.
                            </div>
                        </Content>
                        <Footer style={{textAlign: 'center'}}>
                            Ant Design ©2016 Created by Ant UED
                        </Footer>
                    </Layout>
                </Layout>

            </HashRouter>
        );
    }
});

export default Index;   //将App组件导出
