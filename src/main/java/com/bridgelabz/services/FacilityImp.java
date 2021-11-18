package com.bridgelabz.services;

import com.bridgelabz.DB.DBConnectionImp;
import com.bridgelabz.DB.IDBConnection;
import com.bridgelabz.UserDTO.UserDTO;
import com.bridgelabz.model.User;

public class FacilityImp implements Ifacility {

    IDBConnection obj = new DBConnectionImp();

    @Override
    public void dtomodelMapping(UserDTO userDTO) {

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setPassword(userDTO.getPassword());

        obj.register(user);
    }

}
