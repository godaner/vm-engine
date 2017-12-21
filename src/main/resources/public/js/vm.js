
//成功返回码
const RESPONSE_CODE_SUCCESS = 1;
//失败返回码
const RESPONSE_CODE_FAILURE = 2;


function fail(code){
    return code == RESPONSE_CODE_FAILURE;
}
function success(code){
    return code == RESPONSE_CODE_SUCCESS;
}

const LOADING_IMG = "/frontend/image/img_loading.gif";
//开始懒加载，依赖jquery.lazyload.js
function lazyLoad(){
    // c($("img"));
    $("img").lazyload({effect: "fadeIn"});
}

