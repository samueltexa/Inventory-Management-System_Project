/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrames;
import Tables.Supplier_Table;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
    /**
    The AddSupplier class extends the javax.swing.JFrame class to provide
    a GUI window for adding a new supplier to a database.
    The AddSupplier class includes the following components:
    A lblName for displaying the supplier name field label.
    A txtMobile and lblMobile for entering and displaying the supplier mobile number respectively.
    A lblDistrict for displaying the supplier District field label.
    A txtAddress for entering the product supplied by the supplier.
    A btnSave for saving and  submitting the supplier information.
    A btnClear for clearing all the text fields.
    The AddSupplier class also includes methods for setting and getting
    the supplier name and address, as well as for submitting the supplier
    information to a database.
     @author woola
     */
public final class AddSupplier extends javax.swing.JFrame {
    //Declaring Variables

    /**
     *
     */
    Connection con;

    /**
     *
     */
    PreparedStatement statement;

    /**
     *
     */
    Statement st;

    /**
     *
     */
    String cs;

    /**
     *
     */
    String user;

    /**
     *
     */
    String password;

    /**
     *
     */
    String query;

    /**
     *
     */
    ResultSet rs;

    /**
     *
     */
    String records;

    /**
     *
     */
    int count = 0;

    /**
     * Creates new form AddSupplier
     */
    public AddSupplier() {
        // Initializing the user interface components:
        con = null;
        st = null;
        cs = "jdbc:mysql://localhost:3306/inventorydatabase";
        user = "root";
        password = "";
        initComponents();
        AddDataToDistrict();
        AddDataToProduct();
        AddDataToCategory();
    }
    
    /**
      This method selects district name from the database and adds it to the district comboBox
     */
    public void AddDataToDistrict(){
        // Connect to the database and execute a query to add suppliers:
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            String query = "SELECT Districts FROM location";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
             // Iterate over the result set and add items to the comboBox
            while(rs.next()){
                box1.addItem(rs.getString("Districts"));   
            }
             box1.setSelectedItem(null);
             txtdistrict.setText(null);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
    
    /**
       This method selects product name from the database and adds it to the product comboBox
     */
    public void AddDataToProduct(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            String query = "SELECT Name FROM product";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
            while(rs.next()){
                box2.addItem(rs.getString("Name"));   
            }
             box2.setSelectedItem(null);
             txtproduct.setText(null);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
    
    /**
       This method selects product category from the database and adds it to the category comboBox
     */
    public void AddDataToCategory(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            String query = "SELECT Category FROM product_category";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
            while(rs.next()){
                box3.addItem(rs.getString("Category"));   
            }
             box3.setSelectedItem(null);
             txtcategory.setText(null);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnback = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        namelbl = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        lblmobile = new javax.swing.JLabel();
        mobiletxt = new javax.swing.JTextField();
        btnclear = new javax.swing.JButton();
        lbldistrict = new javax.swing.JLabel();
        txtdistrict = new javax.swing.JTextField();
        box1 = new javax.swing.JComboBox<>();
        lblproduct = new javax.swing.JLabel();
        txtproduct = new javax.swing.JTextField();
        box2 = new javax.swing.JComboBox<>();
        lblcategory = new javax.swing.JLabel();
        txtcategory = new javax.swing.JTextField();
        box3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add New Supplier");

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnsave.setBackground(new java.awt.Color(102, 255, 102));
        btnsave.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("Save");
        btnsave.setToolTipText("click to  add new products");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        namelbl.setText("Name");

        lblmobile.setText("Mobile");

        btnclear.setText("Clear All");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        lbldistrict.setText("District");

        box1.setToolTipText("Select Your District");
        box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1ActionPerformed(evt);
            }
        });

        lblproduct.setText("Product");

        box2.setToolTipText("Select Your Didtrict");
        box2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box2ActionPerformed(evt);
            }
        });

        lblcategory.setText("Category");

        box3.setToolTipText("Select Your Didtrict");
        box3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnback)
                        .addGap(12, 12, 12)
                        .addComponent(namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsave))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtcategory)
                                    .addComponent(txtproduct, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(box3, 0, 88, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(box2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblmobile, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(mobiletxt, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtdistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lblcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbldistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 72, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(btnclear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnback)
                        .addComponent(btnsave))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblmobile, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(mobiletxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(lbldistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnclear)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
      Handles the event when the "back" button is clicked.
      <p>This method is called when the user clicks the "back" button in the user interface.
      It returns the user to the Supplier List.</p>
      @param evt the ActionEvent object representing the event will occur occurred
     */
    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
         //calling the Supplier_Table form
        Supplier_Table supplier_table = new Supplier_Table();
        supplier_table.show();
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed
  /**
    Handles the event when the "save" button is clicked.
    <p>This method is called when the user clicks the "save" button in the user interface.
    It saves and submits the supplier data to the database once clicked.</p>
    @param evt the ActionEvent object representing the event will occur
  */
    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        //declaring and iniatializing variables:
        String s1 = nametxt.getText();
        String s2 = mobiletxt.getText();
        String s3 = txtproduct.getText();
        String s4 = txtcategory.getText();
        String s5 = txtdistrict.getText();
        try{
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            String query = "SELECT * FROM suplier where Name = '" + s1 + "'";
            ResultSet re1 = st.executeQuery(query);
            if(!s1.equals("") && !s2.equals("") && !s3.equals("") && !s4.equals("")){
                if(re1.next()){
                    JOptionPane.showMessageDialog(null, "Supplier name already exists");
                }
                else{
                    query = "INSERT INTO suplier(Name, Mobile, Product, Category, District) VALUES('" + s1 + "','" + s2 +"','" + s3 +"','" + s4 +"','" + s5 +"')";
                    st.executeUpdate(query);// savings
                    JOptionPane.showMessageDialog(null, "Supplier saved Successfully");
                    nametxt.setText("");//make empty
                    mobiletxt.setText("");//make empty
                    txtproduct.setText("");//make empty
                    txtcategory.setText("");//make empty
                    txtdistrict.setText("");//make empty
                    //set focus to txtname
                    nametxt.requestFocus();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "All fields must be filled");
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
    }//GEN-LAST:event_btnsaveActionPerformed
    /**
      Handles the event when the "clear" button is clicked.
      <p>This method is called when the user clicks the "clear" button in the user interface.
      It clears all  the data in the text fields:.</p>
      @param evt the ActionEvent object representing the event will occur occurred
     */
    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
      //clearing all text fields:
        nametxt.setText("");//make empty
        mobiletxt.setText("");//make empty
        txtproduct.setText("");//make empty
        txtcategory.setText("");//make empty
        txtdistrict.setText("");//make empty
        //set focus to txtname
        nametxt.requestFocus();
    }//GEN-LAST:event_btnclearActionPerformed
/**
  Handles the selection of an item in the JComboBox.
  @param evt is the ActionEvent object that trigger this method
 */
    private void box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1ActionPerformed
        // sets the data selected from the comboBox to the district text field:
        txtdistrict.setText((String) box1.getSelectedItem());

    }//GEN-LAST:event_box1ActionPerformed
/**
  Handles the selection of an item in the JComboBox.
  @param evt is the ActionEvent object that trigger this method
 */
    private void box2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box2ActionPerformed
        // setting the data selected from the comboBox to the product text field:
        txtproduct.setText((String) box2.getSelectedItem());

    }//GEN-LAST:event_box2ActionPerformed
/**
  Handles the selection of an item in the JComboBox.
  @param evt is the ActionEvent object that trigger this method
 */
    private void box3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box3ActionPerformed
        //setting the data selected from the comboBox to the category text field:
        txtcategory.setText((String) box3.getSelectedItem());
    }//GEN-LAST:event_box3ActionPerformed

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
            java.util.logging.Logger.getLogger(AddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddSupplier().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box1;
    private javax.swing.JComboBox<String> box2;
    private javax.swing.JComboBox<String> box3;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel lblcategory;
    private javax.swing.JLabel lbldistrict;
    private javax.swing.JLabel lblmobile;
    private javax.swing.JLabel lblproduct;
    private javax.swing.JTextField mobiletxt;
    private javax.swing.JLabel namelbl;
    private javax.swing.JTextField nametxt;
    private javax.swing.JTextField txtcategory;
    private javax.swing.JTextField txtdistrict;
    private javax.swing.JTextField txtproduct;
    // End of variables declaration//GEN-END:variables
}
