package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")    // Ira mapear as requisicoes feitas para barra
    public String index() {
        System.out.println("Entrando na Home da Casa do Codigo");
        return "home";
    }
}
