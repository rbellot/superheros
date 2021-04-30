package com.sp.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.example.entity.Superhero;
import com.sp.example.repository.SuperheroRepository;

@Service
public class SuperheroServiceImpl implements SuperheroService {

    @Autowired
    private SuperheroRepository superheroRepository;

    public List<Superhero> findAll() {
        return (List<Superhero>) superheroRepository.findAll();
    }

    public Optional<Superhero> findById(Long id) {
        return superheroRepository.findById(id);
    }
    
    public List<Superhero> findByName(String name) {
        return (List<Superhero>) superheroRepository.findByNameContainingIgnoreCase(name);
    }
    
    public String deleteById(Long id) {
        superheroRepository.deleteById(id);
        return "Superhero deleted correctly.";
    }

    public Superhero save(Superhero superhero) {
        return superheroRepository.save(superhero);
    }

}
