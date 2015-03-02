 /**  
 * 文件名：Bigger.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月6日  
 *  
 */
package bigger;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Bigger  
 * 类描述：  不用比较运算符，判断int型的a，b两数的大小的答案 
 * 创建人：zhu
 * 创建时间：2014年11月6日 下午2:31:22  
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
public class Bigger {
    
    public static void main(String[] args){
        int a = 8;
        int b = 9;
        String[] strArray = {"a>b","a<b"};
        //计算机系统中,数值一律用补码来存储
        //正数的补码和原码相同,负数的补码为原码符号位不变,其余各位先取反再加1
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(4+(-4)));
        System.out.println(Integer.toBinaryString(2147483647));
        System.out.println(Integer.toBinaryString(-2147483647));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        //value >>> num     --   num 指定要移位值value 移动的位数,忽略符号位扩展,0补最高位(高位在左低位在右).
        //最高位为符号位,1代表负数,0代表正数
        //实际上,在计算机中,如果一个二进制数的最左边的位为1,那么我们可以判断它是一个负数,并且是用补码表示的.
        //在这之所以要把int强转为long是因为如果两个异号的int值做减法后结果可能超过了int型(32位)的最大或最小值
        //导致符号位丢失
        //把相减结果向右移了63位并高位补零后,其实就只剩下了符号位,1就是负数,0就是正数
        int i = (int)((long)a - (long)b >>>63);
        System.out.println(Integer.toBinaryString((int)((long)a - (long)b >>>63)));
        System.out.println(strArray[i]);
        /*
         * a=8,二进制表示为1000
         * <<运算符将二进制位左移,1<<3表示把1的二进制数左移了3位,1就变成了8(1000)
         * 1000&1000的结果还是1000
         * >>运算符将二进制位右移,1000>>2表示把1000右移了两位,变为了10
         * 所以最后的result为10,打出来就是2.
         * */
        int result = (a&(1<<3))>>2;
        System.out.println(result+"二进制表示为:"+Integer.toBinaryString(result));
    }

}
