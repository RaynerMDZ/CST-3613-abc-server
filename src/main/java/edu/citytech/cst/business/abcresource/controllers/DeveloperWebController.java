package edu.citytech.cst.business.abcresource.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/developer")
public class DeveloperWebController {

    @GetMapping
    public ResponseEntity<String> getDeveloperInfo() {
        return new ResponseEntity<>("Rayner Mendez" ,HttpStatus.OK);
    }

    @GetMapping("/more-info")
    public ResponseEntity<Map<String, String>> getDeveloperMoreInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("name", "Rayner Mendez");
        info.put("email", "rayner.mendez@mail.citytech.cuny.edu");
        info.put("title", "developer");

        return new ResponseEntity<>(info ,HttpStatus.OK);
    }

    @PostMapping("{name}")
    public ResponseEntity<String> greeting(@PathVariable(name = "name") String name) {
        return new ResponseEntity<>("Hello " + name + ", How are you?", HttpStatus.OK);
    }

}
