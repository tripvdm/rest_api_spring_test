package org.test_example.demo.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SymbolService {

    public String getJson(String str) {
        Map<Character, Integer> mapSymbols = new HashMap<>();
        countSymbols(mapSymbols, str);
        mapSymbols = sortMap(mapSymbols);
        return new Gson().toJson(mapSymbols);
    }

    public void countSymbols(Map<Character, Integer> mapSymbols, String str) {
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            mapSymbols.put(ch, mapSymbols.getOrDefault(ch, 0) + 1);
        }
    }

    public Map<Character, Integer> sortMap(Map<Character, Integer> mapSymbols) {
        return mapSymbols.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}
