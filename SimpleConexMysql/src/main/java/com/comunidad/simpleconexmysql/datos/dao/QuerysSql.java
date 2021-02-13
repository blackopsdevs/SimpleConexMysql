/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.simpleconexmysql.datos.dao;

/**
 *
 * @author Santiago
 */
public class QuerysSql {
    public static final String INSERT_DATO;
    public static final String SELECT_DATO;
        
    static {
        StringBuilder sqlInsert = new StringBuilder();
        sqlInsert.append(" INSERT INTO DATOS (ID, NOMBRE, APE_PATERNO, APE_MATERNO, GENERO) VALUES (?,?,?,?,?) ");
        INSERT_DATO = sqlInsert.toString();
        
        StringBuilder sqlSelect = new StringBuilder();
        sqlSelect.append(" SELECT ID, NOMBRE, APE_PATERNO, APE_MATERNO, GENERO FROM DATOS ");
        SELECT_DATO = sqlSelect.toString();
    }
}
