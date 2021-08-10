/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examengutierrez.dto;

import java.util.List;
import lombok.Data;

@Data
public class SegUsuarioAgenciaRQ {

    private String codUsuario;
    private List<AgenciaRQ> agencias;
    
}
