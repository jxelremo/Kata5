package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        //Class.forName("org.sqlite.JDBC");
        //Connection conec = DriverManager.getConnection("jdbc:sqlite:DDBBKATA");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conec = DriverManager.getConnection("jdbc:oracle:thin:@10.0.2.15:1521:orcl","system","orcl");
        Statement state = conec.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM PEOPLE");
        
        while(rs.next()) {
            System.out.println("ID = "+rs.getInt("ID"));
            System.out.println("NAME = "+rs.getString("NAME"));
        }
        
        String nameFile ="C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata5\\emailsfilev1.txt";
        BufferedReader reader = new BufferedReader (new FileReader(new File(nameFile)));
        String mail;
        
        /*
        while((mail=reader.readLine())!=null){
            String query ="INSERT INTO MAIL (MAIL) VALUES ('"+mail+"')";
            state.executeUpdate(query);
        }*/
        
        rs.close();
        state.close();
        conec.close();
    }
}