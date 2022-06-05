package lt.viko.eif.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * This class configures front-end
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final String developmentOrigin = "http://localhost:3000";
    private final String productionOrigin = "https://saityno-projektas-front-end.vercel.app";

    /**
     * //todo
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins(developmentOrigin, productionOrigin)
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
