package com.sample.employee.dao;

import com.sample.employee.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginDao implements LoginService {

    @Override
    public String getLoginId(String userName, String password) {
        return "Temp#Id";
    }

}
