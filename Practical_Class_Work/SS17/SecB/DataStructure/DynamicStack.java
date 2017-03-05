package SS17.SecB.DataStructure;
public class DynamicStack implements IntStack{
    int stack[];
    int top=-1;
    public DynamicStack(int size){
        stack = new int[size];
    }
    public void push(int item){
        if(top == stack.length-1){
            System.out.println("Stack is full doubling the size of stack");
            int temp[] = new int[stack.length*2];
            for(int i=0; i<stack.length; i++){
                temp[i]= stack[i];
            }
            stack = temp;
            top++;
            stack[top]= item;
        }
        else{
            top++;
            stack[top]=item;
        }
    }
    public int pop(){
        int item=0;
        if(top == -1)
        {
            System.out.println("Stack is empty");
        }
        else{
            item = stack[top];
            top--;
        }
        return item;
    }
}