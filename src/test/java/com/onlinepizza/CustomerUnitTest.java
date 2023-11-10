package com.onlinepizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinepizza.entity.Customer;
import com.onlinepizza.exception.PizzaCustomerManagementException;
import com.onlinepizza.repository.CustomerRepository;
import com.onlinepizza.serviceimp.ICustomerServiceImp;

@SpringBootTest
public class CustomerUnitTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private ICustomerServiceImp customerService;

//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    void testRegisterCustomer() {
        Customer customer = new Customer();
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer result = customerService.registerCustomer(customer);

        assertEquals(customer, result);
        verify(customerRepository).save(customer);
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = new Customer();
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer result = customerService.updateCustomer(customer);

        assertEquals(customer, result);
        verify(customerRepository).save(customer);
    }

   

    @Test
    void testViewCustomerByPhoneInvalid() {
        Long phoneNo = 1234567890L;
        when(customerRepository.findByCustomerMobile(phoneNo)).thenReturn(null);

        assertThrows(PizzaCustomerManagementException.class, () -> customerService.viewCustomerByPhone(phoneNo));
    }

    @Test
    void testViewAllCustomer() {
        List<Customer> customersList = new ArrayList<>();
        when(customerRepository.findAll()).thenReturn(customersList);

        List<Customer> result = customerService.viewAllCustomer();

        assertEquals(customersList, result);
        verify(customerRepository).findAll();
    }

    
   
}
