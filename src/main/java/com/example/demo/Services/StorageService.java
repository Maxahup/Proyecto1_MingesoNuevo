package com.example.demo.Services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.nio.file.Path;

public interface StorageService {
    void init();
    String storage(MultipartFile file);
    Path load(String filename);
    Resource loadAsResource(String filename) throws FileNotFoundException;
    void delete(String filename);
}
