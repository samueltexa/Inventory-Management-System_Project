/**
  The InternalFrame package provides classes deleting and editing data in the database.
  This includes classes for defining table structures, querying and modifying data in tables.
 */
package InternalFrames;
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
public class AddSupplier extends javax.swing.JInternalFrame {
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
     * Creates new form AddSupplier
     */
    public AddSupplier() {
        // Initializing the user interface components:
        initComponents();
        setLocation(150,30);
        con = null;
        st = null;
        cs = "jdbc:mysql://localhost:3306/inventorydatabase";
        user = "root";
        password = "";
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
            query = "SELECT Districts FROM location";
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
            Logger.getLogger(AddSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddSupplier.class.getName()).log(Level.SEVERE, null, ex);
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
            query = "SELECT Name FROM product";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
            while(rs.next()){
                box2.addItem(rs.getString("Name"));   
            }
             box2.setSelectedItem(null);
             txtproduct.setText(null);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AddSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddSupplier.class.getName()).log(Level.SEVERE, null, ex);
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
            query = "SELECT Category FROM product_category";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
            while(rs.next()){
                box3.addItem(rs.getString("Category"));   
            }
             box3.setSelectedItem(null);
             txtcategory.setText(null);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AddSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddSupplier.class.getName()).log(Level.SEVERE, null, ex);
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
        nametxt = new javax.swing.JTextField();
        lblmobile = new javax.swing.JLabel();
        mobiletxt = new javax.swing.JTextField();
        lblproduct = new javax.swing.JLabel();
        txtproduct = new javax.swing.JTextField();
        box2 = new javax.swing.JComboBox<>();
        lblcategory = new javax.swing.JLabel();
        txtcategory = new javax.swing.JTextField();
        box3 = new javax.swing.JComboBox<>();
        lbldistrict = new javax.swing.JLabel();
        txtdistrict = new javax.swing.JTextField();
        box1 = new javax.swing.JComboBox<>();
        btnsave = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Add New Suppliers");

        namelbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        namelbl.setText("Name");

        lblmobile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmobile.setText("Mobile");

        lblproduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblproduct.setText("Product");

        box2.setToolTipText("Select Your Didtrict");
        box2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box2ActionPerformed(evt);
            }
        });

        lblcategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcategory.setText("Category");

        box3.setToolTipText("Select Your Didtrict");
        box3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box3ActionPerformed(evt);
            }
        });

        lbldistrict.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldistrict.setText("District");

        box1.setToolTipText("Select Your District");
        box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1ActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldistrict, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtdistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblmobile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblproduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcategory)
                                    .addComponent(txtproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(box2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(mobiletxt, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsave)
                .addGap(190, 190, 190))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmobile, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobiletxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnsave)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void box2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box2ActionPerformed
        // setting the data selected from the comboBox to the product text field:
        txtproduct.setText((String) box2.getSelectedItem());
    }//GEN-LAST:event_box2ActionPerformed

    private void box3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box3ActionPerformed
        //setting the data selected from the comboBox to the category text field:
        txtcategory.setText((String) box3.getSelectedItem());
    }//GEN-LAST:event_box3ActionPerformed

    private void box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1ActionPerformed
        // sets the data selected from the comboBox to the district text field:
        txtdistrict.setText((String) box1.getSelectedItem());
    }//GEN-LAST:event_box1ActionPerformed

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
            query = "SELECT * FROM suplier where Name = '" + s1 + "'";
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box1;
    private javax.swing.JComboBox<String> box2;
    private javax.swing.JComboBox<String> box3;
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
