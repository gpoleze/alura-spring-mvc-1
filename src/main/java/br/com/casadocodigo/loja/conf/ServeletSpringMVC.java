//Esta classe será responsável por atender as requisicoes feitas pelo servidor

package br.com.casadocodigo.loja.conf;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServeletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Para que o Spring reconheça o controller que iremos utilizar, precisamos passar o arquivo de configuracao,
        // exposto na linha seguinte
        return new Class[]{AppWebConfiguration.class, JPAConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        //  método responsável por mapear as URL do meu projeto
        return new String[]{"/"};
    }
}
