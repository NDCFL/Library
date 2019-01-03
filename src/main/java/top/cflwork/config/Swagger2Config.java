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

//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                //为当前包路径
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    //构建 api文档的详细信息函数
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                //页面标题
//                .title("功能测试")
//                //创建人
//                .contact(new Contact("Edison", "xxx@qq.com", "xxx@qq.com"))
//                //版本号
//                .version("1.0")
//                //描述
//                .description("API 描述")
//                .build();
//    }
    @Bean
    public Docket tApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户模块")
                .apiInfo(apiInfo())
                .select()
                .paths(markingPaths())
                .build();
    }
    private Predicate<String> markingPaths() {
        return or(
                regex("/user/.*")
        );
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("cflwork")
                .description("<h4>接口里pager对象只在查询列表时用到</h4>")
                .termsOfServiceUrl("http://springfox.io")
                .contact(new Contact("名字", "www.baidu.com", "test@163.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
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