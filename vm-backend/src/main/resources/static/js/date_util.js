/**
 * 获取自1970-1-1 00:00:00到现在的毫秒数
 * @returns {number}
 */
Date.prototype.nowTime = function () {
    return new Date().getTime();
}

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
Date.prototype.format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
/**
 * 某年某月的天数
 * @returns {*}
 */
Date.prototype.getCountOfMonthDay = function () { //author: meizz
    var curDate = this;
    /* 获取当前月份 */
    var curMonth = curDate.getMonth();
    /*  生成实际的月份: 由于curMonth会比实际月份小1, 故需加1 */
    curDate.setMonth(curMonth + 1);
    /* 将日期设置为0, 这里为什么要这样设置, 我不知道原因, 这是从网上学来的 */
    curDate.setDate(0);
    /* 返回当月的天数 */
    return curDate.getDate();
}


/**
 * 时间格式化
 */
var timeFormatter = {
    /**
     * 将long型的date格式化为指定格式
     */
    formatDate: function (longDate, pattern) {

        if (isEmpty(longDate)) {
            return undefined;
        }
        if (isEmpty(pattern)) {
            pattern = "yyyy-MM-dd"
        }
        if (isEmpty(longDate)) {
            return "";
        }
        return new Date(longDate).format(pattern);
    },
    /**
     * 将long型的time格式化为指定格式
     */
    formatTime: function (longTime, pattern) {
        if (isEmpty(longTime)) {
            return undefined;
        }
        if (isEmpty(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss"
        }
        if (isEmpty(longTime)) {
            return "";
        }
        return new Date(longTime).format(pattern);
    }
}

