package org.example.restaurante.data;

import org.example.restaurante.logic.Categoria;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component("categoriaRepository")
public class CategoriaRepository {
    List<Categoria> list;

    public Categoria findById(String id) throws Exception{
        Categoria r = list.stream()
                .filter( e-> e.getId().equals(id))
                .findFirst().get();
        return r.clone();
    }

    public List<Categoria> findAll(){
        return list.stream()
                .map(Categoria::clone)
                .toList();
    }

    public CategoriaRepository() {
        list = new ArrayList<Categoria>();

        list.add(new Categoria("111","Entradas"));
        list.add(new Categoria("222","Carnes"));
        list.add(new Categoria("333","Sopas"));
        list.add(new Categoria("444","Arroces"));
        list.add(new Categoria("555","Bebidas"));
        list.add(new Categoria("666","Postres"));
    }

}






