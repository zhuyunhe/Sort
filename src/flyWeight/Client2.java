 /**  
 * 文件名：Client2.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年12月14日  
 *  
 */
package flyWeight;

import java.util.HashMap;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client2  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年12月14日 下午6:12:42  
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
class ExtrinsicState{
    //考试科目
    private String subject;
    
    //考试地点
    private String location;

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**  
     * @param subject the subject to set  
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**  
     * @param location the location to set  
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
    @Override
    public boolean equals(Object obj){
        //使用运行时类型信息（RTTI）
        if(obj instanceof ExtrinsicState){
            ExtrinsicState state = (ExtrinsicState) obj;
            
            boolean result = state.getLocation().equals(location)&&state.getSubject().equals(subject);
            
            return result;
            
        }
        return false;
        
    }
    
    @Override
    public int hashCode(){
        return subject.hashCode() + location.hashCode();
    }
    
}

class SignInfoFactory2{
    //池容器
    //把一个对象作为Map类的键值，一定要确保重写equals和hashCode方法，否则会出现通过键值搜索失败的情况
    private static HashMap<ExtrinsicState,SignInfo> pool = new HashMap<ExtrinsicState,SignInfo>();
    
    public static SignInfo getSignInfo(ExtrinsicState key){
        SignInfo result = null;
        
        if(!pool.containsKey(key)){
            result = new SignInfo();
            pool.put(key, result);
        } else{
            result = pool.get(key);
        }
        return result;
    }
}

public class Client2 {
    public static void main(String[] args){
        ExtrinsicState state1 = new ExtrinsicState();
        state1.setLocation("大理");
        state1.setSubject("科目1");
        SignInfoFactory2.getSignInfo(state1);

        ExtrinsicState state2 = new ExtrinsicState();
        state2.setLocation("北京");
        state2.setSubject("科目1");
        SignInfoFactory2.getSignInfo(state2);
        
        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        
        for(int i=0; i<1000000; i++){
            SignInfoFactory2.getSignInfo(state1);
        }
        
        long tailTime = System.currentTimeMillis();
        System.out.println(tailTime);
        
        System.out.println("执行时间"+(tailTime-currentTime)+"毫秒");
    }
}
