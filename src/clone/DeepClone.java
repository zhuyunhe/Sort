 /**  
 * 文件名：DeepClone.java  
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

import java.util.ArrayList;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：DeepClone  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年11月18日 上午9:34:40  
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
class DeepThing implements Cloneable{
  private ArrayList<String> arrayList = new ArrayList<String>();
  
  @Override
  public DeepThing clone(){
      DeepThing thing = null;
      try {
          thing = (DeepThing)super.clone();
          //确保类中的对象引用也被克隆
          thing.arrayList = (ArrayList<String>)this.arrayList.clone();
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
public class DeepClone {
    public static void main(String[] args){
        DeepThing thing = new DeepThing();
        thing.setValue("朱");
        
        DeepThing cloneThing = thing.clone();
        cloneThing.setValue("李li");
        
        
        
        System.out.println(thing.getValue().toString());
    }
}
