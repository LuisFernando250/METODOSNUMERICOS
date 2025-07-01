package mx.edu.itses.lfuab.MetodosNumericos.web;

import ch.qos.logback.core.model.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MainController {

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("INDEX");
        return "index";
    }

}
