/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Metodos {

    private final File fichero = new File("clientes.dat");
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public void crearFichero() {
        try {
            if (getFichero().exists()) {
                System.out.println("Fichero existente");
            } else {
                if (getFichero().createNewFile()) {
                    System.out.println("Se ha creado el fichero correctamente");
                } else {
                    System.err.println("Ha ocurrido un error al crear el fichero");
                }
            }
        } catch (IOException e) {
            System.err.println("Ocurrio un error");
        }
    }

    public void cerrarFichero() {
        try {
            if (!(ois == null)) {
                ois.close();
            }
            if (!(oos == null)) {
                 oos.close();
            }
        } catch (IOException ex) {
            System.err.println("No se pudo cerrar el archivo");
        }
    }

    public void escribirFichero(Persona persona) {
        try {
            if (getFichero().exists()) {

//                ObjectOutputStream oos;
                if (getFichero().length() == 0) {
                    oos = new ObjectOutputStream(new FileOutputStream(getFichero()));
                } else {
                    //el true es importante para seguir añadiento
                    oos = new MiObjectOutputStream(new FileOutputStream(getFichero(), true));
                }

                //lo inserta en el fichero
                oos.writeObject(persona);
                oos.flush();
                oos.close();

            }
        } catch (InputMismatchException e) {

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            cerrarFichero();
        }
    }

    public ArrayList<Persona> leerFichero() throws ClassNotFoundException {
        ArrayList<Persona> personas = new ArrayList<>();
        Persona p;

        try {
//            ObjectInputStream
            ois = new ObjectInputStream(new FileInputStream("clientes.dat"));
            try {
                while (true) {
                    p = (Persona) ois.readObject();
                    personas.add(p);
                }
            } catch (EOFException ex) {
                cerrarFichero();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("\nArchivo no encontrado: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("\nProblema de E/S: " + ex.getMessage());
        } finally {
            cerrarFichero();
        }
        return personas;
    }

    public void modificarFichero(Persona persona, String nombre, String apellido, String fijo, String cel, String correo, ArrayList<Persona> personas) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNombre().equals(persona.getNombre())
                    && personas.get(i).getApellido().equals(persona.getApellido())
                    && personas.get(i).getCorreo().equals(persona.getCorreo())) {

                personas.get(i).setNombre(nombre);
                personas.get(i).setApellido(apellido);
                personas.get(i).setTelefonoFijo(fijo);
                personas.get(i).setTelefonoCel(cel);
                personas.get(i).setCorreo(correo);
            }
        }
        cerrarFichero();
        //eliminarFichero();
        crearFichero();
        try {
            if (getFichero().exists()) {

//                ObjectOutputStream oos = null;
                for (int i = 0; i < personas.size(); i++) {
                    if (i == 0) {
                        oos = new ObjectOutputStream(new FileOutputStream(getFichero()));
                    } else {
                        //el true es importante para seguir añadiento
                        oos = new MiObjectOutputStream(new FileOutputStream(getFichero(), true));
                    }
                    oos.writeObject(personas.get(i));
                }
                //lo inserta en el fichero                
            }
        } catch (InputMismatchException e) {

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            cerrarFichero();
        }
    }

    public File getFichero() {
        return fichero;
    }

    public void eliminar(ArrayList<Persona> personas) throws ClassNotFoundException {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNombre().equals("-1")) {
                personas.remove(i);
            }else{
            }
        }
        crearFichero();
        try {
            if (getFichero().exists()) {

//                ObjectOutputStream oos = null;
                for (int i = 0; i < personas.size(); i++) {
                    if (i == 0) {
                        oos = new ObjectOutputStream(new FileOutputStream(getFichero()));
                    } else {
                        //el true es importante para seguir añadiento
                        oos = new MiObjectOutputStream(new FileOutputStream(getFichero(), true));
                    }
                    oos.writeObject(personas.get(i));
                }
                //lo inserta en el fichero                
            }
        } catch (InputMismatchException e) {

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            cerrarFichero();
        }
    }

}
