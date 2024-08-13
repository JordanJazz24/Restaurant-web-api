package org.example.restaurante.presentation;

import org.example.restaurante.logic.Platillo;
import org.example.restaurante.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platillos")
public class PlatilloController {
    private final Service service;

    @Autowired
    public PlatilloController(Service service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<Platillo> listarPlatillosPorCategoria(@RequestParam String categoriaId) {
        return service.readPlatillosByCategoria(categoriaId);
    }

    @GetMapping("/buscar")
    public Platillo buscarPlatillo(@RequestParam String id) {
        return service.readPlatillo(id);
    }

    // Añadir métodos adicionales según sea necesario, como crear, actualizar y eliminar platillos
}
