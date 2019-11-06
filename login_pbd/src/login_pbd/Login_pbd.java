/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_pbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author YOGI
 */

public class Login_pbd {
    public static String sql;//
    public static String user, username, pass, password;
     public static Connection conn;
    public static Statement stm;
    public static void koneksi(String args[]){
        try{
            String url = "jdbc:mysql://localhost/login_pbd";
            String user="root";
            String pass="arema1987654321";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pass);
            stm = conn.createStatement();
            System.out.println("Koneksi Berhasil");
            
        }catch(Exception e){
            System.err.println("koneksi gagal"+e.getMessage());
        }
    }
    

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
         
         JOptionPane.showMessageDialog(null, "anda memasuki ruang angkasa");
        JOptionPane.showMessageDialog(null, "silakan registrasi ");
         user = JOptionPane.showInputDialog("masukan nama user anda :");
         pass = JOptionPane.showInputDialog("masukan password anda :");
         String sql = "INSERT INTO login (userrname, password) VALUE('%s', '%s')";
        sql = String.format(sql,user , pass);
      
        
        JOptionPane.showMessageDialog(null, "akun telah terdaftar");
        JOptionPane.showMessageDialog(null, "silakan LOGIN");
        login();
        System.exit(0);
       
    }
        
        public static void login(){
        
        JOptionPane.showMessageDialog(null, "Hello, ini adalah halaman login, klik ok!");
        String inputan = JOptionPane.showInputDialog(null,"masukan pilihanmu "
                + "1. login "
                + "2. keluar");
        switch(inputan){
            case "1" : 
               String username = JOptionPane.showInputDialog("masukan username :");
               String password = JOptionPane.showInputDialog("masukan password");
               if (username.equals(user)&&password.equals(pass)){
                   JOptionPane.showMessageDialog(null, "login berhasil!!");
               }else{
                   JOptionPane.showMessageDialog(null, "login gagal!!");
                   JOptionPane.showMessageDialog(null, "masukan username atau password dengan benar!!");
                   login();
               }
               
               break;
            case "2":
                JOptionPane.showMessageDialog(null, "terimakasih");
                System.exit(0);
            break;
            default :
                JOptionPane.showMessageDialog(null, "masukan angka yang benar!");
              
                
        }
        
}
}

