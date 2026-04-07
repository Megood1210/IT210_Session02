package hello.world.session2.Bai5.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() { return null; }
    protected Class<?>[] getServletConfigClasses() { return new Class[] { WebConfig.class }; }
    protected String[] getServletMappings() { return new String[] { "/" }; }
}
