import org.omg.CORBA.INTERNAL;

import java.util.Stack;

class MinStack {

//    剑指 Offer 30. 包含min函数的栈
//    定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

    /**
     * initialize your data structure here.
     */
    private int min;
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    //stack2保留stack1中非完全降序的元素

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
       stack1.push(x);
       if (stack2.isEmpty() || stack2.peek() >= x){
           stack2.push(x);
       }
    }

    public void pop() {
        if(stack1.pop().equals(stack2.peek()) ){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        if (stack1.isEmpty()){
            return -1;
        }
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */