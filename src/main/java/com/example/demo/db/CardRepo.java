package com.example.demo.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.Card;

public interface CardRepo extends JpaRepository<Card, Long> {}
