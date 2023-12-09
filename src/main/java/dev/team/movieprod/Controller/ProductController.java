package dev.team.movieprod.Controller;


import dev.team.movieprod.Entity.Product;
import dev.team.movieprod.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller//аннотация сообщающая Spring что данный класс является контроллером(конечной точкой нашего API)
@RequestMapping("/start")//аннотация для работы с HTTP и браузером=> набирая URI в поисковой строке,
// приложение предоставит нам представление(результаты выполнения методов, информацию, фронтенд)
public class ProductController {

    @Autowired//аннотация выполняющая автоматический монтаж Bean-объекта (см. 5.1. Аннотации Spring)
    private ProductService service;

    @GetMapping("/news_in")
    public String showPageNewsIn(){
        return "news_in";
    }
    @GetMapping("/news")
    public String showPageNews(Model model){
        List<Product> products = service.findAllProducts();
        model.addAttribute("products", products);
        return "news";
    }
    @GetMapping("/feedback_page")
    public String showPageReviews(){
        return "feedback_page";
    }




    @GetMapping//данная аннтация предоставит определенному URI определенную информацию/результат
    // который мы прописали в методе
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<List<Product>>(service.findAllProducts(), HttpStatus.OK);
    }//в данном случае мы возвращаем  список из всех имеющихся продуктов
    //ResponseEntity-некая сущность, билдер, для работы  с HTTP протоколом
    // имеет под капотом методы для возвращения статус кода(200-ОК, 404- Not Found, 401-No Authorized и тп)

    @GetMapping("/{productId}")
    public ResponseEntity<Optional<Product>> getSingleProduct(@PathVariable  String productId){
        return new ResponseEntity<Optional<Product>>(service.findByProductId(productId), HttpStatus.OK);
    }//данный метод возвращает возвращает 1 ппродукт по идентификатору
    //аннотация @PathVariable берет аргумент для метода из URI, на что мы и указываем в аннотации @GetMapping
    // "ResponseEntity<Optional<Product>>" - Optional, в данном случае некая обертка, которая регулирует работу метода
    //метод вернет продукт, только в случае если он существует

}
