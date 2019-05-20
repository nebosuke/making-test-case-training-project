package com.kanjinumbers;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("kanjinumbers")
                .select()
                .paths(paths())
                .build()
                .apiInfo(makeApiInfo());
    }

    private Predicate<String> paths() {
        return Predicates.or( //
                Predicates.containsPattern("/v1/kanji2number"), //
                Predicates.containsPattern("/v1/number2kanji"));
    }

    private ApiInfo makeApiInfo() {
        return new ApiInfo("Number to Kanji converter service", // title
                "Let's enjoy testing.", // description
                "v1", // version
                "", // terms of service url
                new Contact("DreamArts", "https://www.dreamarts.co.jp", "kensuke[at]dreamarts.co.jp"), //
                "", // license
                "", // license url
                Collections.emptyList());
    }
}
