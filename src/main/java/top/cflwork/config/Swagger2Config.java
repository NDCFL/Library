package top.cflwork.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * ${DESCRIPTION}
 *
 * @author edison
 * @create 2017-01-02 23:53
 */
@EnableSwagger2
@Configuration
@ComponentScan("top.cflwork.controller")
public class Swagger2Config {

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户模块")
                .apiInfo(apiInfo())
                .select()
                .paths(userPaths())
                .build();
    }
    private Predicate<String> userPaths() {
        return or(
                regex("/user/.*")
        );
    }
    @Bean
    public Docket loginApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("读者登录模块")
                .apiInfo(apiInfo())
                .select()
                .paths(loginPaths())
                .build();
    }
    private Predicate<String> loginPaths() {
        return or(
                regex("/readUser/login.*")
        );
    }

    @Bean
    public Docket bookSearchApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("图书检索和新书通报模块")
                .apiInfo(apiInfo())
                .select()
                .paths(bookSearchPaths())
                .build();
    }
    private Predicate<String> bookSearchPaths() {
        return or(
                regex("/metatable/.*")
        );
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("cflwork")
                .description("<h4>接口里pager对象只在查询列表时用到,图片，文件等需要加上前缀http://file.mykefang.com</h4>")
                .termsOfServiceUrl("http://springfox.io")
                .contact(new Contact("名字", "www.baidu.com", "test@163.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("http://file.mykefang.com")
                .version("1.0")
                .build();
    }

    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("77777").parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        return pars;
    }
}