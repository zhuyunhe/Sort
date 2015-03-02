 /**  
 * 文件名：MyArrayList.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2014年12月31日  
 *  
 */
package myArrayList;

import java.util.Iterator;

/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：MyArrayList  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2014年12月31日 下午3:45:44  
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
public class MyArrayList<E>{
    
    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private E[] theItems;
    
    public MyArrayList(){
        clear();
    }
    
    public void clear(){
        this.theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
        
        
    }
    
    public int size(){
        return this.theSize;
    }
    
    public boolean isEmpty(){
        return this.size()==0;
    }
    
    public void trimToSize(){
        
    }

    public E get(int idx){
        if(idx<0 || idx>=this.size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.theItems[idx];
    }
    
    public E set(int idx, E newVal){
        if(idx<0 || idx>=this.size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        E oldItem = this.theItems[idx];
        this.theItems[idx] = newVal;
        return oldItem;
    }
    
    public void ensureCapacity(int newCapacity){
        if(newCapacity < this.theSize){
            return;
        }
        
        E[] old = this.theItems;
        theItems = (E[])new Object[newCapacity];
        for(int i=0; i<this.size();i++){
            theItems[i] = old[i];
        }
    }
    
    public boolean add(E e){
        add(size(),e);
        return true;
    }
    
    public void add(int idx,E e){
        if(this.theItems.length == this.size()){
            this.ensureCapacity(this.size()*2+1);
        }
        for(int i=this.theSize; i>idx; i--){
            this.theItems[i] = this.theItems[i-1];
        }
        this.theItems[idx] = e;
        
        this.theSize++;
    }
    
    public E remove(int idx){
        E removeItem = this.theItems[idx];
        for(int i=idx; i<this.size()-1; i++){
            this.theItems[i] = this.theItems[i+1];
        }
        this.theSize--;
        return removeItem;
    }
    
    public Iterator<E> iterator(){
        return new ArrayListIterator();
    }
    
    private class ArrayListIterator implements java.util.Iterator<E>{
        private int current = 0;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current<size();
        }
       
        @Override
        public E next() {
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            return theItems[current++];
        }
        
        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
            
        }
        
    }
    
    public static void main(String[] args){
        MyArrayList<String> list = new MyArrayList<String>();
        list.add("zhu");
        list.add("li");
    }

}
