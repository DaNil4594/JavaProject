package dev.team.movieprod.Service;


import dev.team.movieprod.Entity.Product;
import dev.team.movieprod.Entity.Review;
import dev.team.movieprod.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service//аннотируем наш класс сервисом
//сервис - промежуточный уровень API использующий методы репозитория в удобном нам формате,
// для предоставления данных и функционала нашим эндпоинтам - контроллерам
public class ReviewService {
    @Autowired//аннотация выполняющая автоматический монтаж Bean-объекта (см. 5.1. Аннотации Spring)
    private ReviewRepository repository;

    @Autowired//аннотация выполняющая автоматический монтаж Bean-объекта (см. 5.1. Аннотации Spring)
    private MongoTemplate mongoTemplate;//это объект позволяющий работать с бд в сервисе

    public Review createReview(String userName, String reviewBody,String mark, String productId) {//метод создания отзыва
        Review review = repository.insert(new Review(userName,reviewBody,mark, LocalDateTime.now(), LocalDateTime.now()));

        mongoTemplate.update(Product.class)
                .matching(Criteria.where("productId").is(productId))
                .apply(new Update().push("reviews").value(review))
                .first();//через наш бин проверяем соответствие идентификаторов(строка 29)
            //заполняем тело отзыва и сохраняем(строки 30-31)

        return review;
    }
}