package com.taobao.danchen.test.jboss;

public interface ContainerDelegatorMBean {
	 /**
     *  ��������
     * @throws Exception
     */
    public void start() throws Exception;
    
    /**
     * ֹͣ����
     * @throws Exception
     */
    public void stop() throws Exception;
}
