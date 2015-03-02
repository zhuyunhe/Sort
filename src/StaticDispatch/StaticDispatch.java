 /**  
 * 文件名：StaticDispatch.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年10月27日  
 *  
 */
package StaticDispatch;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：StaticDispatch  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年10月27日 下午2:24:12  
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
public class StaticDispatch {
    static abstract class Human{
        
    }
    
    static class Man extends Human{
        
    }
    
    static class Woman extends Human{
        
    }

    public void sayHello(Human human){
        System.out.println("hello guys!");
    }
    
    public void sayHello(Man man){
        System.out.println("hello man!");
    }
    
    public void sayHello(Woman woman){
        System.out.println("hello woman");
    }
    
    public static void main(String[] args){
        Human man = new Man();
        Human woman = new Woman();
        Man man2 = new Man();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
        sd.sayHello(man2);
    }
}
