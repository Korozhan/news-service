package by.korozhan.news.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(value = {
        "by.korozhan.news.service",
        "by.korozhan.news.service.implement"
})
@Import({MongoConfig.class})
public class AppConfig {
    @Bean
    public PropertyPlaceholderConfigurer preferencesPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocations(new ClassPathResource("application.properties"));
        return configurer;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
