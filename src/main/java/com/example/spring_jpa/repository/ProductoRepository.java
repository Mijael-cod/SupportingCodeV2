
package com.example.spring_jpa.repository;

import com.example.spring_jpa.entity.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
     //@Query("SELECT * FROM PRODUCTO p WHERE p.nombre LIKE %?1%")
     //public List<Producto> findAll(String keyword);
    
    //Buscar productos por nombre
    List<Producto> findByNombre(String nombre); 
    
    
    
}
