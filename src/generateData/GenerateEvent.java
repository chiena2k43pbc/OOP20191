package generateData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import model.Agreement;
import model.Event;
import model.Time;

public class GenerateEvent {
	public static int nEvent = 87;
	
	public static Event[] getListEvents() throws ClassNotFoundException, SQLException {
		Event events[] = new Event[100];
		List<String> timeId = generateData.getListId.getListTimeId();
		int nTime = timeId.size();
		try {
			File fileDir = new File("EVENT.txt");
			BufferedReader sc = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileDir), "UTF8"));
			
			Random rd = new Random();
			for(int i = 0; i < nEvent; i++) {
				events[i] = new Event();
				events[i].setIdentifier("EVENT" + Integer.toString(i));
				events[i].setName(sc.readLine());
				Time time = new Time();
				time.setIdentifier(timeId.get(rd.nextInt(nTime)));
				events[i].setTime(time);
				String description = "Sự kiện " + events[i].getName() + ", diễn ra vào thời gian có định danh là " + events[i].getTime().getIdentifier();
				events[i].setDescription(description);
			}
			sc.close();
					
		}
		catch (Exception e) {
			 System.out.println(e);
		}
		return events;
	}
}
