package ru.fcpsr.yandexballoonproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.fcpsr.yandexballoonproject.components.DataBase;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final DataBase dataBase;

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("schools", dataBase.getSchools());
        return "main";
    }
}
