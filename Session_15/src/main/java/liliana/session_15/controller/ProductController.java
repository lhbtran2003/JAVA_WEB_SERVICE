package liliana.session_15.controller;

import liliana.session_15.entity.Product;
import liliana.session_15.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/movies")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/admin/movies")
    public ResponseEntity<Product> createProduct(@RequestBody Product movie){
        return new ResponseEntity<>(productService.addProduct(movie), HttpStatus.OK);
    }

    @PutMapping("/admin/movies/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product movie) throws Exception{
        return new ResponseEntity<>(productService.updateProduct(id,movie), HttpStatus.OK);
    }

    @DeleteMapping("/admin/movies/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
