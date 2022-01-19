/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekammedis;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JTable;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

/**
 *
 * @author Chris
 */
public class HomeUser extends javax.swing.JFrame {
    String user ="root";
    String pwd ="";
    String url = "jdbc:mysql://localhost/rekap_medis";

    /**
     * Creates new form HomeUser
     */
    public HomeUser() {
        initComponents();
        setLocationRelativeTo(null);
        id.setVisible(false);
    }
    
    private Object[][]getData(){
        Object[][]data1=null;
        try{
            Connection conn = DriverManager.getConnection(url,user,pwd);
            Statement st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery("Select tgl_input,diagnosis,status_pasien,no_kamar from rekam_medis where id_user='"+id.getText().trim()+"'");
            rs.last();
            int rowCount=rs.getRow();
            rs.beforeFirst();
            data1=new Object[rowCount][4];
            int no=-1;
        
        while(rs.next()){
        no=no+1;
//        data1[no][0]=rs.getString("id");
        data1[no][0]=rs.getString("tgl_input");
        data1[no][1]=rs.getString("diagnosis");
        data1[no][2]=rs.getString("status_pasien");
        data1[no][3]=rs.getString("no_kamar");
        }
    } catch(SQLException e){
        System.out.println("Koneksi gagal"+e.toString());
}
        return data1;
    }
    void tampil(){
        String[] columnNames = {"tgl_input", "diagnosis", "status_pasien", "no_kamar"};
        JTable table=new JTable (getData(),columnNames);
        table.setEnabled(false);
        jScrollPane2.setViewportView(table);
    }

    /*void isiId(){
        try{
            Connection conn = DriverManager.getConnection(url,user,pwd);
            Statement st = (Statement) conn.createStatement();
            String sql = "Select * from user";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                cbID.addItem(rs.getString("id_user"));
            }
        }
        catch (Exception e) {
            System.out.println("Koneksi Gagal isiId" + e.toString());
        }
    }*/
    
    void cari(){
        try{
            Connection conn = DriverManager.getConnection(url,user,pwd);
            Statement st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from user where id_user='"+id.getText().trim()+"'");
            if (rs.next()){
                txtNama.setText(rs.getString("nama"));
                cbGender.setSelectedItem(rs.getString("gender"));
                txtAlamat.setText(rs.getString("alamat"));
                txtEmail.setText(rs.getString("email"));
                txtHP.setText(rs.getString("no_hp"));
            }
            else{
                JOptionPane.showMessageDialog(this,"Data tidak ditemukan","info",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch(SQLException e){
            System.out.println("Koneksi Gagal"+e.toString());
        }
    }
    void bersih(){
        txtNama.setText("");
        txtAlamat.setText("");
        txtEmail.setText("");
        txtHP.setText("");
        
    }
     void update(){
        try{
            Connection conn = DriverManager.getConnection(url,user,pwd);
            Statement st = (Statement) conn.createStatement();
            
            String sql = "update user set nama='"+txtNama.getText()+"',gender='"+cbGender.getSelectedItem()+"',alamat='"+txtAlamat.getText()+"',no_hp='"+txtHP.getText()+"'"+"where id_user='"+id.getText().trim()+"'";
            
            st.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(this,"Data berhasil diupdate","info",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException e){
            System.out.println("Koneksi gagal"+e.toString());
        }
        formWindowActivated(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtNama = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        cbGender = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();
        txtHP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(1, 151, 202));
        jPanel1.setLayout(null);

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNama);
        txtNama.setBounds(120, 70, 640, 24);

        txtAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatActionPerformed(evt);
            }
        });
        jPanel1.add(txtAlamat);
        txtAlamat.setBounds(120, 160, 640, 24);

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "P", "L" }));
        jPanel1.add(cbGender);
        cbGender.setBounds(120, 110, 50, 26);
        jPanel1.add(txtEmail);
        txtEmail.setBounds(120, 200, 640, 24);

        txtHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHPActionPerformed(evt);
            }
        });
        jPanel1.add(txtHP);
        txtHP.setBounds(120, 240, 640, 24);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Home User");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(360, 20, 119, 29);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rekammedis/edit.png"))); // NOI18N
        btnEdit.setText("Update");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);
        btnEdit.setBounds(30, 290, 370, 60);

        jLabel2.setText("Nama Pasien");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 70, 90, 16);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rekammedis/multiply.png"))); // NOI18N
        btnCancel.setText("Clear");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel);
        btnCancel.setBounds(423, 290, 340, 60);

        jLabel3.setText("Gender");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 110, 60, 16);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 470, 767, 223);

        jLabel4.setText("Alamat");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 160, 70, 16);

        jLabel5.setText("Email");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 200, 90, 16);
        jPanel1.add(id);
        id.setBounds(710, 410, 14, 24);

        jLabel6.setText("No.HP");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 240, 60, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHPActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
     update();
    }//GEN-LAST:event_btnEditActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        tampil();
        cari();
    }//GEN-LAST:event_formWindowActivated

    private void txtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
       bersih();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(HomeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cbGender;
    public static javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHP;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}