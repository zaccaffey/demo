package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Card;
import com.example.demo.db.CardRepo;

@RestController
public class CardController {

    private final CardRepo repository;
    
    public CardController(CardRepo repository) {
        this.repository = repository;
    }

    // GET
    @GetMapping("/pokemon")
    List<Card> all() {
        return repository.findAll();
    }

    // POST
    @PostMapping("/pokemon")
    void add(@RequestBody Card pokemon) {
        repository.save(pokemon);
    }

    // PUT
    @PutMapping("/pokemon/{id}")
    void edit(@RequestBody Card pokemon, @PathVariable Long id) {
        Card updatedCard = repository.findById(id)
            .map(card -> {
                card.setName(pokemon.getName());
                card.setHealth(pokemon.getHealth());
                card.setType(pokemon.getType());
                return repository.save(card);
            })
            .orElseGet(() -> {
                pokemon.setId(id);
                return repository.save(pokemon);
              });

    }

    // DELETE
    @DeleteMapping("/pokemon/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
