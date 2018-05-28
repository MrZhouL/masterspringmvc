package masterspringmvc;

import masterspringmvc.config.PicturesUploadProperties;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
@EnableConfigurationProperties({PicturesUploadProperties.class})
public class MasterspringmvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(MasterspringmvcApplication.class, args);
    }


    /**
     * tomcatEmbedded这段代码是为了解决，上传文件大于10M出现连接重置的问题。此异常内容GlobalException也捕获不到。
     * 详细查看
     * http://www.mkyong.com/spring/spring-file-upload-and-connection-reset-issue/
     * @return
     */
    /*@Bean
    public TomcatServletWebServerFactory tomcatEmbedded(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

        factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector->{
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)){
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });

        return factory;
    }*/

}
