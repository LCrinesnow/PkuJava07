class MinStack {
    Stack <Integer> s = new Stack<Integer>();//Stack <int> s = new Stack<int>();
    Stack <Integer> min = new Stack<Integer>();//Stack <int> min = new Stack<int>();
    
    public void push(int x) {
        s.push(x);
       if(min.isEmpty() ||x <= min.peek())// if(min.isEmpty() ||x < min.peek())if(min.empty() ||x < min.peek()){ // 最开始min栈要入一个元素 不然会出现空栈的min与x比较，报错
       //push(0),push(1),push(0),getMin,pop,getMin --> 没有等于号会出错
            min.push(x);
        
    }

    public void pop() { 
        if(s.peek().equals(min.peek())){
            s.pop();
            min.pop();
        }else{
            s.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
