package com.startup_app;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.startup_app.domain.User;
import com.startup_app.model.UserDTO;
import com.startup_app.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

    @GetMapping("/greeting")
    public String index() {
        return "Hello Rafaaaa!";
    }

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/1")
    public String testFunction(@PathVariable long id, Model model) {
        //model.addAttribute("name", name);


        return "index";
    }

    @GetMapping("/gene")
    public String gene(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "nav";

//    @GetMapping("/{id}")
//    @ResponseBody
//    public String index(@PathVariable int id, Model model) {
//        return "Hello World!";
//    }

//    private UserDTO getLinkedinByIdFromDatabase(int id){
//        System.out.println("get linkedin name from database...");
//        Optional<User> findById = UserRepository.findById(id);
//        return findById.isPresent() ? mapToTaskDTO(findById.get()) : null;
//    }

    }
}
