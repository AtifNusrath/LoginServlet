package com.bridgelabz.DB;

import com.bridgelabz.model.User;
import com.bridgelabz.UserDTO.UserDTO;

import java.sql.Connection;

public interface IDBConnection {
    public Connection DBConnection();
    void register(User user);
    int forgotPassword(UserDTO user);
    void logOut();
    boolean login(User user) throws ClassNotFoundException;
    boolean checkEmail(String email);
}
