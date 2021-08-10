/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examengutierrez.service;

import ec.edu.espe.distribuidas.examengutierrez.dao.SegUsuarioAgenciaRepository;
import ec.edu.espe.distribuidas.examengutierrez.exception.CreateException;
import ec.edu.espe.distribuidas.examengutierrez.model.SegUsuarioAgencia;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SegUsuarioAgenciaService {

    private final SegUsuarioAgenciaRepository segUsuarioAgenciaRepo;

    public SegUsuarioAgenciaService(SegUsuarioAgenciaRepository segUsuarioAgenciaRepo) {
        this.segUsuarioAgenciaRepo = segUsuarioAgenciaRepo;
    }

    public void insertarAgencias(List<SegUsuarioAgencia> agencias) {
        int count = 0;
        for (SegUsuarioAgencia s : agencias) {
            if ("S".equals(s.getPorOmision())) {
                count++;
            }
        }
        if (count == 1) {
            for (SegUsuarioAgencia s : agencias) {
                this.segUsuarioAgenciaRepo.save(s);
            }
        }else{
            throw new CreateException("El usuario debe tener una agencia por omisión");
        }
    }
}
