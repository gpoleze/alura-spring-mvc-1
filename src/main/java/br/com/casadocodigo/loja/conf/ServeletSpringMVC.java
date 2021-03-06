//Esta classe será responsável por atender as requisicoes feitas pelo servidor

package br.com.casadocodigo.loja.conf;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

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

    @Override
    protected Filter[] getServletFilters() {
        // Aqui poderemos fazer com que o Srping/Hobernate usem um encoding differente
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");

        return new Filter[]{encodingFilter};
    }

    // Método necessário para que o Spring entenda que lidaremos com um arquivo
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(""));
    }
}
