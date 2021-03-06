package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;


@Controller
public class HomeController {

    String email = "";

    @GetMapping("/")
    public String index() {

        return "login";
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

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam (value = "email") String email) throws SQLException {
        Utility.deleteUser(email);
        return "userList";
    }
    @GetMapping("/userList")
    public String userList(Model model) throws SQLException {
        ArrayList<User> uList = Utility.loadUserList();
        model.addAttribute("uList", uList);
        return "userList";
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam (value = "email") String email, Model model) throws SQLException {
        User u = Utility.loadEditUser(email);
        if (u instanceof Mentor) {
            model.addAttribute("Mentor", u);
            return "editMentor";
        }
        if (u instanceof Student) {
            model.addAttribute("student", u);
            return "editStudent";
        }
            return "redirect:/";
    }

    @PostMapping("/editStudent")
    public String editStudent(@ModelAttribute Student student)throws Exception{

        Utility.editStudent(student);
        return "redirect:/";

    }

    @PostMapping("/editMentor")
    public String editMentor(@ModelAttribute Mentor mentor) throws SQLException {
        Utility.editMentor(mentor);
        return "redirect:/";  //HEJ
    }

    @GetMapping("/menuStudent")
    public String menuStudent(){

        return "menuStudent";
    }

    @GetMapping("/menuMentor")
    public String menuMentor(){
        return "menuMentor";
    }

    @PostMapping("/login")
    public String login(@RequestParam (value = "email") String email, @RequestParam(value = "password") String password, Model model)throws SQLException{
        String [] login = Utility.login(email, password);
        this.email = login[0];
        if(login[1].equals("student")){
            return("menuStudent");
        }
        if(login[1].equals("mentor")){
            return("menuMentor");
        }
        if(login[1].equals("admin")){
            return("userList");
        }
        return"login";
    }

    @GetMapping("/studentList")
    public String studentList(Model model) throws SQLException {
        ArrayList<Mentor> mList = Utility.loadMentorList();
        model.addAttribute("mList", mList);
        return "studentList";
    }

    @GetMapping("/mentorList")
    public String mentorList(Model model) throws SQLException {
        ArrayList<User> uList = Utility.loadUserList();
        model.addAttribute("uList", uList);
        return "mentorList";
    }

    @GetMapping("/editStudent")
    public String editStudent(Model model) throws SQLException {
        User u = Utility.loadEditUser(email);
        model.addAttribute("Student", u);
        return "editStudent";
    }

    @GetMapping("/editMentor")
    public String editMentor(Model model) throws SQLException {
        User u = Utility.loadEditUser(email);
        model.addAttribute("Mentor", u);
        return "editMentor";
    }

    @GetMapping("/logOut")
    public String logOut(){
        email="";
        return "login";
    }

}



