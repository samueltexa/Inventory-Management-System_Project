/**
  The InternalFrame package provides classes deleting and editing data in the database.
  This includes classes for defining table structures, querying and modifying data in tables.
 */
package InternalFrames;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

 /**
    The EditProduct class extends the javax.swing.JFrame class to provide
    a GUI window for editing  products information in the database.
    The EditProduct class includes the following components:
    A lblName for displaying the product name field label.
    A txtPrice and lblPrice for entering and displaying the product price respectively.
    A lblCategory for displaying the product category field label.
    A lblQuantity for displaying the product quantity field label.
    A btnSave for saving and  submitting the product information.
    A btnClear for clearing all the text fields.
    The AddProducts class also includes methods for setting and getting
    the product name and address, as well as for submitting the updated product information to a database.
    @author woola
     */
public final class EditProduct extends javax.swing.JInternalFrame {
    /**
     Declaring connection Variable
     */
    Connection con;
    /**
     Declaring Prepared statement Variable
     */
    PreparedStatement statement;
    /**
     Declaring statement Variable
     */
    Statement st;
    /**
     Declaring local host Variable
     */
    String cs;
    /**
     Declaring connection user Variable
     */
    String user;
    /**
     Declaring connection password Variable
     */
    String password;
    /**
     Declaring MySQL query Variable
     */
    String query;
    /**
     Declaring result Variable
     */
    ResultSet rs;
    /**
     Declaring count Variable
     */
    int count = 0;

    /**
     * Creates new form AddProduct
     */
    public EditProduct() {
        // Initializing the user interface components:
        initComponents();    
        setLocation(150,50);
        con = null;
        st = null;
        cs = "jdbc:mysql://localhost:3306/inventorydatabase";
        user = "root";
        password = "";
        AddDataToSupplier();
        AddDataToCategory();
        
    }
        /**
     This loads supplier name from the database and adds it to the supplier comboBox
     */
    public void AddDataToSupplier(){
        // Connect to the database and execute a query to add products:
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            query = "SELECT Name FROM suplier";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
             // Iterate over the result set and add items to the comboBox
            while(rs.next()){
                box1.addItem(rs.getString("Name"));   
            }
             box1.setSelectedItem(null);
             txtsupplier.setText(null);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
      This loads product category from the database and adds it to the category comboBox
     */
    public void AddDataToCategory(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            query = "SELECT Category FROM product_category";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
            while(rs.next()){
                box2.addItem(rs.getString("Category"));   
            }
             box2.setSelectedItem(null);
             txtcategory.setText(null);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
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

        namelbl = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        pricelbl = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        numberlbl = new javax.swing.JLabel();
        txtnumber = new javax.swing.JTextField();
        lblcategory = new javax.swing.JLabel();
        txtcategory = new javax.swing.JTextField();
        box2 = new javax.swing.JComboBox<>();
        lblquantity = new javax.swing.JLabel();
        txtquantity = new javax.swing.JTextField();
        lbldistrict = new javax.swing.JLabel();
        txtsupplier = new javax.swing.JTextField();
        box1 = new javax.swing.JComboBox<>();
        btnsave = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Edit Product");

        namelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        namelbl.setText("Name");

        pricelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pricelbl.setText("Price");

        numberlbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numberlbl.setText("Number");

        txtnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumberActionPerformed(evt);
            }
        });

        lblcategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcategory.setText("Category");

        box2.setToolTipText("Select Your Didtrict");
        box2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box2ActionPerformed(evt);
            }
        });

        lblquantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblquantity.setText("Quantity");

        txtquantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtquantityActionPerformed(evt);
            }
        });

        lbldistrict.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldistrict.setText("Supplier");

        box1.setToolTipText("Select Your Didtrict");
        box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1ActionPerformed(evt);
            }
        });

        btnsave.setBackground(new java.awt.Color(102, 255, 102));
        btnsave.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("Update");
        btnsave.setToolTipText("click to update product");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(numberlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pricelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbldistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtsupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsave)
                .addGap(187, 187, 187))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pricelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsupplier)
                    .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsave)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumberActionPerformed
  /**
      Handles the event when the "comboBox for category"  is clicked.
      <p>This method is called when the user clicks the "comboBox"  in the user interface.
      It loads and displays the product categories below within it from the database.</p>
      @param evt the ActionEvent object represent the event that will occur
     */
    private void box2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box2ActionPerformed
        //sets the data from the comboBox to the category tex field:
        txtcategory.setText((String) box2.getSelectedItem());
    }//GEN-LAST:event_box2ActionPerformed
 /**
      Handles the event when the "comboBox for supplier"  is clicked.
      <p>This method is called when the user clicks the "comboBox"  in the user interface.
      It loads and displays the supplier name below within it from the database.</p>
      @param evt the ActionEvent object represent the event that will occur
     */
    private void box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1ActionPerformed
        //sets the data selected from the combo box to the supplier tex field:
        txtsupplier.setText((String) box1.getSelectedItem());
    }//GEN-LAST:event_box1ActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        try{
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            query = "update product set Name ='" + txtname.getText() + "', Price ='" + txtprice.getText() + "', Number ='" + txtnumber.getText() + "', Category ='" + txtcategory.getText() + "', Quantity ='" + txtquantity.getText() + "', Supplier ='" + txtsupplier.getText() + "'";
            int success = st.executeUpdate(query);
            if(success == 1){
                JOptionPane.showMessageDialog(null, " Record Updated Succefully.");   
            }
            else{
                JOptionPane.showMessageDialog(null, "The product could not be updateds");
            }
            txtname.setText("");
            txtprice.setText("");
            txtnumber.setText("");
            txtcategory.setText("");
            txtquantity.setText("");
            txtsupplier.setText("");
            txtname.requestFocus(); //set focus to txtregno
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

    private void txtquantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtquantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtquantityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box1;
    private javax.swing.JComboBox<String> box2;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel lblcategory;
    private javax.swing.JLabel lbldistrict;
    private javax.swing.JLabel lblquantity;
    private javax.swing.JLabel namelbl;
    private javax.swing.JLabel numberlbl;
    private javax.swing.JLabel pricelbl;
    public javax.swing.JTextField txtcategory;
    public javax.swing.JTextField txtname;
    public javax.swing.JTextField txtnumber;
    public javax.swing.JTextField txtprice;
    public javax.swing.JTextField txtquantity;
    public javax.swing.JTextField txtsupplier;
    // End of variables declaration//GEN-END:variables
}
