package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login");
        registry.addViewController("/sobreNosotros");
        registry.addViewController("/admin/index");
        registry.addViewController("/admin/sobreNosotros");
        registry.addViewController("/cliente/index");
        registry.addViewController("/cliente/sobreNosotros");
    }
}
