 /**  
 * 文件名：Medium.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月18日  
 *  
 */
package medium;

import java.util.Random;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Medium  
 * 类描述：  中介者模式demo
 * 创建人：zhu
 * 创建时间：2014年11月18日 下午9:03:27  
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
//采购
class Purchase{
    public void buyIBMComputer(int number){
        //访问库存
        Stock stock = new Stock();
        
        //访问销售
        Sale sale = new Sale();
        
        //得到销售情况
        int saleStatus = sale.getSaleStatus();
        
        //销售不错
        if(saleStatus > 80){
            System.out.println("采购IBM电脑"+number+"台");
            stock.increase(number);
        } else {
            System.out.println("采购IBM电脑"+number/2+"台");
            stock.increase(number/2);
            
        }
    }
    
    public void refuseIBM(){
        System.out.println("不再采购IBM电脑");
    }
}

//库存
class Stock{
    private static int COMPUTER_NUMBER = 100;
    
    //增加库存
    public void increase(int number){
        setStockNumber(getStockNumber() + number);
        System.out.println("目前库存为"+COMPUTER_NUMBER+"台");
        
    }

    //减少库存
    public void decrease(int number){
        setStockNumber(getStockNumber()-number);
        System.out.println("目前库存为"+COMPUTER_NUMBER+"台");
    }
    
    
    /**
     * 得到库存
     * @return the cOMPUTER_NUMBER
     */
    public static int getStockNumber() {
        return COMPUTER_NUMBER;
    }

     /**  
     * @param cOMPUTER_NUMBER the cOMPUTER_NUMBER to set  
     */
    public static void setStockNumber(int cOMPUTER_NUMBER) {
        COMPUTER_NUMBER = cOMPUTER_NUMBER;
    }
    
    public void clearStock(){
        Purchase purchase = new Purchase();
        Sale sale= new Sale();
        System.out.println("清理库存量为"+COMPUTER_NUMBER);
        
        //打折促销
        sale.offSale();
        
        //不再采购
        purchase.refuseIBM();
        
    }
}

//销售
class Sale{

    //销售电脑方法
    public void sellIBMComputer(int number){
        //访问库存
        Stock stock =new Stock();
        
        //访问采购
        Purchase purchase = new Purchase();
        
        //库存不够,继续采购已增加库存
        if(stock.getStockNumber() < number){
            purchase.buyIBMComputer(number);
            System.out.println("销售了IBM"+number+"台");
            
            //库存相应减少
            stock.decrease(number);
        } else{ //库存够
            
            System.out.println("销售了IBM"+number+"台");
            
            //库存相应减少
            stock.decrease(number);
        }
    }
    
    public int getSaleStatus() {
        Random random = new Random(System.currentTimeMillis());
        int saleStatus = random.nextInt(100);
        
        System.out.println("IBM销售情况为"+saleStatus);
        
        return saleStatus;
    }
    
    public void offSale(){
        //访问库存
        Stock stock =new Stock();
        System.out.println("打折销售IBM共"+stock.getStockNumber());
        this.sellIBMComputer(stock.getStockNumber());
    }
    
}


//抽象中介者
abstract class AbstractMediator{
    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;
    
    public AbstractMediator(){
        purchase = new Purchase();
        sale = new Sale();
        stock = new Stock();
    }
    
    public abstract void execute();
}

public class Medium {
    public static void main(String[] args){
        System.out.println("开始采购");
        Purchase purchase = new Purchase();
        purchase.buyIBMComputer(100);
        
        System.out.println("销售电脑");
        Sale sale = new Sale();
        sale.sellIBMComputer(1);
        
        System.out.println("库存管理电脑");
        Stock stock = new Stock();
        stock.clearStock();
        
    }
}
