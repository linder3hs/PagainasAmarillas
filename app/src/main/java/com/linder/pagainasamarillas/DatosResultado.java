package com.linder.pagainasamarillas;

/**
 * Created by linderhassinger on 9/20/17.
 */

public class DatosResultado {
    private String nameEmpresa;
    private String direccion;
    private String lugar;
    private int imagen;
    private String numero;

    public DatosResultado(String nameEmpresa, String direccion, String lugar, String numero, int imagen) {
        this.nameEmpresa = nameEmpresa;
        this.direccion = direccion;
        this.lugar = lugar;
        this.numero = numero;
        this.imagen = imagen;

    }



    public String getNameEmpresa() {
        return nameEmpresa;
    }

    public void setNameEmpresa(String nameEmpresa) {
        this.nameEmpresa = nameEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "DatosResultado{" +
                "nameEmpresa='" + nameEmpresa + '\'' +
                ", direccion='" + direccion + '\'' +
                ", lugar='" + lugar + '\'' +
                ", imagen=" + imagen +
                ", numero='" + numero + '\'' +
                '}';
    }
}
