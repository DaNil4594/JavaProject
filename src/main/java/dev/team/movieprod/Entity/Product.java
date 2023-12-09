package dev.team.movieprod.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "products") //аннотация позволяющая подключится к БД и именовать коллекцию
@Data // аннотация позволяющая использовать геттеры и сеттеры не указывая их явно
@AllArgsConstructor // аннотация позволяющая использовать конструктор со всеми параметрами, без явного его указания
@NoArgsConstructor // аннотация позволяющая использовать конструктор без параметров, без явного его указания
public class Product { //название класса
    @Id // аннотация маркирующая наше поле id, автогенерацией дял бд
    private ObjectId id;
    private String title;//название продукта
    @DocumentReference // аннотация позваляющая работать с другой коллекцией в бд.
    // В данном случае создает список объектов Review, работающих с другой коллекцией
    private List<Review> reviews;
    private String productId;// id нашего продукта

    public Product(String title,String productId) { // наш конструктор с 2мя аргументами
        this.title = title;
        this.productId = productId;

    }
}
