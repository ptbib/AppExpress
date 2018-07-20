package bib.Class;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joko Purwanto
 */
public class Session {

    private static String jLabel2;

    public static void setUserLogin(String jLabel2) {
        Session.jLabel2 = jLabel2;
    }

    public static String getUserLogin() {
        return jLabel2;
    }

}
