package com.rahul.Back_end.repositry;

import com.rahul.Back_end.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productrepo extends JpaRepository<Products,Integer> {

}
