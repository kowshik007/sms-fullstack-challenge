package com.application.start.service;

import com.application.start.dao.TblDataAPIInterface;
import com.application.start.entity.TblData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TblDataService {
    @Autowired
    private TblDataAPIInterface tblDataAPIInterface;
    @Transactional
    public List<TblData> getAllRecords(){
        return tblDataAPIInterface.getAllRecords();
    }
    @Transactional
    public List<TblData> getNRecords(int page,int n){
        return  tblDataAPIInterface.getNRecords(page,n);
    }
    @Transactional
    public TblData getRecordById(int id) {
        return tblDataAPIInterface.getRecordById(id);
    }
    @Transactional
    public TblData updateRecordById(int id, TblData tblData) {
        return tblDataAPIInterface.updateRecordById(id,tblData);
    }
    @Transactional
    public TblData createRecord(TblData tblData) {
        return tblDataAPIInterface.createRecord(tblData);
    }
    @Transactional
    public String deleteRecord(int id) {
        return tblDataAPIInterface.deleteRecord(id);
    }
    @Transactional
    public List<TblData> getRecordsBetween(LocalDate startDate, LocalDate endDate) {
        return tblDataAPIInterface.getRecordsBetween(startDate,endDate);
    }
    @Transactional
    public List<TblData> sortByCity() {
        return tblDataAPIInterface.sortByCity();
    }
    @Transactional
    public List<TblData> sortByCityDes() {
        return tblDataAPIInterface.sortByCityDes();
    }
}
