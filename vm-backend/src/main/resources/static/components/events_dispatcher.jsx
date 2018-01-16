import React from "react"; //引入react组件
import {EventEmitter} from "events";
window.event = new EventEmitter();
//项目前端事件分发器
window.EventsDispatcher = {
    event: window.event,
    showLoginDialog(args) {
        this.event.emit('showLoginDialog', args);
    }

};
var eventsDispatcher = window.EventsDispatcher;
var EventsDispatcher = eventsDispatcher;


