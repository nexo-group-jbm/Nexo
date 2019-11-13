package com.project2;

public interface CustomerBo {
 void addCustomer();
 String addCustomerReturnValue();
 void addCustomerThrowException() throws Exception;
 void addCustomerAround(String name);
}
