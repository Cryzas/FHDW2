package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudentFacade{

	private String schemaName;
	private Connection con;

	public StudentFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudent newStudent(String firstName,String lastName,java.sql.Date birthDate,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntFacade.newStdnt(?,?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, firstName);
            callable.setString(3, lastName);
            callable.setDate(4, birthDate);
            callable.setLong(5, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Student result = new Student(firstName,lastName,birthDate,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentStudent)PersistentProxi.createProxi(id, 195);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentStudent newDelayedStudent(String firstName,String lastName,java.sql.Date birthDate) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntFacade.newDelayedStdnt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Student result = new Student(firstName,lastName,birthDate,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentStudent)PersistentProxi.createProxi(id, 195);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Student getStudent(long StudentId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntFacade.getStdnt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudentId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentProgramStudent program = null;
            if (obj.getLong(5) != 0)
                program = (PersistentProgramStudent)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentStudent This = null;
            if (obj.getLong(7) != 0)
                This = (PersistentStudent)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            Student result = new Student(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                         obj.getString(3) == null ? "" : obj.getString(3) /* In Oracle "" = null !!! */,
                                         obj.getDate(4),
                                         program,
                                         This,
                                         StudentId);
            obj.close();
            callable.close();
            StudentICProxi inCache = (StudentICProxi)Cache.getTheCache().put(result);
            Student objectInCache = (Student)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntFacade.getClass(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void firstNameSet(long StudentId, String firstNameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntFacade.frstNmSet(?, ?); end;");
            callable.setLong(1, StudentId);
            callable.setString(2, firstNameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void lastNameSet(long StudentId, String lastNameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntFacade.lstNmSet(?, ?); end;");
            callable.setLong(1, StudentId);
            callable.setString(2, lastNameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void birthDateSet(long StudentId, java.sql.Date birthDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntFacade.brthDtSet(?, ?); end;");
            callable.setLong(1, StudentId);
            callable.setDate(2, birthDateVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void programSet(long StudentId, ProgramStudent4Public programVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntFacade.prgrmSet(?, ?, ?); end;");
            callable.setLong(1, StudentId);
            callable.setLong(2, programVal.getId());
            callable.setLong(3, programVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long oldProgramsAdd(long StudentId, ProgramStudent4Public oldProgramsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntFacade.oldPrgrmsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, StudentId);
            callable.setLong(3, oldProgramsVal.getId());
            callable.setLong(4, oldProgramsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void oldProgramsRem(long oldProgramsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntFacade.oldPrgrmsRem(?); end;");
            callable.setLong(1, oldProgramsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ProgramStudentList oldProgramsGet(long StudentId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntFacade.oldPrgrmsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudentId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ProgramStudentList result = new ProgramStudentList();
            while (list.next()) {
                result.add((PersistentProgramStudent)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long StudentId, Student4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, StudentId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

