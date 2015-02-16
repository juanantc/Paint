
package paint;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;
import static java.lang.Math.sqrt;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;
import sm.image.KernelProducer;

/**
* Clase que hereda de BufferedImageOpAdapter y que redefine el método filter
* implementando la operación de Sobel.
* @author Juan Antonio Moraleda Ocón
*/
public class SobelOp extends BufferedImageOpAdapter{
    
    public SobelOp() {}
    
    public BufferedImage filter(BufferedImage src, BufferedImage dest){
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }

        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
              
        Kernel gradienteX = KernelProducer.createKernel(KernelProducer.TYPE_SOBELX_3x3);
        Kernel gradienteY = KernelProducer.createKernel(KernelProducer.TYPE_SOBELY_3x3);
        
        ConvolveOp convolucionX = new ConvolveOp(gradienteX);
        ConvolveOp convolucionY = new ConvolveOp(gradienteY);
        
        BufferedImage imgX = convolucionX.filter(src, null);
        BufferedImage imgY = convolucionY.filter(src, null);
        
        BufferedImagePixelIterator itX = new BufferedImagePixelIterator(imgX);
        BufferedImagePixelIterator itY = new BufferedImagePixelIterator(imgY);
        
        
        while(itX.hasNext()){ // while(itY.hasNext())
            BufferedImagePixelIterator.PixelData pixelX = itX.next();
            BufferedImagePixelIterator.PixelData pixelY = itY.next();
            
            int[] pixelCompX = pixelX.sample;
            int[] pixelCompY = pixelY.sample;
            
            int sumX = pixelCompX[0] + pixelCompX[1] + pixelCompX[2];
            int sumY = pixelCompY[0] + pixelCompY[1] + pixelCompY[2];
            
            int magnitud = (int)sqrt(sumX*sumX+sumY*sumY);
          
            magnitud = sm.image.ImageTools.clampRange(magnitud,0,255);
            
            int[] mag={magnitud,magnitud,magnitud};
            
            destRaster.setPixel(pixelX.col, pixelX.row,mag);    // destRaster.setPixel(pixelY.col, pixelY.row,mag);      
        }
        return dest;
    }
}