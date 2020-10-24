package org.hanedan.example.backendforfrontend.app.web;

import org.hanedan.example.backendforfrontend.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestOperations;

@Controller
public class BackendForFrontendController {

    @Autowired
    RestOperations restOperations;

    @GetMapping("users")
    public String getUsers(Model model) {
        String service = "/backend/api/v1/users";
        model.addAttribute("users", restOperations.getForObject(service, User[].class));
        return "users";
    }
}
