package com.fh.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 *以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候中取出ApplicaitonContext.   
 * @author chb                                                                 
 */
public class SpringContextHolder implements ApplicationContextAware{  //AD need spring support  //Spring bean
	private static final Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);
	
    private static ApplicationContext applicationContext;

    /**
     * common
     * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextHolder.applicationContext = applicationContext;
    }
   
    /**
     * common
     * 取得存储在静态变量中的ApplicationContext.
     * @return
     */
    public static ApplicationContext getApplicationContext() {
    	return applicationContext;
    }

    /**
     * common
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
    	if(applicationContext==null){
    		return null;
    	}
    	
        try {
			return (T) applicationContext.getBean(name);
		} catch (Exception e) {
			logger.warn("chb: No bean found by name '"+name+"' "+e.getMessage());
			return null;
		}
    }
    
    /**
     * 通过类型获取Bean
     * @param requiredType
     * @return
     */
    public static <T> T getBean(Class<T> requiredType){
    	if(applicationContext==null){
    		logger.warn("chenhb: SpringContext is null, could not get bean by type "+requiredType.getName());
    		return null;
    	}
    	
    	try {
			return applicationContext.getBean(requiredType);
		} catch (Exception e) {
			logger.warn("chenhb: Find bean by type '"+requiredType.getName()+"' exception ",e.getMessage());
			return null;
		}
    }
    
    /**
     * common
     * 取得HttpSession
     * @return
     *//*
    public static HttpSession getHttpSession() {
		WebSessionHolder webSessionHolder=SpringContextHolder.getBean(WebSessionHolder.class);
		return webSessionHolder.getHttpSession();
	}

    *//**
	 * chb 获取主窗口，显示Notification信息
	 * @return MyTaskTabView
	 *//*
	public static Window getMainWindow() {
		return (Window) getHttpSession().getAttribute("mainWindow");
	}*/
	
    
}