import React from "react"; //引入react组件
import {EventEmitter} from "events";
window.event = new EventEmitter();
//项目前端事件分发器
window.VmFrontendEventsDispatcher = {
    event: window.event,
    showMsgDialog: function (msg, onCloseCallfun) {
        this.event.emit('showMsgDialog', msg, onCloseCallfun);
    }

};
window.EventsDispatcher = window.VmFrontendEventsDispatcher;
var eventsDispatcher = window.EventsDispatcher;
var EventsDispatcher = eventsDispatcher;


