package com.piperit.bpmcontainer;

import javax.jms.ConnectionFactory;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@EnableJms
@EnableAutoConfiguration
@EnableAdminServer
public class BpmApp {

	public static void main(String[] args) {
		SpringApplication.run(BpmApp.class, args);
	}

	
    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override some of Boot's default if necessary.
        return factory;
    }
    
    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
	
	@Bean
	InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {

		return new InitializingBean() {
			public void afterPropertiesSet() throws Exception {

				Group group = identityService.newGroup("user");
				group.setName("users");
				group.setType("security-role");
				identityService.saveGroup(group);

				User admin = identityService.newUser("admin");
				admin.setPassword("admin");
				identityService.saveUser(admin);

			}
		};
	}

//	@Bean
//	CommandLineRunner init(final RepositoryService repositoryService, final RuntimeService runtimeService,
//			final TaskService taskService) {
//
//		return new CommandLineRunner() {
//
//			public void run(String... strings) throws Exception {
//				Map<String, Object> variables = new HashMap<String, Object>();
//				variables.put("applicantName", "John Doe");
//				variables.put("email", "john.doe@activiti.com");
//				variables.put("phoneNumber", "123456789");
//				runtimeService.startProcessInstanceByKey("allocationProcess", variables);
//			}
//		};
//	}
}
