/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.simpleconexmysql.datos.service;

import com.comunidad.simpleconexmysql.datos.dao.DatosDao;
import com.comunidad.simpleconexmysql.datos.dao.vo.DatosVo;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class DatosService {

    private DatosDao datosDao = new DatosDao();

    public int guardar(DatosVo datosVo) throws Exception {
        return datosDao.guardar(datosVo);
    }

    public List<DatosVo> datos() throws Exception {
        return datosDao.datos();
    }
}
