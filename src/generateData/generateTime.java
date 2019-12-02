package generateData;

import java.util.Random;
import model.Time;

public class generateTime {
	public static Time[] getListTimes(int n) {
		int rd, rm, ry;
		Random ran = new Random();
		int date[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		Time[] times = new Time[100000];
		
		for(int i = 0; i < n; i++)
		{
			times[i] = new Time();
			times[i].setIdentifier("TIME" + Integer.toString(i + 1));
			ry = 1980 + ran.nextInt(40);
			rm = 1 + ran.nextInt(12);
			rd = 1 + ran.nextInt(date[rm - 1]);
			times[i].setName(Integer.toString(ry) + "-" + Integer.toString(rm) + "-" + Integer.toString(rd));
	        if (rm == 9 && rd ==2)
	            times[i].setDescription("Ngày Quốc khánh Việt Nam");
	        else if (rm == 8 && rd == 19)
	            times[i].setDescription("Cách mạng tháng Tám, sinh nhật Hoài Nhật");
	        else if (rm == 6 && rd == 1)
	            times[i].setDescription("Ngày Quốc tế thiếu nhi");
	        else if (rm == 5 && rd == 1)
	            times[i].setDescription("Ngày Quốc tế lao động");
	        else if (rm == 10 && rd == 20)
	            times[i].setDescription("Ngày Phụ nữ Việt Nam");
	        else if (rm == 3 && rd == 8)
	        	times[i].setDescription("Ngày Quốc tế Phụ nữ");
	        else if (rm == 1 && rd == 1)
	        	times[i].setDescription("Ngày Tết dương lịch");
	        else if (rm == 11 && rd == 20)
	        	times[i].setDescription("Ngày Nhà giáo Việt Nam");
	        else if (rm == 4 && rd == 30)
	        	times[i].setDescription("Ngày giải phóng miền Nam, thống nhất đất nước");
	        else if (rm == 2 && rd == 14)
	        	times[i].setDescription("Ngày Valentine trắng");
	        else if (rm == 3 && rd == 14)
	        	times[i].setDescription("Ngày Valentine đen");
	        else if (rm == 5 && rd == 19)
	        	times[i].setDescription("Ngày sinh Chủ tịch Hồ Chí Minh");
	        else times[i].setDescription("Chỉ là một ngày bình thường");
		}
		return times;
	}
}
