 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月23日  
 *  
 */
package composite;

import java.util.*;
/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  组合模式测试类
 * 创建人：zhu
 * 创建时间：2014年11月23日 下午8:44:32  
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


abstract class Component{
    //个体和整体都具有的共享
    public void doSomething() {
        System.out.println("公共业务逻辑");
    }
    
    private Component parent = null;
    
    //设置父节点
    public void setParent(Component _parent){
        this.parent = _parent;
    }
    
    //得到父节点
    public Component getParent(){
        return this.parent;
    }
    
    public static final Component find(Component c){
        if(c.getParent() != null){
            c = c.getParent();
            System.out.println("找到一个上级");
            find(c);
            
        }
        return c.getParent();
    }
}

//树枝构建
class Composite extends Component{
    private ArrayList<Component> componentArrayList = new ArrayList<Component>();
    
    //增加一个叶子构件或树枝构建
    public void add(Component component){
        component.setParent(this);
        this.componentArrayList.add(component);
    }
    
    //删除一个叶子构件或树枝构建
    public void remove(Component component){
        this.componentArrayList.remove(component);
    }
    
    //获得分支下的所有叶子构件或树枝构建
    public ArrayList<Component> getChildren(){
        return this.componentArrayList;
    }

}

//树叶构件,没有下级对象
class Leaf extends Component{
    //可以覆写父类方法
    public void doSomething(){
        System.out.println("我是叶子节点");
    }

}


public class Client {
    public static void main(String[] args){
        
    //创建一个根节点
    Composite root = new Composite();
    root.doSomething();
    
    //创建一个树枝构建
    Composite branch = new Composite();
    
    //创建一个叶子节点
    Leaf leaf = new Leaf();
    
    //建立整体
    root.add(branch);
    root.add(leaf);
    
    //遍历展示
    display(root);
    
    Component.find(leaf);
    
    }
    
    //通过递归遍历树
    public static void display(Composite root){
        for(Component c : root.getChildren()){
            if(c instanceof Leaf){
                c.doSomething();
            } else{ //树枝节点,递归
                c.doSomething();
                display((Composite)c);
            }
        }
    }
}
