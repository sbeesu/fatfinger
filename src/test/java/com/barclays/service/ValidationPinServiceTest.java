package com.barclays.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ValidationPinServiceTest {

	@Autowired
	ValidationPinService validationPinService;

	@Test
	public void testValidateWhenEqual() {
		String userInput = "4873";
		String storedInput = "4873";
		assertTrue("VALID".equalsIgnoreCase(validationPinService.validate(userInput, storedInput)));
	}

	@Test
	public void testValidateWhenEqualByAdjacency() {
		String userInput = "4873";
		String storedInput = "1873";
		assertTrue("VALID".equalsIgnoreCase(validationPinService.validate(userInput, storedInput)));
	}

	@Test
	public void testValidateWhenNotEqual() {
		String userInput = "4873";
		String storedInput = "6873";
		assertTrue("INVALID".equalsIgnoreCase(validationPinService.validate(userInput, storedInput)));
	}
}
