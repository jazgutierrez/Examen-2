/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examengutierrez.dao;

import ec.edu.espe.distribuidas.examengutierrez.model.GenAgencia;
import ec.edu.espe.distribuidas.examengutierrez.model.GenAgenciaPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GenAgenciaRepository extends JpaRepository<GenAgencia, GenAgenciaPK> {
    List<GenAgencia> findByPkCodEmpresa(String codEmpresa);
}
