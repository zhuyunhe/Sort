 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月28日  
 *  
 */
package interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  解释器模型测试类
 * 创建人：zhu
 * 创建时间：2014年11月28日 上午9:30:39  
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

abstract class Expression{
    public abstract int interpreter(HashMap<String,Integer> var);
}

class VarExpression extends Expression{

    private String key;
    
    //构造函数
    public VarExpression(String _key){
        this.key = _key;
    }
    
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
    
}

abstract class SymbolExpression extends Expression{
    protected Expression left;
    protected Expression right;
    
    public SymbolExpression(Expression _left, Expression _right){
        this.left = _left;
        this.right = _right;
    }
    
}

class AddExpression extends SymbolExpression{

    /**  
     * 创建一个新的实例 AddSymbolExpression.  
     *  
     * @param _left
     * @param _right  
     */
    public AddExpression(Expression _left, Expression _right) {
        super(_left, _right);
    }

   
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var)+super.right.interpreter(var);
    }
    
}

class SubExpression extends SymbolExpression{

    /**  
     * 创建一个新的实例 SubSymbolExpression.  
     *  
     * @param _left
     * @param _right  
     */
    public SubExpression(Expression _left, Expression _right) {
        super(_left, _right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var)-super.right.interpreter(var);
    }
    
}

class Calculator{
    private Expression expression;
    
    //构造函数传参并解析
    public Calculator(String expStr){
        //定义一个栈,安排运算先后顺序
        Stack<Expression> stack = new Stack<Expression>();
        
        //表达式拆分成字符数组
        char[] charArray = expStr.toCharArray();
        
        //运算
        Expression left = null;
        Expression right = null;
        
        for(int i=0; i<charArray.length; i++){
            switch(charArray[i]){
            case'+':
                left = stack.pop();
                right = new VarExpression(String.valueOf(charArray[++i]));
                stack.push(new AddExpression(left,right));
                break;
                
            case'-':
                left = stack.pop();
                right = new VarExpression(String.valueOf(charArray[++i]));
                stack.push(new SubExpression(left,right));
                break;
                
            //公式中的变量
            default:
                stack.push(new VarExpression(String.valueOf(charArray[i])));
                
            }
        }
        //抛出运算结果
        this.expression = stack.pop();
        
    }
    
    //开始运算
    public int run(HashMap<String,Integer> var){
        return this.expression.interpreter(var);
    }
}

public class Client {
    public static void main(String[] args) throws IOException{
        //输入表达式
        String expStr = getExpStr();
        
        //赋值
        HashMap<String,Integer> var = getValue(expStr);
        
        Calculator cal = new Calculator(expStr);
        
        System.out.println("运算结果为:"+expStr+"="+cal.run(var));
        
        
        
    }
    public static String getExpStr() throws IOException{
        System.out.println("请输入表达式:");
        String expStr = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        return expStr;
        
    }
    
    public static HashMap<String,Integer> getValue(String expStr) throws IOException{
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        //解析有几个参数要传递
        for(char c : expStr.toCharArray()){
            if(c!='+' && c!='-'){
                //解决重复参数
                if(!map.containsKey(String.valueOf(c))){
                    System.out.println("请输入"+c+"的值:");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    
                    map.put(String.valueOf(c), Integer.valueOf(in));
                }
            }
        }
        
        return map;
        
    }
}
