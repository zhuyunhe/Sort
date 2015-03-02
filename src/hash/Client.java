 /**  
 * 文件名：Client.java  
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

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  测试哈希函数
 * 创建人：zhu
 * 创建时间：2014年12月26日 上午9:56:10  
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
    public static int getHashCode(String str){
        char[] s = str.toCharArray();
        int hash = 0;
        for(int i=0; i<s.length; i++){
            System.out.println(s[i]);
            //计算时用字符的unicode值
            hash = s[i] + 31*hash;
        }
        return hash;
    }
    
    public static int getHashCode(int k){
        int m = 5;
        int hash = k%m;
        
        return hash;
    }
    
    public static void main(String[] args){
        String str = "call";
        int hash = getHashCode(str);
        System.out.println(hash);
        
        int k = 99;
        hash = getHashCode(k);
        System.out.println(hash);
    }
}
