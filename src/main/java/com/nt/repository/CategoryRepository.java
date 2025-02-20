package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category> findByIsActiveTrue();

	Optional<Category> findByIdAndIsDeleteFalse(Integer id);

	List<Category> findByIsDeleteFalse();

	List<Category> findByIsActiveTrueAndIsDeleteFalse();




}
