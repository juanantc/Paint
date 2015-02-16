
package paint;

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;

/**
* Clase que hereda de BinaryOp y que redefine el método binaryOp
* implementando la operación producto.
* @author Juan Antonio Moraleda Ocón
*/
public class MultiplicacionOp extends BinaryOp {

    public MultiplicacionOp(BufferedImage img) {
        super(img);
    }
   
    public int binaryOp(int v1, int v2) {        
        double producto = (v1*v2)/255;
        
        return (int)producto;
    } 
}
