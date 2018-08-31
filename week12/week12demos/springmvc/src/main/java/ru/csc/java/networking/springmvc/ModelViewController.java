package ru.csc.java.networking.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/mvc/", method = RequestMethod.GET, produces = "text/html")
public class ModelViewController {

    @RequestMapping
    public ModelAndView mvc() {
        Map<String, Object> model = new LinkedHashMap<>();
        model.put("foo", LocalDateTime.now());
        return new ModelAndView("view", model);
    }
}
