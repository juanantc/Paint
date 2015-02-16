
package sm.formas;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;

/**
* Clase que hereda de Forma y que redefine los metodos abstractos
* para que sea posible instanciar objetos de tipo Curva.
* @author Juan Antonio Moraleda Ocón
*/
public class Curva extends Forma {
    
    /**
     * Constructor. Asigna valores a los atributos que hereda la clase Curva de Forma. 
     * @param p Recibe el valor que permite definir el punto inicial y, momentaneamente, los puntos de control y final de la Curva.
     * @param c1 Recibe el valor del atributo colorFondo.
     * @param c2 Recibe el valor del atributo colorFrente.
     * @param r Recibe el valor del atributo relleno.
     * @param sk Recibe el valor del atributo stroke.
     */
    public Curva(Point2D p,Color c1,Color c2,int r,Stroke sk){
        shape = new QuadCurve2D.Double(p.getX(),p.getY(),p.getX(),p.getY(),p.getX(),p.getY());
        colorFondo = c1;
        colorFrente = c2; 
        relleno = r;
        stroke = sk;
    }
    
    public void updateForma(Point2D p1, Point2D p2){
        ((QuadCurve2D)shape).setCurve(p1.getX(),p1.getY(),(p1.getX()+p2.getX())/2,
                                     (p1.getY()+p2.getY())/2,p2.getX(),p2.getY());
    }   
      
    public void updateControlPoint(Point2D pCtrl){
        ((QuadCurve2D)shape).setCurve(((QuadCurve2D)shape).getP1(),pCtrl,((QuadCurve2D)shape).getP2());
    }
    
    public boolean contains(Point2D p){
        if(isNear(p))
            return true;
        else
            return false;  
    }
         
    /**
     * Método que permite saber si el punto que se le pasa como argumento se encuentra cerca de la Curva.
     * @param p Recibe el valor del punto a comprobar.
     * @return Devuelve si el punto está o no cerca de la Curva.
     */
    private boolean isNear(Point2D p){
        return ((QuadCurve2D)shape).intersects(p.getX()-2.5,p.getY()-2.5,5,5);
    }
    
    public void setLocation(Point2D pos){
        double dx1 = ((QuadCurve2D)shape).getCtrlX() - ((QuadCurve2D)shape).getX1();
        double dy1 = ((QuadCurve2D)shape).getCtrlY() - ((QuadCurve2D)shape).getY1();
        double dx2 = ((QuadCurve2D)shape).getX2() - ((QuadCurve2D)shape).getCtrlX();
        double dy2 = ((QuadCurve2D)shape).getY2() - ((QuadCurve2D)shape).getCtrlY();
        
        ((QuadCurve2D)shape).setCurve(pos.getX(),pos.getY(),
                                      pos.getX()+dx1,pos.getY()+dy1,
                                      pos.getX()+dx1+dx2,pos.getY()+dy1+dy2);
    }
}
