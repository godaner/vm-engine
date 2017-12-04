package com.vm.controller;

import com.google.common.collect.ImmutableMap;
import com.vm.base.utils.LoggerWrapper;
import com.vm.dao.po.Temple;
import com.vm.service.users.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * <b>Title:</b>
 * <br/>
 * <br/>
 * <b>Description:</b>
 * <br/>
 * <br/>
 * <b>Author:</b>ZhangKe
 * <br/>
 * <br/>
 * <b>Date:</b>2017/11/17 13:12
 */
@Controller
@RequestMapping("/temple")
public class TempleController extends ServiceController<UsersService> {

    private LoggerWrapper logger = LoggerWrapper.newLoggerWrapper(TempleController.class);

    @RequestMapping("/a")
    public Object a(Model model,@RequestBody Temple temple) {

        logger.info("temple {}",temple);

        model.addAttribute("name", temple.getUsername());

        return "frontend/views/index";
    }
    @RequestMapping("/b")
    public @ResponseBody Object b() {
        map.put("a","b");
        return map;
    }

    @RequestMapping("/query/{id}")
    public Object query(@PathVariable("id") Long id) {
        int i = 0;
        i = i / i;
        return ImmutableMap.of("k1", "v1", "k2", "v2");
    }
    @RequestMapping("/forward/{pagename}")
    public Object forward(Model model,@PathVariable("pagename") String pagename) {
        model.addAttribute("name",pagename);
        return "frontend/views/"+pagename;
    }
}
