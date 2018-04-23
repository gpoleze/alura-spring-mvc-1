package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutosController {

    @Autowired
    // This annotation will make Spring create the object -> for that works, the DAO should annotate as Repository
    // This is the Dependency Injection; it keeps the Inversion of Control concept and which makes the server be responsible
    // by any kind of configuration
    private ProdutoDAO produtoDAO;

    @RequestMapping("/produtos/form")
    public ModelAndView form() {
        System.out.println("Entrando na Página de cadastro de produtos");
        return new ModelAndView("produtos/form").addObject("tipos", TipoPreco.values());
    }

    @RequestMapping("casadocodigo/produtos")
    public String gravar(Produto produto) {
        System.out.println(produto);

        produtoDAO.gravar(produto);

        return "produtos/ok";
    }
}
