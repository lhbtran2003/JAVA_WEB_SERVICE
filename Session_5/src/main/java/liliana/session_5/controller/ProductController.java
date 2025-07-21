package liliana.session_5.controller;

import liliana.session_5.entity.Product;
import liliana.session_5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE })
    public List<Product> showProduct() {
        return productService.getAllProducts();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public String showProductXML() {
        return null;
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @PutMapping("/edit/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable long id) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id);
    }
}
