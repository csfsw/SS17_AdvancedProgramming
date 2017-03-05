package SS17.SecB;
import SS17.SecB.DataStructure.*;
public class StackDemo{
    public static void main(String arg[]){
        IntStack is;
        FixedStack fs = new FixedStack(5);
        DynamicStack ds = new DynamicStack(5);
        
        is= fs;
        for(int x=0; x<6; x++){
            is.push(x);
        }
        for(int x=0; x<6; x++){
            System.out.println("Item: "+is.pop() + "from fixed stack");
        }

        is= ds;
        for(int x=0; x<6; x++){
            is.push(x);
        }
        for(int x=0; x<6; x++){
            System.out.println("Item: "+is.pop() + "from dynamic stack");
        }
    }
}