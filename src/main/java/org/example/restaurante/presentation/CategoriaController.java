package org.example.restaurante.presentation;

import org.example.restaurante.logic.Categoria;
import org.example.restaurante.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private Service service;

    @GetMapping("/listar")
    public List<Categoria> listar() throws Exception {
        List<org.example.restaurante.logic.Categoria> lista = service.readAllCategorias();
        return lista;
    }

    @GetMapping("/buscar")
    public Categoria buscar(String id) throws Exception {
        Categoria categoria = service.readCategoria(id);
        return categoria;
    }


}
