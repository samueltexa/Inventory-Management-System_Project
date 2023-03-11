/**
  The Tables package provides classes for creating and manipulating tables of data.
  This includes classes for defining table structures, inserting and deleting rows and columns, 
  and querying and modifying data in tables.
 */
package Tables;
import MainFrames.AddCustomer;
import MainFrames.Menu;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.raven.datechooser.DateChooser;
import java.text.SimpleDateFormat;
/**
  The Sales_Table class represents a graphical user interface for displaying sales data in a table format.
  It extends the javax.swing.JFrame class to create a window for displaying the data.
  This class includes methods for setting up the table, adding data to it, and updating the view.
  <p>This class is designed to be used in conjunction with a database system that stores sales data.</p>
  @author woola
 */
public final class Sales_Table extends javax.swing.JFrame {
    //Declaring Variables

    /**
     *
     */
    DateChooser datechooser = new DateChooser();

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
     Constructs a new Sales_Table object and initializes the user interface components.
     */
    public Sales_Table() {
        // Initializing the user interface components
        con = null;
        st = null;
        cs = "jdbc:mysql://localhost:3306/inventorydatabase";
        user = "root";
        password = "";
        initComponents();
        AddDataToCustomer();
        AddDataToProduct();
        AddDataToPrice();
        AddDataToAddress();
        datechooser.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
        datechooser.setTextField(txtdate); 
    }
     /**
      Loads data from a database and adds it to the customer name comboBox.
     */
     public void AddDataToCustomer(){
        // Connect to the database and execute a query to retrieve customer names.
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            String query = "SELECT Name FROM customer";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
            // Iterate over the result set and add items to the comboBox
            while(rs.next()){
                box.addItem(rs.getString("Name"));   
            }
             box.setSelectedItem(null);
             txtname.setText(null);
        }
        catch (SQLException | ClassNotFoundException ex){
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
      Loads data from a database and adds it to the product comboBox.
     */
     public void AddDataToProduct(){
         // Connect to the database and execute a query to retrieve product names.
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            String query = "SELECT Name FROM product";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
            // Iterate over the result set and add items to the comboBox
            while(rs.next()){
                box1.addItem(rs.getString("Name"));   
            }
             box1.setSelectedItem(null);
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
      Loads data from a database and adds it to the price name comboBox.
     */
     public void AddDataToPrice(){
         // Connect to the database and execute a query to retrieve product prices.
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            String query = "SELECT Price FROM product";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
            // Iterate over the result set and add items to the comboBox
            while(rs.next()){
                box2.addItem(rs.getString("Price"));   
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
      Loads data from a database and adds it to the address comboBox.
     */
     public void AddDataToAddress(){
         // Connect to the database and execute a query to retrieve location address.
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            con = DriverManager.getConnection(cs, user, password);
            String query = "SELECT Address FROM customer";
            st = con.createStatement();           
            statement = con.prepareStatement(query);
            rs = st.executeQuery(query);
            // Iterate over the result set and add items to the comboBox
            while(rs.next()){
                box3.addItem(rs.getString("Address"));   
            }
             box3.setSelectedItem(null);
             txtproduct.setText(null);
        }
        catch (SQLException | ClassNotFoundException ex) {
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

        namelbl = new javax.swing.JLabel();
        lbladdress = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        btndelete = new javax.swing.JButton();
        btnconfirmsale = new javax.swing.JButton();
        lblproduct = new javax.swing.JLabel();
        quantitylbl = new javax.swing.JLabel();
        txtquantity = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        box = new javax.swing.JComboBox<>();
        txtproduct = new javax.swing.JTextField();
        box1 = new javax.swing.JComboBox<>();
        txtaddress = new javax.swing.JTextField();
        box3 = new javax.swing.JComboBox<>();
        lblprice = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        box2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        salestable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnaddsale = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        lbltotal = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        lbldate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        lbllocation = new javax.swing.JLabel();
        lblcontactinfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Make A Sale");

        namelbl.setText("Customer Name");

        lbladdress.setText("Address");

        btnback.setText("Back");
        btnback.setToolTipText("Back to menu");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btndelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 0, 0));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnconfirmsale.setText("Confirm Sale");
        btnconfirmsale.setToolTipText("confirm sale");

        lblproduct.setText("Product");

        quantitylbl.setText("Quantity");

        txtquantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtquantityActionPerformed(evt);
            }
        });

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        box.setToolTipText("Select customer name");
        box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxActionPerformed(evt);
            }
        });

        txtproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproductActionPerformed(evt);
            }
        });

        box1.setToolTipText("Select Your Didtrict");
        box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1ActionPerformed(evt);
            }
        });

        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });

        box3.setToolTipText("Select customer Didtrict/ Address");
        box3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box3ActionPerformed(evt);
            }
        });

        lblprice.setText("Rate");

        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });

        box2.setToolTipText("Select Your Didtrict");
        box2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box2ActionPerformed(evt);
            }
        });

        salestable.setForeground(new java.awt.Color(0, 0, 204));
        salestable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantity", "Product", "Rate", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salestable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salestableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(salestable);

        jLabel1.setText("Mr/Mrs:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tell:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Address:");

        btnaddsale.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnaddsale.setForeground(new java.awt.Color(0, 255, 0));
        btnaddsale.setText("Add Sale");
        btnaddsale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddsaleActionPerformed(evt);
            }
        });

        btnedit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnedit.setForeground(new java.awt.Color(0, 0, 204));
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        lbltotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltotal.setForeground(new java.awt.Color(0, 204, 204));
        lbltotal.setText("Total Amount");

        lbldate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldate.setForeground(new java.awt.Color(0, 0, 255));
        lbldate.setText("DATE");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("RECIEPT");

        lbltitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltitle.setText("M & J MULTIPURPOSE ENTERPRISES LTD");

        lbllocation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbllocation.setText("PURSE STREET OPPOSITE LORRY PARK, PO.BOX 229, HOIMA");

        lblcontactinfo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblcontactinfo.setText("TELL: 0771172559/ 0706629737         EMAIL: woolardsamuesl@gmail.com");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnconfirmsale))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(quantitylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtquantity)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbladdress, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblproduct)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnaddsale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btndelete)))
                .addGap(23, 23, 23)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(lbltotal)
                                .addGap(18, 18, 18)
                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblcontactinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtaddress)
                                                    .addComponent(txtname))
                                                .addGap(138, 138, 138)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(105, 105, 105))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(31, 31, 31)
                                                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(42, 42, 42)))))))))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(lbllocation, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(lbltitle)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconfirmsale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbltitle)
                        .addGap(11, 11, 11)
                        .addComponent(lbllocation, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblcontactinfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txttotal, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                .addGap(17, 17, 17))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbladdress, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(lblproduct)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(quantitylbl)
                        .addGap(18, 18, 18)
                        .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblprice, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprice, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btndelete)
                            .addComponent(btnaddsale)
                            .addComponent(btnedit))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
  Handles the event when the "back" button is clicked.
  <p>This method is called when the user clicks the "back" button in the user interface.
  It returns the user to the previous screen or view.</p>
  @param evt the ActionEvent object representing the event will occur occurred
 */
    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        //calling the menue frame
        Menu menu = new Menu();
        menu.show();
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed
/**
  Handles the selection of an item in the JComboBox.
  @param evt is the ActionEvent object that trigger this method
 */
    private void boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxActionPerformed
         //seting the data in the comboBox to the name texField:
        txtname.setText((String) box.getSelectedItem());

    }//GEN-LAST:event_boxActionPerformed
/**
  Handles the selection of an item in the JComboBox.
  @param evt is the ActionEvent object that trigger this method
 */
    private void box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1ActionPerformed
        //seting the data in the comboBox to the roduct texField:
         txtproduct.setText((String) box1.getSelectedItem());
    }//GEN-LAST:event_box1ActionPerformed
/**
  Handles the selection of an item in the JComboBox.
  @param evt is the ActionEvent object that trigger this method
 */
    private void box3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box3ActionPerformed
        //seting the data in the comboBox to the Address texField:
        txtaddress.setText((String) box3.getSelectedItem());
    }//GEN-LAST:event_box3ActionPerformed
   /**
    Handles the selection of an item in the JComboBox.
    @param evt is the ActionEvent object that trigger this method
   */
    private void box2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box2ActionPerformed
        //seting the data in the comboBox to the Price texField:
        txtprice.setText((String) box2.getSelectedItem());
    }//GEN-LAST:event_box2ActionPerformed
    
    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressActionPerformed

    private void txtproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproductActionPerformed

    private void txtquantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtquantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtquantityActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
/**
  Handles the event when the "delete" button is clicked.
  <p>This method is called when the user clicks the "delete" button in the user interface.
  It deletes a selected row in the table once clicked.</p>
  @param evt the ActionEvent object representing the event will occur occurred
 */
    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        //getting jtable model
        DefaultTableModel model = (DefaultTableModel)salestable.getModel();
        //delete data
        if(salestable.getSelectedRowCount()== 1){
            //if row is selected
            model.removeRow(salestable.getSelectedRow());
        }
        else{
            if(salestable.getSelectedRowCount() == 0){
            //if table is empty
            JOptionPane.showMessageDialog(this, "Table is empty");
            }
            else{
                //if table is not empty but nothing is selected
                 JOptionPane.showMessageDialog(this, "Please select a single row!");
            }
        }
    }//GEN-LAST:event_btndeleteActionPerformed
/**
  Handles the event when the "addSale" button is clicked.
  <p>This method is called when the user clicks the "addSale" button in the user interface.
  It adds a row in the table once clicked.</p>
  @param evt the ActionEvent object representing the event will occur occurred
 */
    private void btnaddsaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddsaleActionPerformed
        if(!txtquantity.getText().equals("") && !txtprice.getText().equals("")){
        int quantity = Integer.parseInt(txtquantity.getText());
        int price = Integer.parseInt(txtprice.getText());
        DefaultTableModel model = (DefaultTableModel)salestable.getModel();
        model.addRow(new Object[]{txtquantity.getText(), txtproduct.getText(),
                                  txtprice.getText(), Integer.toString(price * quantity)});
        txtproduct.setText("");//making empty
        txtquantity.setText("");//making empty
        txtprice.setText("");//making field empty
        //setting focus to txtquantity
        txtproduct.requestFocus();
        //
        double sum = 0;
        for (int i = 0; i< salestable.getRowCount(); i++){
            int amount = Integer.parseInt((String)salestable.getValueAt(i, 3));
            sum+=amount;
        }
    txttotal.setText(String.valueOf(sum));
        }else{
            JOptionPane.showMessageDialog(null, "Please enter quantity, product and rate");
        }
    }//GEN-LAST:event_btnaddsaleActionPerformed
    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed
/**
  Handles the event when the "adit" button is clicked.
  <p>This method is called when the user clicks the "edit" button in the user interface.
  It edits and updates elements in a selected row in the table once clicked.</p>
  @param evt the ActionEvent object representing the event will occur occurred
 */
    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        //getting table model
        DefaultTableModel model = (DefaultTableModel)salestable.getModel();
         //delete data
        if(salestable.getSelectedRowCount()== 1){
            //if row is selected
            String mytable0 = txtquantity.getText();
            String mytable1 = txtproduct.getText();
            String mytable2 = txtprice.getText();
            
            //setting update values on the tables
            model.setValueAt(mytable0, salestable.getSelectedRow(), 0);
            model.setValueAt(mytable1, salestable.getSelectedRow(), 1);
            model.setValueAt(mytable2, salestable.getSelectedRow(), 2);
        }
        else{
            if(salestable.getSelectedRowCount() == 0){
            //if table is empty
            JOptionPane.showMessageDialog(this, "Table is empty");
            }
            else{
                //if table is not empty but nothing is selected
                 JOptionPane.showMessageDialog(this, "Please select a single row!");
            }
        } 
    }//GEN-LAST:event_btneditActionPerformed
/**
 Handles the event when a row in the sales table is clicked.
 <p>This method is called when the user clicks on a row in the sales table.
 It retrieves the data for the selected row and displays it in respective text fields.</p>
 @param evt the MouseEvent object represent the event that occur
 */
    private void salestableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salestableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)salestable.getModel();
        //seeting data to textfiled when row is selected
        String mytable0 = model.getValueAt(salestable.getSelectedRow(), 0).toString();
        String mytable1 = model.getValueAt(salestable.getSelectedRow(), 1).toString();
        String mytable2 = model.getValueAt(salestable.getSelectedRow(), 2).toString();
        //setting to textfield
        txtquantity.setText(mytable0);
        txtproduct.setText(mytable1);
        txtprice.setText(mytable2);
    }//GEN-LAST:event_salestableMouseClicked

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    /**
        The main entry point for the Sales_Table application.
        <p>This method is the entry point for the Sales_Table application.
        It initializes the application and creates the main user interface window.</p>
         @param args the command line arguments
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
            java.util.logging.Logger.getLogger(Sales_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Sales_Table().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box;
    private javax.swing.JComboBox<String> box1;
    private javax.swing.JComboBox<String> box2;
    private javax.swing.JComboBox<String> box3;
    private javax.swing.JButton btnaddsale;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnconfirmsale;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbladdress;
    private javax.swing.JLabel lblcontactinfo;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbllocation;
    private javax.swing.JLabel lblprice;
    private javax.swing.JLabel lblproduct;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JLabel namelbl;
    private javax.swing.JLabel quantitylbl;
    private javax.swing.JTable salestable;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtproduct;
    private javax.swing.JTextField txtquantity;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
