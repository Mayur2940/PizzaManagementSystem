package com.onlinepizza;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinepizza.entity.Toppings;
import com.onlinepizza.exception.PizzaToppingsManagementException;
import com.onlinepizza.repository.ToppingsRepository;
import com.onlinepizza.service.IToppingsService;
import com.onlinepizza.serviceimp.IToppingsServiceImp;

@SpringBootTest
public class ToppingsUnitTest {

    @Mock
    private ToppingsRepository toppingsRepository;

    @InjectMocks
    private IToppingsService toppingsService = new IToppingsServiceImp();


    


    @Test
    void testAddToppingsFailedSave() {
        Toppings topping = new Toppings();
        when(toppingsRepository.save(topping)).thenReturn(null);

        assertThrows(PizzaToppingsManagementException.class, () -> toppingsService.addToppings(topping));
        verify(toppingsRepository).save(topping);
    }

    @Test
    void testAddToppingsFailedSaveIdIsNull() {
        Toppings topping = new Toppings();
        topping.setToppingsId(null);
        when(toppingsRepository.save(topping)).thenReturn(topping);

        assertThrows(PizzaToppingsManagementException.class, () -> toppingsService.addToppings(topping));
        verify(toppingsRepository).save(topping);
    }

    @Test
    void testDeleteToppingsById() throws PizzaToppingsManagementException {
        Integer toppingsId = 1;
        when(toppingsRepository.findById(toppingsId)).thenReturn(java.util.Optional.of(new Toppings()));

        String result = toppingsService.deleteToppingsById(toppingsId);

        assertEquals("Toppings Removed Successfully", result);
        verify(toppingsRepository).deleteById(toppingsId);
    }

    @Test
    void testDeleteToppingsByIdNotFound() {
        Integer toppingsId = 1;
        when(toppingsRepository.findById(toppingsId)).thenReturn(java.util.Optional.empty());

        assertThrows(PizzaToppingsManagementException.class, () -> toppingsService.deleteToppingsById(toppingsId));
    }
}


