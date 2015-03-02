 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年12月30日  
 *  
 */
package gcd;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年12月30日 下午3:57:22  
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
    //求最大公因数的欧几里得算法
    public static long gcb(long m,long n){
        while(n != 0){
            long rem = m%n;
            m = n;
            n = rem;
        }
        return m;
    }
    
    //幂指数
    public static long pow(long x, int n){
        if(n == 0){
            return 1;
        }else if(n == 1){
            return x;
        } 
        else if(isEven(n)){
            return pow(x*x,n/2);
        } else{
            return pow(x*x,n/2)*x;
        }
    }
    
    public static boolean isEven(long x){
        if(x % 2 == 0){
            return true;
        } else{
            return false;
        }
    }
    
    public static void main(String[] args){
        long result = gcb(1989,1590);
        System.out.println(result);
        long p = pow(2,7);
        System.out.println(p);
    }  
}
