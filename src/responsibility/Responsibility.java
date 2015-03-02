 /**  
 * 文件名：Responsibility.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月20日  
 *  
 */
package responsibility;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Responsibility  
 * 类描述：  责任链模式
 * 创建人：zhu
 * 创建时间：2014年11月20日 下午9:36:51  
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
import java.util.*;

//决策者抽象类
abstract class Handler{
    public final static int FATHER_LEVEL_REQUEST=1;
    public final static int HUSBAND_LEVEL_REQUEST=2;
    public final static int SON_LEVEL_REQUEST=3;
    
    //能处理的级别
    private int level=0;
    
    //定义接班人
    private Handler nextHandler;
    
    public Handler(int _level){
        this.level = _level;
    }
    
    public final void HandleMessage(IWomen women){
      //未婚少女
        if(women.getStatus() == this.level){
            this.response(women);
        } else if(this.nextHandler != null){ //如有接班人,让接班人处理
            this.nextHandler.response(women);
        } else{ //没有接班人了,不处理
            System.out.println("没人了,不处理了");
        }
    }
     public abstract void response(IWomen women);
     
     public void setNext(Handler _handler){
         this.nextHandler = _handler;
         
     }
    
    
    
}

//女性接口
interface IWomen{
    //获得个人情况,已嫁,未嫁,夫死
    public int getStatus();
    
    //获得个人请示,你要干什么?逛街,约会,ktv?
    public String getRequest();
}

//每个实现类只需要1.定义自己的级别,2.做出自己的response
//父亲类
class Father extends Handler{

    /**  
     * 创建一个新的实例 Father.  
     *  
     * @param _level  
     */
    public Father() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    
    @Override
    public void response(IWomen women) {
        System.out.println("请示"+women.getRequest()+",父亲同意");
    }
    
    

    
}

//丈夫类
class Husband extends Handler{

    /**  
     * 创建一个新的实例 Husband.  
     *  
     * @param _level  
     */
    public Husband() {
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("请示"+women.getRequest()+",老公同意");
    }
    
}

//儿子类
class Son extends Handler{

    /**  
     * 创建一个新的实例 Son.  
     *  
     * @param _level  
     */
    public Son() {
        super(Handler.SON_LEVEL_REQUEST);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void response(IWomen women) {
        System.out.println("请示"+women.getRequest()+",儿子同意");
    }
  
}

//妇女实现类
class Women implements IWomen{
    //1未嫁,2出嫁,3夫死
    private int status = 1;
    
    //请示
    private String request="";
    
    //构造函数
    public Women(int _status, String _request){
        this.status = _status;
        switch(this.status){
        case 1:
            this.request = "女儿请求是";
            break;
        case 2:
            this.request = "妻子请求是";
            break;
        case 3:
        this.request = "母亲请求是";
        break;
        }
        
        this.request = _request;
        }
        
    
   
    @Override
    public int getStatus() {
        // TODO Auto-generated method stub
        return this.status;
    }

    
    @Override
    public String getRequest() {
        // TODO Auto-generated method stub
        return this.request;
    }
    
}
public class Responsibility {
    public static void main(String[] args){
        //随即挑选几名女性
        Random ran = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<IWomen>();
        for(int i=0; i<5; i++){
            arrayList.add(new Women(ran.nextInt(4),"要买包包"));
        }
        
        //定义三个请示对象
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();
        
        //设置请求顺序
        father.setNext(husband);
        husband.setNext(son);
        
        //循环,五个女的轮一圈
        for(IWomen women : arrayList){
            father.HandleMessage(women);
        }
    }

}
