package com.tsl.repository;

import com.tsl.model.Book;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DBRepository implements PanacheRepository<Book>{

}
