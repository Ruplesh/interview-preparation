package com.example.interviewpreparation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/map")
public class MapOperations {

    // In-memory map to store key-value pairs
    private Map<String, String> storage = new HashMap<>();

    // API to add key-value pair to the map
    @PostMapping("/store")
    public ResponseEntity<String> storeValue(@RequestParam String key, @RequestParam String value) {
        storage.put(key, value);
        return ResponseEntity.ok("Stored key: " + key + " with value: " + value);
    }

    // API to get a value from the map by key
    @GetMapping("/get")
    public ResponseEntity<String> getValue(@RequestParam String key) {
        String value = storage.get(key);
        if (value != null) {
            return ResponseEntity.ok("Value for key " + key + " is: " + value);
        } else {
            return ResponseEntity.status(404).body("Key not found");
        }
    }

    // API to get all key-value pairs in the map
    @GetMapping("/all")
    public ResponseEntity<Map<String, String>> getAllValues() {
        return ResponseEntity.ok(storage);
    }

    @PostMapping("/store/map")
    public ResponseEntity<String> storeValue(@RequestBody Map<String, String> keyValueMap) {
        keyValueMap.forEach(storage::put); // Store all key-value pairs from the request body into the storage map
        return ResponseEntity.ok("Stored key-value pairs: " + keyValueMap.toString());
    }

    @GetMapping("/exception")
    public ResponseEntity<String> getException() {
        getExceptionFromMethodCall();
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    private void getExceptionFromMethodCall() {
        throw new RuntimeException();
    }
}

