package binblee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookReviewApplication.class, args);
    }
}
