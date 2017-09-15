package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/hello")
	public String index (){
		return "hello";
	}
	
	@RequestMapping ( "/greeting")
	public String greeting ( @RequestParam ( value = "name" , required = false, defaultValue = "dunia" ) String name , Model model){
		model . addAttribute ( "name" , name );
		return "greeting";
	}
	
	@RequestMapping ( value = { "/greeting" , "greeting/{name}" })
	public String greetingPath ( @PathVariable Optional < String > name , Model model ) {
		if ( name . isPresent ()) {
			model . addAttribute ( "name" , name . get ());
		} else {
			model . addAttribute ( "name" , "dengklek" );
		}
		return "greeting";
	}
	
	@RequestMapping ( "/perkalian")
	public String perkalian ( @RequestParam ( value = "a" , required = false, defaultValue = "0" ) int value1, @RequestParam ( value = "b" , required = false, defaultValue = "0" ) int value2, Model model) {
		model . addAttribute ( "val1" , value1);
		model . addAttribute ( "val2" , value2);
		model . addAttribute ( "result" , value1 * value2);
		return "perkalian";
	}
}
