 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月21日  
 *  
 */
package calculator;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年11月21日 下午5:24:48  
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

enum Calculator{
    //加法
    ADD("+"){
        public int exec(int a, int b){
            return a+b;
        }
    },
  //减法
    SUB("-"){
        public int exec(int a, int b){
            return a-b;
        }
    };
    
    String value = "";
    
    //定义成员值类型
    private Calculator (String _value){
        this.value = _value;
    }
    
    public String getValue(){
        return this.value;
    }
    
    public abstract int exec(int a, int b);
}

public class Client {
    
    public static void main(String[] args){
        //int a = Integer.parseInt(args[0]);
        int a = 1;
        
        String symbol = "+"; //符号
        
        //int b = Integer.parseInt(args[2]);
        int b = 2;
        
        System.out.println("运行结果为"+a+symbol+b+"="+Calculator.ADD.exec(a, b));
        
    }
}
