package pub.hqs.raccoon.configs;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @program: raccoon
 * @description: open api
 * @author: hqs.pub
 * @create: 2020-09-23 18:18
 **/
@Configuration
public class OpenApiConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Raccoon管理系统接口文档")
                .description("Raccoon Api Document.")
                .contact(new Contact("song", "https://blog.hqs.pub", "admin@hqs.pub"))
                .version("1.0")
                .license("Copyright ️2020 song")
                .build();
    }
}
