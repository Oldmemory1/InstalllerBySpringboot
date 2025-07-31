package org.example.installerbyspringboot.Controller;

import lombok.extern.java.Log;
import org.example.installerbyspringboot.Component.Utility;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Log
@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "main-page";
    }
}
