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
	
	MyBooleanVisitor booleanVisitor = new MyBooleanVisitor() {

		@Override
		public void handleBTrue(BTrue4Public bTrue) throws PersistenceException {
		}

		@Override
		public void handleBFalse(BFalse4Public bFalse) throws PersistenceException {
			fail();
		}
	};

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
		moduleAtomarSoko.changeGradeSystem(SimpleGradeSystem.getTheSimpleGradeSystem());
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
	public void startStudyGroup()
			throws AlreadyExistsInParentException, NoFractionValueException, PersistenceException {
		programManager.startStudyGroup(programWirtschaftsinformatik, "HFW2");
		try {
			programManager.startStudyGroup(programWirtschaftsinformatik, "HFW1");
			fail();
		} catch (UserException e) {
			// Should go in here
		}
	}

	@Test
	public void startStudyGroupWith0CPUnit() throws PersistenceException, AlreadyExistsInParentException {
		try {
			unitDB1.changeCPOnUnit(Fraction.parse("0"));
			programManager.startStudyGroup(programWirtschaftsinformatik, "HFW2");
			fail();
		} catch (NoFractionValueException e) {
			// Should go in here
		}
	}

	@Test
	public void startStudyGroupWith0CPModuleAtomar() throws AlreadyExistsInParentException, PersistenceException {
		try {
			moduleAtomarLomf.changeCPOnModule(Fraction.parse("0"));
			programManager.startStudyGroup(programWirtschaftsinformatik, "HFW2");
			fail();
		} catch (NoFractionValueException e) {
			// Should go in here
		}
	}

	@Test
	public void startStudyGroupProgramCopy()
			throws PersistenceException, AlreadyExistsInParentException, NoFractionValueException {
		ProgramSGroup4Public programCopy = programWirtschaftsinformatik.copyForStudyGroup();
		programManager.startStudyGroup(programWirtschaftsinformatik, "HFW2");
		StudyGroup4Public group = StudyGroup.getStudyGroupByName("HFW2").iterator().next();
		assertEquals(group.getProgram().getName(), programCopy.getName());
		assertEquals(group.getProgram().getCreditPoints(), programCopy.getCreditPoints());
		group.getProgram().getModules().applyToAll(module -> {
			assertTrue(programCopy.getModules()
					.findFirst(moduleCopy -> moduleCopy.toString().equals(module.toString())) != null);
		});
	}

	@Test
	public void endStudyGroup() throws AlreadyFinishedException, PersistenceException {
		groupManager.endStudyGroup(studyGroupHFW1);
		studyGroupHFW1.getFinished().accept(booleanVisitor);
		studyGroupHFW1.getProgram().getFinished().accept(booleanVisitor);
		studyGroupHFW1.getProgram().getModules().applyToAll(module -> {
			module.accept(new ModuleAbstractSGroupVisitor() {

				@Override
				public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup)
						throws PersistenceException {
					moduleWithUnitsSGroup.getFinished().accept(booleanVisitor);
					moduleWithUnitsSGroup.getUnits()
							.applyToAll(unit -> moduleWithUnitsSGroup.getFinished().accept(booleanVisitor));
				}

				@Override
				public void handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup)
						throws PersistenceException {
					moduleGroupSGroup.getFinished().accept(booleanVisitor);
					moduleGroupSGroup.getModules().applyToAll(module2 -> module2.accept(this));
				}

				@Override
				public void handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup)
						throws PersistenceException {
					moduleAtomarSGroup.getFinished().accept(booleanVisitor);
				}
			});
		});
		try {
			studyGroupHFW1.endStudyGroup();
		} catch (AlreadyFinishedException e) {
			// Should go in here
		}
	}
	
	@Test
	public void endStudyGroupFinished() throws AlreadyFinishedException, PersistenceException {
		groupManager.endStudyGroup(studyGroupHFW1);
		try {
			studyGroupHFW1.endStudyGroup();
		} catch (AlreadyFinishedException e) {
			// Should go in here
		}
	}


	@Test
	public void swapCP() throws AlreadyFinishedException, UnitSwapException, PersistenceException {
		ModuleWithUnitsSGroup4Public moduleWithUnitsSMathe = (ModuleWithUnitsSGroup4Public) studyGroupHFW1.getProgram()
				.getModules().findFirst(module -> module.getName().equals("Mathe"));
		UnitSGroup4Public unitGMathe1 = moduleWithUnitsSMathe.getUnits()
				.findFirst(unit -> unit.getName().equals("Mathe 1"));
		UnitSGroup4Public unitGMathe2 = moduleWithUnitsSMathe.getUnits()
				.findFirst(unit -> unit.getName().equals("Mathe 2"));
		groupManager.swapCPonModuleWithUnits(moduleWithUnitsSMathe, unitGMathe2, unitGMathe1, Fraction.parse("2"));
		assertEquals(Fraction.parse("5"), unitGMathe1.getCreditPoints());
		assertEquals(Fraction.parse("2"), unitGMathe2.getCreditPoints());
	}
	
	@Test
	public void swapCPEquals0() throws AlreadyFinishedException, UnitSwapException, PersistenceException {
		ModuleWithUnitsSGroup4Public moduleWithUnitsSMathe = (ModuleWithUnitsSGroup4Public) studyGroupHFW1.getProgram()
				.getModules().findFirst(module -> module.getName().equals("Mathe"));
		UnitSGroup4Public unitGMathe1 = moduleWithUnitsSMathe.getUnits()
				.findFirst(unit -> unit.getName().equals("Mathe 1"));
		UnitSGroup4Public unitGMathe2 = moduleWithUnitsSMathe.getUnits()
				.findFirst(unit -> unit.getName().equals("Mathe 2"));
		try {
			groupManager.swapCPonModuleWithUnits(moduleWithUnitsSMathe, unitGMathe2, unitGMathe1, Fraction.parse("4"));
			fail();
		} catch (UnitSwapException e) {
			// Should go in here
		}
	}
	
	@Test
	public void swapCPUnder0() throws AlreadyFinishedException, UnitSwapException, PersistenceException {
		ModuleWithUnitsSGroup4Public moduleWithUnitsSMathe = (ModuleWithUnitsSGroup4Public) studyGroupHFW1.getProgram()
				.getModules().findFirst(module -> module.getName().equals("Mathe"));
		UnitSGroup4Public unitGMathe1 = moduleWithUnitsSMathe.getUnits()
				.findFirst(unit -> unit.getName().equals("Mathe 1"));
		UnitSGroup4Public unitGMathe2 = moduleWithUnitsSMathe.getUnits()
				.findFirst(unit -> unit.getName().equals("Mathe 2"));
		try {
			groupManager.swapCPonModuleWithUnits(moduleWithUnitsSMathe, unitGMathe2, unitGMathe1, Fraction.parse("5"));
			fail();
		} catch (UnitSwapException e) {
			// Should go in here
		}
	}
	
	@Test
	public void swapCPUnder0Negative() throws AlreadyFinishedException, UnitSwapException, PersistenceException {
		ModuleWithUnitsSGroup4Public moduleWithUnitsSMathe = (ModuleWithUnitsSGroup4Public) studyGroupHFW1.getProgram()
				.getModules().findFirst(module -> module.getName().equals("Mathe"));
		UnitSGroup4Public unitGMathe1 = moduleWithUnitsSMathe.getUnits()
				.findFirst(unit -> unit.getName().equals("Mathe 1"));
		UnitSGroup4Public unitGMathe2 = moduleWithUnitsSMathe.getUnits()
				.findFirst(unit -> unit.getName().equals("Mathe 2"));
		try {
			groupManager.swapCPonModuleWithUnits(moduleWithUnitsSMathe, unitGMathe1, unitGMathe2, Fraction.parse("-5"));
			fail();
		} catch (UnitSwapException e) {
			// Should go in here
		}
	}
	
	@Test
	public void swapCPFinished() throws AlreadyFinishedException, UnitSwapException, PersistenceException {
		ModuleWithUnitsSGroup4Public moduleWithUnitsSMathe = (ModuleWithUnitsSGroup4Public) studyGroupHFW1.getProgram()
				.getModules().findFirst(module -> module.getName().equals("Mathe"));
		UnitSGroup4Public unitGMathe1 = moduleWithUnitsSMathe.getUnits()
				.findFirst(unit -> unit.getName().equals("Mathe 1"));
		UnitSGroup4Public unitGMathe2 = moduleWithUnitsSMathe.getUnits()
				.findFirst(unit -> unit.getName().equals("Mathe 2"));
		try {
			groupManager.endStudyGroup(studyGroupHFW1);
			groupManager.swapCPonModuleWithUnits(moduleWithUnitsSMathe, unitGMathe1, unitGMathe2, Fraction.parse("1"));
			fail();
		} catch (AlreadyFinishedException e) {
			// Should go in here
		}
	}

}
