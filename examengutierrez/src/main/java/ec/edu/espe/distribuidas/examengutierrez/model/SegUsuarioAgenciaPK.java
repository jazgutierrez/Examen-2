/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examengutierrez.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SegUsuarioAgenciaPK implements Serializable {

    @Column(name = "cod_usuario" , length = 30)
    private String codUsuario;

    @Column(name = "cod_empresa", length = 8)
    private String codEmpresa;

    @Column(name = "cod_agencia", length = 8)
    private String codAgencia;

   
}
