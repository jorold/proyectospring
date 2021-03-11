package controllers;

import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Hospital;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryHospitalV2;

public class Controller11HospitalesV2 implements Controller {

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web11hospitalesv2");
        RepositoryHospitalV2 repo = (RepositoryHospitalV2) this.getBean("repositoryhospitalv2", hsr.getServletContext());
        DriverManagerDataSource datasource = (DriverManagerDataSource) this.getBean("dataSourceOracle", hsr.getServletContext());
        ArrayList<Hospital> hospital = repo.getHospital();
        if (hospital != null) {
            mv.addObject("hospitalv2", hospital);
        }
        return mv;
    }

}
