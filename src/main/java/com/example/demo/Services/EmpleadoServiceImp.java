package com.example.demo.Services;


import com.example.demo.Models.Empleado;
import com.example.demo.Repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

@Service
public class EmpleadoServiceImp implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listarTodosEmpleados(){

        return empleadoRepository.findAll();
    }
    public List<Empleado> generatePayment() {

        List<Empleado> empleados = listarTodosEmpleados();
        Integer cantidadEmpleados = empleados.size();
        Integer contador = 0;
        while (contador < cantidadEmpleados) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("com/example/Proyecto_Mingeso/Data_Files/data.txt"));
                String linea = br.readLine();
                float descuentoAtraso = 0;
                Integer cantidadHorasExtras = 0;
                Integer diasJustificados = 0;       //este valor solo cambia cuando se implementen los justificados
                Integer yearActual = 2022;
                float bonificacionServicio = 0;
                float descuentoPrevisionSocial = (float) (empleados.get(contador).getSueldo_bruto() * 0.1);
                float descuentoPlanSalud = (float) (empleados.get(contador).getSueldo_bruto() * 0.08);
                float descuentoTotal;
                float bonificacionTotal;

                while (linea != null) {
                    //DESCUENTO POR ATRASOS PARA CADA PERSONA
                    String[] registro = linea.split(";");
                    //forma: registro["2022/07/01", "08:00" , "12111222-3"]
                    String[] stringFechaRegistrada = registro[0].split("/");
                    yearActual = Integer.parseInt(stringFechaRegistrada[0]);
                    if (empleados.get(contador).getRut().equals(registro[2])) {
                        String[] horaPersona = registro[1].split(":");
                        Integer horaLeida = Integer.parseInt(horaPersona[0]);
                        Integer minutoLeido = Integer.parseInt(horaPersona[1]);
                        boolean descuentoDuplicado = false;
                        //Seccion para revisar atrasos
                        if (horaLeida == 8) {
                            if (minutoLeido > 0 && minutoLeido < 26) {
                                descuentoAtraso = descuentoAtraso + (float) (empleados.get(contador).getSueldo_bruto() * 0.01);
                            }
                            if (minutoLeido > 25 && minutoLeido < 46) {
                                descuentoAtraso = descuentoAtraso + (float) (empleados.get(contador).getSueldo_bruto() * 0.03);
                            }
                            if (minutoLeido > 45 && minutoLeido <= 60) {
                                descuentoAtraso = descuentoAtraso + (float) (empleados.get(contador).getSueldo_bruto() * 0.06);
                                descuentoDuplicado = true;
                            }
                        }
                        if (horaLeida == 9) {
                            if (minutoLeido >= 00 && minutoLeido < 11 && !descuentoDuplicado) {
                                descuentoAtraso = descuentoAtraso + (float) (empleados.get(contador).getSueldo_bruto() * 0.06);
                            }
                            if (minutoLeido > 10) {
                                descuentoAtraso = descuentoAtraso + (float) (empleados.get(contador).getSueldo_bruto() * 0.15);
                            }
                        }
                        if (horaLeida > 18 && horaLeida < 24) {
                            cantidadHorasExtras = cantidadHorasExtras + (horaLeida - 18);
                        }
                        linea = br.readLine();
                    }
                }
                Integer yearServicio = yearActual - empleados.get(contador).getAnno_contratacion();
                if (yearServicio >= 5 && yearServicio < 10) {
                    bonificacionServicio = (float) (empleados.get(contador).getSueldo_bruto() * 0.05);
                }
                if (yearServicio >= 10 && yearServicio < 15) {
                    bonificacionServicio = (float) (empleados.get(contador).getSueldo_bruto() * 0.08);
                }
                if (yearServicio >= 15 && yearServicio < 20) {
                    bonificacionServicio = (float) (empleados.get(contador).getSueldo_bruto() * 0.11);
                }
                if (yearServicio >= 20 && yearServicio < 25) {
                    bonificacionServicio = (float) (empleados.get(contador).getSueldo_bruto() * 0.14);
                }
                if (yearServicio >= 25) {
                    bonificacionServicio = (float) (empleados.get(contador).getSueldo_bruto() * 0.08);
                }
                descuentoTotal = descuentoAtraso + descuentoPlanSalud + descuentoPrevisionSocial;
                bonificacionTotal = bonificacionServicio;
            } catch (java.io.FileNotFoundException ex) {
                System.out.println("Error: archivo data.txt no encontrado");
            } catch (Exception ex) {
                System.out.println("Error: no se ha podido leer data.txt");
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (Exception ex) {
                    System.out.println("Error: no se ha podido cerrar el archivo data.txt");
                }
            }
            empleadoRepository.save(empleados.get(contador));
            System.out.println("el sueldo liquido de "+ empleados.get(contador).getRut() + "es de $" + empleados.get(contador).getSueldo_liquido());
            contador = contador + 1;
        }
        return empleados;
    }


    @Override
    public Empleado obtenerEmpleadoId(Integer id) {
        return empleadoRepository.findById(id).get();
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}