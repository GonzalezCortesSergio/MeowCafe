package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import com.itextpdf.text.DocumentException;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.pdf.PdfGenerator;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioUsuario;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
public class ControladorDescarga {


    @Autowired
    private PdfGenerator generator;

    @Autowired
    private ServicioUsuario servicioUsuario;



    @GetMapping("/admin/descarga/{id}/{pwd}")
    public void descargarArchivo(HttpServletResponse response, @PathVariable("id") long id, @PathVariable("pwd") String contrasenaGenerata) throws IOException, DocumentException {

        PdfGenerator generator = new PdfGenerator();

        Usuario usuario = servicioUsuario.findById(id).get();

        byte[] pdfUsuario = generator.generarPdf(usuario, contrasenaGenerata).toByteArray();

        String mimeType = "application/pdf";
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "usuario.pdf"));

        response.setContentLength(pdfUsuario.length);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(pdfUsuario);

        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
}
