package dev.team.movieprod.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews") //аннотация позволяющая подключится к БД и именовать коллекцию
@Data// аннотация позволяющая использовать геттеры и сеттеры не указывая их явно
@AllArgsConstructor // аннотация позволяющая использовать конструктор со всеми параметрами, без явного его указания
@NoArgsConstructor // аннотация позволяющая использовать конструктор без параметров, без явного его указания
public class Review {
    private ObjectId id; // аннотация маркирующая наше поле id, автогенерацией дял бд
    private String userName;// Имя нашего пользователя
    private String body;// Текст отзыва
    private String mark; // оценка продукта в отзыве
    private LocalDateTime created; //время создания
    private LocalDateTime updated;//время обновления


    // наш конструктор
    public Review(String userName, String body,String mark, LocalDateTime created, LocalDateTime updated) {

        this.userName = userName;
        this.body = body;
        this.mark = mark;
        this.created = created;
        this.updated = updated;
    }
}