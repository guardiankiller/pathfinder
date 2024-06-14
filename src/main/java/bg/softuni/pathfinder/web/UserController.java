package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.Level;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.web.dto.UserLoginDTO;
import bg.softuni.pathfinder.web.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String viewRegister(Model model) {
        model.addAttribute("registerData", new UserRegisterDTO());
        model.addAttribute("levels", Level.values());

        return "/register";
    }

    @PostMapping("/register")
    public String doRegister(
            @Valid UserRegisterDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {

        //BindingResult for hangling error or without it, 404 error
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.UserRegisterDTO", bindingResult);

            // handle errors
            return "redirect:/users/register";
        }

        userService.registerUser(data);

        //register user
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String viewLogin(Model model) {
        model.addAttribute("loginData", new UserLoginDTO());
        return "login";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO loginData) {
        userService.loginUser(loginData);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout() {
        userService.logoutUser();

        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("profileData", userService.getProfileData());

        return "profile";
    }
}
