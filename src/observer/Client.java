 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月25日  
 *  
 */
package observer;

import java.util.*;
/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  观察者模式测试类
 * 创建人：zhu
 * 创建时间：2014年11月25日 上午10:57:15  
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
//被观察者抽象类
abstract class Subject{
    //Vector是线程同步的,安全.ArrayList是线程异步
    //定义一个观察者数组
    private Vector<Observer> obsVector = new Vector<Observer>();
    
    //增加一个观察者
    public void addObserver(Observer o){
        this.obsVector.add(o);
    }
    
    //删除一个观察者
    public void delObserver(Observer o){
        this.obsVector.remove(o);
    }
    
    public int getVectorSize(){
        return this.obsVector.size();
    }
    
    //通知所有观察者
    public void notifyObservers(){
        for(Observer o : this.obsVector){
            o.update();
        }
    }
}

//观察者接口
interface Observer{
    public void update();
}

//一个实际被观察者
class ConcreteSubject extends Subject{
    public void doSomething(){
        System.out.println("我是被观察的");
        
        //通知观察我的人
        super.notifyObservers();
    }
}

//一个实际的观察者
class ConcreteObserver1 implements Observer{
    public void update(){
        System.out.println("观察者1接收到消息并处理");
    }
}

//一个实际的观察者
class ConcreteObserver2 implements Observer{
  public void update(){
      System.out.println("观察者2接收到消息并处理");
  }
}
public class Client {
    public static void main(String[] args){
        //创建一个被观察者
        ConcreteSubject subject = new ConcreteSubject();
        
        //定义一个观察者
        Observer observer1 = new ConcreteObserver1();
        
        //定义一个观察者
        Observer observer2 = new ConcreteObserver2();
        
        //观察者观察被观察者
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        
        System.out.println(subject.getVectorSize());
        
        //观察者开始活动
        subject.doSomething();
    }

}
