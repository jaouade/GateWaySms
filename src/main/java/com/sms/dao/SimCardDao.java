package com.sms.dao;

import com.sms.entities.SimCard;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public class SimCardDao extends Dao<SimCard> implements ISimCardDao {


}
