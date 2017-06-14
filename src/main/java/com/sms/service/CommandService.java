package com.sms.service;

import com.sms.dao.CommandDao;
import com.sms.dao.IDao;
import com.sms.entities.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class CommandService extends Service<Command> implements ICommandService {
    private CommandDao commandDao;

    public CommandService() {

    }

    @Autowired
    public CommandService(
            @Qualifier("commandDao") IDao<Command> genericDao) {
        super(genericDao);
        this.commandDao = (CommandDao) genericDao;
    }
}
