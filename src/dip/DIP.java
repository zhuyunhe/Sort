 /**  
 * 文件名：DIP.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月13日  
 *  
 */
package dip;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：DIP-依赖倒置原则
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年11月13日 上午10:30:49  
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
//驾驶员接口
interface IDriver{
    //在接口中声明了依赖对象,这也叫接口注入
    public void drive(ICar car);
}
//汽车接口
interface ICar{
    public void run();
}

class Driver implements IDriver{

    /**
     * (non-Javadoc)  
     * @see dip.IDriver#drive(dip.ICar)  
     */
    @Override
    public void drive(ICar car) {
        car.run();
    }
    
}

class Benz implements ICar{
    public void run(){
        System.out.println("开奔驰");
    }
}
class BMW implements ICar{
    public void run(){
        System.out.println("开宝马");
    }
}

//DIP类就是高层模块,里面是高层应用逻辑,它对底层模块(Driver,Car)的依赖都建立在抽象IDriver,ICar上
public class DIP {
    public static void main(String[] args){
        //zhu表面类型是IDriver,在以后的操作中,zhu都是以IDriver类型进行操作,屏蔽了细节对抽象的影响.
        IDriver zhu = new Driver();
        //benz,bmw同上
        ICar benz = new Benz();
        ICar bmw = new BMW();
        zhu.drive(benz);
        zhu.drive(bmw);
        
    }

}

