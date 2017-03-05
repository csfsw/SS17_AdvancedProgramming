package SS17.SecA;
import SS17.SecA.DataStructure.*;
public class StackDemo{
    public static void main(String arg[]){
            IntStack is;
            FixedStack fs = new FixedStack(5);
            DynStack ds = new DynStack(5);
            is = fs;
            for(int x=0; x<=5; x++){
                is.push(x);
            }
            for(int x=0; x<=5; x++){
                is.pop();
            }
             is = ds;
            for(int x=0; x<=5; x++){
                is.push(x);
            }
            for(int x=0; x<=5; x++){
                is.pop();
            }

    }
}