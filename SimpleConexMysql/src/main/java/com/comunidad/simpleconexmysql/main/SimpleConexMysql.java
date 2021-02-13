/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.simpleconexmysql.main;

import com.comunidad.simpleconexmysql.datos.dao.vo.DatosVo;
import com.comunidad.simpleconexmysql.datos.service.DatosService;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Santiago
 */
public class SimpleConexMysql {

    private static DatosService datosService = new DatosService();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sn = new Scanner(System.in);
        Scanner cadena = new Scanner(System.in);
        List<DatosVo> listaDatos = null;
        boolean salir = false;
        int opcion;
        int id;
        String nombre;
        String apePaterno;
        String apeMaterno;
        String genero;
    
        while (!salir) {
            System.out.println("******************************");
            System.out.println("      Menu de opciones        ");
            System.out.println("******************************");
            System.out.println("*   Selecciona una opcion:   *");
            System.out.println("*   1. Datos personales 1    *");
            System.out.println("*   2. Consultar datos  2    *");
            System.out.println("*   3. Salir                 *");
            System.out.println("******************************");
            System.out.println("******************************");
            try {

                System.out.println("Escribe una de las opciones: ");
                opcion = sn.nextInt();
                System.out.println("------------------------------");
                switch (opcion) {
                    case 1:
                        System.out.println("******************************");
                        System.out.println("*** Datos personales ***");
                        System.out.println("Ingresa tu ID: ");
                        id = sn.nextInt();
                        System.out.println("Ingresa tu nombre: ");
                        nombre = cadena.nextLine();
                        System.out.println("Ingresa tu apellido paterno: ");
                        apePaterno = cadena.nextLine();
                        System.out.println("Ingresa tu apellido materno: ");
                        apeMaterno = cadena.nextLine();
                        System.out.println("Ingresa tu genero: F - Femenino, M - Masculino ");
                        genero = cadena.nextLine();
                        datosService.guardar(new DatosVo(id, nombre, apePaterno, apeMaterno, genero));
                        System.out.println("El registro de guardo correctamente.");
                        System.out.println("******************************");
                        break;
                    case 2:
                        System.out.println("******************************");
                        System.out.println("*** Consultar datos ***");
                        listaDatos = datosService.datos();
                        System.out.println("*** Total de registros ***"+listaDatos.size());
                        if(listaDatos != null && listaDatos.size() > 0){
                            for(int x = 0; x < listaDatos.size(); x++){
                                System.out.println("* "+listaDatos.get(x));
                            }
                        }
                        System.out.println("******************************");
                        break;
                    case 3:
                        System.out.println("Hasta luego!, vuelve pronto.");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }catch (Exception e) {
                System.out.println("Error!!");
                e.printStackTrace(System.out);
            }
        }
    }
    
}
