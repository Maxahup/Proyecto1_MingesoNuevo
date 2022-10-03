package com.example.demo.Services;

import com.example.demo.Models.Empleado;

import java.util.List;

public interface EmpleadoService {

    public List<Empleado> listarTodosEmpleados();

    public List<Empleado> generatePayment();

    public Empleado obtenerEmpleadoId(Integer id);

    public Empleado actualizarEmpleado(Empleado empleado);

}
