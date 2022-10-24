/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laboratorio5;

/**
 *
 * @author Admin
 */
public class Operaciones extends Empleado{
    
    Empleado emp = new Empleado();
    
    public void asignar(String nombre, int id, double salario) {
        emp.setNombre(nombre);
        emp.setId(id);
        emp.setSalario(salario);
    }
}
