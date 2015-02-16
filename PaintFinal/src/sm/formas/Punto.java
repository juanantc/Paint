
package sm.formas;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
* Clase que hereda de Forma y que redefine los metodos abstractos
* para que sea posible instanciar objetos de tipo Linea.
* @author Juan Antonio Moraleda Ocón
*/
public class Punto extends Forma {

    /**
     * Constructor. Asigna valores a los atributos que hereda la clase Linea de Punto. 
     * @param p Recibe el valor que permite definir la ubicación del Punto
     * @param c1 Recibe el valor del atributo colorFondo.
     * @param c2 Recibe el valor del atributo colorFrente.
     * @param r Recibe el valor del atributo relleno.
     * @param sk Recibe el valor del atributo stroke.
     */
    public Punto(Point2D p,Color c1,Color c2,int r,Stroke sk){
        shape = new Line2D.Double(p,p);
        colorFondo = c1;
        colorFrente = c2; 
        relleno = r;
        stroke = sk;
    }
    
    public void updateForma(Point2D p1,Point2D p2){
        ((Line2D)shape).setLine(p1.getX(),p1.getY(),p1.getX(),p1.getY());
    }
    
    public boolean contains(Point2D p){
        if(isNear(p))
            return true;
        else
            return false;  
    }
    
     /**
     * Método que permite saber si el punto que se le pasa como argumento se encuentra cerca de él.
     * @param p Recibe el valor del punto a comprobar.
     * @return Devuelve si el punto está o no cerca.
     */
    private boolean isNear(Point2D p){
        return ((Line2D)shape).ptSegDist(p)<=2.0;
    }
    
    public void setLocation(Point2D pos){           
        ((Line2D)shape).setLine(pos.getX(),pos.getY(),pos.getX(),pos.getY());
    }

    @Override
    public void updateControlPoint(Point2D pCtrl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
