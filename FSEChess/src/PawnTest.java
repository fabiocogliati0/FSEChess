import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.ChessBoardConfiguration;
import model.Configuration;

import org.junit.Before;
import org.junit.Test;


public class PawnTest {
	
	Configuration conf;
	
	@Before
	public void createConfiguration(){
		conf = new ChessBoardConfiguration();
	}
	
	@Test
	public void TestMovesStartMove() {
		//muovo un pedone bianco in avanti di 2
		assertTrue(conf.isLegalMove(6, 1, 4, 1));
	}
	
	@Test
	public void TestNormalMove(){
		//muovo un pedone bianco in avanti di 1
		assertTrue(conf.isLegalMove(6, 1, 5, 1));
	}
	
	@Test
	public void TestAttackMove(){
		//muovo un pedone bianco in 2,2 poi provo a mangiarlo con il pedone nero che sta in 1,1
		conf = conf.swap(6, 2, 2, 2);
		assertTrue(conf.isLegalMove(1, 1, 2, 2));
	}
	
	@Test
	public void TestIllegalMove1(){
		//provo a muovere un pedone bianco in diagonale senza avere nulla da mangiare
		assertFalse(conf.isLegalMove(6, 1, 5, 2));
	}
	
	@Test
	public void TestIllegalMove2(){
		//provo a fare una mossa di un pedone che avanza di 0
		assertFalse(conf.isLegalMove(1, 1, 1, 1));
	}
	
	@Test
	public void TestIllegalMove3(){
		//provo a mandare un pedone bianco indietro
		conf = conf.swap(7, 1, 5, 0);		//cavallo bianco in avanti/sinistra
		conf = conf.swap(1, 1, 1, 2);		//mossa del nero
		assertFalse(conf.isLegalMove(6, 1, 7, 1));
	}

}
