package com.tap.gestiontorneo.Model.Strategy;

public class ValidarCorreo implements Validaciones {
    @Override
    public boolean validar(String dato) {
        if (dato == null || dato.isBlank()) return false;

        int atIndex = dato.indexOf("@");
        int lastAtIndex = dato.lastIndexOf("@");
        if (atIndex <= 0 || atIndex != lastAtIndex) return false;

        int dotIndex = dato.indexOf(".", atIndex);
        if (dotIndex <= atIndex + 1 || dotIndex == dato.length() - 1) return false;

        String invalidChars = " ,;:()[]{}<>|\\\"'!#%&/?";
        for (char c : invalidChars.toCharArray()) {
            if (dato.indexOf(c) >= 0) return false;
        }

        return true;
    }
}