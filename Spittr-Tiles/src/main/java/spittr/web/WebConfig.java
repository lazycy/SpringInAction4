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
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {
  
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // TODO Auto-generated method stub
    super.addResourceHandlers(registry);
  }
  
  
  //Tiles
  @Bean
  public TilesConfigurer tilesConfigurer() {
	  TilesConfigurer tiles = new TilesConfigurer();
	  tiles.setDefinitions(new String[] {
			  "/WEB-INF/layout/tiles.xml"
	  });
	  
	  return tiles;
  }

  @Bean
  public ViewResolver viewResolver() {
    return new TilesViewResolver();
  }
  
  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = 
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("/WEB-INF/messages");
    Properties properties = new Properties(); 
    properties.setProperty("/WEB-INF/messages", "UTF-8"); 
    messageSource.setFileEncodings(properties);
    messageSource.setCacheSeconds(10);
    return messageSource;
  }
  
  @Bean
  public MessageSource validationMessageSource() {
    ResourceBundleMessageSource validationMessageSource = 
        new ResourceBundleMessageSource();
    validationMessageSource.setBasename("classpath:ValidationMessages");
    validationMessageSource.setDefaultEncoding("UTF-8");
    validationMessageSource.setCacheSeconds(10);
    return validationMessageSource;
  }

}
