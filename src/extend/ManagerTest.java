 /**  
 * 文件名：ManagerTest.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年10月21日  
 *  
 */
package extend;

import java.util.*;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：ManagerTest  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年10月21日 下午10:08:52  
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
public class ManagerTest {
    public static void main(String[] agrs){
        Manager boss = new Manager("zhu",80000,1991,01,02);
        boss.setBouns(10000);
        
        boss.setName("zhuyunhe");
        
        
        Employee[] staff = new Employee[3];
        
        staff[0] = boss;
        staff[1] = new Employee("li",50000,1991,02,01);
        staff[2] = new Employee("a",60000,1991,02,01);
        
        Employee original = new Employee("zuo",20000,1991,10,16);
        
        try {
            //clone方法抛出了一个已检查异常,这里需要处理
            Employee copy = original.clone();
            Date newHireDay = new GregorianCalendar(2000,11,15).getTime();
            copy.setHireDay(newHireDay);
  
            System.out.println(original.getHireDay()+"//"+copy.getHireDay());
            
            Employee bossCopy = boss.clone();
            System.out.println(bossCopy.getClass().getName()+"//"+bossCopy.getSalary());
            System.out.println(Employee.yy);
        } catch (CloneNotSupportedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        
    }

}

//员工类
class Employee implements Cloneable{
    //带参数的构造器
    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        hireDay = calendar.getTime();
    }
    
    //重写克隆函数
    public Employee clone() throws CloneNotSupportedException{
        Employee cloned = (Employee) super.clone();
        
        cloned.hireDay = (Date)hireDay.clone();
        
        return cloned;
        
    }
    
    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**  
     * @param name the name to set  
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }
    /**  
     * @param salary the salary to set  
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    /**
     * @return the hireDay
     */
    public Date getHireDay() {
        return hireDay;
    }
    /**  
     * @param hireDay the hireDay to set  
     */
    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }
    
    //涨工资函数
    public void raiseSalary(double percent){
        salary += salary*percent/100;
    }
    
    private String name;
    private double salary;
    private Date hireDay;
    private String alise;
    //final域,构建对象时必须初始化的域,也就是说在每个构造器(可能有很多构造器)执行之后,这个域都要被赋值
    //可以在定义时候就赋值,或者在构造器中去赋值
    final int x = 0;
    
    //类变量,静态域,可以不赋值,但一般都定义时赋值,因为static修饰的变量只能被初始化一次
    static final float yy=1;
}

//经理类
class Manager extends Employee{

    /**  
     * 创建一个新的实例 Manager.  
     *  
     * @param n
     * @param s
     * @param year
     * @param month
     * @param day  
     */
    public Manager(String n, double s, int year, int month, int day) {
        //调用超类的构造函数来初始化超类的私有域,super必须是子类构造器的第一句话
        super(n, s, year, month, day);
        // TODO Auto-generated constructor stub
        this.bouns = 0;
    }
    
    //重写了超类方法
    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary += bouns;
        
    }
    
    /**
     * @return the bouns
     */
    public double getBouns() {
        return bouns;
    }

    /**  
     * @param bouns the bouns to set  
     */
    public void setBouns(double bouns) {
        this.bouns = bouns;
        
        //局部变量不赋初值是不能使用的
        int a;
        //System.out.println(a);
    }

    private double bouns;
    
    static int j;
    
    static{
        //定义在静态块以后的静态变量,只能对其赋值,不能访问
        i = 1;
        //下面这条访问i的操作不行
        //j = i;
    }
    static int i;
}