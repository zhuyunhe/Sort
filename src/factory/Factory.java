 /**  
 * 文件名：Factory.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月14日  
 *  
 */
package factory;

import java.util.*;
/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Factory  
 * 类描述：  工厂模式设计
 * 创建人：zhu
 * 创建时间：2014年11月14日 下午1:55:54  
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
//定义Human接口
interface Human{
    public void getColor();
}

class WhiteHuman implements Human{
    public void getColor(){
        System.out.println("我是白人");
    }
}
class BlackHuman implements Human{
    public void getColor(){
        System.out.println("我是黑人");
    }
    
}
class YellowHuman implements Human{
    public void getColor(){
        System.out.println("我是黄人");
    }    
}

//定义抽象工厂
abstract class AbstractHumanFactory{
    public abstract<T extends Human> T createHuman(Class<T> c);
    //public abstract void TT();
}

class HumanFactory extends AbstractHumanFactory{
    @SuppressWarnings("unchecked")
    public <T extends Human> T createHuman(Class<T> c){
        Human human = null;
        try {
            human = (Human)Class.forName(c.getName()).newInstance();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return (T)human;
        
    }
    
}

public class Factory {
     public static void main(String[] args){
         
         AbstractHumanFactory Lu = new HumanFactory();
         
         Human whiteHuman = Lu.createHuman(WhiteHuman.class);
         whiteHuman.getColor();
         Human blackHuman = Lu.createHuman(BlackHuman.class);
         blackHuman.getColor();
         Human yellowHuman = Lu.createHuman(WhiteHuman.class);
         yellowHuman.getColor();
         
         List list = new ArrayList();
         AbstractList list2 = new ArrayList();

         
         System.out.println(list.getClass());
         System.out.println(list2.getClass());
     }

}
