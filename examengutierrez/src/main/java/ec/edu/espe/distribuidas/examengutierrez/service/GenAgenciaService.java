/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examengutierrez.service;

import ec.edu.espe.distribuidas.examengutierrez.dao.GenAgenciaRepository;
import ec.edu.espe.distribuidas.examengutierrez.model.GenAgencia;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GenAgenciaService {
    private final GenAgenciaRepository agenciaRepo;

    public GenAgenciaService(GenAgenciaRepository agenciaRepo) {
        this.agenciaRepo = agenciaRepo;
    }
    
    public List<GenAgencia> listarAgenciasPorEmpresa(String codEmpresa){
        return this.agenciaRepo.findByPkCodEmpresa(codEmpresa);
    }
}
