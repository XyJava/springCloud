package com.eureka.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHelloController {

    @Autowired
    FeignService feignService;

    @RequestMapping(value = "/feignHi",method = RequestMethod.GET)
    public String feignHi(@RequestParam String  name) {
        return feignService.feignHello(name);
    }

    @RequestMapping(value = "/feignHello",method = RequestMethod.GET)
    public String feignHello(@RequestParam String  name) {
        return feignService.helloFeign(name);
    }
}
