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
public class DAOVenta implements IDAOGeneral<Venta, Long> {

    @Override
    public Venta create(Venta p) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();

            session.save(p);
            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se guardo la venta");
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
            Venta venta = findById(id);
            if (venta == null)
                res = false;
            else {
                session.delete(venta);
                res = true;
            }
            t.commit();
        }
        return res;
    }

    @Override
    public Venta update(Venta p, Long id) {
        Venta venta;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            venta = findById(id);
            if (venta == null)
                session.update(venta);
            t.commit();
        }
        return venta;
    }

    @Override
    public List<Venta> findAll() {
        List<Venta> lstRes = null;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            lstRes = session.createQuery("from empleado").list();
            t.commit();
        }
        return lstRes;
    }

    @Override
    public Venta findById(Long id) {
        Venta venta = null;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            venta = session.get(Venta.class, id);
            t.commit();
        }
        return venta;
    }

}
