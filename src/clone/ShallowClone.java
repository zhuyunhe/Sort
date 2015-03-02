 /**  
 * 文件名：ShallowClone.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月18日  
 *  
 */
package clone;

import java.util.*;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：ShallowClone  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年11月18日 上午9:05:28  
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
//要克隆的对象的类
class Thing implements Cloneable{
    private ArrayList<String> arrayList = new ArrayList<String>();
    
    @Override
    public Thing clone(){
        Thing thing = null;
        try {
            thing = (Thing)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }
    
    public void setValue(String value){
        this.arrayList.add(value);
    }
    
    public ArrayList<String> getValue(){
        return this.arrayList;
    }
}

public class ShallowClone {
    public static void main(String[] args){
        Thing thing = new Thing();
        thing.setValue("朱");
        
        Thing cloneThing = thing.clone();
        cloneThing.setValue("李");
        
        /*对象内部的数组,引用对象都不拷贝,还是指向原生对象的内部元素地址
         * thing和cloneThing两个对象共享了私有变量
         * */
        
        System.out.println(thing.getValue().toString());
    }

}
