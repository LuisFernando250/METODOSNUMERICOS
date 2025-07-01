package mx.edu.itses.lfuab.MetodosNumericos.domain;

import lombok.Data;

@Data
public class PuntoFijo {

    private String GX; 
    private double XI; 
    private double XI1; 
    private double FXI; 
    private double Ea;
    private int IteracionesMaximas; 
    private int Iteracion; 

}
