package controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Departamento;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryPaginarDepartamentos;

public class Controller20PaginarDepartamentos implements Controller {

    RepositoryPaginarDepartamentos repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web20paginardepartamentos");
        this.repo = (RepositoryPaginarDepartamentos) this.getBean("repositorypaginardepartamentos", hsr.getServletContext());
        //vamos a recuperar la posición del departamento que nos manden desde la página
        String dato = hsr.getParameter("posicion");
        //al no estar en multiaction hay que preguntar si existe parámetro
        //al iniciar la página mostramos un departamento que será el primero
        int posicion = 1;
        if (dato != null) {
            posicion = Integer.parseInt(dato);
        }
        //recuperaremos un departamento a partir de la posición
        Departamento departamento = this.repo.getDepartamento(posicion);
        //recuperamos el valor del último depués de la consulta
        //porque dentro de la consulta es donde se guardan el número de registros
        int ultimo = this.repo.getNumeroRegistros();
        mv.addObject("ultimo", ultimo);
        int siguiente = posicion + 1;
        //comprobamos que no nos pasamos del último
        if (siguiente > ultimo) {
            siguiente = ultimo;
        }
        mv.addObject("siguiente", siguiente);
        int anterior = posicion - 1;
        //comprobamos que no nos pasamos del primero hacia atrás
        if (anterior < 1) {
            anterior = 1;
        }
        mv.addObject("anterior", anterior);
        //añadir el departamento a la vista
        mv.addObject("departamento", departamento);
        return mv;
    }

}
