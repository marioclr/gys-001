package com.example.demo.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.IQnaTimbrado;
import com.example.demo.model.ITimbradoMeta4;
import com.example.demo.model.Timbrado;
import com.example.demo.repository.TimbradoRepository;
import com.example.demo.service.ITimbradoService;

@Service
public class TimbradoServiceJpa implements ITimbradoService {
    
    @Autowired
    private TimbradoRepository timbradoRepo;

    @Override
    public void guardar(Timbrado timbrado) {
        timbradoRepo.save(timbrado);
        
    }

    @Override
    public List<ITimbradoMeta4> mostrarRegistrosMeta4(Integer quincena) {
        return timbradoRepo.mostrarRegistrosMeta4(quincena);
    }

    @Override
    public List<IQnaTimbrado> listaQnaTimbrado() {
        return timbradoRepo.listaQnaTimbrado();
    }

}
    