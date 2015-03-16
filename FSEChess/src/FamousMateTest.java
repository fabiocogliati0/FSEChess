import static org.junit.Assert.assertTrue;
import model.ChessBoardConfiguration;
import model.Configuration;
import model.Constants;

import org.junit.Before;
import org.junit.Test;


public class FamousMateTest {
	
	Configuration conf;
	
	@Before
	public void createConfiguration(){
		conf = new ChessBoardConfiguration();
	}
	
	@Test
	public void ScholarsMateTest(){
		//provo il matto del barbiere
		assertTrue(conf.isLegalMove(6, 4, 4, 4));
		conf = conf.swap(6, 4, 4, 4);		//pedone bianco in avanti di 2
		
		assertTrue(conf.isLegalMove(1, 4, 3, 4));
		conf = conf.swap(1, 4, 3, 4);		//pedone nero in avanti di 2
		
		assertTrue(conf.isLegalMove(7, 5, 4, 2));
		conf = conf.swap(7, 5, 4, 2);		//tiro fuori l'alfiere bianco
		
		assertTrue(conf.isLegalMove(0, 1, 2, 2));
		conf = conf.swap(0, 1, 2, 2);		//tiro fuori il cavallo nero
		
		assertTrue(conf.isLegalMove(7, 3, 3, 7));
		conf = conf.swap(7, 3, 3, 7);		//tiro fuori la regina
		
		assertTrue(conf.isLegalMove(0, 6, 2, 5));
		conf = conf.swap(0, 6, 2, 5); 		//tiro fuori l'altro cavallo nero per bersagliare la regina
		
		assertTrue(conf.isLegalMove(3, 7, 1, 5));
		conf = conf.swap(3, 7, 1, 5);		//entro con la regina in 1 5 e eseguo lo scacco matto
		
		assertTrue(conf.noLegalmoves(Constants.blackColor) && conf.isChessConfiguration(Constants.blackColor));
		
	}
	
	@Test
	public void FoolsMateTest(){
		assertTrue(conf.isLegalMove(6, 5, 5, 5));
		conf = conf.swap(6, 5, 5, 5);		//pedone bianco in avanti di 1
	
		assertTrue(conf.isLegalMove(1, 4, 2, 4));
		conf = conf.swap(1, 4, 2, 4);		//pedone nero in avanti di 1
		
		assertTrue(conf.isLegalMove(6, 6, 4, 6));
		conf = conf.swap(6, 6, 4, 6);		//pedone bianco in avanti di 2
		
		assertTrue(conf.isLegalMove(0, 3, 4, 7));
		conf = conf.swap(0, 3, 4, 7);		//la regina nera entra di fianco e fa scacco matto
		
		assertTrue(conf.noLegalmoves(Constants.whiteColor) && conf.isChessConfiguration(Constants.whiteColor));
	}

}
