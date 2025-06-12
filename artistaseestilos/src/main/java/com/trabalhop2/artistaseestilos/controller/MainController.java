package com.trabalhop2.artistaseestilos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trabalhop2.artistaseestilos.Artista;
import com.trabalhop2.artistaseestilos.ArtistaService;
@Controller
public class MainController {

    @Autowired
    ApplicationContext ctx;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("artista", new Artista());
        model.addAttribute("titulo", "CADASTRO DE ARTISTAS");
        model.addAttribute("link", "/cadastro");
        model.addAttribute("valor", "Cadastrar");
        return "formulario";
    }

    @PostMapping("/cadastro")
    public String cadastro(@ModelAttribute Artista artista) {
        ArtistaService as = ctx.getBean(ArtistaService.class);
        as.inserirArtista(artista);
        return "index";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        ArtistaService as = ctx.getBean(ArtistaService.class);
        List<Artista> artistas = as.puxarTodosArtistas();
        model.addAttribute("artistas", artistas);
        return "listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        ArtistaService as = ctx.getBean(ArtistaService.class);
        Artista artista = as.puxarArtista(id);
        model.addAttribute("artista", artista);
        model.addAttribute("titulo", "EDITAR ARTISTA");
        model.addAttribute("link", "/editar/" + id);
        model.addAttribute("valor", "Editar");
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String editarSalvar(@PathVariable int id, @ModelAttribute Artista artista) {
        ArtistaService as = ctx.getBean(ArtistaService.class);
        as.atualizarArtista(id, artista);
        return "redirect:/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        ArtistaService as = ctx.getBean(ArtistaService.class);
        as.deletar(id);
        return "redirect:/listar";
    }
}