 /**  
 * 文件名：SetTest.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年7月25日  
 *  
 */
package collection;
import java.util.*;
/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：SetTest  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年7月25日 上午11:16:54  
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
public class SetTest {
    public static void main(String[] args){
        System.out.println("zhu");
        //实例一个hashSet
        Set<String> words = new HashSet<String>();
        
        long totalTime = 0;
        
        Scanner in = new Scanner(System.in);
        
        while(in.hasNext()){
            String word = in.next();
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            totalTime += callTime;
        }
        
        Iterator<String> iter = words.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next() + totalTime);
            
        }
        in.close();
    }
    

}
