package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import common.Fraction;
import model.*;
import persistence.*;

public class ProgramModuleTest {
	
	ProgramManager4Public programManager;
	ModuleManager4Public moduleManager;
	
	Program4Public programWirtschaftsinformatik; 
	
	ModuleAtomar4Public moduleAtomarSoko; 
	ModuleAtomar4Public moduleAtomarLomf; 
	ModuleAtomar4Public moduleAtomarDBSQL; 
	
	ModuleWithUnits4Public moduleWithUnitsMathe;
	Unit4Public unitMathe1;
	Unit4Public unitMathe2;
	
	ModuleWithUnits4Public moduleWithUnitsSWT;
	Unit4Public unitSWT1;
	Unit4Public unitSWT2;
	
	ModuleWithUnits4Public moduleWithUnitsDBProgra;
	Unit4Public unitDB1;
	Unit4Public unitDB2;
	
	ModuleGroup4Public moduleGroupInformatik;
	ModuleGroup4Public moduleGroupDB;
	
	@Before
	public void setUp() throws Exception {
		TestSupport.clearDatabase();
		TestSupport.prepareSingletons();
		Cache.getTheCache().reset$For$Test();
		programManager = ProgramManager.createProgramManager();
		moduleManager = ModuleManager.createModuleManager();
		
		programWirtschaftsinformatik = Program.createProgram("Wirtschaftsinformatik");
		programManager.getPrograms().add(programWirtschaftsinformatik);
		
		moduleGroupInformatik = ModuleGroup.createModuleGroup("Informatik");
		moduleManager.getModules().add(moduleGroupInformatik);
		programWirtschaftsinformatik.addModule(moduleGroupInformatik);
		
		moduleGroupDB = ModuleGroup.createModuleGroup("Datenbanken");
		moduleManager.getModules().add(moduleGroupDB);
		moduleGroupInformatik.addModule(moduleGroupDB);
		
		moduleAtomarSoko = ModuleAtomar.createModuleAtomar("Soziale Kompetenz");
		moduleAtomarSoko.changeCPOnModule(Fraction.parse("3"));
		moduleManager.getModules().add(moduleAtomarSoko);
		programWirtschaftsinformatik.addModule(moduleAtomarSoko);
		
		moduleWithUnitsMathe = ModuleWithUnits.createModuleWithUnits("Mathe");
		unitMathe1 = Unit.createUnit("Mathe 1", Fraction.parse("3"));
		unitMathe2 = Unit.createUnit("Mathe 2", Fraction.parse("4"));
		moduleWithUnitsMathe.getUnits().add(unitMathe1);
		moduleWithUnitsMathe.getUnits().add(unitMathe2);
		moduleManager.getModules().add(moduleWithUnitsMathe);
		programWirtschaftsinformatik.addModule(moduleWithUnitsMathe);
		
		moduleAtomarLomf = ModuleAtomar.createModuleAtomar("LOMF");
		moduleAtomarLomf.changeCPOnModule(Fraction.parse("5"));
		moduleManager.getModules().add(moduleAtomarLomf);
		moduleGroupInformatik.getModules().add(moduleAtomarLomf);
		
		moduleAtomarDBSQL = ModuleAtomar.createModuleAtomar("Datenbanken SQL");
		moduleAtomarDBSQL.changeCPOnModule(Fraction.parse("4"));
		moduleManager.getModules().add(moduleAtomarDBSQL);
		moduleGroupDB.getModules().add(moduleAtomarDBSQL);
		
		moduleWithUnitsSWT = ModuleWithUnits.createModuleWithUnits("SWT");
		unitSWT1 = Unit.createUnit("SWT 1", Fraction.parse("4"));
		unitSWT2 = Unit.createUnit("SWT 2", Fraction.parse("3"));
		moduleWithUnitsSWT.getUnits().add(unitSWT1);
		moduleWithUnitsSWT.getUnits().add(unitSWT2);
		moduleManager.getModules().add(moduleWithUnitsSWT);
		moduleGroupInformatik.addModule(moduleWithUnitsSWT);
		
		moduleWithUnitsDBProgra = ModuleWithUnits.createModuleWithUnits("Database Programming");
		unitDB1 = Unit.createUnit("Datenbanken 1", Fraction.parse("5"));
		unitDB2 = Unit.createUnit("Datenbanken 2", Fraction.parse("4"));
		moduleWithUnitsDBProgra.getUnits().add(unitDB1);
		moduleWithUnitsDBProgra.getUnits().add(unitDB2);
		moduleManager.getModules().add(moduleWithUnitsDBProgra);
		moduleGroupDB.addModule(moduleWithUnitsDBProgra);
		
		
	}

	@Test
	public void createProgramDuplicate() throws PersistenceException {
		try {
			programManager.createProgram("Wirtschaftsinformatik");
			fail();
		} catch (AlreadyExistsInParentException e) {
			//Should go in here
		}
		try {
			programManager.createProgram("Soziale Kompetenz");
			fail();
		} catch (AlreadyExistsInParentException e) {
			//Should go in here
		}		
	}
	
	@Test
	public void createModuleDuplicate() throws PersistenceException {
		try {
			moduleManager.createModule("Atomar", "Soziale Kompetenz");
			fail();
		} catch (AlreadyExistsInParentException e) {
			//Should go in here
		}
		try {
			moduleManager.createModule("Atomar", "Wirtschaftsinformatik");
			fail();
		} catch (AlreadyExistsInParentException e) {
			//Should go in here
		}
	}
	
	@Test
	public void createUnitDuplicate() throws PersistenceException {
		try {
			moduleManager.addUnit(moduleWithUnitsMathe, "Mathe 1", Fraction.parse("3"));
			fail();
		} catch (AlreadyExistsInParentException e) {
			//Should go in here
		} catch (CycleException e) {
			fail();
		}
		try {
			moduleManager.addUnit(moduleWithUnitsSWT, "Mathe 1", Fraction.parse("3"));
		} catch (AlreadyExistsInParentException e) {
			fail();
		} catch (CycleException e) {
			fail();
		}
	}
	
	@Test
	public void createModuleGroupDuplicate() throws PersistenceException {
		try {
			moduleManager.createModule("Gruppe", "Informatik");
			fail();
		} catch (AlreadyExistsInParentException e) {
			//Should go in here
		} 
	}
	
	@Test
	public void createUnit() throws PersistenceException {
		try {
			moduleManager.addUnit(moduleWithUnitsMathe, "Mathe 3", Fraction.parse("3"));
		} catch (AlreadyExistsInParentException e) {
			fail();
		} catch (CycleException e) {
			fail();
		}
		try {
			moduleManager.addUnit(moduleWithUnitsMathe, "Mathe 3", Fraction.parse("3"));
			fail();
		} catch (AlreadyExistsInParentException e) {
			//Should go in here
		} catch (CycleException e) {
			fail();
		}
	}
	
	@Test
	public void addModuleToProgram() throws PersistenceException {
		ModuleAtomar4Public moduleAtomar;
		moduleAtomar = ModuleAtomar.createModuleAtomar("Rechnungswesen");
		try {
			programManager.addModuleToProg(programWirtschaftsinformatik, moduleAtomar);
			assertTrue(programWirtschaftsinformatik.containsprogramHierarchy(moduleAtomar));
		} catch (AlreadyExistsInParentException e) {
			fail();
		} catch (CycleException e) {
			fail();
		}
		try {
			programManager.addModuleToProg(programWirtschaftsinformatik, moduleAtomar);
			fail();
		} catch (AlreadyExistsInParentException e) {
			// Should go in here
		} catch (CycleException e) {
			fail();
		}
	}
	
	@Test
	public void addModuleToGroup() throws PersistenceException {
		ModuleAtomar4Public moduleAtomar;
		moduleAtomar = ModuleAtomar.createModuleAtomar("Rechnungswesen");
		try {
			moduleManager.addModuleToGroup(moduleGroupDB, moduleAtomar);
			assertTrue(moduleGroupDB.containsprogramHierarchy(moduleAtomar));
		} catch (AlreadyExistsInParentException e) {
			fail();
		} catch (CycleException e) {
			fail();
		}
		try {
			moduleManager.addModuleToGroup(moduleGroupDB, moduleAtomar);
			fail();
		} catch (AlreadyExistsInParentException e) {
			// Should go in here
		} catch (CycleException e) {
			fail();
		}
	}
	
	@Test
	public void changeCPonUnit() throws PersistenceException {
		moduleManager.changeCPOnUnit(unitMathe1, Fraction.parse("5"));
		assertEquals(Fraction.parse("5"), unitMathe1.getCreditPoints());
		moduleManager.changeCPOnUnit(unitSWT2, Fraction.parse("4"));
		assertEquals(Fraction.parse("4"), unitSWT2.getCreditPoints());
	}
	
	@Test
	public void changeCPonModule() throws PersistenceException {
		moduleManager.changeCPOnModule(moduleAtomarLomf, Fraction.parse("4"));
		assertEquals(Fraction.parse("4"), moduleAtomarLomf.getCreditPoints());
		moduleManager.changeCPOnModule(moduleAtomarSoko, Fraction.parse("2"));
		assertEquals(Fraction.parse("2"), moduleAtomarSoko.getCreditPoints());
	}
	
	@Test
	public void changeGradeSystem() throws PersistenceException {
		assertEquals(ThirdGradeSystem.getTheThirdGradeSystem(), moduleAtomarLomf.getGradeSystem());
		moduleManager.changeGradeSystem(moduleAtomarLomf);
		assertEquals(SimpleGradeSystem.getTheSimpleGradeSystem(), moduleAtomarLomf.getGradeSystem());
		moduleManager.changeGradeSystem(moduleAtomarLomf);
		assertEquals(ThirdGradeSystem.getTheThirdGradeSystem(), moduleAtomarLomf.getGradeSystem());
	}
	
	@Test
	public void getCreditPoints() throws PersistenceException {
		assertEquals(Fraction.parse("35"),programWirtschaftsinformatik.getCreditPoints());
		assertEquals(Fraction.parse("25"),moduleGroupInformatik.getCreditPoints());
		assertEquals(Fraction.parse("3"),moduleAtomarSoko.getCreditPoints());
		assertEquals(Fraction.parse("7"),moduleWithUnitsMathe.getCreditPoints());
		assertEquals(Fraction.parse("3"),unitMathe1.getCreditPoints());
		assertEquals(Fraction.parse("4"),unitMathe2.getCreditPoints());
		assertEquals(Fraction.parse("13"),moduleGroupDB.getCreditPoints());
		assertEquals(Fraction.parse("5"),moduleAtomarLomf.getCreditPoints());
		assertEquals(Fraction.parse("7"),moduleWithUnitsSWT.getCreditPoints());
		assertEquals(Fraction.parse("4"),unitSWT1.getCreditPoints());
		assertEquals(Fraction.parse("3"),unitSWT2.getCreditPoints());
		assertEquals(Fraction.parse("4"),moduleAtomarDBSQL.getCreditPoints());
		assertEquals(Fraction.parse("9"),moduleWithUnitsDBProgra.getCreditPoints());
		assertEquals(Fraction.parse("5"),unitDB1.getCreditPoints());
		assertEquals(Fraction.parse("4"),unitDB2.getCreditPoints());
	}
	
}
