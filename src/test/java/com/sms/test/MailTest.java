package com.sms.test;

import com.sms.config.ApplicationConfig;
import com.sms.service.MailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ApplicationConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MailTest {

    @Autowired
    private MailService mailS;

    @Test
    public void sendTest() {

        mailS.sendEmail("email", "jdjdj");
        Assert.assertNotNull("cool");

    }

}
