package com.sample.employee.controller;

import com.sample.employee.dao.LoginDao;
import com.sample.employee.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login-action", produces = { MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController implements LoginService {

    @Autowired
    LoginDao loginDao;

    @GetMapping("/login")
    public String getLoginId(@RequestParam String userName, @RequestParam String password) {
        return loginDao.getLoginId(userName, password);
    }

}
