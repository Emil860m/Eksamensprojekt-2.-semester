package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;


@Controller
public class HomeController {


/*  Tilføjer bare skelettet til Menu forsiden for både Mentor og Student
    @GetMapping("/createTime")  - KUN MENTOR
    public String Menu(Model model) {
        //model.addAttribute("", );
        return "Menu";
    }

    @GetMapping("/bookTime") - STUDENT
    public String editInformation(Model model) {
        model.addAttribute("", );
        return "bookTime";
    }

    @GetMapping("/editInformation") - STUDENT + MENTOR
    public String editInformation(Model model) {
        model.addAttribute("", );
        return "editInformation";
    }

    @GetMapping("/viewUsers") - STUDENT + MENTOR men med forskellig information i postmapping
    public String viewUsers(Model model) {
        model.addAttribute("", );
        return "viewUsers";
    }




 */
@GetMapping("/")
    public String index() {

        return "index";
    }
    @GetMapping("/createStudent")
        public String createStudent(Model model){
        model.addAttribute("Student", new Student());
        return "createStudent";

}

    @PostMapping("/createStudent")
    public String createStudent(@ModelAttribute Student student) throws SQLException {
        Utility.saveUser(student);
        return "redirect:/";
        }

    @GetMapping("/createMentor")
    public String createMentor(Model model){
        model.addAttribute("Mentor", new Mentor());
        return "createMentor";

    }

    @PostMapping("/createMentor")
    public String createMentor(@ModelAttribute Mentor mentor) throws SQLException {
        Utility.saveUser(mentor);
        return "redirect:/";
    }

}