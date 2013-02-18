import java.awt.Dimension;
import java.awt.Toolkit;

public class MainFrame extends javax.swing.JFrame
{
    Toolkit myKit=Toolkit.getDefaultToolkit();
    Dimension myScreenSize = myKit.getScreenSize();
    
    public MainFrame()
    {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Exit Poll Generator");
        this.setLocation(myScreenSize.width/4, myScreenSize.height/4);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Apri = new javax.swing.JMenuItem();
        Salva = new javax.swing.JMenuItem();
        Esci = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Help = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        File.setText("File");

        Apri.setText("Apri");
        Apri.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ApriActionPerformed(evt);
            }
        });
        File.add(Apri);

        Salva.setText("Salva");
        File.add(Salva);

        Esci.setText("Esci");
        Esci.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                EsciActionPerformed(evt);
            }
        });
        File.add(Esci);

        jMenuBar1.add(File);

        Edit.setText("Edit");
        jMenuBar1.add(Edit);

        Help.setText("?");
        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EsciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EsciActionPerformed

    private void ApriActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ApriActionPerformed
    {//GEN-HEADEREND:event_ApriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApriActionPerformed

    public static void main(String args[]) 
    {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Apri;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenuItem Esci;
    private javax.swing.JMenu File;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem Salva;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}