 /**  
 * 文件名：EmployClone.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年10月22日  
 *  
 */
package clone;

import java.util.Date;
import java.util.GregorianCalendar;


/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：EmployClone  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年10月22日 下午9:10:13  
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
public class EmployClone {
    public static void main(String args[]){
        Manager boss = new Manager(50000,1991,01,02);
        
        
        //Manager boss2 = (Manager) boss.clone();
        //boss2.setBouns(10000);
        //System.out.println(boss.getSalary());
    }

}

//员工类
class Employee{
  //带参数的构造器
  public Employee(double salary, int year, int month, int day){
      this.salary = salary;
      GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
      hireDay = calendar.getTime();
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
  
  private double salary;
  private Date hireDay;
  
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
  public Manager(double s, int year, int month, int day) {
      //调用超类的构造函数来初始化超类的私有域,super必须是子类构造器的第一句话
      super(s, year, month, day);
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
  }

  private double bouns;
  
}