package lt.viko.eif.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final String developmentOrigin = "http://localhost:3000";
    private final String productionOrigin = "https://saityno-projektas-front-end.vercel.app";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedOrigins(developmentOrigin, productionOrigin)
                .allowCredentials(true);
    }
}
