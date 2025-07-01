package mx.edu.itses.lfuab.MetodosNumericos.services;

import java.util.ArrayList;
import mx.edu.itses.lfuab.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.lfuab.MetodosNumericos.domain.PuntoFijo;
import mx.edu.itses.lfuab.MetodosNumericos.domain.ReglaFalsa;
import mx.edu.itses.lfuab.MetodosNumericos.domain.NewtonRaphsony;

public interface UnidadIIService {
     public ArrayList<Biseccion> AlgoritmoBiseccion(Biseccion biseccion);
     public ArrayList<PuntoFijo> AlgoritmoPuntoFijo (PuntoFijo puntoFijo);
     public ArrayList<ReglaFalsa> AlgoritmoReglaFalsa (ReglaFalsa reglafalsa);
     public ArrayList<NewtonRaphsony> AlgoritmoNewtonRaphson(NewtonRaphsony newtonRaphsony);
}
