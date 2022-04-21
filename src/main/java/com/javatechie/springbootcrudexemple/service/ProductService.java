package com.javatechie.springbootcrudexemple.service;


import com.javatechie.springbootcrudexemple.entity.Product;
import com.javatechie.springbootcrudexemple.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

//    Enregistrer un seul produit
    public Product saveProduct(Product product){
        return repository.save(product);
    }
//    Enregistrer plusieurs produits
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }
//    Afficher tous les produits
    public List<Product> getProducts(){
        return repository.findAll();
    }
// Afficher le produit par id
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
//    Afficher le produit par nom

    public Product getProductByName(String name){
        return repository.findByName(name);
    }
// Supprimer le produit


//    Supprimer un produit
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "the product was deleted"+id;
    }
// Mettre a jour un produit

    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuality(product.getQuality());

        return repository.save(existingProduct);

    }
}
