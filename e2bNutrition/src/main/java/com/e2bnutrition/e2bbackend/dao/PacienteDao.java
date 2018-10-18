package com.e2bnutrition.e2bbackend.dao;


import java.util.List;

import com.e2bnutrition.e2bbackend.model.Paciente;

public interface PacienteDao {

    void savePaciente(Paciente paciente);
    void deletePacienteById(Long idPaciente);
    void updatePaciente(Paciente paciente);

    List<Paciente> findAllPacientes();
    Paciente findById(Long idPaciente);
    Paciente findByNombre(String nombre);
}