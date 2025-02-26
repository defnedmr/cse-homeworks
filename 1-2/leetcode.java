import java.util.Stack;

public class leetcode {
    public static void main(String[] args) {



    }
    public static boolean isValid(String s){
        Stack<String> stack=new Stack<String>();
        char[] arrayC=s.toCharArray();
        String[] array=new String[arrayC.length];
        for (int i = 0; i < arrayC.length; i++) {
            array[i]=(String)(arrayC[i]);
        }
        boolean result=true;
        for (int i = 0; i < array.length; i++) {
            if(array[i]== '(' || array[i]== '{' || array[i]== '['){
                stack.push(array[i]);
            }
            else if(array[i]== ')'){
                if(!(stack.peek()=='(')){
                    result=false;
                    break;
                }
                else
                    stack.pop();
            }
            else if(array[i]== '}'){
                if(!(stack.peek()=='{')){
                    result=false;
                    break;
                }
                else
                    stack.pop();
            }
            else {
                if(!(stack.peek()=='[')){
                    result=false;
                    break;
                }
                else
                    stack.pop();
            }
        }
    return result;
    }
}
