 /**  
 * 文件名：Client.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月23日  
 *  
 */
package iterator;

import java.util.*;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Client  
 * 类描述：  迭代器模式测试类
 * 创建人：zhu
 * 创建时间：2014年11月23日 上午11:33:08  
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

//项目信息接口
interface IProject{
    public void add(String name, int num, int cost);
    
    public String getProjectInfo();
    
    public IProjectIterator iterator();
}

//自定义一个迭代器接口
interface IProjectIterator extends Iterator<IProject>{
    
}

//实际项目类
class Project implements IProject{
    private String name = "";
    private int num = 0;
    private int cost = 0;
    
    private ArrayList<IProject> projectList = new ArrayList<IProject>();
    
    //空构造函数
    public Project(){
        
    }
    
    //私有构造函数
    private Project(String _name, int _num, int _cost){
        this.name = _name;
        this.num = _num;
        this.cost = _cost;
    }

    @Override
    public void add(String _name, int _num, int _cost) {
        projectList.add(new Project(_name,_num,_cost));
    }

    @Override
    public String getProjectInfo() {
        StringBuilder info = new StringBuilder();
        info.append("项目名称是:").append(this.name)
        .append("项目人数:").append(this.num)
        .append("项目花费").append(this.cost);
        
        return info.toString();
    }

    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator(this.projectList);
    }
    
}

//实际项目迭代器类
class ProjectIterator implements IProjectIterator{
    
    private ArrayList<IProject> projectList = new ArrayList<IProject>();
    
    private int currentItem = 0;
    
    //构造函数
    public ProjectIterator(ArrayList<IProject> _projectList){
        this.projectList = _projectList;
        
    }
    
    @Override
    public boolean hasNext() {
        boolean b = true;
        if(this.currentItem >= this.projectList.size() || this.projectList.get(this.currentItem)==null){
            b= false;
            return b;
        } else{
            return b;
            
        }
    }

    
    @Override
    public IProject next() {
        return this.projectList.get(this.currentItem++);
    }

   
    @Override
    public void remove() {
        // TODO Auto-generated method stub
    }
    
}

public class Client {
    public static void main(String[] args){
        IProject project = new Project();
        project.add("项目1", 10, 10000);
        project.add("项目2", 20, 20000);
        project.add("项目3", 30, 30000);
        project.add("项目4", 40, 40000);
        
        IProjectIterator iProjectIterator = project.iterator();
        
        while(iProjectIterator.hasNext()){
            IProject p = iProjectIterator.next();
            System.out.println(p.getProjectInfo());
        }
        
    }
}
