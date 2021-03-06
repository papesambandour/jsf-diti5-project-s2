/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isi.diti5.service;


import com.isi.diti5.model.Vehicule;
import com.isi.diti5.utils.HibernateUtil;
import org.hibernate.Session;


import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @author mac
 */
@Stateless
public class VehiculeFacade extends AbstractFacade<Vehicule> implements VehiculeFacadeLocal {
    private Session session;
    @Override
    protected Session getSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        return session;
    }


    public VehiculeFacade() {
        super(Vehicule.class);
    }

    @Override
    public Vehicule getVoitureByNMatricule(String matricule) {
        List<Vehicule> vehiculeList=  getSession().createQuery("SELECT v from Vehicule v where v.matricule  = :mat").setParameter("mat",matricule).list();
        if(vehiculeList.size() > 0)
        {
            return  vehiculeList.get(0);
        }
        return null;
    }
}
