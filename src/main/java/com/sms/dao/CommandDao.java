package com.sms.dao;

import com.sms.entities.Command;
import org.springframework.stereotype.Repository;


@Repository
public class CommandDao extends Dao<Command> implements ICommandDao {
}
