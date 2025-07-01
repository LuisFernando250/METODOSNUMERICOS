
package mx.edu.itses.lfuab.MetodosNumericos.domain;

import lombok.Data;

@Data
public class NewtonRaphsony {
 private String fx;
 private String DFX; 
 private double XI;
 private double XI1;
 private double FXI;
 private double DFXI;
 private double Ea; 
 private int IteracionesMaximas; 
 private int Iteracion; 
}
