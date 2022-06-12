package com.iudigital.persistencia.persistenciacrud.service;


import com.iudigital.persistencia.persistenciacrud.model.Almacen;
import com.iudigital.persistencia.persistenciacrud.repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService {
    @Autowired //indica que esta conectado al repositorio y esta haciendo uso de los objetos
    private AlmacenRepository almacenRepository;

    public Almacen guardarAlmacen (Almacen almacen){
        return almacenRepository.save(almacen);
    }

    public List<Almacen> getAllAlmacen(){
        return almacenRepository.findAll();
    }

    public void delete (Long id){
        almacenRepository.deleteById(id);
    }
    public Optional<Almacen> findById (Long id){
        return almacenRepository.findById(id);
    }

}
