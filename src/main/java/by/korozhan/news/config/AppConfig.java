package by.korozhan.news.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = {
        "by.korozhan.news.service",
        "by.korozhan.news.service.implement"
})
@Import({MongoConfig.class})
public class AppConfig {

}
