package generateData;

import model.Person;
import model.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class generatePerson {
	private static String positions[] = {"Họa sĩ", "Nhạc sĩ", "Lập trình viên", "Hạ sĩ", "Đảng viên", "Chủ tịch công đoàn","Trung sĩ", "Thượng sĩ", "Ca sĩ", "Thiếu úy", "Chủ nhiệm","Trung úy", "Thượng úy", "Người mẫu", "Đại úy", "Thiếu tá", "Bộ trưởng","Trung tá", "Thượng tá", "Hiệu trưởng","Đại tướng", "Đại tá", "Thứ trưởng", "Thượng tướng", "Phó hiệu trưởng","Thiếu tướng", "Trung tướng" ,"Danh hài", "Giám đốc điều hành", "Giám đốc tài chính", "Trưởng phòng hoạt động", "Trưởng phòng", "Tổng giám đốc", "Phó giám đốc", "Chủ tịch", "Quản lý", "Phó thủ tướng", "Chánh án", "Luật sư", "Cầu thủ", "Tiến sĩ", "Giáo sư", "Thạc sĩ", "PGS-TS", "Bác sĩ", "Diễn viên", "Kỹ sư", "Giáo viên", "Giảng viên", "Kiểm soát viên"};
	private static int nP = 50;
	public static int nPerson = 0;
	
	public static List<Person> generateVNName(int n) {
		String firstNames[] = {"Nguyễn", "Trần", "Lê", "Phạm", "Hoàng", "Huỳnh", "Phan", "Vũ", "Võ", "Đặng", "Bùi", "Đỗ", "Hồ", "Ngô", "Dương", "Lý", "Thái", "Cao", "Đinh", "Tạ"};
	    int nFN = 20;
	    String femaleMiddleNames[] = {"Thị", "Thu", "Phương", "Thanh", "Minh", "Ngọc", "Thùy", "Hồng", "Quỳnh", "Thúy", "Hương", "Diệu", "Mai", "Huyền", "Lan"};
	    int nFMN = 15;
	    String femaleLastNames[] = {"Anh", "Trang", "Linh", "Phương", "Hương", "Thảo", "Hà", "Huyền", "Ngọc", "Hằng", "Giang", "Nhung", "Yến", "Nga", "Mai", "Thu", "Hạnh", "Vân", "Hoa", "Hiền"};
	    int nFLN = 20;
	    String maleLastNames[] = {"Chiến", "Chung", "Đạt", "Hiếu", "Thắng", "Trọng", "Nhật", "Quân", "Đạo", "Đạt", "Phúc", "Mạnh", "Minh", "Trường", "Cường", "Đức", "Hoàng", "Anh", "Duy", "Hưng"};
	    int nMLN = 20;
	    String maleMiddleNames[] = {"Văn", "Quốc", "Trọng", "Trung", "Xuân", "Duy", "Hoài", "Hoàng", "Công", "Đình", "Đức", "Thanh", "Nhật", "Hoàng", "Hữu", "Minh", "Khánh", "Hải", "Thế", "Đăng"};
	    int nMMN = 20;

	    int fN, fMN, fLN, mN, mMN, mLN, age;
	    Random rd = new Random();
	    List<Person> listVNPersons = new ArrayList<Person>();
	    
	    Country country = new Country();
	    country.setIdentifier("COUNTRY01");
	    country.setName("Việt Nam");
	    country.setDescription("Việt Nam tên chính thức là Cộng hòa xã hội chủ nghĩa Việt Nam là quốc gia ở rìa phía đông bán đảo Đông Dương, gần trung tâm khu vực Đông Nam Á.");
	    
	    for(int i = 0; i < n; i++)
	    {
	        Person person = new Person();
	        int gender = rd.nextInt(2);
	        age = 15 + rd.nextInt(40);
	        int pos = rd.nextInt(nP);
	        person.setGender(gender == 1 ? "Nam" : "Nữ");
	        person.setCountry(country);
	        person.setAge(age);
	        person.setPosition(positions[pos]);
	        if (gender == 0) //nếu người đó là nữ
	        {
	            fN = rd.nextInt(nFN);
	            fMN = rd.nextInt(nFMN);
	            fLN = rd.nextInt(nFLN);
	            person.setName(firstNames[fN] + " " + femaleMiddleNames[fMN] + " " + femaleLastNames[fLN]);
	        } else //nếu người đó là nam
	        {
	            mN = rd.nextInt(nFN);
	            mMN = rd.nextInt(nMMN);
	            mLN = rd.nextInt(nMLN);
	            person.setName(firstNames[mN] + " " + maleMiddleNames[mMN] + " " + maleLastNames[mLN]);
	        }
	        person.setIdentifier("PERSON" + Integer.toString(nPerson++));
	        String description = person.getPosition()+ " " + person.getName() + ", giới tính " + person.getGender() + ", năm nay " + Integer.toString(person.getAge()) + " tuổi, có quốc tịch " + person.getCountry().getName() + ".";
	        person.setDescription(description);
	        listVNPersons.add(person);
	    }
	    return listVNPersons;
	}
	
	public static List<Person> generateTwoWordsName(String firstName[], String lastName[], int nFN, int nLN, Country country, int n) {
		List<Person> listPers = new ArrayList<Person>();
		Random rd = new Random();
		int gender, pos, lN, fN, age;
	    for(int i = 0; i < n; i++) {
	    	Person person = new Person();
	        gender = rd.nextInt(2);      				  	//sinh ngẫu nhiên 1 giá trị 0 hoặc 1
	        age = 15 + rd.nextInt(40);   					//sinh ngẫu nhiên 1 giá trị trong khoảng [15, 55)
	        pos = rd.nextInt(nP);        					//sinh ngẫu nhiên 1 giá trị là chỉ số của chức vụ
	        
	        person.setGender(gender == 1 ? "Nam" : "Nữ");  	//nếu gender = 1, gán giới tính là nam, nếu không thì là nữ
	        person.setCountry(country);					   	//gán cho person đó country tương ứng	
	        person.setAge(age);							   	//gán tuổi cho person đó với giá trị age ở trên
	        person.setPosition(positions[pos]);			   	//gán chức vụ tương ứng với chỉ số pos cho người đó
	        
	        fN = rd.nextInt(nFN);						   	//lấy ra ngẫu nhiên 1 học trong danh sách
	        lN = rd.nextInt(nLN);						   	//lấy ra ngẫu nhiên 1 tên trong danh sách	
	        person.setName(firstName[fN] + " " + lastName[lN]);   //ghép họ và tên lại thành một tên hoàn chỉnh

	        person.setIdentifier("PERSON" + Integer.toString(nPerson++));  //gán định danh cho person đó là PERSON + 1 chỉ số khác nhau giữa mỗi người
	        //gán description cho mỗi person
	        String description = person.getPosition()+ " " + person.getName() + ", giới tính " + person.getGender() + ", năm nay " + 
	        Integer.toString(person.getAge()) + " tuổi, có quốc tịch " + person.getCountry().getName() + ".";
	        person.setDescription(description);
	        listPers.add(person);
	    }
	    return listPers;
	}
	
	public static List<Person> generateENName(int n) {
		String firstNames[] = {"Smith", "Jones", "Williams", "Taylor", "Brown", "Davies", "Evans", "Wilson", "Thomas", "Johnson", "Roberts", "Robinson", "Thompson", "Wright", "Walker", "White", "Edwards", "Hughes", "Green", "Hall","Kane","Rooney","Rashford","Sterling","Sancho","Alli","Lingard","Maguire","Mings","Pickford","Abraham","Mount","Henderson","Trippier","Rice","Shaw","Keane","Walker","Winks","Chilwell","Barkley","Maddison","Welbeck","Dier","Stones","Rose","Cheek","Tomori","Pope","Gomez","Butland","Heaton","Delph"};
	    String lastNames[] = {"Oliver", "Jake", "Noah", "James", "Jack", "Connor", "Liam", "John", "Harry", "Callum", "Mason", "Robert", "Jacob", "Michael", "Charlie", "Thomas", "Geogre", "Oscar", "Daniel", "Lambert","Wayne","Marcus","Raheem","Jadon","Dele","Jesse","Harry","Trent","Tyrone","Jordan","Tammy","Mason","Kieran","Declan","Luke","Kyle","Ben","Ross","Danny","Eric","John","Danny","Callum","Fikayo","Alex","Nick","Joe","Dean","Fabian","Nathaniel","Demarai","Lewis","Nathan"};
	    Country country = new Country();
	    country.setIdentifier("COUNTRY02");
	    country.setName("Vương Quốc Anh");
	    country.setDescription("Vương quốc Liên hiệp Anh và Bắc Ireland, thường gọi tắt là Anh Quốc, Vương Quốc Anh, Liên hiệp Anh hoặc Anh, là một quốc gia có chủ quyền tại châu Âu.");
	    return generateTwoWordsName(firstNames, lastNames, 53, 53, country, n);
	}
	public static List<Person> generateUSName(int n) {
		String firstNames[] = {"Smith", "Jones", "Williams", "Taylor", "Brown", "Davies", "Evans", "Wilson", "Thomas", "Johnson", "Roberts", "Robinson", "Thompson", "Wright", "Walker", "White", "Edwards", "Hughes", "Green", "Hall","Kane","Rooney","Rashford","Sterling","Sancho","Alli","Lingard","Maguire","Mings","Pickford","Abraham","Mount","Henderson","Trippier","Rice","Shaw","Keane","Walker","Winks","Chilwell","Barkley","Maddison","Welbeck","Dier","Stones","Rose","Cheek","Tomori","Pope","Gomez","Butland","Heaton","Delph"};
	    String lastNames[] = {"Oliver", "Jake", "Noah", "James", "Jack", "Connor", "Liam", "John", "Harry", "Callum", "Mason", "Robert", "Jacob", "Michael", "Charlie", "Thomas", "Geogre", "Oscar", "Daniel", "Lambert","Wayne","Marcus","Raheem","Jadon","Dele","Jesse","Harry","Trent","Tyrone","Jordan","Tammy","Mason","Kieran","Declan","Luke","Kyle","Ben","Ross","Danny","Eric","John","Danny","Callum","Fikayo","Alex","Nick","Joe","Dean","Fabian","Nathaniel","Demarai","Lewis","Nathan"};
	    Country country = new Country();
	    country.setIdentifier("COUNTRY03");
	    country.setName("Hoa Kỳ");
	    country.setDescription("Hoa Kỳ, còn gọi là Mỹ, tên đầy đủ là Hợp chúng quốc Hoa Kỳ hoặc Hợp chúng quốc Mỹ là một nước cộng hòa lập hiến liên bang gồm 50 tiểu bang và 1 đặc khu liên bang.");
	    return generateTwoWordsName(firstNames, lastNames, 53, 53, country, n);
	}
	
	public static List<Person> generateGERName(int n) {
		String firstNames[] = {"Müller","Schmidt","Schneider","Fischer","Meyer","Weber","Schulz","Wagner","Becker","Konstancy","Hoffmann","Schäfer","Koch","Bauer","Flick","Fuerstenberg","Porsche","Pieoch","Einstein","Faber","Castell","Özil" };
	    String lastNames[] = {"Mia","Emma","Hanna","Hannah","Sophia","Sofia","Anna","Lea","Emilia","Marie","Lena","Leonie","Ben","Luca","Luka","Paul","Jonas","Finn","Fynn","Leon","Luis","Louis","Lucas","Lukas","Maximilian","Felix","Friedrich","Joachim","Ferdinand","Ferry","Aibert","Caspar","Karen","Adam","James","Sivori","Thomas","Mesut"};
	    Country country = new Country();
	    country.setIdentifier("COUNTRY04");
	    country.setName("Đức");
	    country.setDescription("Đức, tên chính thức là Cộng hòa Liên bang Đức, là một nước cộng hòa nghị viện liên bang nằm tại Trung-Tây Âu.");
	    return generateTwoWordsName(firstNames, lastNames, 22, 38, country, n);
	}
	
	
	public static List<Person> generateRUSName(int n) {
		String firstNames[] = {"Sharipov","Kostin","Kolesnikov","Repin","Bogdanov","Ponomarev","Romanenkov","Maxim","Mazein","Palashchenko","Vasiliev","Akhlebinin","Bykov","Gunina","Romanova","Bazanova","Stolyarov","Rykhtorov","Akhundov","Kostin","Bogdanov","Rahkonen","Bityukov","Zimin","Novikov","Gusev","Ivanov","Popov","Petrov","Vasilyev","Smirnov","Kozlov","Mikhailov","Semenov","Stepanov"};
	    String lastNames[] = {"Denis","Sofiya","Ksenya","Mariya","Artem","Vladimir","Kirill"," Yegor"," Dmitry","Oleg","Kiril","Anton","Nikolay","Dmitry","Mihail","Emil","Sergey","Emil","Jan","Nikolay","Aleksey","Danil","Vadim","Sivaeva","Kasyanova","Gaisina","Viktor","Lyubov","Valentina","Yanina","Ekaterina","Barbara","Svetlana"};
	    Country country = new Country();
	    country.setIdentifier("COUNTRY05");
	    country.setName("Liên Bang Nga");
	    country.setDescription("Nga, quốc danh hiện tại là Liên bang Nga, là một quốc gia ở phía bắc lục địa Á - Âu. Nga là nhà nước cộng hòa liên bang, gồm 83 thực thể liên bang.");
	    return generateTwoWordsName(firstNames, lastNames, 35, 33, country, n);
	}
	
	public static List<Person> generateFRAName(int n) {
		String firstNames[] = {"Martin", "Bernard", "Thomas", "Petit", "Durand", "Richard","Moreau", "Dubois","Robert", "Laurent","Lloris"," Mandanda","Areola"," Pavard"," Kimpembe","Varane"," Umtiti"," Rami","Sidibe","Hernandez","Mendy"," Pogba"," Lemar", "Tolisso", "Kante","Matuidi","Nzonzi","Griezmann","Giroud","Mbappe","Dembele","Fekir","Thauvin"};
	    String lastNames[] = {"Alix Noble","Linda","Sinda","Fatima","Christelle","Hlalia","Angela","Gaelle","Annabelle","Tatu","Lucile","Rachel","Ariane","Madeline","Yka","Sheera","Margaux","Héloïse","Fleur","Mandira","Ludivine","Nora","Elwyna","Ghislaine","Léna","Catherine","Sofia Wisdom","Yella","Darifa","Ilona","Géraldine","Farah","Heida Noble","Gabrielle","Danielle","Irza","Romina","Asmae","Naomi Agreeableness","Aurore","Salomé","Lou","Laurie","Karima Noble","Joyce","Latika Creeper","Coline","Selena","Meriem","Abiba","Lynda Hose","Christine","Loanne","Camélia","Anais","Evelyne","Axelle","Hadjer","Fati","Lydia","Rayen","Eve","Nisrine","Florine","Madeleine","Mohamed","Lorraine","Maya","Emmanuelle","Samantha","Andréa","Nesrine","Annily Grace"};
	    Country country = new Country();
	    country.setIdentifier("COUNTRY06");
	    country.setName("Pháp");
	    country.setDescription("Pháp, tên chính thức là nước Cộng hòa Pháp, là một quốc gia có lãnh thổ chính nằm tại Tây Âu cùng một số vùng và lãnh thổ hải ngoại.");
	    return generateTwoWordsName(firstNames, lastNames, 33, 73, country, n);
	}
	
	public static List<Person> generateSPAName(int n) {
		String firstNames[] = {"Reina","Arrizabalaga","López","Ramos","Albiol","Navas","Carvajal","Bernat","Martínez","Torres","Busquets","Cazorla","Sarabia","Olmo","Morata","Alcácer","Mikel","Zamora","Iceta","Quesada","Eizaguirre","Quincoces","Molowny","Villalonga","Suárez","Sáez","Clemente","Miera","Ladislao","Lopetegui","Fernando","Robert","Enrique","Casillas","García","Fernández","González","Rodríguez","Sánchez","Pérez","Martín","Gómez"};
	    String lastNames[] = {"Pepe","Kepa","Pau","Sergio","Raúl","Jesús","Dani","Juan","Iñigo","Santi","Pablo","Dani","Álvaro","Paco","Oyarzabal","Ricardo","Luis","Félix","Guillermo","Jacinto","José","Iñaki","Javier","Vicente","Kubala","Julen","Hierro","Moreno","Iker","Sofia","Isabella","Valentia","Adelina","Emeralda","Camila","Elisa","Rosa","Olivia","Gabriela"," Lucia","Dominica","Tia","Mia"," Emilia","Natalia","Alma","Isla","Maria","Sara","Florencia"};
	    Country country = new Country();
	    country.setIdentifier("COUNTRY07");
	    country.setName("Tây Ban Nha");
	    country.setDescription("Tây Ban Nha, gọi chính thức là Vương quốc Tây Ban Nha, là một quốc gia có chủ quyền với lãnh thổ chủ yếu nằm trên bán đảo Iberia tại phía tây nam châu Âu.");
	    return generateTwoWordsName(firstNames, lastNames, 42, 50, country, n);
	}
	
	public static List<Person> generateJPName(int n) {
		String firstNames[] = {"Katō","Yoshida","Yamada","Sasaki","Yamaguchi","Matsumoto","Inoue","Kimura","Hayashi","Shimizu","Kawasaki","Shinichi","Haibara","Amami","Hamasaki","Kotone","Mikako","Mitake","Tatsumi","Hatano","Hara","Ayashiro","Suzuhara","Yoshihico","Mori","Satou","Suzuki","Takahashi","Tanaka","Watanabe","Itou","Yamamoto","Nakamura","Kobayashi","Saitou" };
	    String lastNames[] = {"Aiko","Akako","Aki","Akiko","Akina","Amaya","Aniko","Azami","Ayame","Bato","Cho","Emiri","Gen","Gin","Gwatan","Ino","Hama","Hasuko","Hanako","Haru","Haruko","Haruno","Hatsu","Hiroko","Hoshi","Ichiko","Iku","Inari","Kazuko","Keiko","Mineko","Misao","Nara","Nareda","Ohara","Ran","Ryo","Shika","Takara","Tamiko","Taki","Tamiko","Umeko","Yasu","Yoko","Yui","Botan","Goro","Hasu","Haro","Hotei","Higo","Ken","Jiro","Kano","Kami","Kame","Kiyoshi","Kisame","Manzo","Maito","Michi","Mochi","Naga","Niran","Ringo","Sam","Santoso","Shima","Tadashi","Taijutsu","Taka","Tani","Taro","Tatsu","Ten","Tengu","Tomi","Toshiro","Toru","Uyeda","Uzumaki","Zen"};
	    Country country = new Country();
	    country.setIdentifier("COUNTRY08");
	    country.setName("Nhật Bản");
	    country.setDescription("Nhật Bản là một đảo quốc nằm ở vùng Đông Á. Tọa lạc trên Thái Bình Dương, nước này nằm bên rìa phía đông của Biển Nhật Bản, Biển Hoa Đông, Trung Quốc, bán đảo Triều Tiên và vùng Viễn Đông Nga, trải dài từ Biển Okhotsk ở phía bắc xuống Biển Hoa Đông và đảo Đài Loan ở phía nam.");
	    return generateTwoWordsName(firstNames, lastNames, 35, 83, country, n);
	}
	
	public static List<Person> generateKORName(int n) {
		String firstNames[] = {"Oh","Han","Shin","Seo","Kwon","Hwang","An","Song","Yoo","Hong","Jeon","Go","Mun","Son","Yang","Bae","Jo","Baek","Min","Nam","Kim","Lee","Park","Choi","Jeong","Kang","Cho","Yoon","Jang","Im"};
	    String lastNames[] = {"Min-Jun","Seo-Jun","Ha-Jun","Do-Yun","Ju-Won","Ye-Jun","Junu","Ji-Ho","Ji-Hu","Jun-Seo","Seo-Yun","Seo-Yeon","Jiu","Ji-Yu","Ha-Yun","Seo-Hyeon","Min-Seo","Ha-Eun","Ji-A","Da-Eun","Siu","Geonu","Hyeon-U","Yun-Seo","Eun-Seo"," Sang-Hyeok"," Jin-Seong"," Gyeong-Hwan"," Jae-Wan"," Hyuk-Kyu"};
	    Country country = new Country();
	    country.setIdentifier("COUNTRY09");
	    country.setName("Hàn Quốc");
	    country.setDescription("Hàn Quốc, tên chính thức là Đại Hàn Dân Quốc, hay còn được gọi bằng các tên gọi khác như là Đại Hàn, Nam Hàn, Nam Triều Tiên hoặc Cộng hòa Triều Tiên, là một quốc gia có chủ quyền thuộc khu vực Đông Á, nằm trên nửa phía nam của bán đảo Triều Tiên.");
	    return generateTwoWordsName(firstNames, lastNames, 30, 30, country, n);
	}
	
	public static List<Person> generateCHIName(int n) {
		String firstNames[] = {"Gia Cát","Bàng","Cam","Bùi","Cao","Cát","Câu","Chân","Chu","Chiêm","Chung","Cố","Công","Cung","Diêm","Dương","Doãn","Đào","Đằng","Đặng","Điền","Đinh","Đỗ","Đổng","Đường","Giả","Hà","Hạ","Hàn","Hoa","Hoàn","Hoàng","Hoắc","Hồ","Hứa","Hướng","Khoái","Khổng","Khương","Kiều","Kim","Kỷ","La","Lã","Liễu","Lệnh","Lỗ","Lục","Lương","Lục","Lưu","Lý","Mã","Mao","My","Mạnh","Nghiêm","Ngô","Ngũ","Ngụy","Nguyễn","Ngưu","Nhạc","Nhâm","Phạm","Phan","Phàn","Phí","Phó","Phùng","Phục","Quách","Quan","Quản","Quốc","Quý","Sách","Sĩ","Sơn","Sử","Tạ","Tả","Tào","Tần","Tập","Tề","Thái","Thân","Thịnh","Thư","Thương","Thượng","Thường","Tiết","Tiên","Tiều","Toàn","Tôn","Tổ","Tống","Trần","Triệu","Trịnh","Trình","Trương","Tuân","Từ","Tư Mã","Tưởng","Ung","Ưng","Vạn","Văn","Vệ","Viên","Vu","Vô","Vương","Xa"}; 
	    String lastNames[] =  {"Cận Bình","Giới Thạch","Phương Lan","Trạch Đông","Huyền Đức","Vân Trường","Tử Long","Mạnh Khởi","Mạnh Đức","Thừa Ngạn","Lệnh Tắc","Kinh Chi","Phụng Tiên","Cung Tổ","Tử Di","Lệnh Minh","Thượng Trường","Cự Sư","Sĩ Nguyên","Vĩnh Niên","Thúc Nghiệp","Doãn Thành","Văn Tài","Tử Sơn","Trọng Tư","Văn Quý","Văn Hành","Linh Tự","Đại Minh","Nhân Minh","Tử Ngư","Công Tự","Quân Lý","Sĩ Quý","Tử Cán","Tử Ân","Quý Tắc","Tử Mặc","Tử Thông","Tử Thán","Hiếu Tắc","Tử Trực","Nguyên Thán","Thăng Tế","Bá Khuê","Văn Ý","Đức Tự","Đức Quang","Văn Tiên","Ngạn Minh","Bá Kiệm","Văn Bình","Lô Nhi","Tư Tiềm","Thứ Tăng","Trọng Đạt"};
	    Country country = new Country();
	    country.setIdentifier("COUNTRY10");
	    country.setName("Trung Quốc");
	    country.setDescription("Trung Quốc, tên chính thức là nước Cộng hòa Nhân dân Trung Hoa, còn gọi là Trung Quốc đại lục, là một quốc gia có chủ quyền nằm tại Đông Á.");
	    return generateTwoWordsName(firstNames, lastNames, 119, 56, country, n);
	}
	public static List<Person> generatePersons(int n) {
		List<Person> lst = new ArrayList<Person>();
		lst.addAll(generateVNName(1000));
		lst.addAll(generateENName(1000));
		lst.addAll(generateUSName(1000));
		lst.addAll(generateCHIName(1000));
		lst.addAll(generateKORName(1000));
		lst.addAll(generateJPName(1000));
		lst.addAll(generateSPAName(1000));
		lst.addAll(generateRUSName(1000));
		lst.addAll(generateFRAName(1000));
		lst.addAll(generateGERName(1000));
		return lst;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> lst = generateUSName(100);
		for(Person p : lst) {
			System.out.println(p.getDescription());
		}
	}
}
