package hh.backend.autolomakeprojekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.autolomakeprojekti.domain.Car;

@Controller
public class CarController {
    // GET /newcar, new car form
    @GetMapping("/newcar")
    public String getNewCar(Model model) {
        model.addAttribute("car", new Car());
        return "carform"; // carfrorm.html
    }

    // POST /newcar, receive data from form
    @PostMapping("/newcar")
    public String receiveNewCarData(@ModelAttribute Car car, Model model) {
        model.addAttribute("car", car);
        return "result"; // result.html
    }
}
