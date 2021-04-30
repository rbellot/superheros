package com.sp.example.service;

import java.util.List;
import java.util.Optional;

import com.sp.example.entity.Superhero;

public interface SuperheroService {
    
    public List<Superhero> findAll();
    
    public Optional<Superhero> findById(Long id);

    public List<Superhero> findByName(String name);
    
    public String deleteById(Long id);

    public Superhero save(Superhero superhero);

}
