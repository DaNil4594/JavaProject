package dev.team.movieprod.Service;



import dev.team.movieprod.Entity.Product;
import dev.team.movieprod.Repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//аннотируем наш класс сервисом
//сервис - промежуточный уровень API использующий методы репозитория в удобном нам формате,
// для предоставления данных и функционала нашим эндпоинтам - контроллерам
public class ProductService {

    @Autowired//аннотация выполняющая автоматический монтаж Bean-объекта (см. 5.1. Аннотации Spring)
    private ProductRepository repository;

    public List<Product> findAllProducts() {
        return repository.findAll();
    }// метод возвращающий все продукты


    public Optional<Product> findByProductId(String productId){
        return  repository.findByProductId(productId);
    }
//метод возвращающий 1 продукт по определенному идентифиикатору
}
