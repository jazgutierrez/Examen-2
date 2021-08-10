/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examengutierrez.controller;

import ec.edu.espe.distribuidas.examengutierrez.dto.GenAgenciaRS;
import ec.edu.espe.distribuidas.examengutierrez.model.GenAgencia;
import ec.edu.espe.distribuidas.examengutierrez.service.GenAgenciaService;
import ec.edu.espe.distribuidas.examengutierrez.transform.GenAgenciaRSTransform;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/genAgencia")
public class GenAgenciaController {

    private final GenAgenciaService service;

    public GenAgenciaController(GenAgenciaService service) {
        this.service = service;
    }

    @GetMapping(value = "{codEmpresa}")
    public ResponseEntity obtenerAgenciasPorEmpresa(@PathVariable("codEmpresa") String codEmpresa) {
        try {
            List<GenAgencia> agencias = this.service.listarAgenciasPorEmpresa(codEmpresa);
            List<GenAgenciaRS> agenciasRS=new ArrayList<>();
            for(GenAgencia g: agencias){
                agenciasRS.add(GenAgenciaRSTransform.buildGenAgenciaRS(g));
            }
            return ResponseEntity.ok(agenciasRS);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

    }
}
