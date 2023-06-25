package com.gl.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.Library.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}



