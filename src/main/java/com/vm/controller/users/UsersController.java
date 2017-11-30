package com.vm.controller.users;

import com.vm.common.bo.Response;
import com.vm.controller.BaseController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
@RestController
@RequestMapping("/users")
public class UsersController extends BaseController {

    @RequestMapping("/insert/{name}/{password}")
    public Response insert(@PathVariable("name") String name, @PathVariable("password") String password){


        try {
            System.out.println("insert");
        } catch (Exception e) {
            response.setFailure();
            e.printStackTrace();
        }
        return response;
    }
    @RequestMapping("/query/{id}")
    public Object query(@PathVariable("id") Long id){

        try {

            System.out.println("query");

        } catch (Exception e) {
            response.setFailure();
            e.printStackTrace();
        }

        return response;
    }
}
