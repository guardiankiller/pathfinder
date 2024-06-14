package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.Category;
import bg.softuni.pathfinder.model.CategoryNames;
import bg.softuni.pathfinder.model.Level;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.dto.RouteInfoDTO;
import bg.softuni.pathfinder.service.dto.RouteShortInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Controller to handle all things route relates
 */

@Controller
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
    /**
     * Method to handle the listing of all routes.
     *
     * @param model the Model for the view
     * @return the list routes view
     */

    @GetMapping("/routes")
    public String routes(Model model) {
//        RouteShortInfoDTO randomRoute = routeService.getRandomRoute();
        List<RouteShortInfoDTO> routes = routeService.getAll();

        model.addAttribute("allRoutes", routes);

        return "routes";
    }

    @GetMapping("/add-route")
    public String viewRouteAdd(Model model) {
        model.addAttribute("routeInfo", new RouteInfoDTO());
        model.addAttribute("levels", Level.values());
        model.addAttribute("categories", CategoryNames.values());

        return "add-route";
    }

    @PostMapping("/add-route")
    public String postRoute(RouteInfoDTO data) {
        routeService.addRoute(data);
        return "redirect:/";
    }
}
