 /**  
 * 文件名：Bank.java  
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

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Bank  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年9月23日 下午4:11:03  
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
public class Bank {
    
  //构造函数
    public Bank(int n, double initialBalance){

        accounts = new double[n];

        for(int i=0; i<n; i++){
        accounts[i] = initialBalance;    
        }
        
        sufficientFunds = bankLock.newCondition();
    }

    //把钱从一个账户转移到另一个账户的函数
    public void transfer(int from, int to, double amount) throws InterruptedException{
        //封锁锁对象
        bankLock.lock();
        try{
            while(accounts[from] < amount){
            System.out.println(Thread.currentThread());
            System.out.println(accounts[from]+"*******"+amount);
            sufficientFunds.await();
            }
            accounts[from] -= amount;
            //System.out.printf("%10.2f from %d to %d",amount,from,to);
            System.out.print("从"+from+"账户转移了"+amount+"到"+to+"账户");
            accounts[to] += amount;
            System.out.println(getTotalBalance());
            
            //重新激活因余额不足条件而等待的所有线程
            sufficientFunds.signalAll();
            //System.out.printf("Total balance %10.2f%n",getTotalBalance());
            }
        finally{
            //解锁
            bankLock.unlock();
        }
            }
        

    //得到所有账户的总钱数的函数
    public double getTotalBalance(){
        double sum = 0;
        for(double a : accounts){
        sum += a;
        }
        return sum;
    }

    //定义保存账户的数组
    private final double[] accounts;
    
    //定义一个重入锁对象
    private Lock bankLock = new ReentrantLock();
    
    //定义一个条件对象
    private Condition sufficientFunds;

}
