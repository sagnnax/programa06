/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa06;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 */
public class DAODetalleVenta implements IDAOGeneral<DetalleVenta, Long> {

    @Override
    public DetalleVenta create(DetalleVenta p) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();

            session.save(p);
            Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.INFO, "Se guardo el detalle");
            t.commit();
        }
        return p;
    }

    @Override
    public boolean delete(Long id) {
        boolean res;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            res = false;
            DetalleVenta detventa = findById(id);
            if (detventa == null)
                res = false;
            else {
                session.delete(detventa);
                res = true;
            }
            t.commit();
        }
        return res;

    }

    @Override
    public DetalleVenta update(DetalleVenta p, Long id) {
        DetalleVenta detventa;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            detventa = findById(id);
            if (detventa == null)
                session.update(detventa);
            t.commit();
        }
        return detventa;

    }

    @Override
    public List<DetalleVenta> findAll() {
        List<DetalleVenta> lstRes = null;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            lstRes = session.createQuery("from empleado").list();
            t.commit();
        }
        return lstRes;

    }

    @Override
    public DetalleVenta findById(Long id) {
        DetalleVenta detventa = null;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            detventa = session.get(DetalleVenta.class, id);
            t.commit();
        }
        return detventa;

    }

}
