package Advancedpogramming.Datastructure;
public class fixedstack implements stack{
    int itmes[];
    int top=-1;
    public fixedstack(int size){
        itmes=new int [size];

    }
    public void push(int itm){
        if(top==itmes.length-1){
            System.out.println("stack over flow")
        }
        else
        {
            top++;
            items[top]=itm;

        }
    }
    public int pop(){
        int item=0;
        if(top==-1){
            System.out.println("no item to pop");
        }
        else{



           int toreturn=items[top];
            top--;
            return items[top];
        }
    }
}