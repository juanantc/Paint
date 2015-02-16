
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
public class Linea extends Forma {

    /**
     * Constructor. Asigna valores a los atributos que hereda la clase Linea de Forma. 
     * @param p Recibe el valor que permite definir el punto inicial y, momentaneamente, el punto final de la Línea.
     * @param c1 Recibe el valor del atributo colorFondo.
     * @param c2 Recibe el valor del atributo colorFrente.
     * @param r Recibe el valor del atributo relleno.
     * @param sk Recibe el valor del atributo stroke.
     */
    public Linea(Point2D p,Color c1,Color c2,int r,Stroke sk){
        shape = new Line2D.Double(p,p);
        colorFondo = c1;
        colorFrente = c2; 
        relleno = r;
        stroke = sk;
    }
    
    public void updateForma(Point2D p1, Point2D p2){
        ((Line2D)shape).setLine(p1, p2);
    }
    
    public boolean contains(Point2D p){
        if(isNear(p))
            return true;
        else
            return false;  
    }
    
    /**
     * Método que permite saber si el punto que se le pasa como argumento se encuentra cerca de la Linea.
     * @param p Recibe el valor del punto a comprobar.
     * @return Devuelve si el punto está o no cerca de la Linea.
     */
    private boolean isNear(Point2D p){
        return ((Line2D)shape).ptSegDist(p)<=2.0;
    }
    
    public void setLocation(Point2D pos){
        double dx= ((Line2D)shape).getX2()-((Line2D)shape).getX1();
        double dy= ((Line2D)shape).getY2()-((Line2D)shape).getY1();
            
        ((Line2D)shape).setLine(pos.getX(),pos.getY(),pos.getX()+dx,pos.getY()+dy);
    }

    @Override
    public void updateControlPoint(Point2D pCtrl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
