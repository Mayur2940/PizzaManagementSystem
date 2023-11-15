package com.onlinepizza.controller;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.onlinepizza.entity.Toppings;
import com.onlinepizza.exception.PizzaToppingsManagementException;
import com.onlinepizza.serviceimp.IToppingsServiceImp;
 
@RestController
@RequestMapping("/toppings")
public class IToppingsController {
    @Autowired
    IToppingsServiceImp iToppingsServiceImp;
    @PostMapping("/add")
    public ResponseEntity<String> addToppings(@Valid @RequestBody Toppings topping, BindingResult result) throws PizzaToppingsManagementException {
        if(result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for(FieldError error : result.getFieldErrors()) {
                errors.append(error.getDefaultMessage()).append("\n");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());
        }
        String response = iToppingsServiceImp.addToppings(topping);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteToppingsById(@PathVariable("id") Integer toppingsId) throws PizzaToppingsManagementException {
        String response = iToppingsServiceImp.deleteToppingsById(toppingsId);
        return ResponseEntity.ok(response);
    }
}
