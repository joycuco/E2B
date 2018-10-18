package com.e2bnutrition.e2bbackend.dao;


import java.util.List;

import com.e2bnutrition.e2bbackend.model.Consulta;
import com.e2bnutrition.e2bbackend.model.EjemploAlimento;
import com.e2bnutrition.e2bbackend.model.LaboratorioConsulta;

public interface ConsultaDao {

    void saveConsulta(Consulta consulta);
    void deleteConsultaById(Long idConsulta);
    void updateConsulta(Consulta consulta);

    List<Consulta> findAllConsultas();
    Consulta findById(Long idConsulta);

    LaboratorioConsulta findLaboratorioByIdAndResultados(Long idLaboratorio, String resultados);
    //Consulta findByNombre(String nombre);
}