package com.example.demo.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadService {
    private String carpeta="src/main/java/com/example/Proyecto_Mingeso/Data_Files//";
    private final Logger logg = LoggerFactory.getLogger(UploadService.class);

    public String save(MultipartFile file) {
        if (!file.isEmpty()){
            try {
                byte [] bytes=file.getBytes();
                Path path = Paths.get(carpeta+file.getOriginalFilename());
                Files.write(path, bytes);
                logg.info("Archivo cargado correctamente");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Archivo guardado";
    }
}
