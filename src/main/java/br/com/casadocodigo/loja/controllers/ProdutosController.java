package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    // This annotation will make Spring create the object -> for that works, the DAO should annotate as Repository
    // This is the Dependency Injection; it keeps the Inversion of Control concept and which makes the server be responsible
    // by any kind of configuration
    private ProdutoDAO produtoDAO;

    @Autowired
    private FileSaver fileSaver;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProdutoValidation());
    }

    @RequestMapping("/form")
    public ModelAndView form(Produto produto) {
        System.out.println("Entrando na Página de cadastro de produtos");
        return new ModelAndView("produtos/form").addObject("tipos", TipoPreco.values());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
        System.out.println(produto);

        if (result.hasErrors())
            return form(produto);

        String path = fileSaver.write("arquivosSumario", sumario);
        produto.setSumarioPath(path);

        produtoDAO.gravar(produto);

        // with the redirectAttributes using a flah attrinute, we keep the attibute from one request to the next one
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");

        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list() {
        System.out.println("Acessando a Página de listagem de produtos");
        List<Produto> produtos = produtoDAO.list();

        return new ModelAndView("produtos/list").addObject("produtos", produtos);
    }
}
