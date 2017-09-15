package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import common.Fraction;
import model.*;
import model.visitor.ModuleAbstractSGroupVisitor;
import model.visitor.MyBooleanVisitor;
import persistence.*;

public class StudyGroupTest {

	ProgramManager4Public programManager;
	ModuleManager4Public moduleManager;
	StudyGroupManager4Public groupManager;

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

	StudyGroup4Public studyGroupHFW1;

	@Before
	public void setUp() throws Exception {
		TestSupport.clearDatabase();
		TestSupport.prepareSingletons();
		Cache.getTheCache().reset$For$Test();
		programManager = ProgramManager.createProgramManager();
		moduleManager = ModuleManager.createModuleManager();
		groupManager = StudyGroupManager.createStudyGroupManager();

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

		studyGroupHFW1 = StudyGroup.createStudyGroup("HFW1");
		studyGroupHFW1.setProgram(programWirtschaftsinformatik.copyForStudyGroup());
		groupManager.getGroups().add(studyGroupHFW1);
	}

	@Test
	public void startStudyGroup() {
		try {
			groupManager.startStudyGroup(programWirtschaftsinformatik, "HFW2");
			assertTrue(groupManager.getGroups().findFirst(group -> group.getName().equals("HFW2")) != null);
		} catch (UserException e) {
			fail();
		} catch (PersistenceException e) {
			fail();
		}
		try {
			groupManager.startStudyGroup(programWirtschaftsinformatik, "HFW1");
			fail();
		} catch (UserException e) {
			// Should go in here
		} catch (PersistenceException e) {
			fail();
		}
	}

	@Test
	public void startStudyGroupWith0CPUnit() {
		try {
			unitDB1.changeCPOnUnit(Fraction.parse("0"));
			groupManager.startStudyGroup(programWirtschaftsinformatik, "HFW2");
			fail();
		} catch (AlreadyExistsInParentException e) {
			fail();
		} catch (NoFractionValueException e) {
			// Should go in here
		} catch (PersistenceException e) {
			fail();
		}
	}
	
	@Test
	public void startStudyGroupWith0CPModuleAtomar() {
		try {
			moduleAtomarLomf.changeCPOnModule(Fraction.parse("0"));
			groupManager.startStudyGroup(programWirtschaftsinformatik, "HFW2");
			fail();
		} catch (AlreadyExistsInParentException e) {
			fail();
		} catch (NoFractionValueException e) {
			// Should go in here
		} catch (PersistenceException e) {
			fail();
		}
	}
	
	@Test
	public void startStudyGroupProgramCopy() {
		try {
			ProgramSGroup4Public programCopy = programWirtschaftsinformatik.copyForStudyGroup();
			groupManager.startStudyGroup(programWirtschaftsinformatik, "HFW2");
			StudyGroup4Public group = StudyGroup.getStudyGroupByName("HFW2").iterator().next();
			assertEquals(group.getProgram().getName(), programCopy.getName());
			assertEquals(group.getProgram().getCreditPoints(), programCopy.getCreditPoints());
			group.getProgram().getModules().applyToAll(module -> {
				assertTrue(programCopy.getModules().findFirst(moduleCopy -> moduleCopy.toString().equals(module.toString())) != null);
			});
		} catch (AlreadyExistsInParentException e) {
			fail();
		} catch (NoFractionValueException e) {
			fail();
		} catch (PersistenceException e) {
			fail();
		}
	}
	
	@Test
	public void endStudyGroup() {
		try {
			MyBooleanVisitor visitor = new MyBooleanVisitor() {
				
				@Override
				public void handleBTrue(BTrue4Public bTrue) throws PersistenceException {
				}
				
				@Override
				public void handleBFalse(BFalse4Public bFalse) throws PersistenceException {
					fail();
				}
			};
			groupManager.endStudyGroup(studyGroupHFW1);
			studyGroupHFW1.getFinished().accept(visitor);
			studyGroupHFW1.getProgram().getFinished().accept(visitor);
			studyGroupHFW1.getProgram().getModules().applyToAll(module -> {
				module.accept(new ModuleAbstractSGroupVisitor() {
					
					@Override
					public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup)
							throws PersistenceException {
						moduleWithUnitsSGroup.getFinished().accept(visitor);
						moduleWithUnitsSGroup.getUnits().applyToAll(unit -> moduleWithUnitsSGroup.getFinished().accept(visitor));
					}
					
					@Override
					public void handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException {
						moduleGroupSGroup.getFinished().accept(visitor);
						moduleGroupSGroup.getModules().applyToAll(module2 -> module2.accept(this));
					}
					
					@Override
					public void handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException {
						moduleAtomarSGroup.getFinished().accept(visitor);
					}
				});
			});
		} catch (AlreadyFinishedException e) {
			fail();
		} catch (PersistenceException e) {
			fail();
		}
		try {
			studyGroupHFW1.endStudyGroup();
		} catch (AlreadyFinishedException e) {
			// Should go in here
		} catch (PersistenceException e) {
			fail();
		}
	}
	
	@Test
	public void swapCP() {
		try {
			ModuleWithUnitsSGroup4Public moduleWithUnitsSMathe = (ModuleWithUnitsSGroup4Public) studyGroupHFW1.getProgram().getModules().findFirst(module -> module.getName().equals("Mathe"));
			UnitSGroup4Public unitGMathe1 = moduleWithUnitsSMathe.getUnits().findFirst(unit -> unit.getName().equals("Mathe 1"));
			UnitSGroup4Public unitGMathe2 = moduleWithUnitsSMathe.getUnits().findFirst(unit -> unit.getName().equals("Mathe 2"));
			try {
				groupManager.swapCPonModuleWithUnits(moduleWithUnitsSMathe, unitGMathe2, unitGMathe1, Fraction.parse("2"));
			} catch (UnitSwapException | AlreadyFinishedException e) {
				fail();
			}
			assertEquals(Fraction.parse("5"), unitGMathe1.getCreditPoints());
			assertEquals(Fraction.parse("2"), unitGMathe2.getCreditPoints());
			try {
				groupManager.swapCPonModuleWithUnits(moduleWithUnitsSMathe, unitGMathe2, unitGMathe1, Fraction.parse("2"));
				fail();
			} catch (UnitSwapException e) {
				// Should go in here
			} catch (AlreadyFinishedException e) {
				fail();
			}
			try {
				groupManager.swapCPonModuleWithUnits(moduleWithUnitsSMathe, unitGMathe2, unitGMathe1, Fraction.parse("4"));
				fail();
			} catch (UnitSwapException e) {
				// Should go in here
			} catch (AlreadyFinishedException e) {
				fail();
			}
			try {
				groupManager.swapCPonModuleWithUnits(moduleWithUnitsSMathe, unitGMathe1, unitGMathe2, Fraction.parse("-2"));
				fail();
			} catch (UnitSwapException e) {
				// Should go in here
			} catch (AlreadyFinishedException e) {
				fail();
			}
			try {
				groupManager.endStudyGroup(studyGroupHFW1);
				groupManager.swapCPonModuleWithUnits(moduleWithUnitsSMathe, unitGMathe1, unitGMathe2, Fraction.parse("1"));
				fail();
			} catch (UnitSwapException e) {
				fail();
			} catch (AlreadyFinishedException e) {
				// SHould go in here
			}
		} catch (PersistenceException e) {
			fail();
		}
	}

}
