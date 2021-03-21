package controllers;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Pelicula;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import repositories.RepositoryPeliculas;

public class ControllerPeliculas extends MultiActionController {

    RepositoryPeliculas repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    /*public ModelAndView start(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ModelAndView mv = new ModelAndView("webtiendapeliculas");
        this.repo = (RepositoryPeliculas) this.getBean("repositorypeliculas", request.getServletContext());
        List<Pelicula> peliculas = this.repo.getPeliculas();
        mv.addObject("peliculas", peliculas);
        return mv;
    }*/
    public ModelAndView start(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ModelAndView mv = new ModelAndView("webtiendapeliculas");
        this.repo = (RepositoryPeliculas) this.getBean("repositorypeliculas", request.getServletContext());
        int posicion = 1;
        String dato = request.getParameter("posicion");
        if (dato != null) {
            posicion = Integer.parseInt(dato);
        }
        int numeroregistros = this.repo.getNumeroRegistros();
        List<Pelicula> peliculas = this.repo.getpagina(posicion);
        mv.addObject("numeroregistros", numeroregistros);
        mv.addObject("peliculas", peliculas);
        return mv;
    }

    public ModelAndView detalles(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ModelAndView mv = new ModelAndView("webtiendapeliculas");
        this.repo = (RepositoryPeliculas) this.getBean("repositorypeliculas", request.getServletContext());
        String dato = request.getParameter("idpelicula");
        int idpelicula = Integer.parseInt(dato);
        Pelicula detalles = this.repo.getDetalles(idpelicula);
        mv.addObject("detalles", detalles);
        return mv;
    }
}
