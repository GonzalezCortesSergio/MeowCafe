package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import org.springframework.stereotype.Service;


import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PdfGenerator {

    public ByteArrayOutputStream generarPdf(Usuario usuario, String contrasenaGenerada) throws IOException, DocumentException {

       try (ByteArrayOutputStream bos = new ByteArrayOutputStream()){

           Document document = new Document();


           Font font = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD);

           PdfWriter.getInstance(document, bos);
           document.open();
           document.add(new Paragraph("Bienvenido " + usuario.getNombre() + ", su nombre de usuario es " + usuario.getUsername(), font));
           document.add(new Paragraph("Su contraseña es: " + contrasenaGenerada + ", deberá cambiarla una vez que inicie sesión", font));
           document.close();

           return bos;

       } catch (Exception e) {

           e.printStackTrace();
       }

       return null;


    }
}
