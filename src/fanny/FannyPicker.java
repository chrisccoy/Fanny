package fanny;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class FannyPicker {
	
	public static void main(String []args)throws Exception
	{
		String fileName= args.length>0?args[0]:"eligibles.json";
		PlayerPool eligibles = loadEligiblePool(fileName);
		List <Team>theTeam = processPool(eligibles);
		//serializeTheTeam(theTeam, args.length>1?args[1]:"theTeam.json");
		serializeTheTeamFlat(theTeam, args.length>1?args[1]:"theTeam.json");
	}
	private static void serializeTheTeamFlat(List<Team> theTeam, String fileName) throws FileNotFoundException 
		{	
		PrintStream out = new PrintStream(new FileOutputStream(fileName));
		for (Team tm : theTeam)
		{
			out.print(tm.getQb().getName()+"|");
			out.print(tm.getRb1().getName()+"|");
			out.print(tm.getRb2().getName()+"|");
			out.print(tm.getWr1().getName()+"|");
			out.print(tm.getWr2().getName()+"|");
			out.print(tm.getWr3().getName()+"|");
			out.print(tm.getTe().getName());
			out.println();
		}
		out.close();
	}

	private static void serializeTheTeam(List<Team> theTeam, String fileName) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), theTeam);	
	}

	public static List <Team> processPool(PlayerPool eligibles) {
	
		
		List <Team>theTeam= new ArrayList<Team>();
		List<Player>theQbs= eligibles.getQb();
		List<Player>theDst= eligibles.getDst();
		List<Player>theKickers= eligibles.getK();
		List<Player>theRbs= eligibles.getRb();
		List<Player>theWr= eligibles.getWr();
		List<Player>theTE= eligibles.getTe();
		
		for (int qbCtr=0; qbCtr<theQbs.size();qbCtr++)
		{	
			for (int rb1Ctr=0; rb1Ctr<theRbs.size();rb1Ctr++)
			{	
				for (int rb2Ctr=rb1Ctr+1; rb2Ctr<theRbs.size();rb2Ctr++)
				{
					for (int wr1Ctr=0; wr1Ctr<theWr.size();wr1Ctr++)
					{
						for (int wr2Ctr=wr1Ctr+1; wr2Ctr<theWr.size();wr2Ctr++)
						{			
							for (int wr3Ctr=wr2Ctr+1; wr3Ctr<theWr.size();wr3Ctr++)
							{		
								for (int teCtr=0; teCtr<theTE.size();teCtr++)
								{
									for (int kCtr=0; kCtr<theKickers.size();kCtr++)
									{
										for (int dstCtr=0; dstCtr<theDst.size();dstCtr++)
										{

											Team t=new Team();
											t.setQb(theQbs.get(qbCtr));
											t.setWr1(theWr.get(wr1Ctr));
											t.setWr2(theWr.get(wr2Ctr));
											t.setWr3(theWr.get(wr3Ctr));
											t.setRb1(theRbs.get(rb1Ctr));
											t.setRb2(theRbs.get(rb2Ctr));
											t.setTe(theTE.get(teCtr));
											t.setKicker(theKickers.get(kCtr));
											t.setDst(theDst.get(dstCtr));
											int ttlVal = t.getQb().getValue()+
													t.getWr1().getValue()+
													t.getWr2().getValue()+
													t.getWr3().getValue()+
													t.getRb1().getValue()+
													t.getRb2().getValue()+
													t.getTe().getValue()+
													t.getKicker().getValue()+
													t.getDst().getValue();
											
											if (ttlVal <= 60000)
											{
												theTeam.add(t);
											}
										}
									}
								}
							}
						}

					}
				}
			}
		}
		return theTeam;
	}
	private static PlayerPool loadEligiblePool(String f) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(f), PlayerPool.class);
	}
	
}
