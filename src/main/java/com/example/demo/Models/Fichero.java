package com.example.demo.Models;

import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Transient;


@NoArgsConstructor
public class Fichero {
    private String rutaFichero;
    private String Autor;

    @Transient
    private MultipartFile rutaArchivo;

    public Fichero(String rutaFichero, String autor) {
        this.rutaFichero = rutaFichero;
        Autor = autor;
    }

    public String getRutaFichero() {
        return rutaFichero;
    }

    public void setRutaFichero(String rutaFichero) {
        this.rutaFichero = rutaFichero;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }
}
