package com.vm.frontend.controller;

import com.vm.base.utils.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 页面索引
 */
@Controller
//@RequestMapping("/")
@Api(value = "IndexController")
public class IndexController extends BaseController {
    @ApiOperation(value = "访问主页", notes = "")
//    @RequestMapping("/")
    public Object index() {
        return "index";
    }

    @ApiOperation(value = "页面转发", notes = "根据page转发到前端页面")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "index", required = true, dataType = "String"),
    })
//    @RequestMapping("/{page}")
    public Object forward(@PathVariable("page") String page) {
        return page;
    }

}
