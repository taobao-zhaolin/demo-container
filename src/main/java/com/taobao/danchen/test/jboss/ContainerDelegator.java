package com.taobao.danchen.test.jboss;

import java.util.HashMap;
import java.util.Map;

import org.jboss.mx.loading.UnifiedClassLoader3;
import org.jboss.mx.loading.UnifiedLoaderRepository3;
import org.jboss.system.ServiceMBeanSupport;

public class ContainerDelegator extends ServiceMBeanSupport implements ContainerDelegatorMBean {

	public void start() throws Exception {
		//���jboss��class loader
        UnifiedClassLoader3 jbossClassloader=(UnifiedClassLoader3) this.getClass().getClassLoader();
        //���jboss��class repository
        UnifiedLoaderRepository3 jbossRepo=(UnifiedLoaderRepository3) jbossClassloader.getLoaderRepository();
        //�����Լ���Ҫ��������,����ֻ��һ��ʾ��
        //...
        Map<String, Class<?>> exportedClasses = new HashMap<String,Class<?>>();
        //�ŵ�jboss�Ļ�����
        for (String className : exportedClasses.keySet()) {
            jbossRepo.cacheLoadedClass(className, exportedClasses.get(className), jbossClassloader);
        }

	}

}
