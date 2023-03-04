/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;
import Logins.LoginPage;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author woola
 */
public class RegisterPage extends javax.swing.JFrame {
     //Declaring Variables
    Connection con;
    PreparedStatement statement;
    Statement st;
    String cs;
    String user;
    String password;
    String query;
    ResultSet rs;
    String records;
    int count = 0;
    /**
     * Creates new form LogIn
     */
    public RegisterPage() {
        con = null;
        st = null;
        cs = "jdbc:mysql://localhost:3306/inventorydatabase";
        user = "root";
        password = "";
        super.setTitle("Account");
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnregister = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblusername = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        lblemail = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        lblmobile = new javax.swing.JLabel();
        txtmobile = new javax.swing.JTextField();
        lblpassword = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        lblalready = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INVENTORY MANAGEMENT SYSTEM");
        setName("title"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTER FOR AN ACCOUNT");

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnregister.setBackground(new java.awt.Color(102, 255, 102));
        btnregister.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        btnregister.setForeground(new java.awt.Color(255, 255, 255));
        btnregister.setText("Register");
        btnregister.setToolTipText("click to register");
        btnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregisterActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logins/main.png"))); // NOI18N

        lblusername.setText("Username");

        txtusername.setToolTipText("Enter user name here");

        lblemail.setText("Email");

        txtemail.setToolTipText("Enter your email here");
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        lblmobile.setText("Mobile");

        txtmobile.setToolTipText("Enter your mobile number here");

        lblpassword.setText("Password");

        txtpassword.setToolTipText("Enter your password here");
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });

        lblalready.setText("Already have an account?");

        btnlogin.setBackground(new java.awt.Color(102, 255, 102));
        btnlogin.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(255, 255, 255));
        btnlogin.setText("Log in");
        btnlogin.setToolTipText("click to go back to login page");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(26, 26, 26)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblpassword)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtpassword))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblmobile)
                                                        .addGap(34, 34, 34)
                                                        .addComponent(txtmobile))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(132, 132, 132)
                                                .addComponent(btnregister, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(105, 105, 105))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblalready, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(76, 76, 76))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblemail)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblmobile)
                            .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblpassword)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnregister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblalready, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnlogin))))
        );

        jLabel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregisterActionPerformed
        
        String s1 = txtusername.getText();
        String s2 = txtemail.getText();
        String s3 = txtmobile.getText();
        String s4 = txtpassword.getText();
        try{
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();           
            String query = "SELECT * FROM user where user_Name = '" + s1 + "' or user_Email='" + s2 +"'";
            ResultSet re1 = st.executeQuery(query);
            
            if(!s1.equals("") && !s2.equals("") && !s3.equals("") && !s4.equals("")){
                if(re1.next()){
                    JOptionPane.showMessageDialog(null, "Username or Email already exists");
                    txtusername.setText("");
                    txtemail.setText("");
                    txtmobile.setText("");
                    txtpassword.setText("");
                    //set focus to txtusername
                    txtusername.requestFocus();
                }
                else{
                    query = "INSERT INTO user(user_Name, user_Email, user_Mobile) VALUES('" + s1 + "','" + s2 +"','" + s3 +"')";
                    st.executeUpdate(query);// savings
                    query = "INSERT INTO login(login_Username , login_Password) VALUES('" + s1 + "','" + s4 +"')";
                    st.executeUpdate(query);// savings
                    JOptionPane.showMessageDialog(null, "Registration Successful");
                    //calling the loginpage form
                    LoginPage loginpage = new LoginPage();
                    loginpage.show();
                    dispose(); // closing current form
                }
            }
            else{
            JOptionPane.showMessageDialog(null, "All fields are required");
            txtusername.setText("");
            txtemail.setText("");
            txtmobile.setText("");
            txtpassword.setText("");
            //set focus to txtusername
            txtusername.requestFocus();
            }
        }
        catch (SQLException | ClassNotFoundException ex){
        }
        finally{
            try {
                if (st != null){
                    st.close();
                }
                if (con != null){
                    con.close();
                }
            }
            catch (SQLException ex){
            }
        }   
    }//GEN-LAST:event_btnregisterActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
         //calling the loginpage form
           LoginPage loginpage = new LoginPage();
           loginpage.show();
           dispose(); // closing current form
    }//GEN-LAST:event_btnloginActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegisterPage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnregister;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblalready;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblmobile;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lblusername;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
