package com.e2b.e2bnutricion.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "permiso_rol")
public class PermisoRol implements Serializable {

    @Id
    @Column(name = "id_permiso_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermisoRol;

    @OneToMany(mappedBy = "permisoRol")
    private Set<Permiso> permisos;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    public PermisoRol() {
        super();
    }

    public PermisoRol(Set<Permiso> permisos, Rol rol) {
        super();
        this.permisos = permisos;
        this.rol = rol;
    }

    public Long getIdPermisoRol() {
        return idPermisoRol;
    }

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

    public void setIdPermisoRol(Long idPermisoRol) {
        this.idPermisoRol = idPermisoRol;
    }


    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
