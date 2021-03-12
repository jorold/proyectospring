package controllers;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Empleado;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryEmpleados;

public class Controller14AlmacenarSalario implements Controller {

    RepositoryEmpleados repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web14almacenarsalario");
        String dato = hsr.getParameter("salario");
        if (dato != null) {
            int salario = Integer.parseInt(dato);
            int sumasalarial = 0;
            //hay que preguntar si existe algo en session
            if (hsr.getSession().getAttribute("sumasalarial") != null) {
                //recuperamos la suma salarial
                sumasalarial = (int) hsr.getSession().getAttribute("sumasalarial");
            }
            sumasalarial += salario;
            //almacenamos los datos en session
            hsr.getSession().setAttribute("sumasalarial", sumasalarial);
            mv.addObject("salario", salario);
        }
        this.repo = (RepositoryEmpleados) this.getBean("repositoryempleados", hsr.getServletContext());
        List<Empleado> empleados = this.repo.getEmpleados();
        mv.addObject("empleados", empleados);
        return mv;
    }

}
