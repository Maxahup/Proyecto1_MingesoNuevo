package com.example.demo.Models;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombres")
    @NotNull
    private String nombres;

    @Column(name = "apellidos")
    @NotNull
    private String apellidos;

    @Column(name = "rut", unique = true)
    @NotNull
    private String rut;

    @Column(name = "categoria")
    @NotNull
    private char categoria;

    @Column(name = "sueldo_bruto")
    @NotNull
    private float sueldo_bruto;

    @Column(name = "anno_contratacion")
    @NotNull
    private int anno_contratacion;

    @Column(name = "mes_contratacion")
    @NotNull
    private int mes_contratacion;

    @Column(name = "desc_atrasos")
    private float desc_atrasos;

    @Column(name = "bonificacion")
    private float bonificacion;

    @Column(name = "desc_cotizacion")
    private float desc_cotizacion;

    @Column(name = "sueldo_liquido")
    private float sueldo_liquido;

    public Empleado(){

    }

    public Empleado(Integer id, String nombres, String apellidos, String rut, char categoria, float sueldo_bruto, int anno_contratacion, int mes_contratacion, float desc_atrasos, float bonificacion, float desc_cotizacion, float sueldo_liquido) {
        super();
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rut = rut;
        this.categoria = categoria;
        this.sueldo_bruto = sueldo_bruto;
        this.anno_contratacion = anno_contratacion;
        this.mes_contratacion = mes_contratacion;
        this.desc_atrasos = desc_atrasos;
        this.bonificacion = bonificacion;
        this.desc_cotizacion = desc_cotizacion;
        this.sueldo_liquido = sueldo_liquido;
    }
    public Empleado(String nombres, String apellidos, String rut, char categoria, float sueldo_bruto, int anno_contratacion, int mes_contratacion, float desc_atrasos, float bonificacion, float desc_cotizacion, float sueldo_liquido) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rut = rut;
        this.categoria = categoria;
        this.sueldo_bruto = sueldo_bruto;
        this.anno_contratacion = anno_contratacion;
        this.mes_contratacion = mes_contratacion;
        this.desc_atrasos = desc_atrasos;
        this.bonificacion = bonificacion;
        this.desc_cotizacion = desc_cotizacion;
        this.sueldo_liquido = sueldo_liquido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public float getSueldo_bruto() {
        return sueldo_bruto;
    }

    public void setSueldo_bruto(float sueldo_bruto) {
        this.sueldo_bruto = sueldo_bruto;
    }

    public int getAnno_contratacion() {
        return anno_contratacion;
    }

    public void setAnno_contratacion(int anno_contratacion) {
        this.anno_contratacion = anno_contratacion;
    }

    public int getMes_contratacion() {
        return mes_contratacion;
    }

    public void setMes_contratacion(int mes_contratacion) {
        this.mes_contratacion = mes_contratacion;
    }

    public float getDesc_atrasos() {
        return desc_atrasos;
    }

    public void setDesc_atrasos(float desc_atrasos) {
        this.desc_atrasos = desc_atrasos;
    }

    public float getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(float bonificacion) {
        this.bonificacion = bonificacion;
    }

    public float getDesc_cotizacion() {
        return desc_cotizacion;
    }

    public void setDesc_cotizacion(float desc_cotizacion) {
        this.desc_cotizacion = desc_cotizacion;
    }

    public float getSueldo_liquido() {
        return sueldo_liquido;
    }

    public void setSueldo_liquido(float sueldo_liquido) {
        this.sueldo_liquido = sueldo_liquido;
    }



}
