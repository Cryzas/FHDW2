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
	
	Program4Public program;
	ModuleAtomar4Public moduleAtomar;
	ModuleWithUnits4Public moduleWithUnits;
	
	
	@Before
	public void setUp() throws Exception {
		TestSupport.clearDatabase();
		TestSupport.prepareSingletons();
		programManager = ProgramManager.createProgramManager();
		moduleManager = ModuleManager.createModuleManager();
		
		program = Program.createProgram("Programm 1");
		programManager.getPrograms().add(program);
		
		moduleAtomar = ModuleAtomar.createModuleAtomar("Modul Atomar 1");
		moduleManager.getModules().add(moduleAtomar);
		
		moduleWithUnits = ModuleWithUnits.createModuleWithUnits("Modul mit Units 1");
		moduleWithUnits.addUnit("Unit 1", Fraction.parse("3"));
		moduleWithUnits.addUnit("Unit 2", Fraction.parse("4"));
		moduleManager.getModules().add(moduleWithUnits);
	}

	@Test
	public void createProgramDuplicate() throws PersistenceException {
		try {
			programManager.createProgram("Programm 1");
			fail();
		} catch (AlreadyExistsInParentException e) {
			//Should go in here
		}
		try {
			programManager.createProgram("Modul Atomar 1");
			fail();
		} catch (AlreadyExistsInParentException e) {
			//Should go in here
		}		
	}
	
	@Test
	public void createModuleDuplicate() throws PersistenceException {
		try {
			moduleManager.createModule("Atomar", "Modul Atomar 1");
			fail();
		} catch (AlreadyExistsInParentException e) {
			//Should go in here
		}
		try {
			moduleManager.createModule("Atomar", "Programm 1");
			fail();
		} catch (AlreadyExistsInParentException e) {
			//Should go in here
		}
	}
	
	@Test
	public void createUnitDuplicate() throws PersistenceException {
		try {
			moduleManager.addUnit(moduleWithUnits, "Unit 1", Fraction.parse("3"));
			fail();
		} catch (AlreadyExistsInParentException e) {
			//Should go in here
		} catch (CycleException e) {
			fail();
		}
	}

}
