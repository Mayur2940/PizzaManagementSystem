//package com.onlinepizza.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@Controller
//public class CustomErrorController {
//
//	 @ExceptionHandler(Exception.class)
//	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	    public String handleException(Exception e, Model model) {
//	        model.addAttribute("error", e.getMessage());
//	        return "error";
//	    }
//}
