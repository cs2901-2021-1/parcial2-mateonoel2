package lab;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.logging.Logger;




public class VacunacionTest {
    static final Logger logger = Logger.getLogger(Vacunacion.class.getName());


    @Test(threadPoolSize = 50)
    public void test01() throws IOException, InterruptedException {
        Vacunacion vacunacion = new Vacunacion();
        Assert.assertEquals(Vacunacion.validateUser("mateonoel2", "1234"), true);
    }

}