/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examengutierrez.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "gen_agencia")
public class GenAgencia implements Serializable {

    @EmbeddedId
    protected GenAgenciaPK pk;

    @Column(name = "nombre", length = 150)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genAgencia")
    private List<SegUsuarioAgencia> segUsuarioAgencias;

}
