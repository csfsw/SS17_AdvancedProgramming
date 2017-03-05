package SS17.SecA.DataStructure;
public class DynStack implements IntStack{
    int stack[];
    int top =-1;
    public DynStack(int size){
        stack = new int[size];
    }

    public void push(int item){
        if(top == stack.length-1){
            System.out.println("Stack is full doubling the stack size");
            int temp[] = new int[stack.length*2];
            for(int x=0; x< stack.length; x++){
                temp[x] = stack[x];
            }
            stack = temp;
            top ++;
            stack[top] = item;
        }
          
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