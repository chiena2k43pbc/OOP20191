package generateData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.*;

public class generateFact {
	public static List<Fact<Person, Event>> getListFactPER2EVE(int n) throws ClassNotFoundException, SQLException {
		List<String> listPersonId = generateData.getListId.getListPersonId();
		List<String> listEventId = generateData.getListId.getListEventId();
		int nPer = listPersonId.size();
		int nEve = listEventId.size();
		//String subject = "Gặp gỡ";
		//String relationship = "gặp gỡ";
		String subject[]= {"Tổ chức","Tham gia","Ủng hộ","Phản đối","Phát biếu tại"};
		String relationship[]= {"tổ chức","tham gia","ủng hộ","phản đối","phát biểu tại"};
		List<Fact<Person, Event>> facts = new ArrayList<Fact<Person, Event>>();
		List<String> timeId = generateData.getListId.getListTimeId();
		int nTime = timeId.size();
		
		Random rd = new Random();
		for(int i = 0; i < n; i++)
		{
			Fact<Person, Event> f = new Fact<Person, Event>();
			String per = listPersonId.get(rd.nextInt(nPer));
			String eve = listEventId.get(rd.nextInt(nEve));
			f.setIdentifier("FACT_PER_EVE_" + Integer.toString(i));
			
			Person person = new Person();
			person.setIdentifier(per);
			Event event = new Event();
			event.setIdentifier(eve);
			int a = rd.nextInt(5);
			f.setObject1(person);
			f.setObject2(event);
			f.setSubject(subject[a]);
			f.setRelationship(relationship[a]);
			Time time = new Time();
			time.setIdentifier(timeId.get(rd.nextInt(nTime)));
			f.setTime(time);
			f.setType(1);
			facts.add(f);
		}
		return facts;
	}
	public static List<Fact<Organization, Event>> getListFactORG2EVE(int n) throws ClassNotFoundException, SQLException {
		List<String> listOrgId = generateData.getListId.getListOrganizationId();
		List<String> listEveId = generateData.getListId.getListEventId();
		int nO = listOrgId.size(); 
		int nE = listEveId.size();
		
		List<String> timeId = generateData.getListId.getListTimeId();
		int nTime = timeId.size();
		
		String[] relationship = {"Tổ chức", "Tham gia", "Phản đối", "Ủng hộ"};
		String rel;
		List<Fact<Organization, Event>> facts = new ArrayList<Fact<Organization, Event>>();
		Random rd = new Random();
		for(int i = 0; i < n; i++)
		{
			Fact<Organization, Event> f = new Fact<Organization, Event>();
			String org = listOrgId.get(rd.nextInt(nO));
			String eve = listEveId.get(rd.nextInt(nE));
			f.setIdentifier("FACT_ORG_EVE_" + Integer.toString(i));
			Organization org1 = new Organization();
			org1.setIdentifier(org);
			Event eve1 = new Event();
			eve1.setIdentifier(eve);
			f.setObject1(org1);
			f.setObject2(eve1);
			
			rel = relationship[rd.nextInt(4)];
			f.setSubject(rel);
			f.setRelationship(rel);
			f.setType(2);
			Time time = new Time();
			time.setIdentifier(timeId.get(rd.nextInt(nTime)));
			f.setTime(time);
			
			facts.add(f);
		}
		return facts;
	}
	
	public static List<Fact<Country, Event>> getListFactCTY2EVE(int n) throws ClassNotFoundException, SQLException {
		List<String> listCtyId = generateData.getListId.getListCountryId();
		List<String> listEveId = generateData.getListId.getListEventId();
		int nC = listCtyId.size(); 
		int nE = listEveId.size();
		
		List<String> timeId = generateData.getListId.getListTimeId();
		int nTime = timeId.size();
		
		String[] relationship = {"Tổ chức sự kiện", "Ủng hộ", "Phản đối", "Hủy bỏ"};
		List<Fact<Country, Event>> facts = new ArrayList<Fact<Country, Event>>();
		Random rd = new Random();
		for(int i = 0; i < n; i++)
		{
			Fact<Country, Event> f = new Fact<Country, Event>();
			String cty = listCtyId.get(rd.nextInt(nC));
			String eve = listEveId.get(rd.nextInt(nE));
			f.setIdentifier("FACT_CTY_EVE_" + Integer.toString(i));
			Country cty1 = new Country();
			cty1.setIdentifier(cty);
			Event eve1 = new Event();
			eve1.setIdentifier(eve);
			
			f.setObject1(cty1);
			f.setObject2(eve1);
			
			String st = relationship[rd.nextInt(4)];
			f.setSubject(st);
			f.setRelationship(st);
			f.setType(3);
			
			Time time = new Time();
			time.setIdentifier(timeId.get(rd.nextInt(nTime)));
			f.setTime(time);
			facts.add(f);
		}
		return facts;
	}
	
	public static List<Fact<Location, Event>> getListFactLOC2EVE(int n) throws ClassNotFoundException, SQLException {
		List<String> listLocId = generateData.getListId.getListLocationId();
		List<String> listEveId = generateData.getListId.getListEventId();
		int nL = listLocId.size(); 
		int nE = listEveId.size();
		
		List<String> timeId = generateData.getListId.getListTimeId();
		int nTime = timeId.size();
		
		String relationship = "là địa điểm tổ chức";
		List<Fact<Location, Event>> facts = new ArrayList<Fact<Location, Event>>();
		Random rd = new Random();
		for(int i = 0; i < n; i++)
		{
			Fact<Location, Event> f = new Fact<Location, Event>();
			String loc = listLocId.get(rd.nextInt(nL));
			String eve = listEveId.get(rd.nextInt(nE));
			f.setIdentifier("FACT_LOC_EVE_" + Integer.toString(i));
			Location loc1 = new Location();
			loc1.setIdentifier(loc);
			Event eve1 = new Event();
			eve1.setIdentifier(eve);
			
			f.setObject1(loc1);
			f.setObject2(eve1);
			
			f.setSubject("Tổ chức sự kiện");
			f.setRelationship(relationship);
			f.setType(4);
			
			Time time = new Time();
			time.setIdentifier(timeId.get(rd.nextInt(nTime)));
			f.setTime(time);
			facts.add(f);
		}
		return facts;
	}
	
	public static List<Fact<Person, Person>> getListFactPER2PER(int n) throws ClassNotFoundException, SQLException {
		List<String> listPersonId = generateData.getListId.getListPersonId();
		int nId = listPersonId.size();
		
		String subject = "Gặp gỡ";
		String relationship = "gặp gỡ";
		
		List<Fact<Person, Person>> facts = new ArrayList<Fact<Person, Person>>();
		List<String> timeId = generateData.getListId.getListTimeId();
		int nTime = timeId.size();
		
		Random rd = new Random();
		for(int i = 0; i < n; i++)
		{
			Fact<Person, Person> f = new Fact<Person, Person>();
			String per1 = listPersonId.get(rd.nextInt(nId));
			String per2 = listPersonId.get(rd.nextInt(nId));
			f.setIdentifier("FACT_PER_PER_" + Integer.toString(i));
			
			Person person1 = new Person();
			person1.setIdentifier(per1);
			Person person2 = new Person();
			person2.setIdentifier(per2);
			
			f.setObject1(person1);
			f.setObject2(person2);
			f.setSubject(subject);
			f.setRelationship(relationship);
			Time time = new Time();
			time.setIdentifier(timeId.get(rd.nextInt(nTime)));
			f.setTime(time);
			f.setType(5);
			facts.add(f);
		}
			
		return facts;
	}
	public static List<Fact<Person, Country>> getListFactPER2CTY(int n) throws ClassNotFoundException, SQLException {
		List<String> listPersonId = generateData.getListId.getListPersonId();
		List<String> listCountryId = generateData.getListId.getListCountryId();
		int nPer = listPersonId.size();
		int nCty = listCountryId.size();
		//String subject = "Gặp gỡ";
		//String relationship = "gặp gỡ";
		String subject[]= {"Ủng hộ","Phản đối"};
		String relationship[]= {"ủng hộ","phản đối"};
		List<Fact<Person, Country>> facts = new ArrayList<Fact<Person, Country>>();
		List<String> timeId = generateData.getListId.getListTimeId();
		int nTime = timeId.size();
		
		Random rd = new Random();
		for(int i = 0; i < n; i++)
		{
			Fact<Person, Country> f = new Fact<Person, Country>();
			String per = listPersonId.get(rd.nextInt(nPer));
			String cty = listCountryId.get(rd.nextInt(nCty));
			f.setIdentifier("FACT_PER_CTY_" + Integer.toString(i));
			
			Person person = new Person();
			person.setIdentifier(per);
			Country country = new Country();
			country.setIdentifier(cty);
			int a = rd.nextInt(2);
			f.setObject1(person);
			f.setObject2(country);
			f.setSubject(subject[a]);
			f.setRelationship(relationship[a]);
			Time time = new Time();
			time.setIdentifier(timeId.get(rd.nextInt(nTime)));
			f.setTime(time);
			f.setType(6);
			facts.add(f);
		}
		return facts;
	}
	
	public static List<Fact<Person, Agreement>> getListFactPER2AGR(int n) throws ClassNotFoundException, SQLException {
		List<String> listPersonId = generateData.getListId.getListPersonId();
		List<String> listAgreementId = generateData.getListId.getListAgreementId();
		int nPer = listPersonId.size();
		int nAgr = listAgreementId.size();
		//String subject = "Gặp gỡ";
		//String relationship = "gặp gỡ";
		String subject[]= {"Tham gia","Ủng hộ","Phản đối","Hủy bỏ"};
		String relationship[]= {"tham gia","ủng hộ","phản đối","hủy bỏ"};
		List<Fact<Person, Agreement>> facts = new ArrayList<Fact<Person, Agreement>>();
		List<String> timeId = generateData.getListId.getListTimeId();
		int nTime = timeId.size();
		
		Random rd = new Random();
		for(int i = 0; i < n; i++)
		{
			Fact<Person, Agreement> f = new Fact<Person, Agreement>();
			String per = listPersonId.get(rd.nextInt(nPer));
			String agr = listAgreementId.get(rd.nextInt(nAgr));
			f.setIdentifier("FACT_PER_AGR" + Integer.toString(i));
			
			Person person = new Person();
			person.setIdentifier(per);
			Agreement agreement = new Agreement();
			agreement.setIdentifier(agr);
			int a = rd.nextInt(4);
			f.setObject1(person);
			f.setObject2(agreement);
			f.setSubject(subject[a]);
			f.setRelationship(relationship[a]);
			Time time = new Time();
			time.setIdentifier(timeId.get(rd.nextInt(nTime)));
			f.setTime(time);
			f.setType(7);
			facts.add(f);
		}
		return facts;
	}
	
	public static List<Fact<Country, Country>> getListFactCTY2CTY(int n) throws ClassNotFoundException, SQLException {
		List<String> listCtyId = generateData.getListId.getListCountryId();
		int nC = listCtyId.size();
		List<Fact<Country, Country>> facts = new ArrayList<Fact<Country, Country>>();
		List<String> timeId = generateData.getListId.getListTimeId();
		int nTime = timeId.size();
		
		String[] r = {"Căng thẳng", "Ủng hộ", "Phản đối", "Đàm phán", "Ký thỏa thuận"};
		Random rd = new Random();
		
		for(int i = 0; i < n; i++)
		{
			Fact<Country, Country> f = new Fact<Country, Country>();
			f.setIdentifier("FACT_CTY_CTY_" + i);
			String cty1 = listCtyId.get(rd.nextInt(nC));
			String cty2 = listCtyId.get(rd.nextInt(nC));
			while (cty2 == cty1)
				cty2 = listCtyId.get(rd.nextInt(nC));
			
			Country cou1 = new Country();
			Country cou2 = new Country();
			cou1.setIdentifier(cty1);
			cou2.setIdentifier(cty2);
			f.setObject1(cou1);
			f.setObject2(cou2);
			
			String st = r[rd.nextInt(5)];
			f.setSubject(st);
			f.setRelationship(st);
			f.setType(9);
			
			Time time = new Time();
			time.setIdentifier(timeId.get(rd.nextInt(nTime)));
			f.setTime(time);
			facts.add(f);
		}
		return facts;
	}
	
	public static List<Fact<Person, Organization>> getListFactPER2ORG(int n) throws ClassNotFoundException, SQLException {
		List<String> listPersonId = generateData.getListId.getListPersonId();
		List<String> listOrganizationId = generateData.getListId.getListOrganizationId();
		int nPer = listPersonId.size();
		int nOrg = listOrganizationId.size();
		//String subject = "Gặp gỡ";
		//String relationship = "gặp gỡ";
		String subject[]= {"Tham gia"};
		String relationship[]= {"tham gia"};
		List<Fact<Person, Organization>> facts = new ArrayList<Fact<Person, Organization>>();
		List<String> timeId = generateData.getListId.getListTimeId();
		int nTime = timeId.size();
		
		Random rd = new Random();
		for(int i = 0; i < n; i++)
		{
			Fact<Person, Organization> f = new Fact<Person, Organization>();
			String per = listPersonId.get(rd.nextInt(nPer));
			String org = listOrganizationId.get(rd.nextInt(nOrg));
			f.setIdentifier("FACT_PER_ORG_" + Integer.toString(i));
			
			Person person = new Person();
			person.setIdentifier(per);
			Organization organization = new Organization();
			organization.setIdentifier(org);
			int a = 0;
			f.setObject1(person);
			f.setObject2(organization);
			f.setSubject(subject[a]);
			f.setRelationship(relationship[a]);
			Time time = new Time();
			time.setIdentifier(timeId.get(rd.nextInt(nTime)));
			f.setTime(time);
			f.setType(8);
			facts.add(f);
		}
		return facts;
	}
	
	public static List<Fact<Organization, Organization>> getListFactORG2ORG(int n) throws ClassNotFoundException, SQLException {
		List<String> listOrgId = generateData.getListId.getListOrganizationId();
		int nO = listOrgId.size();
		List<Fact<Organization, Organization>> facts = new ArrayList<Fact<Organization, Organization>>();
		List<String> timeId = generateData.getListId.getListTimeId();
		int nTime = timeId.size();
		
		String[] r = {"Ủng hộ", "Phản đối", "Đàm phán", "Ký thỏa thuận"};
		Random rd = new Random();
		
		for(int i = 0; i < n; i++)
		{
			Fact<Organization, Organization> f = new Fact<Organization, Organization>();
			f.setIdentifier("FACT_ORG_ORG" + i);
			String org1 = listOrgId.get(rd.nextInt(nO));
			String org2 = listOrgId.get(rd.nextInt(nO));
			Organization o1 = new Organization();
			o1.setIdentifier(org1);
			Organization o2 = new Organization();
			o2.setIdentifier(org2);
			f.setObject1(o1);
			f.setObject2(o2);
			
			String st = r[rd.nextInt(4)];
			f.setSubject(st);
			f.setRelationship(st);
			f.setType(10);
			
			Time time = new Time();
			time.setIdentifier(timeId.get(rd.nextInt(nTime)));
			f.setTime(time);
			facts.add(f);
		}
		return facts;
	}
	public static List<Fact<?, ?>> getListFacts(int n) throws ClassNotFoundException, SQLException {
		List<Fact<?, ?>> lst = new ArrayList<Fact<?, ?>>();
		lst.addAll(getListFactPER2EVE(n));
		lst.addAll(getListFactORG2EVE(n));
		lst.addAll(getListFactCTY2EVE(n));
		lst.addAll(getListFactLOC2EVE(n));
		lst.addAll(getListFactPER2PER(n));
		lst.addAll(getListFactPER2CTY(n));
		lst.addAll(getListFactPER2AGR(n));
		lst.addAll(getListFactPER2ORG(n));
		lst.addAll(getListFactCTY2CTY(n));
		lst.addAll(getListFactORG2ORG(n));
		return lst;
	}
}

