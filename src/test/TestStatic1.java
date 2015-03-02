 /**  
 * 文件名：TestStatic1.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年9月25日  
 *  
 */
package test;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：TestStatic1  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年9月25日 下午2:07:36  
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

public class TestStatic1 extends TestStatic{
    
    /*public static void string(String str){
        System.out.println("string");
    }*/
    public static void string(Object str){
        System.out.println("object");
    }
 
    public static void main(String [] args){
        Object obj = new Object();
        TestStatic1.string(obj);
        //null可以匹配任何引用类型
        TestStatic1.string(null);
        TestStatic1.string("asv");
        
        String a = "a";
        String A = "A";
        System.out.println(A.compareTo(a));
    }
   } 


