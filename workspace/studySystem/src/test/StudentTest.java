package test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import common.Fraction;
import model.*;
import persistence.*;

public class StudentTest {

	ProgramManager4Public programManager;
	ModuleManager4Public moduleManager;
	StudyGroupManager4Public groupManager;
	StudentManager4Public studentManager;

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

	Student4Public hakan;
	Student4Public florian;
	Student4Public michael;
	Student4Public jens;

	@Before
	public void setUp() throws Exception {
		TestSupport.clearDatabase();
		TestSupport.prepareSingletons();
		Cache.getTheCache().reset$For$Test();
		programManager = ProgramManager.createProgramManager();
		moduleManager = ModuleManager.createModuleManager();
		groupManager = StudyGroupManager.createStudyGroupManager();
		studentManager = StudentManager.createStudentManager();

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

		hakan = Student.createStudent("Hakan", "Özdemir", Date.valueOf("1989-02-03"));
		florian = Student.createStudent("Florian", "Raetsch", Date.valueOf("1994-10-29"));
		michael = Student.createStudent("Michael", "Lange", Date.valueOf("1995-05-03"));
		jens = Student.createStudent("Jens", "Burczyk", Date.valueOf("1998-11-16"));
	}

	@Test
	public void createStudent() throws PersistenceException, CycleException, AlreadyFinishedException, AlreadyExistsInParentException {
		studentManager.createStudent(studyGroupHFW1, "Michael", "Löwe", Date.valueOf("1956-01-01"));
		assertTrue(studyGroupHFW1.getStudents()
				.findFirst(student -> student.getFirstName().equals("Michael") && student.getLastName().equals("Löwe")
						&& student.getBirthDate().equals(Date.valueOf("1956-01-01"))) != null);
		assertTrue(studentManager.getStudents()
				.findFirst(student -> student.getFirstName().equals("Michael") && student.getLastName().equals("Löwe")
						&& student.getBirthDate().equals(Date.valueOf("1956-01-01"))) != null);
	}

	@Test
	public void createServerForStudent() throws PersistenceException {
		assertTrue(Server.getServerByUser(String.valueOf(hakan.getId())).iterator().hasNext());
		assertTrue(Server.getServerByUser(String.valueOf(florian.getId())).iterator().hasNext());
		assertTrue(Server.getServerByUser(String.valueOf(michael.getId())).iterator().hasNext());
		assertTrue(Server.getServerByUser(String.valueOf(jens.getId())).iterator().hasNext());
	}

}
