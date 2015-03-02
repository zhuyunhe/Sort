 /**  
 * 文件名：SeperateChain.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年12月26日  
 *  
 */
package hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：SeperateChain  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年12月26日 下午2:27:47  
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

class TableStorePage{
    
}

public class SeperateChain {
    private Entry[] table;
    
    private int size;
    
    private int threshold;
    
    //构造函数，默认构造一个初始大小为16，负载因子为0.75的table
    public SeperateChain(){
        threshold = 12;
        table = new Entry[16];

    }
    
    final int size(){
        return size;
    }
    
    final boolean isEmpty(){
        return size == 0;
    }
    
    
    public static void main(String[] args){
        
    }
}
