package br.com.casadocodigo.loja.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Component
//A anaotacao Component é importante pois avisa ao Srping que a classe será injetada onde for preciso. Eu passo o controle
// do gerenciamento desta classe para o String que faz uma Inversion Of Control (IOC)
public class FileSaver {

    // Novamente, com a anotacao Autowired  o Spring cuida de injetar a request quando esta for necessária
    @Autowired
    private HttpServletRequest request;

    public String write(String baseFolder, MultipartFile file) {
        try {
            String realPath = request.getServletContext().getRealPath("/" + baseFolder);
            String path = realPath + "/" + file.getOriginalFilename();

            file.transferTo(new File(path));

            return baseFolder + "/" + file.getOriginalFilename();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
