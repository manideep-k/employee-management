package com.sample.employee.model;

public enum EmployeeRole {

    ADMIN(100),
    MANAGER(200),
    READ_ONLY(900);

    public int val;

    EmployeeRole(int val) {
        this.val = val;
    }

}
