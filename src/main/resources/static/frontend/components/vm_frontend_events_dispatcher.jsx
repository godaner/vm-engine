import React from "react"; //引入react组件
import {EventEmitter} from "events";
window.event = new EventEmitter();
//项目前端事件分发
window.VmFrontendEventsDispatcher = {
    event:window.event,
    showMsgDialog: function (msg) {
        this.event.emit('showMsgDialog', msg);
    },
    closeMsgDialog: function () {
        this.event.emit('closeMsgDialog');
    }
};


