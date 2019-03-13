/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.LOencrypt;

/**
 *
 * @author Ramirez Ceron, Carlos Fabricio
 * @author Siguenza Figueroa, Jose Miguel
 */
public class cLogin {
    cAES objAES = new cAES();
    private static String[] Username = new String[]{"Mike03","Marvin13","Fabri23"};
    private static String[] Password = new String[]{"DpOarfZvyCmvyizHfO2Kxg==","1zzHXrN7w43e6r3fdfTyxA==","PIkZc121AuL6W0Dyp35HUg=="};
    private static String[] Name = new String[]{"Miguel Siguenza", "Marvin", "Fabricio Ramirez"};
    private static String UsuarioAdmin=null;
    
    public boolean Login(String User, String Pass){
        boolean Log = false;
        String Pass2=null;
        objAES.encrypt(Pass, "password");
        Pass2 = objAES.getTextEncr();
        for (int i = 0; i < Username.length ; i++) {
            if (User.equals(Username[i])&&Pass2.equals(Password[i])) {
                UsuarioAdmin=Name[i];
                Log = true;
            }
        }
       
        
        return Log;
    }

    public static String[] getUsername() {
        return Username;
    }

    public static void setUsername(String[] Username) {
        cLogin.Username = Username;
    }

    public static String[] getPassword() {
        return Password;
    }

    public static void setPassword(String[] Password) {
        cLogin.Password = Password;
    }

    public static String[] getName() {
        return Name;
    }

    public static void setName(String[] Name) {
        cLogin.Name = Name;
    }

    public static String getUsuarioAdmin() {
        return UsuarioAdmin;
    }

    public static void setUsuarioAdmin(String UsuarioAdmin) {
        cLogin.UsuarioAdmin = UsuarioAdmin;
    }
        
    
}
