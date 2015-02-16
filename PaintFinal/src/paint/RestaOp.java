
package paint;

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;

/**
* Clase que hereda de BinaryOp y que redefine el método binaryOp
* implementando la operación resta.
* @author Juan Antonio Moraleda Ocón
*/
public class RestaOp extends BinaryOp {

    public RestaOp(BufferedImage img) {
        super(img);
    }
   
    public int binaryOp(int v1, int v2) {
        return Math.abs(v1 - v2);
    } 
}