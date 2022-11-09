package com.example.demo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.IQnaTimbrado;
import com.example.demo.model.ITimbradoMeta4;
import com.example.demo.service.ITimbradoService;

@RestController
@RequestMapping("/timbrado")
public class TimbradoRestController {
    @Autowired
    ITimbradoService timbradoService;

    @GetMapping("/qna")
    List<IQnaTimbrado> mostrarQnas(){
        return timbradoService.listaQnaTimbrado();
    }

    @PostMapping("/registros")
    List<ITimbradoMeta4> mostrarRegistrosMeta4PorFecha(@RequestParam("quincena") Integer quincena){
        return timbradoService.mostrarRegistrosMeta4(quincena);
    }
}
