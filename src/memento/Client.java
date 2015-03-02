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
package memento;
/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  备忘录模式测试类
 * 创建人：zhu
 * 创建时间：2014年11月25日 下午8:49:55  
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
class Boy{
    //男孩状态
    private String state="";
    
    //认识女孩后状态改变
    public void changeState(){
        this.state = "心情不好";
    }
    
    public String getState(){
        return this.state;
    }
    
    public void setState(String _state){
        this.state = _state;
    }
    
    public Memento createMemento(){
        return new Memento(this.state);
    }
    
    public void restoreMemento(Memento _memento){
        this.setState(_memento.getState());
        
    }
}

//备忘录类
class Memento{
    private String state = "";
    
    //构造函数传递信息
    public Memento(String _state){
        this.state = _state;
    }
    
    public String getState(){
        return this.state;
    }
    
    public void setState(String _state){
        this.state = _state;
    }
}

//备忘录管理者类
class Caretaker{
    private Memento memento;
    
    public Memento getMemento(){
        return this.memento;
    }
    
    public void setMemento(Memento _memento){
        this.memento = _memento;
    }
    
    
}

public class Client {
    public static void main(String[] args){
        //声明主角
        Boy boy = new Boy();
        
        //声明备忘录管理者
        Caretaker caretaker = new Caretaker();
        
        //初始化当前状态
        boy.setState("心情不错");
        
        System.out.println("男孩初始时心情:"+boy.getState());
        
        //记录下当前状态
        caretaker.setMemento(boy.createMemento());
        
        //男孩追女孩后心情改变
        boy.changeState();
        
        System.out.println("男孩追女孩后的心情:"+boy.getState());
        
        //追求失败后恢复原状
        boy.restoreMemento(caretaker.getMemento());
        
        System.out.println("男孩恢复状态后的心情:"+boy.getState());
        
        System.out.println(boy.getClass().getSimpleName());
    }
}
