//成功返回码
const RESPONSE_CODE_SUCCESS = 1;
//失败返回码
const RESPONSE_CODE_FAILURE = 2;


function fail(code) {
    return code == RESPONSE_CODE_FAILURE;
}
function success(code) {
    return code == RESPONSE_CODE_SUCCESS;
}
//电影图片等待加载时使用的图片
const MOVIE_LOADING_IMG = "/frontend/image/movie_img_loading.gif";

//电影人图片等待加载时使用的图片
const FILMMAKER_LOADING_IMG = "/frontend/image/filmmaker_img_loading.gif";
//websocket前缀
const WS_URL_PREFIX = "ws://localhost:8888";

//开始懒加载，依赖jquery.lazyload.js
function lazyLoad() {
    // c($("img"));
    $("img").lazyload({effect: "fadeIn"});
}
//ajax封装
//common是所有的返回结果都会执行的方法
var ajax = {
    ajaxError: "访问服务器失败,请稍后重试",
    requestServerSuccess: function (args, result) {
        c(result);
        if (!isEmpty(args.onResponseStart)) {
            args.onResponseStart();
        }
        if (fail(result.code) && !isEmpty(args.onResponseFailure)) {
            args.onResponseFailure(result);
        }
        if (success(result.code) && !isEmpty(args.onResponseSuccess)) {
            args.onResponseSuccess(result);
        }
        if (!isEmpty(args.onResponseEnd)) {
            args.onResponseEnd();
        }

    },
    requestServerError: function (args) {
        if (!isEmpty(args.onResponseStart)) {
            args.onResponseStart();
        }

        window.VmFrontendEventsDispatcher.showMsgDialog(this.ajaxError, function () {
            if (!isEmpty(args.onRequestError)) {
                args.onRequestError();
            }
            if (!isEmpty(args.onResponseEnd)) {
                args.onResponseEnd();
            }

        });


    },
    ajax: function (args) {
        if (!isEmpty(args.onBeforeRequest) && args.onBeforeRequest() == false) {
            return;
        }
        $.ajax({
            url: args.url,
            type: args.type,
            success: function (result) {
                this.requestServerSuccess(args, result);
            }.bind(this),
            error: function () {
                this.requestServerError(args);
            }.bind(this)
        });
    },
    get: function (args) {
        args.type = "GET";
        this.ajax(args);
    },
    put: function (args) {
        args.type = "PUT";
        this.ajax(args);
    }
};





