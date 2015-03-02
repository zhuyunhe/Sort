 /**  
 * 文件名：TestStatic.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年10月24日  
 *  
 */
package testStatic;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：TestStatic  
 * 类描述：  1.父类的静态语句块要优先于子类的变量赋值操作执行
 *       2.参考java虚拟机268页
 * 创建人：zhu
 * 创建时间：2014年10月24日 下午2:51:10  
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
public class TestStatic {
    public static void main(String[] args) throws ClassNotFoundException{
        Child child = new Child();
        
        System.out.println(child.b);
        //局部变量定义了但没有赋初值是不能使用的
        int d;
        //System.out.println(d);
        
    }

}

class Parent{
    //若不赋初值,默认是1
    public static int a;
    
    public Parent(){
        System.out.println("我是父类构造器");
    }
    
    static{
        System.out.println("我是父类的静态语句块"+a);
    }
    
}

class Child extends Parent{
    public Child(){
        System.out.println("我是子类构造器");
    }
    
    static{
    b = 2;
    }
    //static修饰的变量只能被初始化一次
    public static int b = a;
    
    public static int c = 1;
    
    //报错啦
    //c=1;
    
    
    static{
        System.out.println("我是子类的静态语句块"+b);
    }
    
}