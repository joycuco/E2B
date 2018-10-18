package com.e2bnutrition.e2bbackend.dao;


import java.util.List;

import com.e2bnutrition.e2bbackend.model.Enfermedad;

public interface EnfermedadDao {

    void saveEnfermedad(Enfermedad enfermedad);
    void deleteEnfermedadById(Long idEnfermedad);
    void updateEnfermedad(Enfermedad enfermedad);

    List<Enfermedad> findAllEnfermedades();
    Enfermedad findById(Long idEnfermedad);
    Enfermedad findByNombre(String nombre);
}