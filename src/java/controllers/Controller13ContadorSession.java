package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller13ContadorSession implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web13contadorsession");
        String dato = hsr.getParameter("incremento");
        if (dato != null) {
            int contador = 1;
            //el contador será 1 sólo la primera vez
            //luego tendrá el valor que hemos almacenado en session
            //hay que saber si existe algo en session o no
            //recuperar el objeto session del hsr
            if (hsr.getSession().getAttribute("contador") != null) {
                //si se cumple lo de arriba es que hay algo almacenado
                contador = (int) hsr.getSession().getAttribute("contador");
            }
            //incrementamos el contador, independientemente del valor almacenado
            contador += 1;
            //hay que guardar en session el nuevo valor del contador
            hsr.getSession().setAttribute("contador", contador);
            mv.addObject("contador", contador);
        }
        return mv;
    }

}
