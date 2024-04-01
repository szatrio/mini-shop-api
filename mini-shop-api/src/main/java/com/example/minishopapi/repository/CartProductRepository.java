package com.example.minishopapi.repository;

import com.example.minishopapi.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, String> {

    List<CartProduct> findAllByCart_Id(String s);
}
