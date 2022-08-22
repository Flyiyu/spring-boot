/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * Listener for the {@link SpringApplication} {@code run} method.
 * {@link SpringApplicationRunListener}s are loaded via the {@link SpringFactoriesLoader}
 * and should declare a public constructor that accepts a {@link SpringApplication}
 * instance and a {@code String[]} of arguments. A new
 * {@link SpringApplicationRunListener} instance will be created for each run.
 *
 * @author Phillip Webb
 * @author Dave Syer
 * @author Andy Wilkinson
 * @since 1.0.0
 */
public interface SpringApplicationRunListener {
	/**
	 * started() -> run方法执行的时候立马执行；对应事件的类型是ApplicationStartedEvent，通知监听器，SpringBoot开始执行
	 * environmentPrepared() ->  ApplicationContext创建之前并且环境信息准备好的时候调用；对应事件的类型是ApplicationEnvironmentPreparedEvent), 通知监听器，Environment准备完成
	 * contextPrepared -> ApplicationContext创建好并且在source加载之前调用一次；没有具体的对应事件), 通知监听器，ApplicationContext已经创建并初始化完成
	 * contextLoaded -> ApplicationContext创建并加载之后并在refresh之前调用；对应事件的类型是ApplicationPreparedEvent), 通知监听器，ApplicationContext已经完成IoC配置价值
	 * finished -> run方法结束之前调用；对应事件的类型是ApplicationReadyEvent或ApplicationFailedEvent), 通知监听器，SpringBoot启动完成
	 */

	/**
	 * Called immediately when the run method has first started. Can be used for very
	 * early initialization.
	 * 在 run 方法第一次启动时立即调用。可用于非常早的初始化。
	 */
	default void starting() {
	}

	/**
	 * Called once the environment has been prepared, but before the
	 * {@link ApplicationContext} has been created.
	 *
	 * @param environment the environment
	 *                    当environment准备完成，在ApplicationContext创建之前，该方法被调用
	 */
	default void environmentPrepared(ConfigurableEnvironment environment) {
	}

	/**
	 * Called once the {@link ApplicationContext} has been created and prepared, but
	 * before sources have been loaded.
	 *
	 * @param context the application context
	 */
	default void contextPrepared(ConfigurableApplicationContext context) {
	}

	/**
	 * Called once the application context has been loaded but before it has been
	 * refreshed.
	 *
	 * @param context the application context
	 */
	default void contextLoaded(ConfigurableApplicationContext context) {
	}

	/**
	 * The context has been refreshed and the application has started but
	 * {@link CommandLineRunner CommandLineRunners} and {@link ApplicationRunner
	 * ApplicationRunners} have not been called.
	 *
	 * @param context the application context.
	 * @since 2.0.0
	 */
	default void started(ConfigurableApplicationContext context) {
	}

	/**
	 * Called immediately before the run method finishes, when the application context has
	 * been refreshed and all {@link CommandLineRunner CommandLineRunners} and
	 * {@link ApplicationRunner ApplicationRunners} have been called.
	 *
	 * @param context the application context.
	 * @since 2.0.0
	 */
	default void running(ConfigurableApplicationContext context) {
	}

	/**
	 * Called when a failure occurs when running the application.
	 *
	 * @param context   the application context or {@code null} if a failure occurred before
	 *                  the context was created
	 * @param exception the failure
	 * @since 2.0.0
	 */
	default void failed(ConfigurableApplicationContext context, Throwable exception) {
	}

}
