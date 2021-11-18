package com.bridgelabz.DB;

import com.bridgelabz.UserDTO.UserDTO;
import com.bridgelabz.model.User;

import java.sql.*;

public class DBConnectionImp implements IDBConnection {

    static Connection con;
    static {
        try {
            // load and register class driver
            Class.forName("com.mysql.jdbc.Driver");
            // establish the connection between java application and database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginregistration", "root", "Mohammed@22");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    @Override
    public Connection DBConnection() {
        return con;
    }

    @Override
    public void register(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginregistration","root","Mohammed@22");

            if(con!=null) {
                System.out.println("connection established!!!!");
                System.out.println(con);
                PreparedStatement st;
                String query = "insert into members (firstName,lastName,userName,email,phone,password) values (?,?,?,?,?,?)";

                st = con.prepareStatement(query);
                st.setString(1, user.getFirstName());
                st.setString(2, user.getLastName());
                st.setString(3, user.getUserName());
                st.setString(4, user.getEmail());
                st.setString(5, user.getPhone());
                st.setString(6, user.getPassword());

                int i = st.executeUpdate();
                if (i > 0) {
                    System.out.println("Successfully Registered");
                }
            }else {
                System.out.println("not established!!!!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean login(User user) throws ClassNotFoundException {
        boolean value = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginregistration","root","Mohammed@22");
        if(con!=null) {
            System.out.println("connection established!!!!");
            System.out.println(con);
            PreparedStatement preparedStatement = con
                    .prepareStatement("select * from members where email = ? and password = ? ");
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, user.getPassword());

                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                value = rs.next();
        }else{System.out.println("not established!!!!");}
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public int forgotPassword(UserDTO user) {
        int k = 0;
        String email = user.getEmail();
        String pass = user.getPassword();
        String query0 = "select * from Members where email = ?";
        String query1 = "update Members set password =? where email = ?";
        try {
            PreparedStatement ps0 = con.prepareStatement(query0);
            PreparedStatement ps1 = con.prepareStatement(query1);

            ps0.setString(1, email);
            ps1.setString(1, pass);
            ps1.setString(2, email);
            ResultSet rs = ps0.executeQuery();
            if (rs.next()) {
                k = ps1.executeUpdate();
                System.out.println("Password Update");
            }
        } catch (SQLException e) {
            System.out.println("Password Update failed");
            e.printStackTrace();
        }
        return k;

    }

    @Override
    public void logOut() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean checkEmail(String email) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from Members  where email=?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
//                mailer.send(email, "validation mail", "http://localhost:8080/loginandRegistration/SetPassword.jsp");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
