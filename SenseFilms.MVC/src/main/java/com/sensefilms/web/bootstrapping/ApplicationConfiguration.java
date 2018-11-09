package com.sensefilms.web.bootstrapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.sensefilms.core.utilities.ITransformUtility;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sensefilms")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter
{
	@Autowired
	private ITransformUtility mapperUtility;
	
	@Bean
	public ViewResolver viewResolver() 
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() 
	{
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		
		return messageSource;
	}
	
	@Bean
	public void registerMappings() 
	{
		mapperUtility.registerDefinedMappings();
	}
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) 
    {
        // Static resources from WEB-INF
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
