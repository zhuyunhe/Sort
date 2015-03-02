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
package facade;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  门面模式测试类
 * 创建人：zhu
 * 创建时间：2014年11月25日 下午5:01:53  
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
//子系统A
class ClassA{
    public void doSomethingA(){
        System.out.println("A系统工作");
    }
}
//子系统C
class ClassB{
  public void doSomethingB(){
      System.out.println("B系统工作");
  }
}

//子系统C
class ClassC{
  public void doSomethingC(){
      System.out.println("C系统工作");
  }
}

//门面类
class Facade{
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private ClassC c = new ClassC();
    
    public void methodA(){
        a.doSomethingA();
    }
    public void methodB(){
        b.doSomethingB();
    }
    public void methodC(){
        c.doSomethingC();
    }
}


public class Client {
    public static void main(String[] args){
        Facade f =new Facade();
        f.methodA();
        f.methodB();
        f.methodC();
    }
}
