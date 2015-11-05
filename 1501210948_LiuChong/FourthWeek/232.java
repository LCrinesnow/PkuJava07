package Implement_Queue_using_Stacks;

import java.util.*;

public class MyQueue {
	Stack<Integer> s1=new Stack();
	Stack<Integer> s2=new Stack();

	// Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!s1.isEmpty()){
        	if(s1.size()==1){
        		s1.pop();
        	}
        	else{
        		int s1size=s1.size();
        		for(int i=0;i<s1size;i++){
        			s2.push(s1.pop());
        		}
        		s2.pop();
        		int s2size=s2.size();
        		for(int i=0;i<s2size;i++){
        			s1.push(s2.pop());
        		}
        	}
        }
    }

    // Get the front element.
    public int peek() {
        if(!s1.isEmpty()){
        	if(s1.size()==1){
        		return s1.peek();
        	}
        	else{
        		int s1size=s1.size();
        		for(int i=0;i<s1size;i++){
        			s2.push(s1.pop());
        		}
        		int peek=s2.peek();
        		int s2size=s2.size();
        		for(int i=0;i<s2size;i++){
        			s1.push(s2.pop());
        		}
        		return peek;
        	}
        }
        return 0;//空队
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(s1.isEmpty()&&s2.isEmpty()){
        	return true;
        }
        return false;
    }
}
