package net.xdclass.product_server.service.impl;

import net.xdclass.product_server.domain.Product;
import net.xdclass.product_server.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer, Product> daoMap = new HashMap<>();
    static {
        for(int i=1;i<10;i++){
            daoMap.put(i,new Product(i,"手机"+Integer.toString(i),10000+i,10));
        }
    }

    private ArrayList<Object> list;

    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = daoMap.values();
        List<Product> list = new ArrayList<>(collection);

        return list;
    }

    @Override
    public Product getById(int id) {
        return daoMap.get(id);
    }
}
