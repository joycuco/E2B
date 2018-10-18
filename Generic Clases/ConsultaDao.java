package com.e2bnutrition.e2bbackend.dao;


import java.util.List;

import com.e2bnutrition.e2bbackend.model.Consulta;

public interface ConsultaDao {

    void saveConsulta(Consulta consulta);
    void deleteConsultaById(Long idConsulta);
    void updateConsulta(Consulta consulta);

    List<Consulta> findAllConsultas();
    Consulta findById(Long idConsulta);
    Consulta findByNombre(String nombre);
}