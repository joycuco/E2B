package com.e2bnutrition.e2bbackend.dao;
import java.util.List;

import com.e2bnutrition.e2bbackend.model.Dieta;

public interface DietaDao {

    void saveDieta(Dieta dieta);
    void deleteDietaById(Long idDieta);
    void updateDieta(Dieta Dieta);

    List<Dieta> findAllDietas();
    Dieta findById(Long idDieta);
    Dieta findByTipo(String tipo);
}