
package sm.formas;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
* Clase que hereda de Forma y que redefine los metodos abstractos
* para que sea posible instanciar objetos de tipo Rectangulo.
* @author Juan Antonio Moraleda Ocón
*/
public class Rectangulo extends Forma {

    /**
     * Constructor. Asigna valores a los atributos que hereda la clase Rectangulo de Forma. 
     * @param p Recibe el valor que permite definir el punto inicial y, momentaneamente, el punto final del Rectangulo.
     * @param c1 Recibe el valor del atributo colorFondo.
     * @param c2 Recibe el valor del atributo colorFrente.
     * @param r Recibe el valor del atributo relleno.
     * @param sk Recibe el valor del atributo stroke.
     */
    public Rectangulo(Point2D p,Color c1,Color c2,int r,Stroke sk){
        shape = new Rectangle2D.Double(p.getX(),p.getY(),1,1);
        colorFondo = c1;
        colorFrente = c2; 
        relleno = r;
        stroke = sk;
    }

    public void updateForma(Point2D p1, Point2D p2){
        ((Rectangle2D)shape).setFrameFromDiagonal(p1, p2);  
    }
    
    public boolean contains(Point2D p){
        return shape.contains(p);
    }
    
    public void setLocation(Point2D pos){
       ((Rectangle2D)shape).setFrame(pos.getX(),pos.getY(),((Rectangle2D)shape).getWidth(),((Rectangle2D)shape).getHeight());
    }    

    @Override
    public void updateControlPoint(Point2D pCtrl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
