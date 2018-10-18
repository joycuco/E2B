package com.e2bnutrition.e2bbackend.dao;


import java.util.List;

import com.e2bnutrition.e2bbackend.model.Paquete;

public interface PaqueteDao {

    void savePaquete(Paquete paquete);
    void deletePaqueteById(Long idPaquete);
    void updatePaquete(Paquete paquete);

    List<Paquete> findAllPaquetes();
    Paquete findById(Long idPaquete);
    Paquete findByNombre(String nombre);
}