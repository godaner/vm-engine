
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


