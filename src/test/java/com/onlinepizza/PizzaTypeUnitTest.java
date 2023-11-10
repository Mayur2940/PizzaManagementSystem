package com.onlinepizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.exception.PizzaTypeManagementException;
import com.onlinepizza.repository.PizzaTypeRepository;
import com.onlinepizza.serviceimp.IPizzaTypeServiceImp;

@SpringBootTest
public class PizzaTypeUnitTest {

    @Mock
    private PizzaTypeRepository pizzaTypeRepository;

    @InjectMocks
    private IPizzaTypeServiceImp pizzaTypeService;


    @Test
    void testAddPizzaType() throws PizzaTypeManagementException {
        PizzaType pizzaType = new PizzaType();
        when(pizzaTypeRepository.save(pizzaType)).thenReturn(pizzaType);

        String result = pizzaTypeService.addPizzaType(pizzaType);

        assertEquals("Added PizzaType successfully", result);
        verify(pizzaTypeRepository).save(pizzaType);
    }

    
    @Test
    void testDeleteById() throws PizzaTypeManagementException {
        Integer pizzaTypeId = 1;
        when(pizzaTypeRepository.findById(pizzaTypeId)).thenReturn(Optional.of(new PizzaType()));

        String result = pizzaTypeService.deleteById(pizzaTypeId);

        assertEquals("PizzaType Removed", result);
        verify(pizzaTypeRepository).deleteById(pizzaTypeId);
    }

    @Test
    void testDeleteByIdNotFound() {
        Integer pizzaTypeId = 1;
        when(pizzaTypeRepository.findById(pizzaTypeId)).thenReturn(Optional.empty());

        assertThrows(PizzaTypeManagementException.class, () -> pizzaTypeService.deleteById(pizzaTypeId));
    }

    @Test
    void testViewPizzaType() {
        List<PizzaType> pizzaTypes = new ArrayList<>();
        when(pizzaTypeRepository.findAll()).thenReturn(pizzaTypes);

        List<PizzaType> result = pizzaTypeService.viewPizzaType();

        assertEquals(pizzaTypes, result);
        verify(pizzaTypeRepository).findAll();
    }
}

