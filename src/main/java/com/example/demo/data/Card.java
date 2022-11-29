package com.example.demo.data;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// JPA annotation to make object ready for JPA based storage
@Entity
public
class Card {
    private @Id @GeneratedValue Long id;
    private String name;
    private Integer health;
    private String type;

    public Long getId()
    {
		return this.id;
	}

    public void setId(Long id)
    {
		this.id = id;
	}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return this.health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Card() {}

    public Card(String name, Integer health, String type) {
        this.name = name;
        this.health = health;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (!(o instanceof Card))
            return false;
        Card card = (Card) o;
        return Objects.equals(this.id, card.id) && 
        Objects.equals(this.name, card.name) && 
        Objects.equals(this.health, card.health) &&
        Objects.equals(this.type, card.type);
    }
}
