public class Stack {
    int[] storage=new int[5];
    int top=-1;
    public void push(int value) {
        if (top == storage.length - 1) {
            System.out.println("Stack is full");
        } else {
            storage[++top] = value;
        }
    }
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else
            return storage[top--];
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(11);
        stack.push(6);
        stack.push(43);
        stack.push(11);
        stack.push(12);
        for (int i = 0; i < 5; i++) {
            int value=stack.pop();
            System.out.println("The numbers in the stack are: " + value);
        }
    }
}