/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.simpleconexmysql.datos.dao;

import com.comunidad.simpleconexmysql.datos.dao.vo.DatosVo;
import com.comunidad.simpleconexmysql.utilidad.jdbc.CerrarSentencias;
import com.comunidad.simpleconexmysql.utilidad.jdbc.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class DatosDao extends CerrarSentencias {

    public int guardar(DatosVo datosVo) throws Exception {
        Connection conexion = ConexionBD.getInstance().getConection();
        int index = 1;
        PreparedStatement stm = null;
        int retorno = 0;
        try {
            stm = conexion.prepareStatement(QuerysSql.INSERT_DATO);
            stm.setInt(index++, datosVo.getId());
            stm.setString(index++, datosVo.getNombre());
            stm.setString(index++, datosVo.getApePaterno());
            stm.setString(index++, datosVo.getApeMaterno());
            stm.setString(index++, datosVo.getGenero());
            retorno = stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            ConexionBD.getInstance().closeConnection(conexion);
        }
        return retorno;
    }

    public List<DatosVo> datos() throws Exception {
        Connection conexion = ConexionBD.getInstance().getConection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<DatosVo> listDatosRs = null;
        try {
            stm = conexion.prepareStatement(QuerysSql.SELECT_DATO);
            rs = stm.executeQuery();
            listDatosRs = getListDatosResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            ConexionBD.getInstance().closeConnection(conexion);
        }
        return listDatosRs;
    }

    private List<DatosVo> getListDatosResultSet(ResultSet res) throws SQLException {
        List<DatosVo> listDatos = null;
        if (res.next()) {
            listDatos = new ArrayList<DatosVo>();
            do {
                DatosVo datosVo = new DatosVo();
                datosVo.setId(res.getInt("ID"));
                datosVo.setNombre(res.getString("NOMBRE"));
                datosVo.setApePaterno(res.getString("APE_PATERNO"));
                datosVo.setApeMaterno(res.getString("APE_MATERNO"));
                datosVo.setGenero(res.getString("GENERO"));
                listDatos.add(datosVo);
            } while (res.next());
        }
        return listDatos;
    }
}
