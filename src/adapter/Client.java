 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月22日  
 *  
 */
package adapter;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  适配器模式测试类
 * 创建人：zhu
 * 创建时间：2014年11月22日 下午6:24:53  
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
//目标角色:一个正式运行的角色,你不能去修改角色中的方法,能做的就是如何去现实接口中的方法
interface Target{
    public void request();
}

//目标角色实现类
class ConcreteTarget implements Target{
    public void request(){
        System.out.println("一种目标实现");
    }
}

//源角色
class Adaptee{
    public void doSomething(){
        System.out.println("增加了适配器的目标实现");
    }
}

//适配器角色
class Adapter extends Adaptee implements Target{
    public void request(){
        super.doSomething();
    }
}


public class Client {
    public static void main(String[] args){
        //原有的业务逻辑
        Target target = new ConcreteTarget();
        target.request();
        
        //增加了适配器角色后的业务逻辑
        Target target2 = new Adapter();
        target2.request();
        
    }
}
