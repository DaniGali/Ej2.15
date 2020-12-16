package jesuitas.dam.ej215;

import android.graphics.drawable.Drawable;

public class Peliculas {

    String mnombre;
    String mgenero;
    int mimagen;
    String murl;


    public Peliculas(String nombre, String genero, int descarga, String url) {
       mnombre=nombre;
        mgenero=genero;
        mimagen=descarga;
        murl=url;
    }
}
