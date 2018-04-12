package com.barclays.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.service.ValidationPinService;

@RestController
@RequestMapping("/validatePin/{formInput}")
public class ValidationController {

	@Autowired
	ValidationPinService validationPinService;

	@GetMapping
	public String validatePin(@PathVariable String formInput) {

		String userInput = formInput.split(":")[0];
		String storedInput = formInput.split(":")[1];
		return validationPinService.validate(userInput, storedInput);
	}

}
