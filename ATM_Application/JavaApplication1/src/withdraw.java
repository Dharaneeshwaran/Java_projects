/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aswanth
 */
public class withdraw extends javax.swing.JFrame {

    /**
     * Creates new form withdraw
     */
    int amount;
    public withdraw() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabel1.setText("Enter Amount");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(540, 430, 150, 30);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(720, 430, 180, 30);

        jButton1.setBackground(new java.awt.Color(102, 102, 0));
        jButton1.setFont(new java.awt.Font("Vijaya", 1, 24)); // NOI18N
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(450, 520, 120, 40);

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("WITHDRAW MONEY");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(570, 260, 410, 40);

        jLabel4.setBackground(new java.awt.Color(102, 102, 0));
        jLabel4.setFont(new java.awt.Font("Vani", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(490, 360, 480, 40);

        jLabel5.setFont(new java.awt.Font("Vani", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(490, 320, 540, 40);

        jButton2.setBackground(new java.awt.Color(102, 102, 0));
        jButton2.setFont(new java.awt.Font("Vijaya", 1, 24)); // NOI18N
        jButton2.setText("ANOTHER TRANSACTION");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(610, 520, 290, 40);

        jButton3.setBackground(new java.awt.Color(102, 102, 0));
        jButton3.setFont(new java.awt.Font("Vijaya", 1, 24)); // NOI18N
        jButton3.setText("LOGOUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(920, 520, 140, 40);

        jLabel3.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/money clock.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-160, 0, 1530, 830);

        setBounds(0, 0, 1367, 771);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          String l,str,str1,str3;
          int amt=0;
       l=log.N;
        SQL d=new SQL("jdbc:oracle:thin:@localhost:1521:XE","oracle.jdbc.OracleDriver","hr","hr");
         str1="SELECT BALANCE FROM ACCOUNT WHERE CARD_NO='"+l+"' ";
        try
        {
            d.executeQuery(str1);
            d.rs.next();
          
           amount= Integer.parseInt(d.rs.getString("BALANCE"));
         if(amount<1000)
         {
            jLabel5.setText("YOUR BALANCE IS TOO LOW");
         }
         else 
         {
             amt=Integer.parseInt(jTextField1.getText());
             if((amt<amount)&&((amount-amt)>1000)&&amt>0)
             {
             str="UPDATE ACCOUNT SET BALANCE=BALANCE-'"+amt+"'WHERE CARD_NO='"+l+"'";
             jLabel5.setText("TRANSACTION SUCCESSFULL");
             
        try
        {
            d.execute(str);
        }
        catch(Exception e)
        {
            
        }
             }
             else if(amt<0)
             {
                 jLabel5.setText("INVALID AMOUNT");
             }
             
             else
             {
                 jLabel5.setText("YOUR BALANCE IN NOT SUFFICIENT");
             }
         }
        }
         catch(Exception e)
        {
           
        }
         str3="SELECT BALANCE FROM ACCOUNT WHERE CARD_NO='"+l+"' ";
        try
        {
            d.executeQuery(str3);
            d.rs.next();
          
           amount= Integer.parseInt(d.rs.getString("BALANCE"));
           jLabel4.setText("AVAILABLE BALANCE IS RS."+amount );
        }
        catch(Exception e)
        {
            
        }
        
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dispose();
        option o=new option();
        o.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       dispose();
        logout l=new logout();
       l.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new withdraw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
