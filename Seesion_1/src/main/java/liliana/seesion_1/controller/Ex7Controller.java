package liliana.seesion_1.controller;

import liliana.seesion_1.entity.ex1.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class Ex7Controller {
    @GetMapping("/add")
    public String addProduct() {
        return "";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        return "";
    }

    @GetMapping
    public String listProducts() {
        return "";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable int id) {
        return "";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(Product product, @PathVariable int id) {
        return "";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return "";
    }
}
