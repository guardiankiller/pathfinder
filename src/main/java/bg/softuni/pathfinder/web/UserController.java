package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.web.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("users")
public class UserController {

    @GetMapping("/register")
    public String viewRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegisterDTO data,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes
    ) {

        //BindingResult for hangling error or without it, 404 error
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData", data);

            // handle errors
            return "register";
        }

        //register user
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String viewLogin() {
        return "login";
    }
}
