 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年12月29日  
 *  
 */
package math;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年12月29日 下午4:24:08  
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
public class Client {
    public static int f(int x){
        if(x == 0){
            return 0;
        } else{
            x = 2 * f(x-1) + x;
            return x;
        }
        
    }
    
    public static void main(String[] args){
        int y = f(5);
        System.out.println(y);
    }
}
