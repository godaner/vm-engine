import React from 'react';  //引入react组件
import "../scss/date.scss";
/*日期插件*/
var Date = React.createClass({
    getInitialState: function () {
        return {
            onSelect: this.props.onSelect
        };
    },
    componentDidMount(){
        this.initDate();
    },
    initDate: function () {

    },
    render: function () {


        return (
            <span id="date_content">
                <select id="year" ref="year">

                </select>年

                <select id="month" ref="month">

                </select>月

                <select id="day" ref="day">

                </select>日
            </span>
        );
    }
});
export default withRouter(UserPage);