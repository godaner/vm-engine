import ReactDOM from 'react-dom';
import React from 'react';
import {Layout, Modal, Menu, Breadcrumb, Form, Icon, Input, Button, Checkbox} from 'antd';
const {Header, Content, Footer, Sider} = Layout;
const FormItem = Form.Item;
const SubMenu = Menu.SubMenu;
import {Switch, BrowserRouter, HashRouter, Route} from 'react-router-dom';
import LoginForm from "./login_form";

import "./events_dispatcher";


import "antd/dist/antd.css";
import '../scss/login_dialog.scss';



var LoginDialog = React.createClass({
    getInitialState: function () {
        return {
            loading: false,
            visible: false,
            onLoginSuccess: undefined,
            onLoginFailure: undefined
        };
    },
    updateStateVisible(visible){
        var state = this.state;
        state.visible = visible;
        this.setState(state);
    },

    updateStateLoading(loading){
        var state = this.state;
        state.loading = loading;
        this.setState(state);
    },
    updateStateOnLoginSuccess(onLoginSuccess){
        var state = this.state;
        state.onLoginSuccess = onLoginSuccess;
        this.setState(state);
    },
    updateStateOnLoginFailure(onLoginFailure){

        var state = this.state;
        state.onLoginFailure = onLoginFailure;
        this.setState(state);
    },
    registEvents(){
        window.event.on('showLoginDialog', (args) => {

            this.showLoginDialog();

            if (!isUndefined(args)) {

                this.updateStateOnLoginSuccess(args.onLoginSuccess);

                this.updateStateOnLoginFailure(args.onLoginFailure);
            }

        });
    },
    componentDidMount(){

        this.registEvents();

    },
    showLoginDialog(){
        this.updateStateVisible(true);
    },
    handleLogin  ()  {
        this.updateStateLoading(true);
        setTimeout(() => {
            this.updateStateLoading(false);
        }, 3000);
    },
    handleCancel () {
        this.updateStateVisible(false);
        this.updateStateLoading(false);
    },
    handleSubmit (e){
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
            }
        });
    },
    render: function () {


        //get state
        const {visible, loading} = this.state;
        return (
            <div id="login_dialog">
                <Modal
                    visible={visible}
                    title="登录"
                    onCancel={this.handleCancel}
                    onOk={this.handleLogin}
                    footer={[
                        <Button key="back" onClick={this.handleCancel}>取消</Button>,
                        <Button key="submit" type="primary" loading={loading} onClick={this.handleLogin}>
                            登录
                        </Button>,
                    ]}
                >
                    <div>

                        <LoginForm/>
                    </div>
                </Modal>
            </div>
        );
    }
})
export default LoginDialog;   //将App组件导出

