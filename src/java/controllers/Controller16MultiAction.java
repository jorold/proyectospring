package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class Controller16MultiAction extends MultiActionController {

    public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web16multiaction");
        return mv;
    }

    public ModelAndView alta(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web16multiaction");
        mv.addObject("mensaje", "Has entrado en action Alta");
        return mv;
    }

    public ModelAndView baja(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web16multiaction");
        mv.addObject("mensaje", "Has entrado en action Baja");
        return mv;
    }

    public ModelAndView sumar(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web16multiaction");
        String dato = request.getParameter("numero1");
        String dato2 = request.getParameter("numero2");
        int num1 = Integer.parseInt(dato);
        int num2 = Integer.parseInt(dato2);
        int suma = num1 + num2;
        mv.addObject("mensaje", "La suma de " + num1 + " + " + num2 + " es " + suma);
        return mv;
    }

    public ModelAndView multiplicar(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web16multiaction");
        String dato = request.getParameter("numero1");
        String dato2 = request.getParameter("numero2");
        int num1 = Integer.parseInt(dato);
        int num2 = Integer.parseInt(dato2);
        int multiplicar = num1 * num2;
        mv.addObject("mensaje", "La multiplicación de " + num1 + " * " + num2 + " es " + multiplicar);
        return mv;
    }

}
