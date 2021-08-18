package com.misiontic_DW5_G5.products_ms.repos;

import com.misiontic_DW5_G5.products_ms.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
  //  List<Product> findById (String productId);


}
