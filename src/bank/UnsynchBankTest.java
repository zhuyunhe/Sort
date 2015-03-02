 /**  
 * 文件名：UnsynchBankTest.java  
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

import java.util.List;
import java.util.Map;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：UnsynchBankTest  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年9月23日 下午4:10:29  
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
public class UnsynchBankTest {
    public static void main(String[] args){

        Bank b = new Bank(NACCOUNTS,INITIAL_BALANCE);

        int i;
        
        for(i=0; i<NACCOUNTS; i++)
        {
         TransferRunnable r = new TransferRunnable(b,i,INITIAL_BALANCE);
         Thread t = new Thread(r);
         t.start();
    }
    }

    //共有一百个账户,静态常量:final static(final表示构建对象时必须初始化这个域并不能修改,static表示该实例域属于类,可通过类名.XX获得这个常量)
    public static final int NACCOUNTS = 100;

    //每个账户有1000元
    public static final double INITIAL_BALANCE = 1000;

}
