package com.example.demo.exception;

public class SupplierException extends BaseException {

    public SupplierException(String code) {
        super("Supplier." + code);
    }

    public static SupplierException createNameSupplierNull() {
        return new SupplierException("create.name.null");
    }

    public static SupplierException findIdSupplierNotFound() {
        return new SupplierException("not.available");
    }

    public static SupplierException findSupplierNotFound() {
        return new SupplierException("not.found");
    }

    public static SupplierException notFound() {
        return new SupplierException("not.found");
    }
}
