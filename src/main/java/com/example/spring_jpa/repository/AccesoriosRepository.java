
package com.example.spring_jpa.repository;

import com.example.spring_jpa.entity.Accesorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface AccesoriosRepository extends JpaRepository<Accesorios, Integer>{
    
    
    
}
