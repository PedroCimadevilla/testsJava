/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class TestPersonaje {

    private String nom;
    private int dinero;

    public TestPersonaje(String nom, int dinero) {
        this.nom = nom;
        this.dinero = dinero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "TestPersonaje{" + "nom=" + nom + ", dinero=" + dinero + '}';
    }

    public void guardarPersonaje() {
        int randomNumber = (int) (Math.random() * 100);
        File file = new File("/home/alumno/Descargas/guardadopersonajes/" + nom + randomNumber + ".dat");
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.seek(0);
            raf.writeUTF(nom);
            raf.seek(1);
            raf.writeInt(dinero);
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero inexistente");
        } catch (IOException ex) {
            Logger.getLogger(TestPersonaje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public File recuperarPersonaje(String ruta) throws IOException {
        File file = new File(ruta);
        Scanner teclado = new Scanner(System.in);
        System.out.println("nombre a buscar");
        String nombre = teclado.nextLine();
        File[] listaDirectorios = file.listFiles();
        for (File directorio : listaDirectorios) {
            if (directorio.isDirectory()) {
                file = new File(recuperarPersonaje(directorio.getCanonicalPath()).getCanonicalPath());
                if (file.getName().contains(nombre)) {
                    return file;
                }

            } else {
                if (directorio.getName().contains(nombre)) {
                    file = new File(directorio.getCanonicalPath());
                }
            }
        }
        return file;
    }
    
    public TestPersonaje leerPersonaje(String ruta){
        String nombre;
        int dinero;
        TestPersonaje tp = null;
        try {
            File f = recuperarPersonaje(ruta);
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            raf.seek(0);
            nombre = raf.readUTF();
            raf.seek(1);
            dinero = raf.readInt();
            tp = new TestPersonaje(nombre, dinero);
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
        return tp;
    }
    
    /*
    public void leer(String ruta) throws IOException {
        File file = new File(ruta);
        Scanner teclado = new Scanner(System.in);
        System.out.println("nombre a buscar");
        String nom = teclado.nextLine();
        File[] listaDirectorios = file.listFiles();
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        for (File directorio : listaDirectorios) {
            if (directorio.isDirectory()) {
                file = new File(recuperarPersonaje(directorio.getCanonicalPath()).getCanonicalPath());
                if (file.getName().contains(nom)) {
                    raf.seek(0);
                    System.out.println(raf.readUTF());
                }

            } else {
                if (directorio.getName().contains(nom)) {
                    raf.seek(0);
                    System.out.println(raf.readUTF());
                }
            }
        }
    }
*/
}


