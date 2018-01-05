import React from 'react';  //引入react组件
import "../scss/date.scss";
/*日期插件*/
var Date = React.createClass({
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
    componentDidMount(){
    },
    handleYearChange(){
        this.props.onDateChange(this.state.date);
    },
    handleMonthChange(){
        this.props.onDateChange(this.state.date);
    },
    handleDayChange(){
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

    updateStateYears(years){
        var state = this.state;
        state.years = years;
        this.setState(state);
    },
    updateStateMonths(months){

        var state = this.state;
        state.months = months;
        this.setState(state);
    },

    updateStateDays(days){

        var state = this.state;
        state.days = days;
        this.setState(days);
    },
    setYearValue(year){

    },
    setMonthValue(month){

    },

    setDayValue(day){

    },
    render: function () {

        this.initDateData();

        var yearOptions = function () {
            var res = [];
            for (var i = 0; i < this.state.years.length; i++) {
                var year = this.state.years[i];
                return <option value={year}>{year}</option>;
            }
        }
        var monthOptions = function () {
            var res = [];
            for (var i = 0; i < this.state.months.length; i++) {
                var month = this.state.months[i];
                return <option value={month}>{month}</option>;
            }
        }
        var dayOptions = function () {
            var res = [];
            for (var i = 0; i < this.state.days.length; i++) {
                var day = this.state.days[i];
                return <option value={day}>{day}</option>;
            }
        }

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
export default withRouter(UserPage);