package com.e2bnutrition.e2bbackend.dao;


import java.util.List;

import com.e2bnutrition.e2bbackend.model.Laboratorio;

public interface LaboratorioDao {

    void saveLaboratorio(Laboratorio laboratorio);
    void deleteLaboratorioById(Long idLaboratorio);
    void updateLaboratorio(Laboratorio laboratorio);

    List<Laboratorio> findAllLaboratorios();
    Laboratorio findById(Long idLaboratorio);
    Laboratorio findByNombre(String nombre);
}
