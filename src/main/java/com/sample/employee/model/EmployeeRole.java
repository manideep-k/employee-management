package com.sample.employee.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum EmployeeRole {

    ADMIN(100),
    MANAGER(200),
    READ_ONLY(900);

    public int val;

    EmployeeRole(int val) {
        this.val = val;
    }

    public static EmployeeRole getByCode(int val) {
        return EmployeeRole.values()[val];
    }

}

@Converter
class EmployeeAttributeConverter implements AttributeConverter<EmployeeRole, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EmployeeRole attribute) {
        return attribute.val;
    }

    @Override
    public EmployeeRole convertToEntityAttribute(Integer dbData) {
        return EmployeeRole.getByCode(dbData);
    }

}
