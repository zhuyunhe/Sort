 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年12月13日  
 *  
 */
package flyWeight;

import java.util.HashMap;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年12月13日 下午10:01:31  
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

class SignInfo{
    private String id;
    private String location;
    private String subject;
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**  
     * @param id the id to set  
     */
    public void setId(String id) {
        this.id = id;
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
    
}

class SignInfoFactory{
    //容器池
    private static HashMap<String,SignInfo> pool = new HashMap<String,SignInfo>();
    
    
    
    public static SignInfo getSignInfo(String key){
        
        SignInfo result = null;
        
        if(!pool.containsKey(key)){
            System.out.println(key+"----建立对象，并放入对象池中");
            
            result = new SignInfo4Pool(key);
            
            pool.put(key, result);
        } else{
            result = pool.get(key);
            
            System.out.println(key+"----直接从池中取得");
        }
        
        return result;
    }
}

class SignInfo4Pool extends SignInfo{
    private String key;
    
    public SignInfo4Pool(String _key){
        this.key = _key;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**  
     * @param key the key to set  
     */
    public void setKey(String key) {
        this.key = key;
    }
    
}

public class Client {
    public static void main(String[] args){
        for(int i=0; i<4; i++){
            String subject = "科目"+i;
            
            //初始化地址
            for(int j=0; j<30; j++){
                String key = subject + "考试地点" + j;
                
                SignInfoFactory.getSignInfo(key);
            }
        }
        SignInfo signInfo = SignInfoFactory.getSignInfo("科目1考试地点2");
        signInfo.setId("1");
        
    }

}
