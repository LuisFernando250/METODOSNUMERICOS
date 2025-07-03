package mx.edu.itses.lfuab.MetodosNumericos.services;

import java.util.ArrayList;
import mx.edu.itses.lfuab.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.lfuab.MetodosNumericos.domain.PuntoFijo;
import mx.edu.itses.lfuab.MetodosNumericos.domain.ReglaFalsa;
import mx.edu.itses.lfuab.MetodosNumericos.domain.NewtonRaphsony;
import mx.edu.itses.lfuab.MetodosNumericos.domain.Secante;
import mx.edu.itses.lfuab.MetodosNumericos.domain.SecanteModificado;

public interface UnidadIIService {
    ArrayList<Biseccion>        AlgoritmoBiseccion(Biseccion biseccion);
    ArrayList<PuntoFijo>        AlgoritmoPuntoFijo(PuntoFijo puntoFijo);
    ArrayList<ReglaFalsa>       AlgoritmoReglaFalsa(ReglaFalsa reglafalsa);
    ArrayList<NewtonRaphsony>   AlgoritmoNewtonRaphson(NewtonRaphsony newtonRaphsony);
    ArrayList<Secante>          AlgoritmoSecante(Secante secante);
    ArrayList<SecanteModificado> AlgoritmoSecanteModificado(SecanteModificado secanteModificado);
}
