import static org.junit.Assert.*;
import org.junit.Test;
public class CalculateEngineTest
{
    CalcEngine e = new CalcEngine();
    @Test
    public void testDiv() 
            {
            e.digit(7);
            e.div();
            e.digit(0);
            e.Compute();
            System.out.println("Testando divisão por zero:");
            assertEquals(e.GetResult() , "Divisao por zero!");
            }
    @Test
    public void testSoma() 
            {
            e.digit(3);
            e.add();
            e.digit(2);
            e.Compute();
            System.out.println("Testando soma: 2 + 3");
            assertEquals(e.value , 5);
            }
}