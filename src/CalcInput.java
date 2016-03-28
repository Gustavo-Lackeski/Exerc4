import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class CalcEngine {
    int value;
    int keep;
    char todo;
    void BinOp (char op){
        keep = value;
        value = 0;
        todo = op;        
    }
    void add(){
        BinOp('+');
    }   
    void sub(){
        BinOp('-');
    }
    void mult(){
        BinOp('*');
    }
    void div(){
        BinOp('/');
    }
    void Compute(){
        if (todo == '+')
            value = keep + value;
        else if (todo == '-')
            value = keep - value;
        else if (todo == '*')
            value = keep * value;
        else if (todo == '/')
            try{
                value = keep / value;
            }
            catch(java.lang.ArithmeticException e){
                System.out.println("Divisao por zero!");
            }           
        keep = 0;            
    }
    void digit (int x){
        value = value*10 + x;
    }
    CalcEngine(){
        value = 0;
        keep = 0;
    }
    int GetValue() { 
        return value;
    }
}
public class CalcInput {
    BufferedReader stream;
    CalcEngine engine;
    CalcInput(CalcEngine e){
            InputStreamReader input = new InputStreamReader(System.in);
        stream = new BufferedReader(input);
        engine = e;        
    }       
    void run(){
        for(; ;){
            System.out.print("[" + engine.GetValue() + "]");
            String m = null;
            try {
                m = stream.readLine();
            } catch (IOException ex) {
                System.out.println("IOException!");
            }
            if (m == null) break;
            if (m.length() > 0){
                char c = m.charAt(0);
                if (c == '+') engine.add();
                else if (c == '-') engine.sub();
                else if (c == '*') engine.mult();
                else if (c == '/') engine.div();
                else if (c >= '0' && c<='9') engine.digit(c - '0');
                else if (c == '=') engine.Compute();
                else if (c == 'c' || c == 'C') engine.sub();        
                      
               
            }            
        }
    }
    public static void main(String[] args) throws Exception {
        CalcEngine e = new CalcEngine();
        CalcInput x = new CalcInput(e);
        x.run();        
    }
    
}
