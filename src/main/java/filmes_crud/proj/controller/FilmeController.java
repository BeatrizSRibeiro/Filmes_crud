package filmes_crud.proj.controller;

import filmes_crud.proj.model.Filme;
import filmes_crud.proj.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;

    public FilmeController(FilmeService service) {
        this.service = service;
    }


    @GetMapping
    public String listar(Model model) {
        model.addAttribute("filmes", service.listar());
        return "filmes/lista";
    }

 
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("filme", new Filme());
        return "filmes/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("filme") Filme filme,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "filmes/formulario";
        }
        service.salvar(filme);
        return "redirect:/filmes";
    }

 
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("filme", service.buscarPorId(id));
        return "filmes/formulario";
    }


    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/filmes";
    }
}