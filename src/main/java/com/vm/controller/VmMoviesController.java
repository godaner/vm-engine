package com.vm.controller;

import com.vm.dao.qo.PageBean;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.dao.po.CustomVmMovies;
import com.vm.service.inf.VmMoviesService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by ZhangKe on 2017/12/12.
 */
@Controller
@RequestMapping("/movie")
@Scope("prototype")
public class VmMoviesController extends ServiceController<VmMoviesService> {
    /*********************************前端*********************************/
    /**
     * 获取所有的tags分组及其下面的tags
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody Object getMovies(PageBean page , @Validated VmMoviesQueryBean query,BindingResult bindingResult)  throws Exception {
        validate(bindingResult);
        Long total = service.getMoviesCount(page,query);
        List<CustomVmMovies> list = service.getMovies(page,query);
        response.putData("list", list);
        response.putData("total", total);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Object getMovie() throws Exception  {
        return response;
    }


    ;
    /*********************************后端*********************************/

}

