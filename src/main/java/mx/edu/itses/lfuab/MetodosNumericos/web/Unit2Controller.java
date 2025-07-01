package mx.edu.itses.lfuab.MetodosNumericos.web;

import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.lfuab.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.lfuab.MetodosNumericos.domain.NewtonRaphsony;
import mx.edu.itses.lfuab.MetodosNumericos.domain.ReglaFalsa;
import mx.edu.itses.lfuab.MetodosNumericos.domain.PuntoFijo;
import mx.edu.itses.lfuab.MetodosNumericos.services.UnidadIIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class Unit2Controller {

    @Autowired
    private UnidadIIService bisectionservice;

    @GetMapping("unit2/formbisection")
    public String formBisecccion(Model model) {
        Biseccion bisection = new Biseccion();
        log.info("Aqui");
        model.addAttribute("bisection", bisection);
        return "/unit2/bisection/formbisection";
    }

    @GetMapping("unit2/formreglafalsa")
    public String formReglaFalsa(Model model) {
        ReglaFalsa reglafalsa = new ReglaFalsa();

        model.addAttribute("reglafalsa", reglafalsa);
        return "unit2/reglafalsa/formreglafalsa";
    }

    @PostMapping("/unit2/solvebisection")
    public String solvebisection(Biseccion biseccion, Model model) {
        var solveBisection = bisectionservice.AlgoritmoBiseccion(biseccion);
        log.info("Arreglo" + solveBisection);
        model.addAttribute("solveBisection", solveBisection);
        return "/unit2/bisection/solvebisection";
    }

    @PostMapping("/unit2/solvereglafalsa")
    public String solvereglafalsa(ReglaFalsa reglafalsa, Model model) {
        var solveReglaFalsa = bisectionservice.AlgoritmoReglaFalsa(reglafalsa);
        log.info("Arreglo" + solveReglaFalsa);
        model.addAttribute("solveReglaFalsa", solveReglaFalsa);
        return "/unit2/reglafalsa/solvereglafalsa";
    }

    @GetMapping("unit2/formpuntofijo")
    public String formPuntoFijo(Model model) {
        PuntoFijo puntoFijo = new PuntoFijo();
        model.addAttribute("puntoFijo", puntoFijo);
        return "unit2/puntofijo/formpuntofijo";
    }

    @PostMapping("/unit2/solvepuntofijo")
    public String solvePuntoFijo(PuntoFijo puntoFijo, Model model) {
        var solvePuntoFijo = bisectionservice.AlgoritmoPuntoFijo(puntoFijo);
        log.info("Arreglo Punto Fijo: " + solvePuntoFijo);
        model.addAttribute("solvePuntoFijo", solvePuntoFijo);
        return "/unit2/puntofijo/solvepuntofijo";
    }

    @GetMapping("/unit2/formnewtonraphson")
    public String formNewtonRaphson(Model model) {
        NewtonRaphsony newtonRaphsony = new NewtonRaphsony();
        model.addAttribute("newtonRaphsony", newtonRaphsony);
        return "/unit2/newtonraphson/formnewtonraphson";
    }

    @PostMapping("/unit2/solvenewtonraphson")
    public String solveNewtonRaphson(NewtonRaphsony newtonRaphsony, Model model) {
        var solveNewtonRaphson = bisectionservice.AlgoritmoNewtonRaphson(newtonRaphsony);
        log.info("Arreglo Newton Raphson: " + solveNewtonRaphson);
        model.addAttribute("solveNewtonRaphson", solveNewtonRaphson);
        return "/unit2/newtonraphson/solvenewtonraphson";
    }

}
