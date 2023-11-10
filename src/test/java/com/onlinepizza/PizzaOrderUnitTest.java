package com.onlinepizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinepizza.entity.PizzaOrder;
import com.onlinepizza.exception.PizzaOrderManagementException;
import com.onlinepizza.repository.PizzaOrderRepository;
import com.onlinepizza.serviceimp.IPizzaOrderServiceImp;

@SpringBootTest
public class PizzaOrderUnitTest {

    @Mock
    private PizzaOrderRepository pizzaOrderRepository;

    @InjectMocks
    private IPizzaOrderServiceImp pizzaOrderService;

   
    @Test
    void testBookPizzaOrder() {
        PizzaOrder order = new PizzaOrder();
        when(pizzaOrderRepository.save(order)).thenReturn(order);

        PizzaOrder result = pizzaOrderService.bookPizzaOrder(order);

        assertEquals(order, result);
        verify(pizzaOrderRepository).save(order);
    }



    @Test
    void testCancelPizzaOrder() throws PizzaOrderManagementException {
        Integer pizzaOrderId = 1;
        when(pizzaOrderRepository.findById(pizzaOrderId)).thenReturn(java.util.Optional.of(new PizzaOrder()));

        String result = pizzaOrderService.cancelPizzaOrder(pizzaOrderId);

        assertEquals("Order Cancelled", result);
        verify(pizzaOrderRepository).deleteById(pizzaOrderId);
    }

    @Test
    void testCancelPizzaOrderNotFound() {
        Integer pizzaOrderId = 1;
        when(pizzaOrderRepository.findById(pizzaOrderId)).thenReturn(java.util.Optional.empty());

        assertThrows(PizzaOrderManagementException.class, () -> pizzaOrderService.cancelPizzaOrder(pizzaOrderId));
    }



    @Test
    void testViewPizzaOrderByIdNotFound() {
        Integer pizzaOrderId = 1;
        when(pizzaOrderRepository.findById(pizzaOrderId)).thenReturn(java.util.Optional.empty());

        assertThrows(PizzaOrderManagementException.class, () -> pizzaOrderService.viewPizzaOrderById(pizzaOrderId));
    }

    @Test
    void testViewAllPizzaOrders() {
        PizzaOrder order1 = new PizzaOrder();
        PizzaOrder order2 = new PizzaOrder();
        when(pizzaOrderRepository.findAll()).thenReturn(Arrays.asList(order1, order2));

        List<PizzaOrder> result = pizzaOrderService.viewAllPizzaOrders();

        assertEquals(Arrays.asList(order1, order2), result);
        verify(pizzaOrderRepository).findAll();
    }

    // Add more tests for other methods as needed
}

