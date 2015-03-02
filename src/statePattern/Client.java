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
package statePattern;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  状态模式测试类
 * 创建人：zhu
 * 创建时间：2014年11月27日 下午3:31:40  
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

abstract class LiftState{
    protected Context context;
    
    public void setContext(Context context){
        this.context = context;
    }
    
    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();
    
}

class OpenningState extends LiftState{
    @Override
    public void open() {
        System.out.println("电梯门开启!");
    }
    
    @Override
    public void close() {
        //状态修改
        super.context.setLiftState(Context.closingState);
        
        //动作委托CloseState来执行
        super.context.getLiftState().close();
    }

    @Override
    public void run() {
        
    }

    @Override
    public void stop() {
        
    }
    
}

class ClosingState extends LiftState{
    @Override
    public void open() {
        //状态修改
        super.context.setLiftState(Context.openningState);
        
        //动作委托CloseState来执行
        super.context.getLiftState().open();
    }
    
    @Override
    public void close() {
        System.out.println("电梯门关闭!");
    }

    @Override
    public void run() {
        
    }

    @Override
    public void stop() {
        
    }
    
}

class Context{
    public final static OpenningState openningState = new OpenningState();
    public final static ClosingState closingState = new ClosingState();
    
    private LiftState liftState;
    public void setLiftState(LiftState liftState){
        this.liftState = liftState;
        this.liftState.setContext(this);
        
    }
    
    public LiftState getLiftState(){
        return this.liftState;
        
    }
    
    public void open(){
        this.liftState.open();
    };
    public void close(){
        this.liftState.close();
    };
    public void run(){
        
    };
    public void stop(){
        
    };
}

public class Client {
    public static void main(String[] args){
        Context context = new Context();
        
        //初始是关门状态
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.open();
        
        
    }
}
