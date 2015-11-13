package pint;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/user")
    public User user(@RequestParam(value="username", defaultValue="team4") String username, @RequestParam(value="email", defaultValue="clarke@fiu.edu") String email) {
        return new User(counter.incrementAndGet(),
                            username, email);
    }
}
