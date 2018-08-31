package ru.csc.java.networking.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/session/", method = RequestMethod.GET, produces = "text/html")
public class SessionController {

	@RequestMapping
	@ResponseBody
    public String session(HttpSession session) {
		Object time = session.getAttribute("time");
		if (time == null) {
			time = LocalDateTime.now();
			session.setAttribute("time", time);
		}
		return "<p>" + time + "</p>";
	}

}
