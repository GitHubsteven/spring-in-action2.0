package com.asa.demo.spring.cache.service;

import com.asa.demo.spring.cache.bean.Customer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceTest extends BaseServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void getAddress() {

        Customer customer = new Customer();
        customer.setName("asa.x")
                .setAddress("ganzhou");
        for (int i = 0; i < 4; i++) {
            String newName = "" + (i % 2);
            customer.setName(newName);
            System.out.println("name: " + newName + " " + addressService.getAddress(customer));
        }
        /*结果如下：
            enter the get address method ...
            ganzhou02633214c1
            ganzhou02633214c1
         */
    }
}
