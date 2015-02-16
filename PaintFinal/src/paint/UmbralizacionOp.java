
package paint;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImageSampleIterator;

/**
* Clase que hereda de BufferedImageOpAdapter y que redefine el método filter
* implementando la operación de Umbralización.
* @author Juan Antonio Moraleda Ocón
*/
public class UmbralizacionOp extends BufferedImageOpAdapter{
    private int umbral;
    
    public UmbralizacionOp(int umbral) {
        this.umbral = umbral;
    }

    public BufferedImage filter(BufferedImage src, BufferedImage dest){
        if (dest == null){
            dest = createCompatibleDestImage(src, null);
        }
        
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        for (BufferedImageSampleIterator it = new BufferedImageSampleIterator(src); it.hasNext();) {
            BufferedImageSampleIterator.SampleData sample = it.next() ;
            
            if(sample.value < umbral)
                sample.value = 0;
            else
                sample.value = 255;
            
            destRaster.setSample(sample.col, sample.row, sample.band, sample.value);
        }
        return dest;
    }
}

