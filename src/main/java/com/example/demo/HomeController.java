package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class HomeController {
}

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
/*
@PostMapping("/createStudent")
    public String createStudent(@ModelAttribute Student student){
        Utility u = Utility.getInstance();
        u.createConnection();
        u.createStudent()

    }

    @GetMapping("/createStudent")
    public String createStudent(Model model){
        model.addAttribute("Student", new Student());
        return "OpretStud";

    }
*/