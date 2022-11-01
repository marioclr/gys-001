package com.example.demo.service;

import java.util.List;
 
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.ITimbradoMeta4;
import com.example.demo.model.Timbrado;


public interface ITimbradoService {

    void guardar(Timbrado timbrado);

    @Transactional(readOnly = true)
    List<ITimbradoMeta4> mostrarRegistrosMeta4(Integer quincena);
    
}
