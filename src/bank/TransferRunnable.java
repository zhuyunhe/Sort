 /**  
 * 文件名：TransferRunnable.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年9月23日  
 *  
 */
package bank;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：TransferRunnable  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年9月23日 下午4:11:37  
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
public class TransferRunnable implements Runnable {
  //定义构造函数
    public TransferRunnable(Bank b, int from, double max){
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    public void run(){
        try{
        while(true){
        int toAccount = (int)(100*Math.random());
        double amount = maxAmount * Math.random();
        bank.transfer(fromAccount,toAccount,amount);
        Thread.sleep((int)(DELAY*Math.random()));
        }
        }
        catch(InterruptedException e){
        
        }
    }
    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;
}
