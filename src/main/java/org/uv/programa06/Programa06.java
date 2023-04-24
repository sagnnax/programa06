package org.uv.programa06;

/**
 *
 */
public class Programa06 {

    public static void main(String[] args) {

        DAOVenta dao = new DAOVenta();
        Venta venta = new Venta();

        venta.setClave(10);
        venta.setFecha("12/03/2029");
        venta.setMonto("Avenida 12");
        dao.create(venta);

        DAODetalleVenta daod = new DAODetalleVenta();
        DetalleVenta detventa = new DetalleVenta();

        detventa.setClaveProducto(20);
        detventa.setCantidad("100");
        detventa.setPrecio("$2000");
        detventa.setSubtotal("$2500");
        daod.create(detventa);

        System.out.println("Hello World!");
    }
}
