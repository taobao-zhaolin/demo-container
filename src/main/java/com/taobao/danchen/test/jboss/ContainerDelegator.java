package com.taobao.danchen.test.jboss;

import java.util.HashMap;
import java.util.Map;

import org.jboss.mx.loading.UnifiedClassLoader3;
import org.jboss.mx.loading.UnifiedLoaderRepository3;
import org.jboss.system.ServiceMBeanSupport;

public class ContainerDelegator extends ServiceMBeanSupport implements ContainerDelegatorMBean {

	public void start() throws Exception {
		//获得jboss的class loader
        UnifiedClassLoader3 jbossClassloader=(UnifiedClassLoader3) this.getClass().getClassLoader();
        //获得jboss的class repository
        UnifiedLoaderRepository3 jbossRepo=(UnifiedLoaderRepository3) jbossClassloader.getLoaderRepository();
        //导出自己需要导出的类,这里只是一个示例
        //...
        Map<String, Class<?>> exportedClasses = new HashMap<String,Class<?>>();
        //放到jboss的缓存里
        for (String className : exportedClasses.keySet()) {
            jbossRepo.cacheLoadedClass(className, exportedClasses.get(className), jbossClassloader);
        }

	}

}
