package com.ts.startup;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.ts.data.source.DataSource;
import com.ts.data.utils.DataUtils;

@Component
public class SpringContextListener implements ApplicationListener<ApplicationEvent>{

	public void onApplicationEvent(ApplicationEvent event) {
		if(!DataSource.getInstance().isLoaded()){
			DataUtils.loadData(Thread.currentThread().getContextClassLoader().getResourceAsStream("finefoods.txt"));
		}
    };
}
