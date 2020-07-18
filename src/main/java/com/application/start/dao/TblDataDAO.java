package com.application.start.dao;

import com.application.start.entity.TblData;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


@Repository
@Transactional
public class TblDataDAO implements TblDataAPIInterface{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TblData> getAllRecords() {
        Session session=sessionFactory.getCurrentSession();
        List<TblData> tblDataList=session.createQuery("from TblData",TblData.class).getResultList();
        return tblDataList;
    }

    @Override
    public List<TblData> getNRecords(int page, int n) {
        Session session=sessionFactory.getCurrentSession();
        List<TblData> tblDataList=session.createQuery("from TblData where id>=:id",TblData.class)
                .setParameter("id",(page-1)*n)
                .setMaxResults(n)
                .getResultList();
        return tblDataList;
    }

    @Override
    public TblData getRecordById(int id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(TblData.class,id);
    }

    @Override
    public TblData updateRecordById(int id, TblData tblData) {
        Session session=sessionFactory.getCurrentSession();
        TblData tblDataActual=session.get(TblData.class,id);
        if(tblData.getCity()!=null){
            tblDataActual.setCity(tblData.getCity());
        }
        if(tblData.getColor()!=null){
            tblDataActual.setColor(tblData.getColor());
        }
        if(tblData.getStartDate()!=null){
            tblDataActual.setStartDate(tblData.getStartDate());
        }
        if(tblData.getEndDate()!=null){
            tblDataActual.setEndDate(tblData.getEndDate());
        }
        if(tblData.getPrice()!=null){
            tblDataActual.setPrice(tblData.getPrice());
        }
        if(tblData.getStatus()!=null){
            tblDataActual.setStatus(tblData.getStatus());
        }
        session.save(tblDataActual);
        return tblDataActual;
    }

    @Override
    public TblData createRecord(TblData tblData) {
        Session session=sessionFactory.getCurrentSession();
        session.save(tblData);
        return tblData;
    }

    @Override
    public String deleteRecord(int id) {
        Session session=sessionFactory.getCurrentSession();
        TblData tblData=session.get(TblData.class,id);
        session.delete(tblData);
        return "Success";
    }

    @Override
    public List<TblData> getRecordsBetween(LocalDate startDate, LocalDate endDate) {
        Session session=sessionFactory.getCurrentSession();
        List<TblData> tblDataList=session.createQuery("from TblData where startDate>=:startDate and endDate<=:endDate",TblData.class)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList();
        return tblDataList;
    }

    @Override
    public List<TblData> sortByCity() {
        Session session=sessionFactory.getCurrentSession();
        List<TblData> tblDataList=session.createQuery("from TblData",TblData.class)
                .getResultList();
        Collections.sort(tblDataList,TblData.sortByCity);
        return tblDataList;
    }

    @Override
    public List<TblData> sortByCityDes() {
        Session session=sessionFactory.getCurrentSession();
        List<TblData> tblDataList=session.createQuery("from TblData",TblData.class)
                .getResultList();
        Collections.sort(tblDataList,TblData.sortByCityDes);
        return tblDataList;
    }
}
