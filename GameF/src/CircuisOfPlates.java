
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CircuisOfPlates.java
 *
 * Created on Dec 27, 2011, 1:43:40 AM
 */



/**
 *
 * @author Eng Omnia
 */
public class CircuisOfPlates extends javax.swing.JFrame {

    /** Creates new form CircuisOfPlates */
    public CircuisOfPlates() {
        initComponents();
        this.setSize(getMaximumSize());
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jDialog1 = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jFrame1.getContentPane().setLayout(null);

        jButton4.setText("Easy");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(jButton4);
        jButton4.setBounds(140, 0, 160, 60);

        jButton5.setText("Meduim");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(jButton5);
        jButton5.setBounds(140, 80, 160, 70);

        jButton6.setText("Hard");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(jButton6);
        jButton6.setBounds(140, 170, 170, 60);

        jDialog1.getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel3.setText("How To Play");
        jDialog1.getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 400, 50);

        jLabel4.setText("use Arrow keys for player 1");
        jDialog1.getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 70, 230, 40);

        jLabel5.setText("Use A,D for player 2");
        jDialog1.getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 190, 140, 14);
ImageIcon im = new ImageIcon("images.jpg");
        jLabel6.setIcon(im); // NOI18N
        jDialog1.getContentPane().add(jLabel6);
        jLabel6.setBounds(210, 60, 160, 100);

        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jButton7);
        jButton7.setBounds(180, 250, 90, 23);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(540, 570, 80, 23);

        jLabel2.setFont(new java.awt.Font("Impact", 0, 48));
        jLabel2.setText("Circus of Plates");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 300, 330, 60);

        jButton2.setText("How to Play");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(370, 570, 120, 23);
ImageIcon imgs = new ImageIcon("play.PNG");
        jButton1.setIcon(imgs); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(80, 540, 230, 70);
        ImageIcon imgsC = new ImageIcon("circus.jpg");
        jLabel1.setIcon(imgsC); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1200, 459));
        jLabel1.setPreferredSize(new java.awt.Dimension(1200, 459));
        jLabel1.setRequestFocusEnabled(false);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 110, 930, 560);

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
       jFrame1.setVisible(true);
       
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         View v = null;
        try {
            v = new View();
            v.control.difficulity=1;
        } catch (InstantiationException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            v.runGUI();
        } catch (InstantiationException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        }
        v.control.setDifficulity(1);
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	View v = null;
        try {
            v = new View();
            v.control.setDifficulity(2);
        } catch (InstantiationException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            v.runGUI();
        } catch (InstantiationException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        }
    } private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	View v = null;
        try {
            v = new View();
            v.control.setDifficulity(3);
        } catch (InstantiationException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            v.runGUI();
        } catch (InstantiationException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CircuisOfPlates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jDialog1.setVisible(true);
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jDialog1.setVisible(false);
        this.getFrames()[0].setVisible(true);
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CircuisOfPlates().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration

}
