package edu.citytech.cst.business.abcresource.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/developer")
public class DeveloperWebController {

    @GetMapping
    public String getDeveloperInfo() {
        return "Rayner Mendez";
    }
}
