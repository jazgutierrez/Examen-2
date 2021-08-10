/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examengutierrez.transform;

import ec.edu.espe.distribuidas.examengutierrez.dto.GenAgenciaRS;
import ec.edu.espe.distribuidas.examengutierrez.model.GenAgencia;

/**
 *
 * @author yazbe
 */
public class GenAgenciaRSTransform {

    public static GenAgenciaRS buildGenAgenciaRS(GenAgencia genAgencia) {
        return GenAgenciaRS.builder()
                .codAgencia(genAgencia.getPk().getCodAgencia())
                .nombre(genAgencia.getNombre())
                .build();
    }
}
