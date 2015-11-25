package binblee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class EdgeServer {

    public static void main(String[] args) {
        SpringApplication.run(EdgeServer.class, args);
    }
}
