package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import common.Fraction;
import model.*;
import persistence.*;

public class ProgramCreationTest {
	
	ProgramManager4Public programManager;
	ModuleManager4Public moduleManager;
	
	Program4Public programWirtschaftsinformatik; 
	
	ModuleAtomar4Public moduleAtomarSoko; 
	ModuleAtomar4Public moduleAtomarLomf; 
	ModuleAtomar4Public moduleAtomarDBSQL; 
	
	ModuleWithUnits4Public moduleWithUnitsMathe;
	ModuleWithUnits4Public moduleWithUnitsSWT;
	ModuleWithUnits4Public moduleWithUnitsDBProgra;
	
	ModuleGroup4Public moduleGroupInformatik;
	ModuleGroup4Public moduleGroupDB;
	
	@Before
	public void setUp() throws Exception {
		TestSupport.clearDatabase();
		TestSupport.prepareSingletons();
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
		moduleManager.getModules().add(moduleAtomarSoko);
		programWirtschaftsinformatik.addModule(moduleAtomarSoko);
		
		moduleWithUnitsMathe = ModuleWithUnits.createModuleWithUnits("Mathe");
		moduleWithUnitsMathe.addUnit("Mathe 1", Fraction.parse("3"));
		moduleWithUnitsMathe.addUnit("Mathe 2", Fraction.parse("4"));
		moduleManager.getModules().add(moduleWithUnitsMathe);
		programWirtschaftsinformatik.addModule(moduleWithUnitsMathe);
		
		moduleAtomarLomf = ModuleAtomar.createModuleAtomar("LOMF");
		moduleManager.getModules().add(moduleAtomarLomf);
		
		moduleAtomarDBSQL = ModuleAtomar.createModuleAtomar("Datenbanken SQL");
		moduleManager.getModules().add(moduleAtomarDBSQL);
		
		moduleWithUnitsSWT = ModuleWithUnits.createModuleWithUnits("SWT");
		moduleWithUnitsSWT.addUnit("SWT 1", Fraction.parse("4"));
		moduleWithUnitsSWT.addUnit("SWT 2", Fraction.parse("3"));
		moduleManager.getModules().add(moduleWithUnitsSWT);
		moduleGroupInformatik.addModule(moduleWithUnitsSWT);
		
		moduleWithUnitsDBProgra = ModuleWithUnits.createModuleWithUnits("Database Programming");
		moduleWithUnitsDBProgra.addUnit("Datenbanken 1", Fraction.parse("5"));
		moduleWithUnitsDBProgra.addUnit("Datenbanken 2", Fraction.parse("4"));
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
	}
	
	
	
}
