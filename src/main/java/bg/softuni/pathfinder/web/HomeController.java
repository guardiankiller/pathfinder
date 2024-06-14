package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

/**
 * Controller handling the info pages - home, about, contact
 */

@Controller
public class HomeController {

//        @GetMapping("/")
//        public ModelAndView index() {
//            double sofiaTemp = new Random().nextDouble();
//          ModelAndView mnv = new ModelAndView();
//          mnv.setViewName("index");
//          mnv.addObject("sofiaTemperature", sofiaTemp);
//
//          return mnv;

    @GetMapping("/")
    public String index(Model model) {
        double sofiaTemp = new Random().nextDouble();
        model.addAttribute("sofiaTemperature", sofiaTemp);

        return "index";
    }

    @GetMapping("/about")
    public String about() {

        return "about";
    }

}
