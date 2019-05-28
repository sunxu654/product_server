package net.xdclass.product_server.controller;

import net.xdclass.product_server.domain.Product;
import net.xdclass.product_server.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private ProductService productService;

    /**
     * 获取商品应用列表
     *
     * @return
     */
    @RequestMapping("list")
    public Object list() {
        return productService.listProduct();
    }

    /**
     * 根据id查询商品
     *
     * @param id
     * @return
     */
    @RequestMapping("find")
    public Object find(@RequestParam int id) {
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Product product = productService.getById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product, result);
        result.setName(result.getName() + "data from" + port);
        return result;
    }
}
