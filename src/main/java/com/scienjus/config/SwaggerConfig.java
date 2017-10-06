package com.scienjus.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

/**
 * swagger-ui的配置
 *
 * @author ScienJus
 * @date 2017/10/06
 */
@Configuration
@EnableSwagger
public class SwaggerConfig {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        /* 对于不想显示的项目直接使用null作为参数即可 */
        final String title = "基于SpringBoot的RESTful权限验证示例Api";
        final String description = "案例中包括:<br />无权限验证的/test,<br />有权限验证的/tockens,<br />以及SpringBoot框架自带的/error";
        final String termsOfServiceUrl = "这里一般是公司主页";
        final String contact = "273221594@qq.com";
        final String license = "许可证类型";
        final String licenseUrl = "许可证链接";
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(new ApiInfo(title,
                        description,
                        termsOfServiceUrl,
                        contact,
                        license,
                        licenseUrl)).
                        /* 将Timestamp类型全部转为Long类型 */
                        directModelSubstitute(Timestamp.class, Long.class);
    }

}
