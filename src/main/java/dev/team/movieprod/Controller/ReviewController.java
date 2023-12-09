package dev.team.movieprod.Controller;


import dev.team.movieprod.Entity.Review;
import dev.team.movieprod.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller//аннотация сообщающая Spring что данный класс является контроллером(конечной точкой нашего API)
@RequestMapping("/start/feedback_page")//аннотация для работы с HTTP и браузером=> набирая URI в поисковой строке,
// приложение предоставит нам представление(результаты выполнения методов, информацию, фронтенд)
public class ReviewController {
    @Autowired //Аннотация выполняющая автоматический монтаж Bean-объекта (см. 5.1. Аннотации Spring)
    private ReviewService service;


    @PostMapping()
    //@ResponseBody
    public String createReview(
            @RequestParam String userName,
            @RequestParam String reviewBody,
            @RequestParam String mark,
            @RequestParam String productId) {
        service.createReview(userName, reviewBody, mark, productId);
        return "feedback_page";
    }






//    @PostMapping()//данная аннотация получает данные по определенному URI, используя логику нашего метода
//    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) { //как мы и говорили в описании репозитория,
//        // на вход метод принимает структуру Map, в формате ключ-значение, что очень удобно, тк данные в бд хранятся в формате JSON=> ключ-значение
//
//        return new ResponseEntity<Review>(service.createReview(payload.get("userName"),payload.get("reviewBody"),payload.get("mark"),payload.get("productId")), HttpStatus.OK);
//    }
}
