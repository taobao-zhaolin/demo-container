package com.taobao.danchen.test.container;

import java.net.URL;
import java.net.URLClassLoader;

public class APPClassloader extends URLClassLoader {
	
	private ClassLoader bizClassLoader;
	
	private String appName;
	
	public APPClassloader(URL[] urls, ClassLoader parent, String appName) {
		super(urls,parent);
		this.bizClassLoader = parent;
		this.appName = appName;
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		//first step
		if(name.startsWith("javax.servlet") || name.startsWith("org.springframework")){
			try {
				return bizClassLoader.loadClass(name);
			} catch (Throwable t) {
				throw new ClassNotFoundException("can't find class="+name);
			}
		}
		
		//second step
		try {
			super.loadClass(name);
		} catch (ClassNotFoundException e) {
			
		} catch (Throwable t){
			 throw new ClassNotFoundException("",t);
		}
		
		//third step
		try {
			return bizClassLoader.loadClass(name);
		} catch (Throwable t){
			throw new ClassNotFoundException("can't find class="+name+" final.");
		}
	}

	public String getAppName() {
		return appName;
	}

	public ClassLoader getBizClassLoader() {
		return bizClassLoader;
	}

}
