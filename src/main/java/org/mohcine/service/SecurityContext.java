package org.mohcine.service;

public class SecurityContext {
    private static String username="";
    private static String password="";
    private static String[] roles= {};
    public static void authenticate(String u, String p, String[] r){
        if(u.equals("root") && p.equals("1234")){
            username=u;
            password=p;
            roles=r;
        }
        else {
            throw new RuntimeException("Accees Denied");
        }
    }
    public static boolean hasRole(String r){
        for (String role:roles){
            if(role.equals(r))
                return true;
        }
        return false;
    }

}

