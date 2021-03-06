package com.ms.env;


/**
 * 配置文件的key
 * @author Wujun
 * @date 2016年5月16日 下午5:52:03
 * @version V1.0.0
 */
public enum Env {
	PROJECT_MODEL		("project.model", "项目模式[dev开发、test测试、release正式]"),
	CODE_TEMPLATE_PATH	("code.template.path", "模板存放路径"),
	CODE_SOURCE_PATH	("code.source.path", "源码存放路径"),
	SEND_EMAIL_IS_OPEN	("send.email.is.open", "是否打开发送邮件的功能[0否、1是]"),
	;
	
	private String code;
	private String name;

	private Env(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
}