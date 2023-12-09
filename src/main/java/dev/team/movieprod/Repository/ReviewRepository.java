package dev.team.movieprod.Repository;

import dev.team.movieprod.Entity.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository//аннотация дающая понять Spring, что данный класс является репозиторием
//и реализует CRUD (создание, получение/поиск по определенному параметру, обновление, удаление)
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {//наш класс наследуется от MongoRepository
    //"MongoRepository<Product, ObjectId>" такая форма наследования (с параметризацией), говорит о том, что методы
    // предоставляемые нам, на входной аргумент будут принимать структуру Map<> в указанном нами формате
    //также, помимо CRUD методов, MongoRepository предоставляет методы вставки, поиска и сохранения сущностей

}
