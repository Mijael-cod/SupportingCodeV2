/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.spring_jpa.servicios;

import com.example.spring_jpa.entity.Accesorios;
import com.example.spring_jpa.repository.AccesoriosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mijae
 */

@Service
public class AccesoriosService implements Operaciones<Accesorios>{
    
    @Autowired
    private AccesoriosRepository accesoriosRepository;
    
    @Override
    public Accesorios create(Accesorios t) {
        return accesoriosRepository.save(t);
    }
    
    @Override
    public Accesorios update(Accesorios t) {
        return accesoriosRepository.save(t);
    }
    
    @Override
    public void delete(int id) {
        accesoriosRepository.deleteById(id);
    }
    
     @Override
    public Accesorios read(int id) {
        return accesoriosRepository.findById(id).get();
    }

    @Override
    public List<Accesorios> readAll() {
        return accesoriosRepository.findAll();
    }
  
}
