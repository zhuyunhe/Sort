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
package maxSubSum;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年12月30日 上午10:02:32  
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
    public static int maxSubSum1(int[] a){
        int maxSum = 0;
        for(int i=0; i<a.length; i++){
            for(int j=i; j<a.length; j++){
                int thisSum = 0;
                for(int k=i; k<=j; k++){
                    thisSum += a[k];
                }
                
                if(thisSum >maxSum){
                    maxSum = thisSum;
                }
            }
        }
        
        return maxSum;
    }
    
    public static int maxSubSum2(int[] a){
        int maxSum = 0;
        for(int i=0; i<a.length; i++){
            int thisSum = 0;
            for(int j=i; j<a.length; j++){
                thisSum += a[j];
                
                if(thisSum >maxSum){
                    maxSum = thisSum;
                }
            }
        }
        
        return maxSum;
    }
    
    private static int maxSumRec(int[] a, int left, int right){
        /*if(left == right){
            if(a[left] > 0){
                return a[left];
            } else{
                return 0;
            }
        }*/
        if(left == right){
            return a[left];
        }
        
        int center = (left + right)/2;
        int maxLeftSum = maxSumRec(a,left,center);
        int maxrightSum = maxSumRec(a,center+1,right);
        
        int maxLeftBorderSum = 0;
        int leftBorderSum = 0;
        for(int i=center; i>=left; i--){
            leftBorderSum += a[i];
            if(leftBorderSum > maxLeftBorderSum){
                maxLeftBorderSum = leftBorderSum;
            }
        }
        
        int maxRightBorderSum = 0;
        int rightBorderSum = 0;
        for(int i=center+1; i<=right; i++){
            rightBorderSum += a[i];
            if(rightBorderSum > maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }
        
        if(maxLeftSum > maxrightSum){
            if(maxLeftSum > maxLeftBorderSum+maxRightBorderSum){
                return maxLeftSum;
            } else{
                return maxLeftBorderSum+maxRightBorderSum;
            }
        } else{
            if(maxrightSum > maxLeftBorderSum+maxRightBorderSum){
                return maxrightSum;
            } else{
                return maxLeftBorderSum+maxRightBorderSum;
            }
        }
    }
    
    public static int maxSubSum3(int[] a){
        return maxSumRec(a,0,a.length-1);
    }
    
    public static int maxSubSum4(int[] a){
        int maxSum =0;  
        int thisSum = 0;
        
        for(int i=0; i<a.length; i++){
            thisSum += a[i];
            
            if(thisSum > maxSum){
                maxSum = thisSum;
            } else if(thisSum < 0){
                thisSum = 0;
            }
        }
        return maxSum;
    }
    
    public static void main(String[] args){
        int[] a = {4,-3,5,-2,-1,2,6,-2};
        int maxSum1 = maxSubSum1(a);
        System.out.println(maxSum1);
        int maxSum2 = maxSubSum2(a);
        System.out.println(maxSum2);
        int maxSum3 = maxSubSum3(a);
        System.out.println(maxSum3);
        int maxSum4 = maxSubSum4(a);
        System.out.println(maxSum4);
    }
}
