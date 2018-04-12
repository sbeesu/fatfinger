package com.barclays.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationPinService {

	@Autowired
	InputKeyMappingService inputKeyMappingService;

	public String validate(String userInput, String storedInput) {

		return validatePin(userInput.split(""), storedInput.split(""));

	}

	private static String validatePin(String[] userInput, String[] storedInput) {

		for (int i = 0; i < 4; i++) {

			if (!(checkTwoCharsAlike(userInput[i], storedInput[i])
					|| checkCharaterHasAlternativeKey(userInput[i], storedInput[i]))) {

				return "INVALID";

			}
		}

		return "VALID";
	}

	private static boolean checkCharaterHasAlternativeKey(String userInputDigit, String storedInputDigit) {

		return userInputDigit.equals(storedInputDigit);

	}

	private static boolean checkTwoCharsAlike(String userInputDigit, String storedInputDigit) {

		Map<String, List<String>> alternativePins = InputKeyMappingService.getAdjacencyKeystrokeMap();
		return alternativePins.get(storedInputDigit).contains(userInputDigit);

	}

}