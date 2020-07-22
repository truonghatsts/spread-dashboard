package io.stably.spreaddashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Fenix truonghatsts@gmail.com
 */

@Controller
public class SpreadDashboardController {

    @GetMapping("/")
    public String showDashboardPage() {
        return "dashboard";
    }
}
