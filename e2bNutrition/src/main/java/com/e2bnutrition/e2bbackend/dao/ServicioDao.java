package com.e2bnutrition.e2bbackend.dao;


import java.util.List;

import com.e2bnutrition.e2bbackend.model.Servicio;

public interface ServicioDao {

    void saveServicio(Servicio servicio);
    void deleteServicioById(Long idServicio);
    void updateServicio(Servicio servicio);

    List<Servicio> findAllServicios();
    Servicio findById(Long idServicio);
    Servicio findByNombre(String nombre);
}