package com.springboottsk3.task31;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService pService;

    @Autowired
    public ProductController(ProductService pService) {
        this.pService = pService;
    }

    @GetMapping
    public List<Product> findAll(){
        return pService.GetAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable String id) throws ProductNotFoundException{
        return pService.findProduct(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void add(@RequestBody Product prod){
        pService.AddProduct(prod);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Product product, @PathVariable String id) throws ProductNotFoundException{
        pService.updateProduct(id,product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws ProductNotFoundException{
        pService.deleteProduct(id);
    }
}
