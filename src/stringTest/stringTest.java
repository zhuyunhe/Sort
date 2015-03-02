 /**  
 * 文件名：stringTest.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年9月26日  
 *  
 */
package stringTest;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：stringTest  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年9月26日 下午3:25:03  
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
public class stringTest {
    public static void main(String[] args){
        //new操作时,不管字符串池中有没有"abc",都会在堆中新建一个字符串对象,然后将其引用赋给str
        String str1=new String("abc");  
        String str2=new String("abc");  
        System.out.println(str1==str2);
        
        String str3 ="abc";
        String str4 = "abc";
        System.out.println(str3==str4);
        
    }

}
