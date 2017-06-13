package com.sms.service;

import com.sms.entities.City;
import org.springframework.stereotype.Component;

@org.springframework.stereotype.Service
@Component("cityservice")
public class CityService extends Service<City> implements IcityService {

}
