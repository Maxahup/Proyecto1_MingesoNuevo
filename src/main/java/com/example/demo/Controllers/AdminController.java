package com.example.demo.Controllers;

import com.example.demo.Models.Empleado;
import com.example.demo.Models.Fichero;
import com.example.demo.Repositories.EmpleadoRepository;
import com.example.demo.Services.FileSystemStorageService;
import com.example.demo.Services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    FileSystemStorageService fileSystemStorageService;
    @Autowired
    private EmpleadoRepository empleadoRepository;

    //@Autowired
    //private Fichero fichero;

    @Autowired
    private UploadService uploadService;
    ModelAndView index(@PageableDefault(sort="anno_contratacion", size = 4) Pageable pageable) {
        Page<Empleado> empleados = empleadoRepository.findAll(pageable);

        return new ModelAndView("index").addObject("empleados", empleados);
    }
    @GetMapping("/fichero/subir")
    ModelAndView nuevoArchivo(){
        return new ModelAndView("admin/subir-archivo")
                .addObject("rutaFichero", new Fichero());

    }
    @PostMapping("/fichero/subir")
    public ModelAndView cargarArchivo(@RequestParam("ruta")MultipartFile file, RedirectAttributes msg){
        uploadService.save(file);
        msg.addAttribute("mensaje", "Archivo subido correctamente");

        return new ModelAndView("index");
    }
    @GetMapping("/fichero/subir/justificar")
    ModelAndView nuevaJustificacion(){
        return new ModelAndView("admin/subir-justificativos").addObject("rutaFichero", new Fichero());
    }
    @PostMapping("/fichero/subir/justificar")
    public ModelAndView cargarJustificaciones(@RequestParam("ruta")MultipartFile file, RedirectAttributes msg){
        uploadService.save(file);
        msg.addAttribute("mensaje", "Archivo de justificaciones subido correctamente");

        return new ModelAndView("index");
    }
    @GetMapping("/fichero/subir/autorizar")
    ModelAndView nuevaAutorizacion(){
        return new ModelAndView("admin/subir-autorizaciones").addObject("rutaFichero", new Fichero());
    }
    @PostMapping("/fichero/subir/autorizar")
    public ModelAndView cargarAutorizacion(@RequestParam("ruta")MultipartFile file, RedirectAttributes msg){
        uploadService.save(file);
        msg.addAttribute("mensaje", "Archivo de justificaciones subido correctamente");

        return new ModelAndView("index");
    }


}
