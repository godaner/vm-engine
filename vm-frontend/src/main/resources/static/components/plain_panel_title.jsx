import React from 'react';  //引入react组件
import '../scss/plain_panel_title.scss';
var PlainPanelTitle = React.createClass({
    getInitialState: function () {
        var state = {title:this.props.title};
        return state;
    },
    render: function () {
        return (
            <div id="plain_panel_title_content">
                <div id="title_div">{this.state.title}</div>
                <div id="split_line"></div>
            </div>
        );
    }
});

export default PlainPanelTitle;   //将App组件导出