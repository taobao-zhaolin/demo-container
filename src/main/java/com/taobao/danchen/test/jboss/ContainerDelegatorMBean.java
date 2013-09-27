package com.taobao.danchen.test.jboss;

public interface ContainerDelegatorMBean {
	 /**
     *  Æô¶¯ÈÝÆ÷
     * @throws Exception
     */
    public void start() throws Exception;
    
    /**
     * Í£Ö¹ÈÝÆ÷
     * @throws Exception
     */
    public void stop() throws Exception;
}
