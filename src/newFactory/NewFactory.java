 /**  
 * 文件名：NewFactory.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月15日  
 *  
 */
package newFactory;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：NewFactory  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年11月15日 下午2:47:03  
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
interface Human{
    public void getColor();
    public void getSex();
}

//白人抽象类
abstract class WhiteHuman implements Human{
    public void getColor(){
        System.out.println("我是白人");
    }
    
}

//黑人抽象类
abstract class BlackHuman implements Human{
    public void getColor(){
        System.out.println("我是黑人");
    }
}

//黄人抽象类
abstract class YellowHuman implements Human{
    public void getColor(){
        System.out.println("我是黄人");
    }
}

class MaleWhiteHuman extends WhiteHuman{
    
    @Override
    public void getSex() {
        System.out.println("我是白男");
    }
}

class FemaleWhiteHuman extends WhiteHuman{
    public void getSex(){
        System.out.println("我是白女");
    }
}

class MaleBlackHuman extends BlackHuman{
    
    @Override
    public void getSex() {
        System.out.println("我是黑男");
    }
}

class FemaleBlackHuman extends BlackHuman{
    public void getSex(){
        System.out.println("我是黑女");
    }
}

class MaleYellowHuman extends YellowHuman{
    
    @Override
    public void getSex() {
        System.out.println("我是黄男");
    }
}

class FemaleYellowHuman extends YellowHuman{
    public void getSex(){
        System.out.println("我是黄女");
    }
}

//总车间
interface HumanFactory{
    public Human createWhiteHuman();
    public Human createYellowHuman();
    public Human createBlackHuman();
}

//女性车间
class FemaleHumanFactory implements HumanFactory{

   
    @Override
    public Human createWhiteHuman() {
        
        return new FemaleWhiteHuman();
    }

    
    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    
    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }
    
}

//男性车间
class MaleHumanFactory implements HumanFactory{

   
    @Override
    public Human createWhiteHuman() {
        return new MaleWhiteHuman();
    }

   
    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }

   
    @Override
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }
    
}

public class NewFactory {
    public static void main(String[] args){
        //没有任何一个方法与实现类有关系,我们只要知道它的工厂方法,就可以直接生产出一个产品对象,无需关心它的实现类.
        //这里一共有两个产品族,男人/女人,每个产品族下又有三种产品(黑,白,黄种人)
        
        HumanFactory femaleHumanFactory = new FemaleHumanFactory();
        HumanFactory maleHumanFactory = new MaleHumanFactory();
        
        //构造一个白人男性
        Human whiteMan = maleHumanFactory.createWhiteHuman();
        whiteMan.getColor();
        whiteMan.getSex();
    }

}
