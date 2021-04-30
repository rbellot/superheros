package com.sp.example.service;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sp.example.entity.Superhero;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuperheroServiceTest {
    
    @Autowired
    private SuperheroService superheroService;
    
    @Test
    void whenDeleteSuperhero_shouldDeleteSuperhero() {
        Superhero superhero = new Superhero("Rock", "Duro", 652);
        superheroService.save(superhero);

        Superhero firstResult = superheroService.findAll().get(0);

        assertNotEquals(superhero.getName(), firstResult.getName());
        assertNotEquals(superhero.getSkill(), firstResult.getSkill());
        assertNotEquals(superhero.getWeight(), firstResult.getWeight());
    }
}
