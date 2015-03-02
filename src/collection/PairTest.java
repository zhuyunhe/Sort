 /**  
 * 文件名：PairTest.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年8月5日  
 *  
 */
package collection;
/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：PairTest  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年8月5日 上午10:03:08  
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
public class PairTest {
    public static void main(String[] args){
        String[] words = {"zhu","abc","aaa"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min=" + mm.getFirst());
        System.out.println("min=" + mm.getSecond());    
    }
}
    
    class ArrayAlg{
        public static Pair<String> minmax(String[] a){
        if(a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for(int i=1; i<a.length; i++){
            //compareTo方法，如第一个字符串比第二个字符串靠后（大），返回正值
            if(min.compareTo(a[i]) > 0) min = a[i];
            
            //compareTo方法，如第一个字符串比第二个字符串靠前（小），返回负值
            if(max.compareTo(a[i]) < 0) max = a[i];    
        }
        
        //实例化一个泛型类
        return new Pair<String>(min,max);
        }
        
        //定义一个泛型方法
        public static <T> T getMiddle(T[] a){
            return a[a.length/2];
            
        }
        
    }

    //一个泛型类
    class Pair<T>{
        public Pair(T min,T max){
        this.first = min;
        this.second = max;
        }

        public T getFirst(){
            return first;
        }
        public T getSecond(){
            return second;
        }

        /**  
         * @param first the first to set  
         */
        public void setFirst(T first) {
            this.first = first;
        }

        /**  
         * @param second the second to set  
         */
        public void setSecond(T second) {
            this.second = second;
        }

        private T first;
        private T second;
    }

