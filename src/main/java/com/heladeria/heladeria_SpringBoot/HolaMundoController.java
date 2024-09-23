package com.heladeria.heladeria_SpringBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class HolaMundoController {

    @GetMapping("/hola")
    public String holaMundo() {
        return "Hola Mundo desde Spring Boot!";
    }
}
