package com.example.demo.Controllers;

import com.example.demo.Models.Empleado;
import com.example.demo.Services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public String listarEmpleados(Model modelo){
        modelo.addAttribute("empleados", empleadoService.listarTodosEmpleados());
        return "empleados"; //nos retorna al archivo empleados
    }
    @GetMapping("/calcular_sueldos")
    public String listarEmpleados2(Model modelo){
        modelo.addAttribute("empleados", empleadoService.listarTodosEmpleados());
        return "empleados"; //nos retorna al archivo empleados
    }
    @PostMapping("/calcular_sueldos")
    public String calcular(Model modelo){
        modelo.addAttribute("empleados", empleadoService.generatePayment());
        return "emplados";
    }
/*
    @PostMapping("/empleados")
    public String generarPagoEmpleado(@ModelAttribute("empleado") Empleado empleado){
        empleado.addAttribute("empleados", empleadoService.generatePayment());
        return "empleados";
    }


 */
    @GetMapping("/empleados/editar/{id}")
    public String mostrarFormularioCalculo(@PathVariable Integer id, Model modelo){
        modelo.addAttribute("empleado", empleadoService.obtenerEmpleadoId(id));
        return "formulario_calculo";
    }

    @PostMapping("/empleados/{id}")
    public String actualizarEmpleado(@PathVariable Integer id, @ModelAttribute("empleado") Empleado empleado, Model modelo){
        Empleado empleadoExistente = empleadoService.obtenerEmpleadoId(id);
        empleadoExistente.setId(id);
        empleadoExistente.setNombres(empleado.getNombres());
        empleadoExistente.setApellidos(empleado.getApellidos());
        empleadoExistente.setRut(empleado.getRut());
        empleadoExistente.setCategoria(empleado.getCategoria());
        empleadoExistente.setSueldo_bruto(empleado.getSueldo_bruto());
        empleadoExistente.setAnno_contratacion(empleado.getAnno_contratacion());
        empleadoExistente.setMes_contratacion(empleado.getMes_contratacion());
        empleadoExistente.setDesc_atrasos(empleado.getDesc_atrasos());
        empleadoExistente.setBonificacion(empleado.getBonificacion());
        empleadoExistente.setDesc_cotizacion(empleado.getDesc_cotizacion());
        empleadoExistente.setSueldo_liquido(empleado.getSueldo_liquido());

        empleadoService.actualizarEmpleado(empleadoExistente);
        return "redirect:/empleados";
    }


}
