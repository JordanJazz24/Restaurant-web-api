package org.example.restaurante.logic;

import org.example.restaurante.data.CategoriaRepository;
import org.example.restaurante.data.PlatilloRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service("service")
public class Service {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PlatilloRepository userRepository;

    Service(CategoriaRepository categoriaRepository, PlatilloRepository userRepository){
        this.categoriaRepository = categoriaRepository;
        this.userRepository = userRepository;
    }


    //-------------------Categoria-------------------
    public Categoria readCategoria(String id) {
        try {
            return categoriaRepository.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Categoria> readAllCategorias() {
        return categoriaRepository.findAll();
    }



    //-------------------Platillo-------------------
    public Platillo readPlatillo(String id) {
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Platillo> readAllPlatillos() {
        return userRepository.findAll();
    }

    public List<Platillo> readPlatillosByCategoria(String categoriaId) {
        return userRepository.findByCategoria(categoriaId);
    }

}
