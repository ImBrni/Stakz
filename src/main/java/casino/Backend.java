package casino;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Backend {

    @GetMapping("/secret")
    public String hello() {
        return "SECRET!";
    }

}
