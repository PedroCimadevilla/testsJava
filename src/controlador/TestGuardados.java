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
        Scanner teclado = new Scanner(System.in);
        String nom;
        int dinero;
        
        /*
        System.out.println("primero nom, luego int");
        nom = teclado.nextLine();
        dinero = teclado.nextInt();
        TestPersonaje nuevo = new TestPersonaje(nom, dinero);
        nuevo.guardarPersonaje();
        */
        
        
        
        String ruta = "/home/alumno/Descargas/guardadopersonajes/";
        TestPersonaje tp = new TestPersonaje("placeholder", 0);
        TestPersonaje este = tp.leerPersonaje(ruta);
        System.out.println(este.toString());
        
        
    }
    
}
