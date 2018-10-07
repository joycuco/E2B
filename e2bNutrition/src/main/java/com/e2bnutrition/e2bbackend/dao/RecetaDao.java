package com.e2bnutrition.e2bbackend.dao;


import java.util.List;

import com.e2bnutrition.e2bbackend.model.Receta;

public interface RecetaDao {

    void saveReceta(Receta receta);
    void deleteRecetaById(Long idReceta);
    void updateReceta(Receta Receta);

    List<Receta> findAllRecetas();
    Receta findById(Long idReceta);
    Receta findByNombre(String nombre);
}