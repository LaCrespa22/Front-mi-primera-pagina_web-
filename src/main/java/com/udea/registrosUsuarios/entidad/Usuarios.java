package com.udea.registrosUsuarios.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "registroUsuarios")
public class Usuarios {

    //atributos, gett y setts
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombreUsuario;
    @Column
    private int edad;
    @Column
    private String numeroTelefono;
    @Column
    private String correoElectronico;
    @Column
    private String rolEmpresa;

    @Column
    private boolean usuarioDisponible;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRolEmpresa() {
        return rolEmpresa;
    }

    public void setRolEmpresa(String rolEmpresa) {
        this.rolEmpresa = rolEmpresa;
    }

    public boolean isUsuarioDisponible() {
        return usuarioDisponible;
    }

    public void setUsuarioDisponible(boolean usuarioDisponible) {
        this.usuarioDisponible = usuarioDisponible;
    }
}

