package us.kulba.directory.web.config;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import us.kulba.directory.config.appconfig.ApplicationConfig;

import javax.servlet.Filter;

public class DirectoryWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { ApplicationConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new DelegatingFilterProxy("springSecurityFilterChain")
//                new OpenEntityManagerInViewFilter()
        };
    }


//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(ApplicationConfig.class, WebMvcConfig.class);
//
//        Dynamic dynamc = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(context));
//        dynamc.addMapping("/*");
//        dynamc.setLoadOnStartup(1);
//    }


}
