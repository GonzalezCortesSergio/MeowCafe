package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.awt.*;
import java.io.*;

@Service
public class PdfGenerator {

    public void generarPdf(Usuario usuario, String contrasenaGenerada) throws FileNotFoundException {

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("Información_del_Usuario.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, Color.BLACK);

        document.add(new Paragraph("Bienvenido " + usuario.getNombre() + ", su nombre de usuario es " + usuario.getUsername(), font));
        document.add(new Paragraph("Su contraseña es: " + contrasenaGenerada + ", deberá cambiarla una vez que inicie sesión", font));

        document.close();
    }
}
