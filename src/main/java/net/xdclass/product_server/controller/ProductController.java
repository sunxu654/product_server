package net.xdclass.product_server.controller;

import net.xdclass.product_server.domain.Product;
import net.xdclass.product_server.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
@RefreshScope   //对动态刷新的类,才需要加此注解;用于当配置文件内某些变量改变时,可以动态加载  比如下面的"env"
public class ProductController {
    @Value("${server.port}")
    private String port;

    @Value("${env}")
    private String env;

    @Autowired
    private ProductService productService;

    /**
     * 获取商品应用列表
     *
     * @return
     */
    @RequestMapping("list")
    public Object list() {
        System.out.println(env);
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
