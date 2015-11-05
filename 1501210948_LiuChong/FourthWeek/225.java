package Implement_Stack_using_Queues;

import java.util.LinkedList;
import java.util.Queue;

public  class MyStack {
	
	 Queue<Integer> q1=new LinkedList<Integer>();
	 Queue<Integer> q2=new LinkedList<Integer>();
	
    // Push element x onto stack.
    public void push(int x) {
    		q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	
    	if(q1.size()==1){//就剩一个top了
	       	q1.poll();// stack pop
        }
    	else if(q1.size()>1){//>1的话，出队，直到就剩一个top
    		int q1size=q1.size();//size()会在每次访问时都变一次
        	for(int i=0;i<q1size-1;i++){
        		q2.offer(q1.poll());//remove front to q2
        	}
//	    	System.out.println("q1大小："+q1.size());
	       	q1.poll();// stack pop
//	    	System.out.println("q1大小："+q1.size());

	       	if(q1.isEmpty()==true){
		    	if(q2.isEmpty()==false){//q2不空
//			    	System.out.println("q2大小："+q2.size());
		    		int q2size=q2.size();
		    		for(int i=0;i<q2size;i++){
				        q1.offer(q2.poll());
			    	}
		    	}
		    	
		    } 
//	    	System.out.println("q1大小："+q1.size());

	    }
    	else if(q1.size()==0){
    		
    	}
	    
    }

    // Get the top element.
    public int top() {
    	int top=0;
    	if(!q1.isEmpty()){
    		if(q1.size()==1){//就剩一个top了
    	       	return q1.peek();// stack pop
            }
        	else{//>1的话，出队，直到就剩一个top
        		int q1size=q1.size();
            	for(int i=0;i<q1size-1;i++){
            		q2.offer(q1.poll());//remove front to q2
            	}
                top=q1.peek();////暂存，
            	//把队列调整回
            		q2.offer(q1.poll());
            	  if(q1.isEmpty()==true){
      		    	if(q2.isEmpty()==false){//q2不空

      		    		int q2size=q2.size();
      		    		for(int i=0;i<q2size;i++){
      				        q1.offer(q2.poll());
      			    	}
//          		    	System.out.println("q2大小："+q2size);

      		    	}

      		    } 
    	       	return top;// stack pop
    	    }
    	}
    	return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
    	if(q1.isEmpty()&&q2.isEmpty()){//******必须两个队列都空才算栈空
	        return true;
    	}
    	return false;
    }
}