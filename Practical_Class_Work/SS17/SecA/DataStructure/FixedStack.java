package SS17.SecA.DataStructure;
public class FixedStack implements IntStack{
    int stack[];
    int top =-1;
    public FixedStack(int size){
        stack = new int[size];
    }

    public void push(int item){
        if(top == stack.length-1)
            System.out.println("Stack overflow");
        else{
            top++;
            stack[top]=item;
        }
    }
    public int pop(){
        int item = 0;
        if(top == -1){
            System.out.println("Stack is empty");
        }
        else{
            item = stack[top];
            top--;
        }
         return item;
    }
   

}