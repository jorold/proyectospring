package controllers;

import java.util.ArrayList;
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

public class Controller15MostrarEmpleados implements Controller {

    RepositoryEmpleados repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web15mostrarempleados");
        String id = hsr.getParameter("eliminar");
        if (id != null) {
            //recuperamos la lista de session
            ArrayList<String> listaids = (ArrayList<String>) hsr.getSession().getAttribute("listaids");
            listaids.remove(id);
            if (listaids.isEmpty()) {
                hsr.getSession().setAttribute("listaids", null);
            } else {
                hsr.getSession().setAttribute("listaids", listaids);
            }
        }
        //en la página vamos a dibujar los empleados no la session
        if (hsr.getSession().getAttribute("listaids") != null) {
            //recuperamos la lista de session
            ArrayList<String> listaids = (ArrayList<String>) hsr.getSession().getAttribute("listaids");
            //recuperamos el repo para los datos
            this.repo = (RepositoryEmpleados) this.getBean("repositoryempleados", hsr.getServletContext());
            List<Empleado> empleados = this.repo.getEmpleadosSession(listaids);
            mv.addObject("empleadossession", empleados);
        }
        return mv;
    }

}
