package com.ms.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ms.task.interceptor.AdminSecurityInterceptor;
import com.ms.task.interceptor.AuthSecurityInterceptor;

@EnableEurekaClient
@ComponentScan("com.*")
@EnableAutoConfiguration(exclude={
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		//HibernateJpaAutoConfiguration.class, //（如果使用Hibernate时，需要加）
})
@ServletComponentScan("com.*")
@SpringBootApplication
public class MsCloudTaskApplication extends SpringBootServletInitializer implements CommandLineRunner {

	private static Logger LOGGER = LoggerFactory.getLogger(MsCloudTaskApplication.class);

	/*@Autowired
	RabbitMessagingTemplate rabbitMessagingTemplate;*/

	public static void main(String[] args) {
		LOGGER.debug("######## Task应用启动开始 ########");
		SpringApplication.run(MsCloudTaskApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		LOGGER.debug("######## Task应用启动完成 ########");
		/*Map<String,Object> map = new HashMap<>();
		map.put("msg","SpringCloudEureka应用启动");
		rabbitMessagingTemplate.convertAndSend("directExchange","queue.foo", JSON.toJSONString(map));
		map.clear();
		map.put("msg","SpringCloudEureka应用启动成功");
		rabbitMessagingTemplate.convertAndSend("directExchange","queue.bar", JSON.toJSONString(map));*/
		
		//initAuthClient();
	}
	/*
	private static void initAuthClient() {
		AuthClient client = new AuthClient("196845682", "测试调用", "http://127.0.0.1", "708c80644e3f868c429c24cd2cdb7c8e", "http://127.0.0.1/callback.htm");
		AuthUtil.addAuthClient(client);
		CliInfoService cliInfoService = FrameSpringBeanUtil.getBean(CliInfoService.class);
		List<CliInfo> cis = cliInfoService.findAll();
		for (CliInfo ci : cis) {
			AuthUtil.addAuthClient(new AuthClient(ci.getClientId(), ci.getName(), "http://" + ci.getIp() + ":" + ci.getPort(), ci.getToken(), "http://127.0.0.1/callback.htm"));
		}
		//初始化config的配置
		SysConfigService sysConfigService = FrameSpringBeanUtil.getBean(SysConfigService.class);
		String clientId = sysConfigService.getValue(SysConfigCode.CONFIG_CLIENT_ID);
		String token = sysConfigService.getValue(SysConfigCode.CONFIG_CLIENT_TOKEN);
		AuthUtil.addAuthClient(new AuthClient(clientId, SysConfigCode.CONFIG_CLIENT_ID.getName(),
				"http://xxxx:", token, ""));
	}*/
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MsCloudTaskApplication.class);
    }

	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		WebMvcConfigurerAdapter wmca = new WebMvcConfigurerAdapter() {

			/**
			 * 添加拦截器
			 */
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(new AuthSecurityInterceptor())
				.addPathPatterns("/api/*/*");
				AdminSecurityInterceptor admin = new AdminSecurityInterceptor();
				admin.setLoginUrl("/index.jsp?errorcode=1");
				registry.addInterceptor(admin)
				.addPathPatterns("/*/f-view/**", "/*/f-json/**");
			}

			/*@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
				registry.addResourceHandler("/view/**").addResourceLocations("/view/");
				super.addResourceHandlers(registry);
			}*/
		};
		return wmca;
	}
	

	/*@Bean
    public FilterRegistrationBean basicFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new XssFilter());
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
        return registrationBean;
    }*/
}