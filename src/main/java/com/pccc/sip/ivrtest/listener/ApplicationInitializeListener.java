package com.pccc.sip.ivrtest.listener;

import com.pccc.sip.ivrtest.util.ExcelInformationUtil;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializeListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        ExcelInformationUtil.init();
    }
}
