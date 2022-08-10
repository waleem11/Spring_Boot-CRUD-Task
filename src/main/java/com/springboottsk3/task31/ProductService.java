package com.springboottsk3.task31;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;


    public List<Product> GetAllProducts(){
          List<Product>  plist = new ArrayList<>();
          productRepo.findAll().forEach(plist::add);
          return plist;
    }

    public void AddProduct(Product product){
        productRepo.save(product);
    }

    public Optional<Product> findProduct(String id) throws ProductNotFoundException{
        try{
        return productRepo.findById(id);}
        catch(EntityNotFoundException e){
            throw new ProductNotFoundException();
        }
    }

    public void updateProduct(String id, Product prod) throws ProductNotFoundException {
        try{
        productRepo.save(prod);}
        catch (EntityNotFoundException e){
            throw new ProductNotFoundException();
        }
    }

    public void deleteProduct(String id) throws ProductNotFoundException {
        try{
        productRepo.deleteById(id);}
        catch (EntityNotFoundException e){
            throw new ProductNotFoundException();
        }
    }


}
