package Base;

import Contants.PetConstants;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

public class TestBase implements PetConstants {

    public Logger logger;

    @BeforeClass
    public void setup(){

        logger=Logger.getLogger("API");//added Logger
        PropertyConfigurator.configure("log4j.properties"); //added logger
        logger.setLevel(Level.DEBUG);
    }
    @BeforeClass
    public Integer PetID(){

        int idPet = numberGenerator(100,67790);
        return idPet;
    }
}
