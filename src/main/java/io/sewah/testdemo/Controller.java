package io.sewah.testdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private TestService testService;

    @GetMapping("/test-controller")
    ResponseEntity<?> test(@RequestParam("number") Integer number) throws Exception {
        return ResponseEntity.ok(testService.checkEvenNumber(number));
    }
}
