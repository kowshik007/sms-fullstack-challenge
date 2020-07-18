package com.application.start.dao;

import com.application.start.entity.TblData;

import java.time.LocalDate;
import java.util.List;

public interface TblDataAPIInterface {
    public List<TblData> getAllRecords();
    public List<TblData> getNRecords(int page,int n);
    public TblData getRecordById(int id);
    public TblData updateRecordById(int id,TblData tblData);
    public TblData createRecord(TblData tblData);
    public String deleteRecord(int id);
    public List<TblData> getRecordsBetween(LocalDate startDate, LocalDate endDate);
    public List<TblData> sortByCity();
    public List<TblData> sortByCityDes();
}
