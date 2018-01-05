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
        if (!isEmpty(this.props.defaultDate) &&
            !isEmpty(this.props.defaultDate.year) &&
            !isEmpty(this.props.defaultDate.month) &&
            !isEmpty(this.props.defaultDate.day)) {
            date = this.props.defaultDate;
        }

        //init years
        var years = [];
        for (var i = maxYear; i >= minYear; i--) {
            years.push(i);
        }
        //init months
        var months = [];
        for (var i = 1; i <= 12; i++) {
            months.push(i);
        }
        //init days
        var days = [];
        var maxDay = now.getCountOfMonthDay();
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
        var year = $(this.refs.year).val();
        c(year);
        this.updateStateYear(year);
        this.props.onDateChange(this.state.date);
    },
    handleMonthChange: function () {

        var month = $(this.refs.month).val();
        c(month);
        this.updateStateYear(month);
        this.props.onDateChange(this.state.date);
    },
    handleDayChange: function () {

        var day = $(this.refs.day).val();
        c(day);
        this.updateStateYear(day);
        this.props.onDateChange(this.state.date);
    },
    updateStateYear: function (year) {
        var state = this.state;
        state.date.year = year;
        this.setState(state);
    },
    updateStateMonth: function (month) {
        var state = this.state;
        state.date.month = month;
        this.setState(state);
    },

    updateStateDay: function (day) {
        var state = this.state;
        state.date.day = day;
        this.setState(state);
    },
    generateOptions: function (values) {
        var res = [];
        for (var i = 0; i < values.length; i++) {
            var value = values[i];

            res.push(
                <option key={value}
                        value={value}>
                    {value}
                </option>
            );
        }
        return res;
    },
    render: function () {

        c(this.state.date.year);
        c(this.state.date.month);
        c(this.state.date.day);
        return (
            <span id="date_content">
                <span>
                    <select id="year"
                            ref="year"
                            defaultValue={this.state.date.year}
                            onChange={this.handleYearChange}>
                        {this.generateOptions(this.state.years)}
                    </select>年
                </span>

                <span>
                    <select id="month"
                            ref="month"
                            defaultValue={this.state.date.month}
                            onChange={this.handleMonthChange}>
                        {this.generateOptions(this.state.months)}
                    </select>月
                </span>

                <span>
                    <select id="day"
                            ref="day"
                            defaultValue={this.state.date.day}
                            onChange={this.handleDayChange}>
                        {this.generateOptions(this.state.days)}
                    </select>日
                </span>


            </span>
        );
    }
});
export default Dater;