package com.tap.gestiontorneo.Model.Strategy;

public class ValidarPassword implements Validaciones {
    @Override
    public boolean validar(String dato) {
        if (dato == null || dato.length() < 8) return false;

        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        String especiales = "!@#$%^&*()_+-={}[]:;\"'<>,.?/";

        for (char c : dato.toCharArray()) {
            if (Character.isDigit(c)) tieneNumero = true;
            if (especiales.indexOf(c) >= 0) tieneEspecial = true;
        }

        return tieneNumero && tieneEspecial;

    }
}
