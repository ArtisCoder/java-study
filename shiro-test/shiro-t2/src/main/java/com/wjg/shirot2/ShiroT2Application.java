package com.wjg.shirot2;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.servlet.KaptchaServlet;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wjg")
public class ShiroT2Application {

    @Value("${http.port}")
    private int httpPort;

    @Value("${server.port}")
    private int serverPort;


    public static void main(String[] args) {
        SpringApplication.run(ShiroT2Application.class, args);
    }

    // 注册统一异常处理bean
//    @Bean
//    public MyExceptionResolver myExceptionResolver() {
//        return new MyExceptionResolver();
//    }

    //配置kaptcha图片验证码框架提供的Servlet
    @Bean
    public ServletRegistrationBean kaptchaServlet() {

        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new KaptchaServlet(), "/kaptcha.jpg");

        registrationBean.addInitParameter(Constants.KAPTCHA_SESSION_CONFIG_KEY,
                Constants.KAPTCHA_SESSION_KEY);
        registrationBean.addInitParameter(Constants.KAPTCHA_IMAGE_HEIGHT,"60");//高度
        registrationBean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE,"50");//字体大小
        registrationBean.addInitParameter(Constants.KAPTCHA_BORDER_THICKNESS,"1"); //边框
        registrationBean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "red"); //文字颜色

        //可以设置很多属性,具体看com.google.code.kaptcha.Constants
//      kaptcha.border  是否有边框  默认为true  我们可以自己设置yes，no
//      kaptcha.border.color   边框颜色   默认为Color.BLACK
//      kaptcha.border.thickness  边框粗细度  默认为1
//      kaptcha.producer.impl   验证码生成器  默认为DefaultKaptcha
//      kaptcha.textproducer.impl   验证码文本生成器  默认为DefaultTextCreator
//      kaptcha.textproducer.char.string   验证码文本字符内容范围  默认为abcde2345678gfynmnpwx
//      kaptcha.textproducer.char.length   验证码文本字符长度  默认为5
//      kaptcha.textproducer.font.names    验证码文本字体样式  默认为new Font("Arial", 1, fontSize), new Font("Courier", 1, fontSize)
//      kaptcha.textproducer.font.size   验证码文本字符大小  默认为40
//      kaptcha.textproducer.font.color  验证码文本字符颜色  默认为Color.BLACK
//      kaptcha.textproducer.char.space  验证码文本字符间距  默认为2
//      kaptcha.noise.impl    验证码噪点生成对象  默认为DefaultNoise
//      kaptcha.noise.color   验证码噪点颜色   默认为Color.BLACK
//      kaptcha.obscurificator.impl   验证码样式引擎  默认为WaterRipple
//      kaptcha.word.impl   验证码文本字符渲染   默认为DefaultWordRenderer
//      kaptcha.background.impl   验证码背景生成器   默认为DefaultBackground
//      kaptcha.background.clear.from   验证码背景颜色渐进   默认为Color.LIGHT_GRAY
//      kaptcha.background.clear.to   验证码背景颜色渐进   默认为Color.WHITE
//      kaptcha.image.width   验证码图片宽度  默认为200
//      kaptcha.image.height  验证码图片高度  默认为50
        return registrationBean;
    }

    /**
     * it's for set http url auto change to https
     */

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    @Bean
    public Connector httpConnector(){
        Connector connector=new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(httpPort);
        connector.setSecure(false);
        connector.setRedirectPort(serverPort);
        return connector;
    }

}
