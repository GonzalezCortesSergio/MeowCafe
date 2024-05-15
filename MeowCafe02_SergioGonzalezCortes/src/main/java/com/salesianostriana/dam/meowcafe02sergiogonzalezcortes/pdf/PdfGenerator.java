package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.pdf;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;

@Service
public class PdfGenerator {

    private String parseThymeleafTemplate(Usuario usuario) {

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("username", usuario.getUsername());
        context.setVariable("password", usuario.getPassword());

        return templateEngine.process("Enviar", context);
    }


    public void generatePdfFromHtml(Usuario usuario) throws IOException {

        String outputFolder = System.getProperty("user.dir") + File.separator + "thymeleaf.pdf";


        OutputStream outputStream = new FileOutputStream(outputFolder);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(parseThymeleafTemplate(usuario));
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }
}
