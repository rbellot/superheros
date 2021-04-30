package com.sp.example.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.example.entity.Superhero;
import com.sp.example.exception.SuperheroNotFoundException;
import com.sp.example.service.SuperheroService;
import com.sp.example.utils.Utils;

@RestController
public class ExampleController {

    private static Logger logger = Logger.getLogger(ExampleController.class.getName());

    @Autowired
    private SuperheroService superheroService;

    @GetMapping("/superheros")
    public List<Superhero> superheros() {
        StopWatch watch = Utils.getWatch();
        List<Superhero> list = superheroService.findAll();
        Utils.stopWatchAndPrint(watch);
        return list;
    }

    @GetMapping("/superheros/{id}")
    public Superhero superheroById(@PathVariable("id") Long id) {
        // Optional<Superhero> superhero = superheroService.findById(id);
        //
        // if (!superhero.isPresent())
        // throw new SuperheroNotFoundException(id);
        //
        // return superhero.get();
        return superheroService.findById(id).orElseThrow(() -> new SuperheroNotFoundException(id));
    }

    @GetMapping("/superherosByName")
    public List<Superhero> superherosByName(@RequestParam(value = "name", defaultValue = "Superman") String name) {
        return superheroService.findByName(name);
    }

    @DeleteMapping("/superheros/{id}")
    public String deleteStudent(@PathVariable long id) {
        return superheroService.deleteById(id);
    }

    @PutMapping("/superheros/{id}")
    public ResponseEntity<Object> updateSuperhero(@RequestBody Superhero superhero, @PathVariable long id) {
        Optional<Superhero> superheroOptional = superheroService.findById(id);
        if (!superheroOptional.isPresent()) {
            logger.info("Superhero do not exists");
            return ResponseEntity.notFound().build();
        }
        superhero.setId(id);
        superheroService.save(superhero);
        return ResponseEntity.noContent().build();
    }
}
