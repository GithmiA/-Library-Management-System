package controller;

public class logincontroller {

    public static boolean nameandpasswordcheck(String name, String password) {
        if(name.equals("githmi") && password.equals("1234")){
            return true;
        }
        return  false;
    }
}
