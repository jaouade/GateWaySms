package com.sms.service;

import com.sms.dao.IDao;
import com.sms.dao.LogHistoryDao;
import com.sms.entities.LogHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
@org.springframework.stereotype.Service
public class LogHistoryService extends Service<LogHistory> implements  Iservice<LogHistory> {
    private LogHistoryDao logHistoryDao;
    public LogHistoryService(){

    }
    @Autowired
    public LogHistoryService(
            @Qualifier("logHistoryDao") IDao<LogHistory> genericDao) {
        super(genericDao);
        this.logHistoryDao = (LogHistoryDao) genericDao;
    }
}
