package com.e2bnutrition.e2bbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2bnutrition.e2bbackend.dao.PacienteDao;
import com.e2bnutrition.e2bbackend.model.Paciente;

@Service("pacienteService")
@Transactional
public class PacienteServiceImpl implements PacienteService{
	
	@Autowired
	private PacienteDao _pacienteDao;

	@Override
	public void savePaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		_pacienteDao.savePaciente(paciente);
		
	}

	@Override
	public void deletePacienteById(Long idPaciente) {
		// TODO Auto-generated method stub
		_pacienteDao.deletePacienteById(idPaciente);
		
	}

	@Override
	public void updatePaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		_pacienteDao.updatePaciente(paciente);
		
	}

	@Override
	public List<Paciente> findAllPacientes() {
		// TODO Auto-generated method stub
		return _pacienteDao.findAllPacientes();
	}

	@Override
	public Paciente findById(Long idPaciente) {
		// TODO Auto-generated method stub
		return _pacienteDao.findById(idPaciente);
	}

	@Override
	public Paciente findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return _pacienteDao.findByNombre(nombre);
	}

}
