package hh.backend.autoprojekti.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.backend.autoprojekti.domain.Car;

@Controller
public class AutoController {

    // https://localhost:8080/allcars

    @GetMapping("/allcars")
    public String getAllCars(Model model) {

        // ei vielä osata hakea tietokannasta autoja
        // luodaan autolista lennosta ja välitetään se thymeleaf templaten näkyville
        List<Car> cars = new ArrayList<Car>(); // tyhjä lista
        cars.add(new Car("Tesla", 2023));
        cars.add(new Car("Lada", 2023));

        model.addAttribute("cars", cars);
        return "carlist"; // carlist.html
    }

}