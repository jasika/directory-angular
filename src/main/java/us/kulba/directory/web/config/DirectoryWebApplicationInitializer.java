package us.kulba.directory.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletRegistration.Dynamic;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class DirectoryWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ApplicationConfig.class, WebMvcConfig.class);

        Dynamic dynamc = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(context));
        dynamc.addMapping("/*");
        dynamc.setLoadOnStartup(1);
    }


}
