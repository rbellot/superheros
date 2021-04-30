package com.sp.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sp.example.entity.Superhero;

public interface SuperheroRepository extends CrudRepository<Superhero, Long> {

    public List<Superhero> findByNameContainingIgnoreCase(String name);

}
