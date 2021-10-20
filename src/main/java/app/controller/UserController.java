package app.controller;


import app.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

//    public UserController(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @GetMapping()
    public String index(Model model) {
    //Получим всех людей из Dao и передадим на отображение в представление
        model.addAttribute("users", userDao.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
    //Получим одного человека из Dao и передадим на отображение в представление
        model.addAttribute("user", userDao.show(id));
        return "users/show";
    }



}
