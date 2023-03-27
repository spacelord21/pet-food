package ru.spacelord.petfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.spacelord.petfood.dto.AdminDTO;
import ru.spacelord.petfood.services.FeedbackService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://91cb-194-106-194-81.eu.ngrok.io"})
@RequestMapping("/api/v1/admin")
public class AdminController {


    @Value("${admin.login}")
    private String login;
    @Value("${admin.password}")
    private String password;

    @PostMapping()
    public boolean givePermission(@RequestBody AdminDTO adminDTO) {
        return adminDTO.getLogin().equals(login) && adminDTO.getPassword().equals(password);
    }
}
