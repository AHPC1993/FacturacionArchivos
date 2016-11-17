/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Oscar
 */
public class GestionA {

    FileInputStream entrada;
    FileOutputStream salida;

    public GestionA() {

    }

    /**
     * Método encargado de leer un archivo .txt y lo devuelve como un modelo de
     * lista, lee línea por línea del archivo de texto y lo agrega al modelo,
     * para posteriormente retornarlo.
     *
     * @param fichero
     * @return
     */
    public DefaultListModel lista(String fichero) {
        try {
            DefaultListModel modelo = new DefaultListModel();
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                modelo.addElement(linea);
            }

            fr.close();
            return modelo;
        } catch (Exception e) {
            System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
            return null;
        }
    }

    /**
     * Método encargado de modificar una lista existente, le entra el archivo
     * .txt que va a leer, la línea vieja que desea reemplazar por la línea
     * nueva; Una vez que encuentra la línea buscada, la reemplaza por la nueva.
     *
     * @param fichero
     * @param lineaVieja
     * @param lineaNueva
     * @return
     */
    public DefaultListModel modificarLista(String fichero, String lineaVieja, String lineaNueva) {
        try {
            DefaultListModel modelo = new DefaultListModel();
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.equals(lineaVieja)) {
                    modelo.addElement(lineaNueva);
                } else {
                    modelo.addElement(linea);
                }
            }

            fr.close();
            return modelo;
        } catch (Exception e) {
            System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
            return null;
        }
    }

    /**
     * Método encargado de guardar en un archivo .txt el contenido que le entra
     * por parámetro.
     *
     * @param ruta
     * @param contenido
     * @return
     */
    public String GuardarATexto(String ruta, String contenido) {

        File archivo = new File(ruta);
        String respuesta = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            respuesta = "Se guardo con exito el archivo";
        } catch (Exception e) {
        }
        return respuesta;
    }

}
