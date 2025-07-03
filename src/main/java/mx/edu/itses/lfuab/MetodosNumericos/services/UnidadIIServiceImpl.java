package mx.edu.itses.lfuab.MetodosNumericos.services;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.lfuab.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.lfuab.MetodosNumericos.domain.PuntoFijo;
import mx.edu.itses.lfuab.MetodosNumericos.domain.ReglaFalsa;
import mx.edu.itses.lfuab.MetodosNumericos.domain.NewtonRaphsony;
import mx.edu.itses.lfuab.MetodosNumericos.domain.Secante;
import mx.edu.itses.lfuab.MetodosNumericos.domain.SecanteModificado;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UnidadIIServiceImpl implements UnidadIIService {

    @Override
    public ArrayList<Biseccion> AlgoritmoBiseccion(Biseccion biseccion) {
        ArrayList<Biseccion> respuesta = new ArrayList<>();
        double XL, XU, XRa, XRn, FXL, FXU, FXR, Ea;

        XL = biseccion.getXL();
        XU = biseccion.getXU();
        XRa = 0;
        Ea = 100;
        FXL = Funciones.Ecuacion(biseccion.getFX(), XL);
        FXU = Funciones.Ecuacion(biseccion.getFX(), XU);
        if (FXL * FXU < 0) {
            for (int i = 1; i <= biseccion.getIteracionesMaximas(); i++) {
                XRn = (XL + XU) / 2;
                FXL = Funciones.Ecuacion(biseccion.getFX(), XL);
                FXU = Funciones.Ecuacion(biseccion.getFX(), XU);
                FXR = Funciones.Ecuacion(biseccion.getFX(), XRn);
                if (i != 1) {
                    Ea = Funciones.ErrorRelativo(XRn, XRa);
                }
                Biseccion renglon = new Biseccion();
                renglon.setXL(XL);
                renglon.setXU(XU);
                renglon.setXR(XRn);
                renglon.setFXL(FXL);
                renglon.setFXU(FXU);
                renglon.setFXR(FXR);
                renglon.setEa(Ea);
                if (FXL * FXR < 0) {
                    XU = XRn;
                } else if (FXL * FXR > 0) {
                    XL = XRn;
                } else if (FXL * FXR == 0) {
                    break;
                }
                XRa = XRn;
                respuesta.add(renglon);
                if (Ea <= biseccion.getEa()) {
                    break;
                }
            }
        } else {
            Biseccion renglon = new Biseccion();
            // renglon.setIntervaloInvalido(true);
            respuesta.add(renglon);
        }

        return respuesta;
    }

    @Override
    public ArrayList<PuntoFijo> AlgoritmoPuntoFijo(PuntoFijo puntofijo) {
        ArrayList<PuntoFijo> respuesta = new ArrayList<>();
        double XI, XI1, FXI, Ea;

        XI = puntofijo.getXI();
        Ea = 100;

        for (int i = 1; i <= puntofijo.getIteracionesMaximas(); i++) {
            XI1 = Funciones.Ecuacion(puntofijo.getGX(), XI);
            FXI = Funciones.Ecuacion(puntofijo.getGX(), XI);

            if (i != 1) {
                Ea = Funciones.ErrorRelativo(XI1, XI);
            }

            PuntoFijo renglon = new PuntoFijo();
            renglon.setGX(puntofijo.getGX());
            renglon.setXI(XI);
            renglon.setXI1(XI1);
            renglon.setFXI(FXI);
            renglon.setEa(Ea);
            renglon.setIteracionesMaximas(puntofijo.getIteracionesMaximas());
            renglon.setIteracion(i);

            respuesta.add(renglon);

            if (Ea <= puntofijo.getEa()) {
                break;
            }
            XI = XI1;
        }
        return respuesta;
    }

    @Override
    public ArrayList<ReglaFalsa> AlgoritmoReglaFalsa(ReglaFalsa reglafalsa) {
        ArrayList<ReglaFalsa> respuesta = new ArrayList<>();
        double XL, XU, XRa, XRn, FXL, FXU, FXR, Ea;

        XL = reglafalsa.getXL();
        XU = reglafalsa.getXU();
        XRa = 0;
        Ea = 100;
        FXL = Funciones.Ecuacion(reglafalsa.getFX(), XL);
        FXU = Funciones.Ecuacion(reglafalsa.getFX(), XU);
        if (FXL * FXU < 0) {
            for (int i = 1; i <= reglafalsa.getIteracionesMaximas(); i++) {
                XRn = XU - (FXU * (XL - XU)) / (FXL - FXU);
                FXL = Funciones.Ecuacion(reglafalsa.getFX(), XL);
                FXU = Funciones.Ecuacion(reglafalsa.getFX(), XU);
                FXR = Funciones.Ecuacion(reglafalsa.getFX(), XRn);
                if (i != 1) {
                    Ea = Funciones.ErrorRelativo(XRn, XRa);
                }
                ReglaFalsa renglon = new ReglaFalsa();
                renglon.setXL(XL);
                renglon.setXU(XU);
                renglon.setXR(XRn);
                renglon.setFXL(FXL);
                renglon.setFXU(FXU);
                renglon.setFXR(FXR);
                renglon.setEa(Ea);
                renglon.setIteracionesMaximas(reglafalsa.getIteracionesMaximas());
                respuesta.add(renglon);

                if (FXL * FXR < 0) {
                    XU = XRn;
                } else if (FXL * FXR > 0) {
                    XL = XRn;
                } else if (FXL * FXR == 0) {
                    break;
                }
                XRa = XRn;
                if (Ea <= reglafalsa.getEa()) {
                    break;
                }
            }
        } else {
            ReglaFalsa renglon = new ReglaFalsa();
            respuesta.add(renglon);
        }

        return respuesta;
    }

    @Override
    public ArrayList<NewtonRaphsony> AlgoritmoNewtonRaphson(NewtonRaphsony newtonRaphsony) {
        ArrayList<NewtonRaphsony> respuesta = new ArrayList<>();
        double XI, XI1, FXI, DFXI, Ea;

        XI = newtonRaphsony.getXI();
        Ea = 100;
        for (int i = 1; i <= newtonRaphsony.getIteracionesMaximas(); i++) {
            FXI = Funciones.Ecuacion(newtonRaphsony.getFx(), XI);
            DFXI = Funciones.Ecuacion(newtonRaphsony.getDFX(), XI);
            if (DFXI == 0) {

                break;
            }
            XI1 = XI - (FXI / DFXI);

            if (i != 1) {
                Ea = Funciones.ErrorRelativo(XI1, XI);
            }
            NewtonRaphsony renglon = new NewtonRaphsony();
            renglon.setFx(newtonRaphsony.getFx());
            renglon.setDFX(newtonRaphsony.getDFX());
            renglon.setXI(XI);
            renglon.setXI1(XI1);
            renglon.setFXI(FXI);
            renglon.setDFXI(DFXI);
            renglon.setEa(Ea);
            renglon.setIteracionesMaximas(newtonRaphsony.getIteracionesMaximas());
            renglon.setIteracion(i);

            respuesta.add(renglon);

            if (Ea <= newtonRaphsony.getEa()) {
                break;
            }
            XI = XI1;

        }
        return respuesta;
    }

    @Override
    public ArrayList<Secante> AlgoritmoSecante(Secante secante) {
        ArrayList<Secante> respuesta = new ArrayList<>();
        double xi_1 = secante.getXI_1();
        double xi = secante.getXI();
        double ea = 100;

        for (int i = 1; i <= secante.getIteracionesMaximas(); i++) {
            double f_xi_1 = Funciones.Ecuacion(secante.getFX(), xi_1);
            double f_xi = Funciones.Ecuacion(secante.getFX(), xi);
            double xi1 = xi - f_xi * (xi_1 - xi) / (f_xi_1 - f_xi);
            if (i != 1) {
                ea = Funciones.ErrorRelativo(xi1, xi);
            }

            Secante renglon = new Secante();
            renglon.setFX(secante.getFX());
            renglon.setXI_1(xi_1);
            renglon.setXI(xi);
            renglon.setXI1(xi1);
            renglon.setFXI_1(f_xi_1);
            renglon.setFXI(f_xi);
            renglon.setEa(ea);
            renglon.setIteracionesMaximas(secante.getIteracionesMaximas());
            renglon.setIteracion(i);
            respuesta.add(renglon);

            if (ea <= secante.getEa()) {
                break;
            }
            xi_1 = xi;
            xi = xi1;
        }
        return respuesta;
    }

    @Override
    public ArrayList<SecanteModificado> AlgoritmoSecanteModificado(SecanteModificado s) {
        ArrayList<SecanteModificado> respuesta = new ArrayList<>();
        double x = s.getX();
        double ea = 100;

        for (int i = 1; i <= s.getIteracionesMaximas(); i++) {
            double f_x = Funciones.Ecuacion(s.getFX(), x);
            double df_x = Funciones.Derivada(s.getFX(), x);
            double x1 = x - f_x / df_x;
            if (i != 1) {
                ea = Funciones.ErrorRelativo(x1, x);
            }

            SecanteModificado renglon = new SecanteModificado();
            renglon.setFX(s.getFX());
            renglon.setX(x);
            renglon.setXI1(x1);
            renglon.setFXI(f_x);
            renglon.setDerivada(df_x);
            renglon.setEa(ea);
            renglon.setIteracionesMaximas(s.getIteracionesMaximas());
            renglon.setIteracion(i);
            respuesta.add(renglon);

            if (ea <= s.getEa()) {
                break;
            }
            x = x1;
        }
        return respuesta;
    }
}
