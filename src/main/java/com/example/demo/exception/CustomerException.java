package com.example.demo.exception;

public class CustomerException extends BaseException {
    public CustomerException(String code) {
        super("Customer." + code);
    }

    public static CustomerException createNameCustomerNull() {
        return new CustomerException("create.name.null");
    }

    public static CustomerException createLastnameCustomerNull() {
        return new CustomerException("create.lastname.null");
    }

    public static CustomerException createBirthdateCustomerNull() {
        return new CustomerException("create.birthdate.null");
    }

    public static CustomerException createSexCustomerNull() {
        return new CustomerException("create.sex.null");
    }

    public static CustomerException createCareerCustomerNull() {
        return new CustomerException("create.career.null");
    }

    public static CustomerException createCivilIdCustomerNull() {
        return new CustomerException("create.civil_id.null");
    }

    public static CustomerException createCivilIdDuplicated() {
        return new CustomerException("create.civil_id.duplicated");
    }

    public static CustomerException createPassportCustomerNull() {
        return new CustomerException("create.passport.null");
    }

    public static CustomerException createPassportDuplicated() {
        return new CustomerException("create.passport.duplicated");
    }

    public static CustomerException createCivilIdCustomerInvalid() {
        return new CustomerException("create.civil_id.Invalid");
    }

    public static CustomerException findCivilIdNotFound(){
        return new CustomerException("not.available");
    }

    public static CustomerException findCustomerNotFound(){
        return new CustomerException("not.found");
    }

    public static CustomerException CustomerNotFound(){
        return new CustomerException("not.found");
    }

}
