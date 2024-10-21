package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // В этом интерфейсе можно оставить базовые методы JpaRepository
    // Дополнительные методы можно добавлять при необходимости
}
