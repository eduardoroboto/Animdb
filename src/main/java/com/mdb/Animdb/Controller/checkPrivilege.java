package com.mdb.Animdb.Controller;

import com.mdb.Animdb.model.users.ADM;
import com.mdb.Animdb.model.users.User;
import com.mdb.Animdb.model.users.Usuario;


public class checkPrivilege {

    public boolean checkAdmin(User user) {

            if (user instanceof ADM) {
                return true;
            } else {
                return false;
            }
    }

    public boolean checkUsuario(User user) {

        if (user instanceof Usuario) {
            return true;
        } else {
            return false;
        }
    }

}