/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Scanner;
import modelo.TestPersonaje;


public class TestGuardados {


    public static void main(String[] args) {
        String ruta = "/home/alumno/Descargas/guardadopersonajes/";
        TestPersonaje tp = new TestPersonaje("placeholder", 0);
        TestPersonaje este = tp.leerPersonaje(ruta);
        System.out.println(este.toString());
        
    }
    
}
