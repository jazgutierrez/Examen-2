/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examengutierrez.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@Entity
@Table(name = "seg_usuario_agencia")
public class SegUsuarioAgencia implements Serializable {

    @EmbeddedId
    protected SegUsuarioAgenciaPK pk;
    
    @Column(name = "por_omision", length = 1)
    private String porOmision;

    @JoinColumns({
        @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false),
        @JoinColumn(name = "cod_agencia", referencedColumnName = "cod_agencia", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private GenAgencia genAgencia;

    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegUsuario segUsuario;
    
}
