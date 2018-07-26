package me.j360.swagger.spring;

import me.j360.swagger.spring.configuration.WebApplicationBootstrap;
import me.j360.swagger.spring.configuration.WebApplicationConfiguration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author: min_xu
 * @date: 2018/6/12 下午5:19
 * 说明：init with annotation equals with webApplication
 */
public class J360AnnotaionWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        String activeProfile = System.getProperty("spring.profiles.active");
        if (activeProfile == null) {
            activeProfile = "dev"; // or whatever you want the default to be
        }

        servletContext.setInitParameter("spring.profiles.active", activeProfile);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { WebApplicationConfiguration.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebApplicationBootstrap.class };
    }

    //dispatch servlet
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/*" };
    }

    //filters
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {
                new HiddenHttpMethodFilter(), new CharacterEncodingFilter() };
    }

}
