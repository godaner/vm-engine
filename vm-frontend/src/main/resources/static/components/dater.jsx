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
    getDate() {
        var year = $(this.refs.year).val();
        var month = $(this.refs.month).val();
        var day = $(this.refs.day).val();
        var d = new Date();
        d.setFullYear(year);
        d.setMonth(month - 1);
        d.setDate(day);
        return d;
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
        var now = this.state.now;
        //init date
        var date = {
            year: now.getFullYear(),
            month: now.getMonth() + 1,
            day: now.getDate()
        };
        if (!isUndefined(this.props.defaultDate)) {
            date = this.splitDate(this.props.defaultDate);
        }
        // c("render");
        // c(date);
        return (
            <span id="date_content">
                <span>
                    <select id="year"
                            ref="year"
                            defaultValue=""
                            value={date.year}
                            onChange={() => {
                                this.props.onDateChange(this.getDate())
                            }}>
                        {this.generateOptions(this.state.years)}
                    </select>年
                </span>

                <span>
                    <select id="month"
                            ref="month"
                            defaultValue=""
                            value={date.month}
                            onChange={() => {
                                this.props.onDateChange(this.getDate())
                            }}>
                        {this.generateOptions(this.state.months)}
                    </select>月
                </span>

                <span>
                    <select id="day"
                            ref="day"
                            defaultValue=""
                            value={date.day}
                            onChange={() => {
                                this.props.onDateChange(this.getDate())
                            }}>
                        {this.generateOptions(this.state.days)}
                    </select>日
                </span>


            </span>
        );
    }
});
export default Dater;