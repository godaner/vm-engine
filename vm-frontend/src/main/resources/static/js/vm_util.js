function fail(code) {
    return code < 0;
}

function success(code) {
    return code > 0;
}


//保护用户页面
function protectUserPageWhenUserIsOffline(react_this) {
    for (var i = 0; i < protectedUserPageLists.length; i++) {
        var protectedPage = protectedUserPageLists[i];
        if (react_this.props.location.pathname.match(protectedPage)) {
            react_this.props.history.replace("/");
            break;
        }
    }

}


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
        if (isUndefined(result)) {
            return;
        }
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
    requestServerError: function (args, XMLHttpRequest, textStatus, errorThrown) {
        console.error(XMLHttpRequest);
        console.error(textStatus);
        console.error(errorThrown);


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
        //handler args.onBeforeRequest
        if (!isEmpty(args.onBeforeRequest) && args.onBeforeRequest() == false) {
            return;
        }
        //handler args.async
        if (isUndefined(args.async)) {
            args.async = true;
        }

        //handle args.contentType
        if (isUndefined(args.contentType)) {
            args.contentType = "application/json";
        }
        //handle args.data
        if (!isUndefined(args.data) && args.contentType == "application/json") {
            args.data = JSON.stringify(args.data);
        }
        //handle args.dataType
        if (isUndefined(args.dataType)) {
            args.dataType = "json";
        }
        //handle args.processData
        if (isUndefined(args.processData)) {
            args.processData = true;
        }
        //handle args.processData
        if (isUndefined(args.enctype)) {
            args.enctype = "text/plain";
        }
        // c("request data is : ");
        // c(args);
        $.ajax({
            url: args.url,
            //配合@requestBody
            data: args.data,
            async: args.async,
            type: args.type,
            contentType: args.contentType,
            dataType: args.dataType,
            processData: args.processData,
            enctype: args.enctype,
            success: function (result) {
                this.requestServerSuccess(args, result);
            }.bind(this),
            error: function (XMLHttpRequest, textStatus, errorThrown) {

                this.requestServerError(args, XMLHttpRequest, textStatus, errorThrown);
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
    },
    post: function (args) {
        args.type = "POST";
        this.ajax(args);
    },
    contentType: {
        TEXT: "text/plain",
        JSON: "application/json"
    }
};


