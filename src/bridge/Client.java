 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年12月20日  
 *  
 */
package bridge;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年12月20日 下午8:15:31  
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

//实现化角色
interface Implementor{
    public void doSomething();
    public void doAnything();
}

//具体实现化角色
class ConcreteImplementor implements Implementor{

    @Override
    public void doSomething() {
        System.out.println("do something!");
    }

    @Override
    public void doAnything() {
        System.out.println("do anything!");
    }
    
}

//抽象化角色
abstract class Abstraction{
    //定义对实现化角色的引用
    private Implementor imp;
    
    //定义一个带参构造函数，约束子类必须实现该构造函数
    public Abstraction(Implementor _imp){
        this.imp = _imp;
    }
    
    //自身的行为和属性
    public void request(){
        this.imp.doSomething();
    }
    
    //获得实现化角色
    public Implementor getImp(){
        return this.imp;
    }
}

//具体抽象化角色
class RefinedAbstraction extends Abstraction{
    public RefinedAbstraction(Implementor _imp){
        super(_imp);
    }
    
    public void request(){
        super.request();
        
        super.getImp().doAnything();
    }
}

public class Client {
    public static void main(String[] args){
        Implementor imp = new ConcreteImplementor();
        
        Abstraction abs = new RefinedAbstraction(imp);
        
        abs.request();
    }
}
