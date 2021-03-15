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

public class Controller15AlmacenarEmpleados implements Controller {

    RepositoryEmpleados repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web15almacenarempleados");
        String dato = hsr.getParameter("id");
        if (dato != null) {
            int id = Integer.parseInt(dato);
            ArrayList<String> listaids;
            if (hsr.getSession().getAttribute("listaids") != null) {
                listaids = (ArrayList<String>) hsr.getSession().getAttribute("listaids");
            } else {
                listaids = new ArrayList<>();
            }
            //aquí preguntamos si se ha pulsado ya sobre un empleado
            if (listaids.contains(dato)) {
                //exite
                mv.addObject("mensaje", "El empleado " + dato + " ya existe en session");
            } else {
                listaids.add(dato);
                //almacenamos los ids en session
                hsr.getSession().setAttribute("listaids", listaids);
                int almacenados = listaids.size();
                mv.addObject("almacenados", almacenados);
            }
        }
        this.repo = (RepositoryEmpleados) this.getBean("repositoryempleados", hsr.getServletContext());
        List<Empleado> empleados = this.repo.getEmpleados();
        mv.addObject("empleados", empleados);
        return mv;
    }
}
