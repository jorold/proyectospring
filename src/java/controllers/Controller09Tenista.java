package controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Tenista;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller09Tenista implements Controller {

    private Object getBean(String id, ServletContext servlet) {
        ApplicationContext container = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object bean = container.getBean(id);
        return bean;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web09tenista");
        Tenista nadal = (Tenista) this.getBean("nadal", hsr.getServletContext());
        mv.addObject("tenistanadal", nadal);
        return mv;
    }

}
