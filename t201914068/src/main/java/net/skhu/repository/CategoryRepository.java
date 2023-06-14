package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer> {

}
