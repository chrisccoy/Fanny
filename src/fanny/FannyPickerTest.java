package fanny;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class FannyPickerTest extends FannyPicker {

	@Test
	public void test() throws JsonGenerationException, JsonMappingException, IOException {
		// Create QBList
		List <Player>qbList = new ArrayList<Player>();
		qbList.add(new Player("Brady", 9000));
		qbList.add(new Player("Brees", 8000));
		PlayerList theQbs=new PlayerList(qbList, 1);
		//Create RB List
		List <Player>rbList = new ArrayList<Player>();
		rbList.add(new Player("rb1", 9000));
		rbList.add(new Player("rb2", 8000));
		rbList.add(new Player("rb3", 9000));
		rbList.add(new Player("rb4", 8000));
		rbList.add(new Player("rb5", 9000));
		rbList.add(new Player("rb6", 8000));
		PlayerList theRbs=new PlayerList(rbList, 2);
		//Create WR List
		List <Player>wrList = new ArrayList<Player>();
		wrList.add(new Player("wr1", 9000));
		wrList.add(new Player("wr2", 8000));
		wrList.add(new Player("wr3", 9000));
		wrList.add(new Player("wr4", 8000));
		wrList.add(new Player("wr5", 9000));
		wrList.add(new Player("wr6", 8000));
		PlayerList theWrs=new PlayerList(wrList, 3);
		// Create DSTList
		List <Player>dstList = new ArrayList<Player>();
		dstList.add(new Player("AZ", 5100));
		PlayerList theDefenses=new PlayerList(dstList, 1);
		// Create KList
		List <Player>kList = new ArrayList<Player>();
		kList.add(new Player("HAUSHKA", 5100));
		PlayerList theKickers=new PlayerList(kList, 1);
		// Create teList
		List <Player>teList = new ArrayList<Player>();
		teList.add(new Player("GRONK", 5100));
		PlayerList theTes=new PlayerList(teList, 1);
		List<PlayerList>pool= new ArrayList<PlayerList>();
		PlayerPool thePool=new PlayerPool();
		thePool.setQb(qbList);
		thePool.setDst(dstList);
		thePool.setK(kList);
		thePool.setWr(wrList);
		thePool.setTe(teList);
		thePool.setRb(rbList);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(thePool));
		List<Team> finalTeam=FannyPicker.processPool(thePool);
		
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("/tmp/theTeam.json"), finalTeam);
		
	}

}
