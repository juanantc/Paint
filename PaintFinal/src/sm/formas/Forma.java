
package sm.formas;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
* Clase abstracta que hereda a Punto, Linea, Rectangulo, Curva, Elipse y RectanguloRedondeado
* @author Juan Antonio Moraleda Ocón
*/
public abstract class Forma {
    /**
     * Shape de la Forma.
     */
    protected Shape shape;
    
    /**
     * Color para el relleno.
     */
    protected Color colorFondo;
    
    /**
     * Color para el borde.
     */
    protected Color colorFrente;
    
    /**
     * Toma los valores 0, 1, 2, 3 que se corresponden con forma sin relleno,
     * con relleno, con degradado vertical y con degradado horizontal respectivamente. 
     */
    protected int relleno;
    
    /**
     * Contiene los atributos de la Forma referentes al grosor y al estilo del trazo.
     */
    protected Stroke stroke;
    
    /**
    * Método modificador del atributo shape.
    * @param s Recibe el valor del atributo shape.
    */
    public void setShape(Shape s){
        shape = s;
    }
    
    /**
    * Método modificador del atributo colorFondo.
    * @param c Recibe el valor del atributo colorFondo.
    */
    public void setColorFondo(Color c){
        colorFondo = c;
    }
    
    /**
    * Método modificador del atributo colorFrente.
    * @param c Recibe el valor del atributo colorFrente.
    */
    public void setColorFrente(Color c){
        colorFrente = c;
    }
    
    /**
    * Método modificador del atributo relleno.
    * @param r Recibe el valor del atributo relleno.
    */
    public void setRelleno(int r){
        relleno = r;
    }
    
    /**
    * Método modificador del atributo stroke.
    * @param s Recibe el valor del atributo stroke.
    */
    public void setStroke(Stroke s){
        stroke = s;
    }
    
    /**
    * Método consultor del atributo shape.
    * @return Retorna el valor del atributo shape.
    */
    public Shape getShape(){
        return shape;
    }
    
    /**
    * Método consultor del atributo colorFondo.
    * @return Retorna el valor del atributo colorFondo.
    */
    public Color getColorFondo(){
        return colorFondo;
    }
    
    /**
    * Método consultor del atributo colorFrente.
    * @return Retorna el valor del atributo colorFrente.
    */
    public Color getColorFrente(){
        return colorFrente;
    }
    
    /**
    * Método consultor del atributo relleno.
    * @return Retorna el valor del atributo relleno.
    */
    public int getRelleno(){
        return relleno;
    }

    /**
    * Método consultor del atributo stroke.
    * @return Retorna el valor del atributo stroke.
    */
    public Stroke getStroke() {
        return stroke;
    }
    
    /**
    * Método que permite actualizar la posición de una forma ya creada.
    * @param p1 Recibe el valor del punto inicial de la forma.
    * @param p2 Recibe el valor del punto final de la forma.
    */
    public abstract void updateForma(Point2D p1, Point2D p2);
    
    /**
    * Método que permite saber si un punto está contenido dentro de la forma.
    * @param p Recibe el valor del punto que se quiere comprobar.
    * @return Devuelve si el punto que se le ha pasado como argumento está contenido dentro la forma.
    */
    public abstract boolean contains(Point2D p);
    
    /**
    * Método que permite modificar la posición de una forma.
    * @param pos Recibe el valor del punto el cual debe ser el punto inicial de la forma.
    */
    public abstract void setLocation(Point2D pos);

    /**
    * Método que permite actualizar el punto de control de la forma, solo está disponible para la forma Curva. 
    * @param pCtrl Recibe el valor del punto que se quiere asignar como punto de control.
    */
    public abstract void updateControlPoint(Point2D pCtrl);
    
    /**
    * Método que dibuja la forma teniendo en cuenta todos los atributos referentes a ésta.
    * @param g2d Objeto de la clase Graphics asociado a nuestra forma. 
    */
    public void dibuja(Graphics2D g2d){
        GradientPaint degradado;
        if(relleno == 1)
            g2d.setPaint(colorFondo);
        else if(relleno == 2){
            double px1 = (shape.getBounds2D().getMaxX() + shape.getBounds2D().getMinX())/2;
            double py1 = shape.getBounds2D().getMinY();
            double px2 = (shape.getBounds2D().getMaxX() + shape.getBounds2D().getMinX())/2;
            double py2 = shape.getBounds2D().getMaxY();
            
            degradado = new GradientPaint((float)px1,(float)py1, colorFrente,(float)px2,(float)py2, colorFondo);
            g2d.setPaint(degradado);
        }else if(relleno == 3){
            double px1 = shape.getBounds2D().getMinX();
            double py1 = (shape.getBounds2D().getMinY() + shape.getBounds2D().getMaxY())/2;
            double px2 = shape.getBounds2D().getMaxX();
            double py2 = (shape.getBounds2D().getMinY() + shape.getBounds2D().getMaxY())/2;
            degradado = new GradientPaint((float)px1,(float)py1, colorFrente,(float)px2,(float)py2, colorFondo);
            g2d.setPaint(degradado);
        }
           
        g2d.setStroke(getStroke());
        if(relleno != 0)
            g2d.fill(shape); 
        g2d.setColor(colorFrente);
        g2d.draw(shape);            
    }  
}
