 /**  
 * 文件名：MyLinkedList.java  
 *  
 * 总体描述：
 * 版权: Edatongtu Software LTD.co Copyright (c) 2013
 * 公司: 易达通途股份有限公司
 * 作者: 
 * 版本：  
 * 创建时间：2015年1月4日  
 *  
 */
package myLinkedList;


/**  
 *   
 * 项目名称：javaStudy  
 * 类名称：MyLinkedList  
 * 类描述：  
 * 创建人：zhu
 * 创建时间：2015年1月4日 上午11:19:41  
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
public class MyLinkedList<E> {
    //链表类中的节点类，是一个嵌套类
    private static class Node<E>{
        public Node(E e,Node<E> p,Node<E> n){
            data = e;
            prev = p;
            next = n;
        }
        
        private E data;
        private Node<E> prev;
        private Node<E> next;
        
        
    }
    
    private MyLinkedList(){
        clear();
    }
    
    public void clear(){
        this.beginMarker = new Node<E>(null,null,null);
        this.endMarker = new Node<E>(null,this.beginMarker,null);
        this.beginMarker.next = this.endMarker;
        
        this.theSize = 0;
        this.modCount++;
        
    }
    
    public int size(){
        return this.theSize;
    }
    
    public boolean isEmpty(){
        return this.size() == 0;
    }
    
    public boolean add(E e){
        add(this.size(),e);
        return true;
    }
    
    public void add(int idx,E e){
        addBefore(getNode(idx),e);
    }
    
    public E get(int idx){
        return getNode(idx).data;
    }
    
    public E set(int idx,E newVal){
        Node<E> p = getNode(idx);
        E oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }
    
    public E remove(int idx){
        return remove(getNode(idx));
    }
    
    private void addBefore(Node<E> p,E e){
        Node<E> newNode = new Node<E>(e,p.prev,p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        this.theSize++;
        this.modCount++;
    }
    
    private E remove(Node<E> p){
        p.next.prev = p.prev;
        p.prev.next = p.next;
        this.theSize--;
        this.modCount++;
        
        return p.data;
        
    }
    
    private Node<E> getNode(int idx){
        Node<E> p;
        if(idx<0 || idx>this.size()){
            throw new IndexOutOfBoundsException();
        }
        
        if(idx<this.size()/2){
            p=this.beginMarker.next;
            for(int i=0; i<idx; i++){
                p=p.next;
            }
        } else{
            p=this.endMarker;
            for(int i=this.size(); i>idx; i--){
                p=p.prev;
            }
        }
        
        return p;
    }
    
    
    
    private int theSize;
    private int modCount = 0;
    private Node<E> beginMarker;
    private Node<E> endMarker;
    
    public static void main(String[] args){
        MyLinkedList<String> list = new MyLinkedList<String>();
        list.add("zhu");
        list.add("li");
    }
}
