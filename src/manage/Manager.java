 /**  
 * 文件名：Manager.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月20日  
 *  
 */
package manage;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Manager  
 * 类描述：  项目经理模式测试
 * 创建人：zhu
 * 创建时间：2014年11月20日 上午11:21:33  
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
abstract class Group{
    //需要和某个组讨论要先找到这个组
    public abstract void find();
    
    public abstract void add();
    
    public abstract void delete();
    
    public abstract void plan();
}

//需求组类
class RequirementGroup extends Group{

    /**
     * (non-Javadoc)  
     * @see manage.group#find()  
     */
    @Override
    public void find() {
        System.out.println("找到需求组");
    }

    /**
     * (non-Javadoc)  
     * @see manage.group#add()  
     */
    @Override
    public void add() {
        System.out.println("增加一项需求");        
    }

    /**
     * (non-Javadoc)  
     * @see manage.group#delete()  
     */
    @Override
    public void delete() {
        System.out.println("删除一项需求");        
    }

    /**
     * (non-Javadoc)  
     * @see manage.group#plan()  
     */
    @Override
    public void plan() {
        System.out.println("客户要求需求变更");        
    }
    
}

//实现组类
class CodeGroup extends Group{

    /**
     * (non-Javadoc)  
     * @see manage.Group#find()  
     */
    @Override
    public void find() {
        System.out.println("找到代码组");
    }

    /**
     * (non-Javadoc)  
     * @see manage.Group#add()  
     */
    @Override
    public void add() {
        System.out.println("增加一项功能");
    }

    /**
     * (non-Javadoc)  
     * @see manage.Group#delete()  
     */
    @Override
    public void delete() {
        System.out.println("删除一项功能");
    }

    /**
     * (non-Javadoc)  
     * @see manage.Group#plan()  
     */
    @Override
    public void plan() {
        System.out.println("客户要求变更代码计划");
    }
    
}
//美工组类
class PageGroup extends Group{

    /**
     * (non-Javadoc)  
     * @see manage.Group#find()  
     */
    @Override
    public void find() {
        System.out.println("找到美工组");
        
    }

    /**
     * (non-Javadoc)  
     * @see manage.Group#add()  
     */
    @Override
    public void add() {
        System.out.println("添加一个页面");
        
    }

    /**
     * (non-Javadoc)  
     * @see manage.Group#delete()  
     */
    @Override
    public void delete() {
        System.out.println("删除一个页面");
    }

    /**
     * (non-Javadoc)  
     * @see manage.Group#plan()  
     */
    @Override
    public void plan() {
        System.out.println("客户要求页面变更计划");
        
    }
    
}

//抽象指令类
abstract class Command{
    //可以看做是一个指令接收者
    protected final Group group;
    
    //父类带参构造器
    public Command(Group _group){
        this.group = _group;
    }
    
    /*public Command(){
        System.out.println("父类");
    }*/
    
    //执行命令
    public abstract void execute();    
}

//增加需求的指令类
class AddRequirementCommand extends Command{

    //声明自己默认的接收者
    public AddRequirementCommand(){
        super(new PageGroup());
    }
    
    /**  
     * 创建一个新的实例 AddRequirementCommand.  
     *  
     * @param _receiver  
     */
    public AddRequirementCommand(Group group) {
        super(group);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void execute() {
        super.group.find();
        
        super.group.add();
        
        super.group.plan();
    }
    
}

//删除页面的指令类
class deletePageCommand extends Command{

    //声明自己默认的接收者
    public deletePageCommand(){
        super(new PageGroup());
    }
    
    
    /**  
     * 创建一个新的实例 deletePageCommand.  
     *  
     * @param _receiver  
     */
    public deletePageCommand(Group _receiver) {
        super(_receiver);
        // TODO Auto-generated constructor stub
    }

   

    @Override
    public void execute() {
        super.group.find();
        
        super.group.delete();
        
        super.group.plan();
       
    }
    
}

//接头人类
class Invoker{
    //定义客户的命令
    private Command command;
    
    //接收客户发给我们的指令
    public void setCommand(Command command){
        this.command = command;
        
    }
    
    //接头人执行客户的命令
    public void action(){
        //执行命令
        this.command.execute();
    }
}

public class Manager {
    public static void main(String[] args){
        //定义一个与用户的接头人
        Invoker invoker = new Invoker();
        
        //定义一个发送给接收者的命令
        //高层的Command类进一步与具体的group解耦了,它不需要知道具体的实现类了
        Command command = new deletePageCommand();
        
        System.out.println("用户要删除一个界面");

        //接头人接收命令
        invoker.setCommand(command);
        
        //接头人去处理命令
        invoker.action();
        
    }
}
