/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: WebConfiguration
 * Author:   zhoulei
 * Date:     2018/5/14 下午1:00
 * Description: web配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.config;

import masterspringmvc.date.LocalDateFormatter;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.time.LocalDate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈web配置类〉
 *
 * @author zhoulei
 * @create 2018/5/14
 * @since 1.0.0
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * 自定义格式化注册
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDate.class,new LocalDateFormatter());
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new SessionLocaleResolver();
    }

    /**
     * 国际化加载拦截 区域信息
     * @return
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

   /* public EmbeddedWebServerFactoryCustomizerAutoConfiguration configurationCustomizer(){
        return null;
    }*/

    //Spring i18n 将这些消息转换为适当的错误消息。
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource resourceBundle = new ReloadableResourceBundleMessageSource();

        resourceBundle.setBasename("classpath:messages");
        resourceBundle.setDefaultEncoding("UTF-8");
        return resourceBundle;
    }



}
