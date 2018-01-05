import React from 'react';  //引入react组件
import "../scss/dater.scss";
/*日期插件*/
var Dater = React.createClass({
    getInitialState: function () {

        var now = new Date();

        var maxYear = now.getYear();

        var minYear = now.getYear() - 30;
        if (!isEmpty(this.props.minYear) && this.props.minYear <= maxYear) {
            minYear = this.props.minYear;
        }
        return {
            date: {
                year: undefined,
                month: undefined,
                day: undefined
            },
            years: [],
            months: [],
            days: [],
            now: now,
            minYear: minYear,
            maxYear: maxYear

        };
    },
    componentDidMount: function () {
    },
    handleYearChange: function () {
        this.props.onDateChange(this.state.date);
    },
    handleMonthChange: function () {
        this.props.onDateChange(this.state.date);
    },
    handleDayChange: function () {
        this.props.onDateChange(this.state.date);
    },
    initDateData: function () {
        //init years
        var years = [];
        for (var i = this.state.minYear; i <= this.state.maxYear; i++) {
            years.push(i);
        }
        this.updateStateYears(years);

        //init months
        var months = [];
        for (var i = 1; i <= 12; i++) {
            months.push(i);
        }
        this.updateStateMonths(months);

        //init days
        var days = [];
        var maxDay = this.state.now.getCountOfMonthDay();
        for (var i = 1; i <= maxDay; i++) {
            days.push(i);
        }
        this.updateStateDays(days);
    },

    updateStateYears: function (years) {
        var state = this.state;
        state.years = years;
        this.setState(state);
    },
    updateStateMonths: function (months) {

        var state = this.state;
        state.months = months;
        this.setState(state);
    },

    updateStateDays: function (days) {

        var state = this.state;
        state.days = days;
        this.setState(days);
    },
    setYearValue: function (year) {

    },
    setMonthValue: function (month) {

    },

    setDayValue: function (day) {

    },
    generateOptions: function (values) {
        for (var i = 0; i < values.length; i++) {
            var value = values[i];
            return <option value={value}>{value}</option>;
        }
    },
    render: function () {

        this.initDateData();

        var yearOptions = this.generateOptions(this.state.years);
        var monthOptions = this.generateOptions(this.state.months);
        var dayOptions = this.generateOptions(this.state.days);
        return (
            <span id="date_content">
                <span>

                    <select id="year" ref="year">
                        {yearOptions()}
                    </select>年
                </span>

                <span>

                    <select id="month" ref="month">

                        {monthOptions()}
                    </select>月
                </span>

                <span>


                    <select id="day" ref="day">

                        {dayOptions()}
                    </select>日
                </span>


            </span>
        );
    }
});
export default Dater;