/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examengutierrez.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenAgenciaRS {

    private String codAgencia;
    private String nombre;
}
