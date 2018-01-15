// var vm_config = {
//     //用户未登录时受保护的页面，用于用户注销后或者被动离线后调用
//     protectedUserPageLists: ["/user/[0-9/_-a-zA-Z]*"]
// };


//用户在其他地方登录code
const WS_USER_STATUS_RESULT_CODE_LOGIN_OTHER_AREA = 5;
//在线用户超时code
const WS_USER_STATUS_RESULT_CODE_SESSION_TIMEOUT = 6;

//电影图片等待加载时使用的图片
const MOVIE_LOADING_IMG = "/image/movie_img_loading.gif";

//电影人图片等待加载时使用的图片
const FILMMAKER_LOADING_IMG = "/image/filmmaker_img_loading.gif";
//websocket前缀
const WS_URL_PREFIX = "ws://localhost:8888";