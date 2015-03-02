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
package frog;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  井不关心白天黑夜,井啥都不用知道,只要知道自己的高度
 *       青蛙要关心白天还是夜晚
 * 创建人：zhu
 * 创建时间：2014年11月27日 下午5:27:50  
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
//井
class Well{
    //井高度
    private int height;
    
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

interface IFrog{
    public final static Context day = new Day();
    public final static Context night = new Night();
    
    public void jump();
}

//青蛙
class Frog implements IFrog{
    //青蛙一共跳了多少米
    private int jumpHeight = 0;
    
    //青蛙外界环境:白天或夜晚
    private Context context;
    
    public Context getContext() {
        return context;
    }
    
    public void setContext(Context context) {
        this.context = context;
    }
    
    public int getJumpHeight() {
        return this.jumpHeight;
    }

    @Override
    //青蛙跳
    public void jump() {
        //白天跳
        if(this.context.getClass().isInstance(day)){
            this.jumpHeight += 2;
            System.out.println("白天跳了2米");
            
            //天黑了
            this.context = this.context.turn();
        } else if(this.context.getClass().isInstance(night)){ //晚上跳
            this.jumpHeight -= 1;
            System.out.println("晚上掉了1米");
            
            //天亮了
            this.context = this.context.turn();
        }
    }

}

//环境接口
interface Context{
    //黑白交替
    public Context turn();
}

//白天
class Day implements Context{
    @Override
    //天黑了
    public Night turn() {
        return new Night();
        
    }
    
}

//黑夜
class Night implements Context{
    @Override
    //天亮了
    public Day turn() {
        return new Day();
        
    }
    
}

public class Client {
    public static void main(String[] args){
        //得到一口井
        Well well = new Well();
        
        //设置井的高度
        well.setHeight(100);
        
        //一只青蛙
        Frog frog = new Frog();
        //青蛙准备在白天开始跳
        frog.setContext(IFrog.day);
        while(frog.getJumpHeight() < well.getHeight()){
            //青蛙跳
            frog.jump();
        }
        
        System.out.println("跳出来了~一共跳了" + frog.getJumpHeight() +"米");
    }
}
