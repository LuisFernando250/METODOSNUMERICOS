package mx.edu.itses.lfuab.MetodosNumericos.domain;

import lombok.Data;

@Data
public class Secante {

    private String FX;
    private double XI_1;
    private double XI;
    private double XI1;
    private double FXI_1;
    private double FXI;
    private double Ea;
    private int IteracionesMaximas;
    private int Iteracion;
}
