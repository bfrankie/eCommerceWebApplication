package com.capstone3.api.repos;


import com.capstone3.api.entities.Category;
import com.capstone3.api.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

    @Override
    Iterable<Product> findAll();

    @Override
    Optional<Product> findById(Long aLong);

    Optional<Product> findByTitle(String title);

    Optional<Product> findByCategory(Category category);

    Optional<Product> findBySerialNumber(int serialNumber);

    Optional<List<Product>> findByPrice(BigDecimal price);

    @Override
    <S extends Product> S save(S s);

    void deleteByTitle(String title);

    void deleteBySerialNumber(int serialNumber);


}
