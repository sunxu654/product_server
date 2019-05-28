package net.xdclass.product_server.service;

import net.xdclass.product_server.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface ProductService {

    List<Product> listProduct();

    Product getById(int id);

}
