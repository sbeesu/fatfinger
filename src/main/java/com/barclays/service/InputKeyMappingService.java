package com.barclays.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class InputKeyMappingService {

	public static Map<String, List<String>> getAdjacencyKeystrokeMap() {

		Map<String, List<String>> adjacencyKeystrokeMap = new HashMap<String, List<String>>();

		adjacencyKeystrokeMap.put("1", new ArrayList<String>(Arrays.asList("2", "4")));
		adjacencyKeystrokeMap.put("2", new ArrayList<String>(Arrays.asList("1", "3", "5")));
		adjacencyKeystrokeMap.put("3", new ArrayList<String>(Arrays.asList("2", "6")));
		adjacencyKeystrokeMap.put("4", new ArrayList<String>(Arrays.asList("1", "5", "7")));
		adjacencyKeystrokeMap.put("5", new ArrayList<String>(Arrays.asList("2", "4", "6", "8")));
		adjacencyKeystrokeMap.put("6", new ArrayList<String>(Arrays.asList("3", "5", "9")));
		adjacencyKeystrokeMap.put("7", new ArrayList<String>(Arrays.asList("4", "8")));
		adjacencyKeystrokeMap.put("8", new ArrayList<String>(Arrays.asList("5", "7", "9", "0")));
		adjacencyKeystrokeMap.put("9", new ArrayList<String>(Arrays.asList("6", "8")));
		adjacencyKeystrokeMap.put("0", new ArrayList<String>(Arrays.asList("8")));

		return adjacencyKeystrokeMap;

	}

}
