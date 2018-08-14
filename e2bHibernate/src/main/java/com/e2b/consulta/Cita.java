package com.e2b.consulta;

import java.util.Date;

public class Cita {
    private Long idCita;
    private Paciente paciente;
    private Date fechaCita;
    private Empleado empleado;

    public Cita() {
    }

    public Cita(Long idCita, Paciente paciente, Date fechaCita, Empleado empleado) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.fechaCita = fechaCita;
        this.empleado = empleado;
    }

    public Long getIdCita() {
        return idCita;
    }

    public void setIdCita(Long idCita) {
        this.idCita = idCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
