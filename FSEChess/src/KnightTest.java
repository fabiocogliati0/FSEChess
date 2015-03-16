import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.ChessBoardConfiguration;
import model.Configuration;

import org.junit.Before;
import org.junit.Test;


public class KnightTest {
	
	Configuration conf;
	
	@Before
	public void createConfiguration(){
		conf = new ChessBoardConfiguration();
	}
	
	@Test
	public void TestNormalMove1(){
		//muovo un cavallo bianco avanti/sinistra
		assertTrue(conf.isLegalMove(7, 1, 5, 0));
	}
	
	@Test
	public void TestNormalMove2(){
		//muovo un cavallo bianco avanti/destra
		assertTrue(conf.isLegalMove(7, 1, 5, 2));
	}
	
	@Test
	public void TestIllegalMove1(){
		//provo a muovere un cavallo dove c'è già un alleato
		assertFalse(conf.isLegalMove(7, 1, 6, 3));
	}
	
	@Test
	public void TestIllegalMove2(){
		//provo a muovere un cavallo di una L col lato lungo di 3
		assertFalse(conf.isLegalMove(7, 1, 4, 0));
	}

}
