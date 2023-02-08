package com.capstone3.api.repos;

import com.capstone3.api.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {

    @Override
    Iterable<Category> findAll();

    @Override
    Optional<Category> findById(Integer id);

    Optional<Category> findByCategoryName(String Name);

    @Override
    <S extends Category> S save(S s);

    @Override
    void deleteById(Integer id);

    void deleteByCategoryName(String name);
}
