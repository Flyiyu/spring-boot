package org.springframework.boot.test;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @date: 2022/3/21 9:46
 * @author: yhc
 */
public class LearnListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("************************" +
				"********************88/n" +
				"*********************88/n" +
				"**************");
	}
}
