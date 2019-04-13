package hello;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @Value("${file.path}")
    private String filepath = null;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        logger.info("path is {}", filepath);
        FileReader fr =
                null;
        try {
            fr = new FileReader(filepath);
            int i;
            while ((i=fr.read()) != -1)
                System.out.print((char) i);
        } catch (IOException e) {
            e.printStackTrace();
        }



        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
