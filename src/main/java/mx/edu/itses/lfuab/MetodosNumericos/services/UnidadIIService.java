package mx.edu.itses.lfuab.MetodosNumericos.services;

import java.util.ArrayList;
import mx.edu.itses.lfabMetodosNumericos.domain.Biseccion;
import mx.edu.itses.lfabMetodosNumericos.domain.PuntoFijo;
import mx.edu.itses.lfabMetodosNumericos.domain.ReglaFalsa;

public interface UnidadIIService {
     public ArrayList<Biseccion> AlgoritmoBiseccion(Biseccion biseccion);
     public ArrayList<PuntoFijo> AlgoritmoPuntoFijo (PuntoFijo puntoFijo);
     public ArrayList<ReglaFalsa> AlgoritmoReglaFalsa (ReglaFalsa reglafalsa);
     
}
