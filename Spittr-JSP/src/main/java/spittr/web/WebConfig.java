package spittr.web;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }
  
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // TODO Auto-generated method stub
    super.addResourceHandlers(registry);
  }
  
  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = 
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("/WEB-INF/messages");
    Properties properties = new Properties(); 
    properties.setProperty("/WEB-INF/messages", "UTF_8"); 
    messageSource.setFileEncodings(properties);
    messageSource.setCacheSeconds(10);
    return messageSource;
  }
  
  @Bean
  public MessageSource validationMessageSource() {
	  ReloadableResourceBundleMessageSource  validationMessageSource = 
        new ReloadableResourceBundleMessageSource ();
    validationMessageSource.setBasename("classpath:ValidationMessages");
    Properties properties = new Properties(); 
    properties.setProperty("classpath:ValidationMessages", "UTF_8"); 
    validationMessageSource.setFileEncodings(properties);
    validationMessageSource.setCacheSeconds(10);
    return validationMessageSource;
  }

}
