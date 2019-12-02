package generateData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import model.Agreement;
import model.Article;
import model.Time;

public class GenerateArticle {
	public static Article[] getListArticles(int n) throws ClassNotFoundException, SQLException {
		
		int nAuthors = 2100;
		String[] authors = new String[nAuthors + 5];
		
		List<String> timeId = generateData.getListId.getListTimeId();
		int nTime = timeId.size();
				
		String subjects[] = {"Văn hóa", "Thể thao", "An ninh", "Giải trí", "Khoa học", "Đời sống", "Xã hội", "Học đường", "Pháp luật", "Âm nhạc", "Giáo dục", "Sức khỏe", "Du lịch", "Công nghệ", "Tài chính", "Kinh doanh", "Chính trị", "Thời sự", "Thế giới", "Thị trường"};
	    String domains[] = {"facebook.com", "youtube.com", "lienmin360.com", "kenh14.vn", "gamek.vn", "tuoitre.vn", "thanhnien.vn", "vietnamnet.vn", "vnexpress.net", "baomoi.com", "anninhthudo.vn", "soict.hust.edu.vn"};
	    Article[] articles = new Article[n + 5];
	    try {
			File fileDir = new File("AUTHORNAME.txt");
			BufferedReader sc = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileDir), "UTF8"));
			String link = "";
			Random rd = new Random();
			for(int i = 0; i < nAuthors; i++)
				authors[i] = sc.readLine();
			for(int i = 0; i < n; i++) {
				articles[i] = new Article();
		        articles[i].setIdentifier("ARTICLE" + Integer.toString(i + 1));
		        articles[i].setName("Bài báo " + Integer.toString(i + 1));
		        articles[i].setAuthorName(authors[rd.nextInt(nAuthors)]);
		        articles[i].setSubject(subjects[rd.nextInt(20)]);
		        link = "http://www." + domains[rd.nextInt(12)] + "/";
		        for(int j = 0; j < 15; j++)
		        {
		            int chr = 97 + rd.nextInt(26);
		            link += (char) chr;
		        }
		        articles[i].setLink(link);
		        Time time = new Time();
		        time.setIdentifier(timeId.get(rd.nextInt(nTime)));
		        articles[i].setWritingTime(time);
		        articles[i].setDescription(articles[i].getName() + ", được viết vào " + articles[i].getWritingTime().getIdentifier() + ", của tác giả " + articles[i].getAuthorName() + ", có chủ đề " + articles[i].getSubject() + ", với đường dẫn: " + articles[i].getLink());
		        
		    }
			sc.close();
					
		}
		catch (Exception e) {
			 System.out.println(e);
		}
	    return articles;
	}
}
