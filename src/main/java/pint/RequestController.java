package pint;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    /*private static final String template = "Hello, %s!";*/
    private final AtomicLong counter = new AtomicLong();

    /*@RequestMapping("/user")
    public User user(@RequestParam(value="username", defaultValue="team4") String username, @RequestParam(value="email", defaultValue="clarke@fiu.edu") String email) {
        return new User(counter.incrementAndGet(),
                            username, email);
    }*/

    @RequestMapping("/blooddrives")
    public BloodDrive[] blooddrives(@RequestParam(value="userId", defaultValue="0") long userId,
    								@RequestParam(value="hospitalId", defaultValue="0") long hospitalId) {
    	BloodDrive[] blooddrives = new BloodDrive[1];

    	if(hospitalId > 0) {
    		BloodDrive hospitalBD = new BloodDrive(counter.incrementAndGet(), "FIU BBC Blood Drive", "Whatever", 0, 0, "hello", 0);
    		blooddrives[0] = hospitalBD;
    	} else {
    		BloodDrive donorBD = new BloodDrive(counter.incrementAndGet(), "FIU MMC Blood Drive", "Whatever", 0, 0, "hello", 0);
    		blooddrives[0] = donorBD;
    	}

    	return blooddrives;
    }
}