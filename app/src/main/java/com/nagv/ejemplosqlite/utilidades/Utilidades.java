package com.nagv.ejemplosqlite.utilidades;

public class Utilidades {

   //Constantes campos producto
   public static final String TABLA_PRODUCTO="tb_productos";
   public static final String CAMPO_CODIGO="codigoProducto";
   public static final String CAMPO_DESCRIPCION="descrpcion";
   public static final String CAMPO_PRECIO="precio";

   public static final String CREAR_TABLA_PRODUCTO="CREATE TABLE "+
           ""+TABLA_PRODUCTO+" ("+CAMPO_CODIGO+""+
           "int, "+CAMPO_DESCRIPCION+" text, "+CAMPO_PRECIO+" real )";
}
