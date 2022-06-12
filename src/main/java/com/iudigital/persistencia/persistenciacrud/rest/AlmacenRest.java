
package com.iudigital.persistencia.persistenciacrud.rest;

import com.iudigital.persistencia.persistenciacrud.model.Almacen;
import com.iudigital.persistencia.persistenciacrud.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/almacen/")
public class AlmacenRest {

    @Autowired
    private AlmacenService almacenService;


    //mostrar formulario crar almacen
    @GetMapping("/almacenes/nuevo")
    public String mostrarFormularioAlmacen(Model modelo) {
        try {
            Almacen almacen = new Almacen();
            modelo.addAttribute("almacen", almacen);
            return "crearAlmacen";
        }
        catch (Exception e){
            return "Error guardando";
        }
    }


    //guardar almacen
    @PostMapping("/almacenes")
    public String guardarAlmacen(@ModelAttribute("almacen") Almacen almacen) {
        almacenService.guardarAlmacen(almacen);
        return "redirect:/almacenes";
    }


    //Listar todos los almacenes
    @GetMapping({"/almacenes","/"})
    public String listarAlmacenes   (Model modelo){
        modelo.addAttribute("almacenes", almacenService.getAllAlmacen());
        return "almacenes";
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    private ResponseEntity<Optional<Almacen>> optenerAlmacen (@PathVariable ("id") Long id){
        return ResponseEntity.ok(almacenService.findById(id));
    }

    //borrar almacen
    @GetMapping("/almacenes/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        almacenService.delete(id);
        return "redirect:/almacenes";
    }



}