package com.assesment.recipeapp.demo.repository;

import com.assesment.recipeapp.demo.model.Ingredients;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientsRepository extends CrudRepository<Ingredients,Long> {
    List<Ingredients> findAllByOrderByName();
}
