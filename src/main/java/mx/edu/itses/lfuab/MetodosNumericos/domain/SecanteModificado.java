package mx.edu.itses.lfuab.MetodosNumericos.domain;

import lombok.Data;

@Data
public class SecanteModificado {

    private String FX;
    private double X;
    private double XI1;
    private double FXI;
    private double derivada;
    private double Ea;
    private int IteracionesMaximas;
    private int Iteracion;
}
