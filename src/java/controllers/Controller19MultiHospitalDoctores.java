package controllers;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Doctor;
import models.Hospital;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import repositories.RepositoryMultiHospitalDoctores;

public class Controller19MultiHospitalDoctores extends MultiActionController {

    RepositoryMultiHospitalDoctores repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    public ModelAndView start(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ModelAndView mv = new ModelAndView("web19multihospitaldoctores");
        this.repo = (RepositoryMultiHospitalDoctores) this.getBean("repositorymultihospitaldoctores", request.getServletContext());
        List<Hospital> hospitales = this.repo.getHospitales();
        mv.addObject("hospitales", hospitales);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView recuperarDoctores(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ModelAndView mv = new ModelAndView("web19multihospitaldoctores");
        String dato = request.getParameter("idhospital");
        int id = Integer.parseInt(dato);
        this.repo = (RepositoryMultiHospitalDoctores) this.getBean("repositorymultihospitaldoctores", request.getServletContext());
        List<Hospital> hospitales = this.repo.getHospitales();
        mv.addObject("hospitales", hospitales);
        List<Doctor> doctores = this.repo.getDoctorHospital(id);
        mv.addObject("doctores", doctores);
        return mv;
    }
}
