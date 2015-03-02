 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月27日  
 *  
 */
package visitor;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  访问者模式
 * 创建人：zhu
 * 创建时间：2014年11月27日 上午9:45:56  
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
interface Role{
    public void accept(AbsActor actor);
}

//牛逼角色
class KungFuRole implements Role{

    @Override
    public void accept(AbsActor actor) {
        actor.act(this);
    }
    
}

//傻逼角色
class IdiotRole implements Role{

    @Override
    public void accept(AbsActor actor) {
        actor.act(this);
    }
    
}

//抽象演员类
abstract class AbsActor{
    public void act(Role role){
        System.out.println("演员可以扮演任何角色!");
    }
    
    //重载
    public void act(KungFuRole role){
        System.out.println("演员可以演功夫角色!");
    }
}

class YoungActor extends AbsActor{
    //年轻演员喜欢功夫戏
    //覆写父类方法
    public void act(KungFuRole role){
        System.out.println("我年轻要演功夫戏!");
    }
}

class OldActor extends AbsActor{
    //年轻演员喜欢功夫戏
    //覆写父类方法
    public void act(KungFuRole role){
        System.out.println("我年纪大了演不来功夫戏!");
    }
}

public class Client {
    public static void main(String[] args){
        //定义一个演员
        AbsActor actor = new OldActor();
        
        //定义一个角色
        Role role = new KungFuRole();
        
        //接受一个访问者,并执行访问者的职责
        //Java虽然是单分派语言,但通过访问者模式可以支持双分派,达到我们想要效果
        role.accept(actor);
        
    }
}
