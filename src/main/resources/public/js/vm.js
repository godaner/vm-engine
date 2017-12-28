
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
//电影图片等待加载时使用的图片
const MOVIE_LOADING_IMG = "/frontend/image/movie_img_loading.gif";

//电影人图片等待加载时使用的图片
const FILMMAKER_LOADING_IMG = "/frontend/image/filmmaker_img_loading.gif";
//开始懒加载，依赖jquery.lazyload.js
function lazyLoad(){
    // c($("img"));
    $("img").lazyload({effect: "fadeIn"});
}




