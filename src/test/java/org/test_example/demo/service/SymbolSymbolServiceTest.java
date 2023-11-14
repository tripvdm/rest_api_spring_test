package org.test_example.demo.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SymbolSymbolServiceTest {

    @Autowired
    private SymbolService symbolService;

    @Test
    void testCheckJsonIfEmpty() {
        String json = symbolService.getJson("");
        assertEquals("{}", json);
    }

    @Test
    void testCheckJsonIfNotEmpty() {
        String json = symbolService.getJson("aaaaabcccc");
        boolean valid = isJSONValid(json);
        assertTrue(valid);
    }

    @Test
    void testCountOfSymbolsIfEmpty() {
        Map<Character, Integer> mapSymbols = new HashMap<>();
        symbolService.countSymbols(mapSymbols, "");
        assertEquals(mapSymbols.size(), 0);
    }

    @Test
    void testCountOfSymbolsIfNotEmpty() {
        Map<Character, Integer> mapSymbols = new HashMap<>();
        symbolService.countSymbols(mapSymbols, "assd");
        assertTrue(mapSymbols.size() > 0);
    }

    @Test
    void testReverseSortedSymbols() {
        Map<Character, Integer> actualMapSymbols = new HashMap<>();
        symbolService.countSymbols(actualMapSymbols, "aaaaabcccc");
        actualMapSymbols = symbolService.sortMap(actualMapSymbols);

        Map<Character, Integer> expectedSymbolsMap = new HashMap<>();
        expectedSymbolsMap.put('a', 5);
        expectedSymbolsMap.put('c', 4);
        expectedSymbolsMap.put('b', 1);

        assertEquals(actualMapSymbols, expectedSymbolsMap);
    }

    private boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }
}