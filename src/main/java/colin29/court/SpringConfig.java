package colin29.court;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import colin29.court.service.ReservationService;
import colin29.court.service.ReservationServiceImpl;

@Configuration
@ComponentScan(basePackages = "colin29.court.controllers") // will scan this directory for components (for us,
															// @Controllers)
public class SpringConfig extends WebMvcConfigurationSupport {

	Logger logger = LoggerFactory.getLogger(SpringConfig.class);

	/* Mapping to Controllers */
	@Bean
	public RequestMappingHandlerMapping myMapping() {
		return new RequestMappingHandlerMapping();
	}

	@Bean
	@Override
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping m = super.requestMappingHandlerMapping();
		m.setUseSuffixPatternMatch(false);
		m.setUseTrailingSlashMatch(true);
		return m;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// ViewControllerRegistration r = registry.addViewController("/");
	}

	/* Mapping to Static resources */

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.debug("spring config");
		registry.addResourceHandler("/**")
				.addResourceLocations("/");
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}

	/* View Resolving */

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

	// ============================================================================

	/* Service Bean Definitions */

	@Bean
	public ReservationService reservationService() {
		return new ReservationServiceImpl();
	}

}
