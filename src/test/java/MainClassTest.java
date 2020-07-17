import org.junit.*;

/**
 * @author N.Petrov
 * @link http://N.Petrov.com
 */
public class MainClassTest {
    @BeforeClass
    public void beforeClassMethod(){

    }



    @Test
    public void method1(){
    }

    @Test
    public void method2(){}

    @Test
    @Ignore
    public void method3(){}

    @Test
    public void method4(){}



    @AfterClass
    public void avferClassMethod(){

    }
}
