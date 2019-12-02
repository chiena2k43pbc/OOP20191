package main;
import model.*;

import java.sql.SQLException;
import java.util.List;

import generateData.*;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int n = 100;
		/*Time[] t = generateData.generateTime.getListTimes(n);
		for(int i = 0; i < n; i++)
		{
			System.out.println(t[i].getIdentifier() + " " + t[i].getName());
			System.out.println(t[i].getDescription());
			System.out.println();
		}
		Aggrement[] a = generateData.generateAggrement.getListAggrements(n);
		for(int i = 0; i < n; i++)
		{
			System.out.println(a[i].getIdentifier());
			System.out.println(a[i].getName());
			System.out.println(a[i].getDescription());
			System.out.println();
		}
		List<Fact<Person,Person>> facts = generateData.generateFact.getListFactPER2PER(1000);
		for(Fact<Person,Person> f : facts)
			System.out.println(f.getObject1().getIdentifier() + f.getObject2().getIdentifier());
		Event[] e = generateData.GenerateEvent.getListEvents();
		int ne = generateData.GenerateEvent.nEvent;
		for(int i = 0; i < ne; i++)
			System.out.println(e[i].getDescription());*/
		//insertData.InsertAgreementIntoDB.insert();
		//insertData.InsertLocationIntoDB.insert();
		/*List<Fact<Location, Event>> facts = generateData.generateFact.getListFactLOC2EVE(1000);
		System.out.println(facts.size());
		for(Fact<Location, Event> f : facts)
			System.out.println(f.getObject1().getIdentifier() + " " + f.getRelationship() + " " + f.getObject2().getIdentifier());
		List<Fact<Country, Event>> facts = generateData.generateFact.getListFactCTY2EVE(1000);
		for(Fact<Country, Event> f : facts)
			System.out.println(f.getObject1().getIdentifier() + " " + f.getRelationship() + " " + f.getObject2().getIdentifier());
		List<Fact<Country, Country>> facts = generateData.generateFact.getListFactCTY2CTY(15);
		for(Fact<Country, Country> f : facts)
			System.out.println(f.getObject1().getIdentifier() + " " + f.getRelationship() + " " + f.getObject2().getIdentifier());
		insertData.InsertOrganizationIntoDB.insert();
		List<Fact<Person, Agreement>> facts = generateData.generateFact.getListFactPER2AGR(15);
		for(Fact<Person, Agreement> f : facts)
			System.out.println(f.getObject1().getIdentifier() + " " + f.getRelationship() + " " + f.getObject2().getIdentifier());*/
		insertData.InsertFactIntoDB.insert();
	}

}
