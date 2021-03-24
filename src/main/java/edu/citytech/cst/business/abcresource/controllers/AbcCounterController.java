package edu.citytech.cst.business.abcresource.controllers;

import edu.citytech.cst.business.abcresource.services.AbcCounterService;
import edu.citytech.cst.business.abcresource.services.AbcCounterServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@RestController
@RequestMapping("api/v1/")
public class AbcCounterController {

    private final Map<String, Supplier<List<?>>> count = new HashMap<>();

    private final AbcCounterService counterService = new AbcCounterServiceImpl();

    {
        count.put("abc", this.counterService::countABC);
        count.put("cba", this.counterService::countCBA);
        count.put("AaBbCc", this.counterService::countAaBbCc);
        count.put("123", this.counterService::count123);
        count.put("321", this.counterService::count321);
        count.put("369", this.counterService::count369);
    }

    @GetMapping("mode/{mode}")
    public ResponseEntity<List<?>> getCount(@PathVariable(name = "mode") String mode) {
        return new ResponseEntity<>(count.getOrDefault(mode, ArrayList::new).get(), HttpStatus.OK);
    }

    @GetMapping("isVowel/{vowel}")
    public ResponseEntity<Boolean> isVowel(@PathVariable(name = "vowel") String vowel) {
        return new ResponseEntity<>(this.counterService.isVowel(vowel), HttpStatus.OK);
    }

    @GetMapping("isVowelAaBbCc/{vowel}")
    public ResponseEntity<Boolean> isVowelAaBbCc(@PathVariable(name = "vowel") String vowel) {
        return new ResponseEntity<>(this.counterService.isVowelAaBbCc(vowel), HttpStatus.OK);
    }

    @GetMapping("isConsonant/{consonant}")
    public ResponseEntity<Boolean> isConsonant(@PathVariable(name = "consonant") String consonant) {
        return new ResponseEntity<>(this.counterService.isConsonant(consonant), HttpStatus.OK);
    }

    @GetMapping("isConsonantAaBbCc/{consonant}")
    public ResponseEntity<Boolean> isConsonantAaBbCc(@PathVariable(name = "consonant") String consonant) {
        return new ResponseEntity<>(this.counterService.isConsonantAaBbCc(consonant), HttpStatus.OK);
    }

    @GetMapping("isEven/{number}")
    public ResponseEntity<Boolean> isEven(@PathVariable(name = "number") Integer number) {
        return new ResponseEntity<>(this.counterService.isEven(number), HttpStatus.OK);
    }

    @GetMapping("isOdd/{number}")
    public ResponseEntity<Boolean> isOdd(@PathVariable(name = "number") Integer number) {
        return new ResponseEntity<>(this.counterService.isOdd(number), HttpStatus.OK);
    }

    @GetMapping("isDivisibleBy6/{number}")
    public ResponseEntity<Boolean> isDivisibleBy6(@PathVariable(name = "number") Integer number) {
        return new ResponseEntity<>(this.counterService.isDivisibleBy6(number), HttpStatus.OK);
    }

    @GetMapping("contains7/{number}")
    public ResponseEntity<Boolean> contains7(@PathVariable(name = "number") Integer number) {
        return new ResponseEntity<>(this.counterService.contains7(number), HttpStatus.OK);
    }
}

























