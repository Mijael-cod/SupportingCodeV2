package com.example.spring_jpa.servicios;

import com.example.spring_jpa.entity.Producto;
import com.example.spring_jpa.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductoService implements Operaciones<Producto>{
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Override
    public Producto create(Producto t) {
        return productoRepository.save(t);
        
    }

    @Override
    public Producto update(Producto t) {
        return productoRepository.save(t);
    }

    @Override
    public void delete(int id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto read(int id) {
        return productoRepository.findById(id).get();
    }

    @Override
    public List<Producto> readAll() {
        return productoRepository.findAll();
    }
    
    //Ejemplo buscar
    
    public List<Producto> buscarporNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }
    
    
    
    //public List<Producto> readAll(String keyword) {
       // if (keyword != null) {
         //  return productoRepository.findAll(keyword);
      //  }
        //return productoRepository.findAll();
    //}
 
}
