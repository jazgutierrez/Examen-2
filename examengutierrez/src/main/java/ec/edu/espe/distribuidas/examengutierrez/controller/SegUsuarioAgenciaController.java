/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examengutierrez.controller;

import ec.edu.espe.distribuidas.examengutierrez.dto.AgenciaRQ;
import ec.edu.espe.distribuidas.examengutierrez.dto.SegUsuarioAgenciaRQ;
import ec.edu.espe.distribuidas.examengutierrez.model.SegUsuarioAgencia;
import ec.edu.espe.distribuidas.examengutierrez.model.SegUsuarioAgenciaPK;
import ec.edu.espe.distribuidas.examengutierrez.service.SegUsuarioAgenciaService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/segUsuarioAgencia")
public class SegUsuarioAgenciaController {

    private final SegUsuarioAgenciaService service;

    public SegUsuarioAgenciaController(SegUsuarioAgenciaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity crearSegUsuarioAgencia(@RequestBody SegUsuarioAgenciaRQ request) {
        try {
            log.info("Va a crear las agencias del usuario con la siguiente informacion: {}", request);
            List<SegUsuarioAgencia> segUsuarioAgencias = new ArrayList<>();
            String codUser = request.getCodUsuario();

            for (AgenciaRQ a : request.getAgencias()) {
                SegUsuarioAgencia segUsuario = new SegUsuarioAgencia();
                SegUsuarioAgenciaPK pk= new SegUsuarioAgenciaPK();
                pk.setCodAgencia(a.getCodAgencia());
                pk.setCodEmpresa(a.getCodEmpresa());
                pk.setCodUsuario(codUser);
                segUsuario.setPk(pk);
                segUsuario.setPorOmision(a.getPorOmision());
                segUsuarioAgencias.add(segUsuario);
            }
            this.service.insertarAgencias(segUsuarioAgencias);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Ocurrio un error al crear la enfermedad. {} - retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
