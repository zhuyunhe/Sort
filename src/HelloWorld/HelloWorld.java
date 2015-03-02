 /**  
 * 文件名：HelloWorld.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年10月24日  
 *  
 */
package HelloWorld;

import java.util.Date;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：HelloWorld  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年10月24日 上午9:46:42  
 * 修改记录：
 *    修改人：
 *    修改时间：
 *    修改备注：
 *    
 * 评审纪录：
 *    评审人：
 *    评审时间：
 *    评审备注：
 */
public class HelloWorld {
    //p125页
    static{
        System.out.println("hello,world!");
        System.exit(0);
    }

}

class HelloBean{
    private String name;
    private int number;
    private Date date;
    
    public HelloBean(Date date, String name, int number) {
        this.date = date;
        this.name = name;
        this.number = number;
      }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**  
     * @param name the name to set  
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**  
     * @param number the number to set  
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set  
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
}
