 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月16日  
 *  
 */
package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  代理模式的测试单元
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年11月16日 上午11:38:09  
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
//游戏者接口
interface IGamePlayer{
  public void login(String user,String pw);
  
  public void killBoss();
  
  public void upgrade();
}
class GamePlayer implements IGamePlayer{
  private String name = "";
  
  //构造函数
  public GamePlayer(String _name){
      this.name = _name;
  }
  
  public void login(String user, String pw){
      System.out.println("欢迎你"+this.name+",你的登录名为"+user);
  }
  
  public void killBoss(){
      System.out.println("打Boss");
  }
  
  public void upgrade(){
      System.out.println("升级");
  }
}


//动态代理类
//InvocationHandler是JDK提供的动态代理接口
class GamePlayIH implements InvocationHandler{

    //被代理者
    Class<?> cls = null;
    
    //被代理者的实例
    Object obj = null;
    
    //构造函数
    public GamePlayIH(Object _obj){
        this.obj = _obj;
        
    }
    
    /**
     * (non-Javadoc)  
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])  
     */
    //proxy被代理的接口,
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
        Object result = method.invoke(this.obj, args);
        
        //切片
        if(method.getName().equalsIgnoreCase("login")){
            System.out.println("账号已登录");
        }
        
        return result;
    }
    
}

public class Client {
  public static void main(String[] args){
      IGamePlayer player = new GamePlayer("朱云鹤");

      //定义一个handler
      InvocationHandler handler = new GamePlayIH(player);
      
      //获得类的class loader
      ClassLoader cl = player.getClass().getClassLoader();
      
      //动态产生一个代理者
      IGamePlayer proxy = (IGamePlayer)Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);
      
      proxy.login("zhu", "123");
      proxy.killBoss();
      proxy.upgrade();
      
      System.out.println("游戏结束");
  }
}
