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
            years: years,
            months: months,
            days: days,
            now: now,
            minYear: minYear,
            maxYear: maxYear
        };
    },
    splitDate: function (originalJsDate) {
        var date = undefined;
        if (!isUndefined(originalJsDate)) {

            var year = originalJsDate.getFullYear();
            var month = originalJsDate.getMonth() + 1;
            var day = originalJsDate.getDate();
            date = {year: year, month: month, day: day};
        }
        return date;
    },
    componentDidMount: function () {

    },
    handleYearChange: function (e) {
        var year = e.target.value;
        c(year);
        // this.updateStateYear(year);
        // this.props.onDateChange(this.state.date);
    },
    handleMonthChange: function (e) {

        var month = e.target.value;
        c(month);
        // this.updateStateYear(month);
        // this.props.onDateChange(this.state.date);
    },
    handleDayChange: function (e) {

        var day = e.target.value;
        c(day);
        // this.updateStateYear(day);
        // this.props.onDateChange(this.state.date);
    },
    /*updateStateYear: function (year) {
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
    },*/
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
        //deal defaultDate
        var now = this.state.now;
        var date = {
            year: now.getFullYear(),
            month: now.getMonth() + 1,
            day: now.getDate()
        };
        c(now);
        c(now.getDate());
        if (!isUndefined(this.props.intDate)) {
            c("if (!isUndefined(this.props.intDate)) {");
            date = this.splitDate(new Date(this.props.intDate));
        }

        c("dates");
        c(date);
        c("datee");
        return (
            <span id="date_content">
                <span>
                    <select id="year"
                            ref="year"
                            defaultValue={date.year}
                            onChange={this.handleYearChange}>
                        {this.generateOptions(this.state.years)}
                    </select>年
                </span>

                <span>
                    <select id="month"
                            ref="month"
                            defaultValue={date.month}
                            onChange={this.handleMonthChange}>
                        {this.generateOptions(this.state.months)}
                    </select>月
                </span>

                <span>
                    <select id="day"
                            ref="day"
                            defaultValue={date.day}
                            onChange={this.handleDayChange}>
                        {this.generateOptions(this.state.days)}
                    </select>日
                </span>


            </span>
        );
    }
});
export default Dater;