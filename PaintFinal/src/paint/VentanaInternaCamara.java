
package paint;

import java.awt.Component;
import java.util.List;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.format.YUVFormat;

public class VentanaInternaCamara extends javax.swing.JInternalFrame {

    private Player p;
    
    private VentanaInternaCamara() {
        initComponents();      
        this.setSize(300,300);
        
        try {
            CaptureDeviceInfo deviceInfo;
            List<CaptureDeviceInfo> deviceList = CaptureDeviceManager.getDeviceList(new YUVFormat());
            deviceInfo = deviceList.get(0);
            MediaLocator ml = deviceInfo.getLocator();
            p = Manager.createRealizedPlayer(ml);
            Component areaVisual = p.getVisualComponent();
            if(areaVisual!=null) this.add(areaVisual,java.awt.BorderLayout.CENTER);
            this.pack();
           
        } catch(Exception e) {
            System.err.println("VentanaInternaCamara: " + e);
        }
    }
    
    public static VentanaInternaCamara getInstance(){
        VentanaInternaCamara vi = new VentanaInternaCamara();
        if(vi.p!=null)
            return vi;
        else
            return null;
    }
    
    public void play(){
         try{
            if(p!=null) p.start();
        } catch(Exception e) {
            System.err.println("VentanaInternaCamara: "+ e);
        }
    }
    
    public void close(){
         try{
            if(p!=null) p.close();
        } catch(Exception e) {
            System.err.println("VentanaInternaCamara: "+ e);
        }
    }
    
    public Player getPlayer(){
        return p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        p.close();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
