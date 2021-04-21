package ma.gfi.leap.api.LEAPAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value="/hello")
    public String hello(){
        return "Hello";
    }
}
