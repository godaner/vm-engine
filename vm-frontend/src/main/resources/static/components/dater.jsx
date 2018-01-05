import React from 'react';  //引入react组件
import "../scss/dater.scss";
/*日期插件*/
var Dater = React.createClass({
    getInitialState: function () {
        //init default value
        var now = new Date();
        //init maxYear
        var maxYear = now.getFullYear();

        //init minYear
        var minYear = maxYear - 100;

        if (!isEmpty(this.props.minYear) && this.props.minYear <= maxYear) {
            minYear = this.props.minYear;
        }
        //init date
        var date = {
            year: now.getFullYear(),
            month: now.getMonth() + 1,
            day: now.getDate()
        };
        if (!isEmpty(this.props.defaultDate)) {
            date = this.props.defaultDate;
        }

        //init years
        var years = [];
        for (var i = this.state.maxYear; i >= this.state.minYear; i--) {
            years.push(i);
        }
        //init months
        var months = [];
        for (var i = 1; i <= 12; i++) {
            months.push(i);
        }
        //init days
        var days = [];
        var maxDay = this.state.now.getCountOfMonthDay();
        for (var i = 1; i <= maxDay; i++) {
            days.push(i);
        }
        return {
            date: date,
            years: years,
            months: months,
            days: days,
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
    generateOptions: function (values, selectedVal) {
        var res = [];
        for (var i = 0; i < values.length; i++) {
            var value = values[i];
            var selected = "selected";
            if (selectedVal != value) {
                selected = "";
            }
            res.push(
                <option key={value}
                        value={value}
                        selected={selected}>
                    {value}
                </option>
            );
        }
        return res;
    },
    render: function () {


        return (
            <span id="date_content">
                <span>
                    <select id="year"
                            ref="year"
                            onChange={this.handleYearChange()}>
                        {this.generateOptions(this.state.years, this.state.date.year)}
                    </select>年
                </span>

                <span>
                    <select id="month" ref="month" onChange={this.handleMonthChange()}>
                        {this.generateOptions(this.state.months, this.state.date.month)}
                    </select>月
                </span>

                <span>
                    <select id="day" ref="day" onChange={this.handleDayChange()}>
                        {this.generateOptions(this.state.days, this.state.date.day)}
                    </select>日
                </span>


            </span>
        );
    }
});
export default Dater;