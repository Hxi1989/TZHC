package com.hxscpro.controller;

import com.hxscpro.bean.User;
import com.hxscpro.service.HiveService;
import com.hxscpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * @author hx
 * @version 1.0
 * @date 2021/1/21 10:43
 */
@RestController
@Scope("prototype")
public class HiveController {
    @Autowired
    private HiveService hiveService;

    @ResponseBody
    @GetMapping("/hiveShow")
    public void hello() throws SQLException, ClassNotFoundException {
        System.out.printf("hiveShow");
        hiveService.showtDb();
    }

}
