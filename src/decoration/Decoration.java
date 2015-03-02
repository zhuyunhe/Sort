 /**  
 * 文件名：Decoration.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年11月21日  
 *  
 */
package decoration;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：Decoration  
 * 类描述：  装饰模式测试类
 * 创建人：zhu
 * 创建时间：2014年11月21日 上午10:59:50  
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
//学校成绩单抽象类
abstract class SchoolReport{
    //汇报成绩
    public abstract void report();
    
    //家长签字
    public abstract void sign(String _name);
}

class MySchoolReport extends SchoolReport{

    @Override
    public void report() {
        System.out.println("我这次语文考了60!");
    }

    /**
     * (non-Javadoc)  
     * @see decoration.SchoolReport#sign(java.lang.String)  
     */
    @Override
    public void sign(String _name) {
        System.out.println("爹签字:" + _name);
    }
    
}

//修饰的抽象类
//目的是要让这个修饰抽象类的子类来封装成绩单类的子类
abstract class Decorator extends SchoolReport{
    private SchoolReport sr;
    
    //构造函数,把原始成绩单传过来
    public Decorator(SchoolReport _sr){
        this.sr = _sr;
    }
    
    public void report(){
        this.sr.report();
    }
    
    public void sign(String _name){
        this.sr.sign(_name);
    }
    
}

//高分装饰类
class HighScoreDecorator extends Decorator{
    
    //构造函数
    public HighScoreDecorator(SchoolReport _sr) {
        super(_sr);
    }
    
    private void reportHighScore(){
        System.out.println("这次语文最高分才70!");
    }
    
    //重写report方法
    @Override
    public void report(){
        //先报最高分
        this.reportHighScore();
        
        //报自己成绩
        super.report();
        
    }
    
}

//排名装饰类
class SortDecorator extends Decorator{

    public SortDecorator(SchoolReport _sr) {
        super(_sr);
    }
    
    private void reportSort(){
        System.out.println("这次我排名20");
    }
    
    public void report(){
        super.report();
        
        this.reportSort();
    }
    
}

public class Decoration {
    public static void main(String[] args){
        SchoolReport sr;
        
        //得到原始成绩单
        sr = new MySchoolReport();
        
        //先用高分修饰
        sr = new HighScoreDecorator(sr);
        
        //再用排名修饰
        sr = new SortDecorator(sr);
        
        //上面这两语句顺序颠倒也没事
        
        //报告
        sr.report();
        
        //爹签字
        sr.sign("朱");
    }
}
