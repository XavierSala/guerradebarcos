package net.xaviersala.barcos;

import java.util.ArrayList;

public class Barco {
    ArrayList<String> posicions;
    
    public Barco(String[] posicions) {
        this.posicions = new ArrayList<String>();
        for(String posicio: posicions) {
            this.posicions.add(posicio);
        }
    }

    public boolean comprovaPosicio(String lloc) {
        
        int pesa = posicions.indexOf(lloc);
        
        if (pesa != -1) return true;
        return false;
    }
    
}
