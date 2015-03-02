 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月21日  
 *  
 */
package strategy;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  策略模式测试
 * 创建人：zhu
 * 创建时间：2014年11月21日 下午3:03:04  
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

//策略接口
interface Strategy {
    public void doSomething();
}

//具体策略1类
class ConcreteStrategy1 implements Strategy{
    
    @Override
    public void doSomething() {
        System.out.println("实施策略1");
    }
    
}

//具体策略2类
class ConcreteStrategy2 implements Strategy{
    
    @Override
    public void doSomething() {
        System.out.println("实施策略2");
    }
    
}

//封装角色类
//上下文角色,起承上启下的封装作用,屏蔽高层模块对策略,算法的直接访问,封装可能存在的变化.
class Context{
    private Strategy strategy = null;
    
    //构造函数
    public Context(Strategy _strategy){
        this.strategy = _strategy;
    }
    
    //封装后的策略方法
    public void doSomething(){
        this.strategy.doSomething();
    }
    
}

public class Client {
    public static void main(String[] args){
        Strategy strategy1 = new ConcreteStrategy1();
        Strategy strategy2 = new ConcreteStrategy2();
        
        Context context = new Context(strategy1);
        context.doSomething();
        context = new Context(strategy2);
        context.doSomething();

        
    }

}
