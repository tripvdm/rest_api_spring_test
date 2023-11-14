package org.test_example.demo.controller;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.test_example.demo.service.SymbolService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    private SymbolService symbolService;

    @GetMapping("/{str}")
    public String getSymbols(@PathVariable String str) {
        Map<Character, Integer> mapSymbols = new HashMap<>();
        symbolService.countSymbols(mapSymbols, str);
        mapSymbols = symbolService.sortMap(mapSymbols);
        return new Gson().toJson(mapSymbols);
    }

}
