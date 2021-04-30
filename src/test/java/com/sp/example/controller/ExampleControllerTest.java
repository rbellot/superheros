package com.sp.example.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sp.example.entity.Superhero;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleControllerTest {
    
    ExampleController exam = new ExampleController();
    
    @Test
    void whenSuperheroById_shouldReturnSuperhero() {
        Superhero result = exam.superheroById(1L);
        assertNotNull(result);
        Superhero superman = new Superhero("Superman", "Vuela", 85);
        assertEquals(superman, result);
    }

    @Test
    void whenGetAllSuperheros_shouldReturnAllSuperheros() {
        List<Superhero> result = exam.superheros();
        
        List<Superhero> expected= this.getListOfSuperheros();

        assertEquals(expected.size(), result.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(expected.get(i).getName().toString(), result.get(i).getName().toString());
            assertEquals(expected.get(i).getSkill().toString(), result.get(i).getSkill().toString());
            assertEquals(expected.get(i).getWeight(), result.get(i).getWeight());
        }
    }
    
    private List<Superhero> getListOfSuperheros() {
        List<Superhero> list = new ArrayList<Superhero>();
        Superhero superman = new Superhero("Superman", "Vuela", 85);
        Superhero spiderman = new Superhero("Spiderman", "Salta", 105);
        Superhero manolito = new Superhero("Manolito el fuerte", "Pega", 71);
        list.add(superman);
        list.add(spiderman);
        list.add(manolito);
        return list;
    }

}
