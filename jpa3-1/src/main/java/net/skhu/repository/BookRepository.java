package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
