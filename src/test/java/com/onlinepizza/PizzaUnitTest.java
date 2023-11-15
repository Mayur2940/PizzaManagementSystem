package com.onlinepizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onlinepizza.entity.Pizza;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.entity.Toppings;
import com.onlinepizza.exception.PizzaServiceManagementException;
import com.onlinepizza.repository.PizzaRepository;
import com.onlinepizza.repository.PizzaTypeRepository;
import com.onlinepizza.repository.ToppingsRepository;
import com.onlinepizza.serviceimp.IPizzaServiceImp;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PizzaUnitTest {

    @Mock
    private PizzaRepository pizzaRepository;

    @Mock
    private ToppingsRepository toppingsRepository;

    @Mock
    private PizzaTypeRepository pizzaTypeRepository;

    @InjectMocks
    private IPizzaServiceImp pizzaService;

    @Test
    void testAddPizza() {
        Pizza pizza = new Pizza();
        when(pizzaRepository.save(pizza)).thenReturn(pizza);

        Pizza result = pizzaService.addPizza(pizza);

        assertEquals(pizza, result);
        verify(pizzaRepository).save(pizza);
    }

    @Test
    void testAddToppings() {
        Toppings toppings = new Toppings();
        Toppings newToppings = new Toppings();
        newToppings.setToppingsId(toppings.getToppingsId());
        newToppings.setToppingsName(toppings.getToppingsName());
        newToppings.setPrice(toppings.getPrice());
        when(toppingsRepository.save(newToppings)).thenReturn(newToppings);

        Toppings result = pizzaService.addToppings(toppings);

        assertEquals(newToppings, result);
        verify(toppingsRepository).save(newToppings);
    }

    @Test
    void testAddPizzaType() {
        PizzaType pizzaType = new PizzaType();
        PizzaType newPizzaType = new PizzaType();
        newPizzaType.setPizzaType(pizzaType.getPizzaType());
        when(pizzaTypeRepository.save(newPizzaType)).thenReturn(newPizzaType);

        PizzaType result = pizzaService.addPizzaType(pizzaType);

        assertEquals(newPizzaType, result);
        verify(pizzaTypeRepository).save(newPizzaType);
    }


    @Test
    void testViewPizzaByIdNotFound() {
        Integer pizzaId = 1;
        when(pizzaRepository.existsById(pizzaId)).thenReturn(false);

        assertThrows(PizzaServiceManagementException.class, () -> pizzaService.viewPizzaById(pizzaId));
    }

    @Test
    void testViewPizzaByIdFound() throws PizzaServiceManagementException {
        Integer pizzaId = 1;
        Pizza pizza = new Pizza();
        when(pizzaRepository.existsById(pizzaId)).thenReturn(true);
        when(pizzaRepository.findById(pizzaId)).thenReturn(Optional.of(pizza));

        Pizza result = pizzaService.viewPizzaById(pizzaId);

        assertEquals(pizza, result);
        verify(pizzaRepository).findById(pizzaId);
    }
}
