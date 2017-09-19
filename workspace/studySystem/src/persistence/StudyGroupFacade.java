package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudyGroupFacade{

	private String schemaName;
	private Connection con;

	public StudyGroupFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudyGroup newStudyGroup(String name,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.newStdGrp(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudyGroup result = new StudyGroup(name,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentStudyGroup)PersistentProxi.createProxi(id, 180);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentStudyGroup newDelayedStudyGroup(String name) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.newDelayedStdGrp(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudyGroup result = new StudyGroup(name,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentStudyGroup)PersistentProxi.createProxi(id, 180);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StudyGroup getStudyGroup(long StudyGroupId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.getStdGrp(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyGroupId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentProgramSGroup program = null;
            if (obj.getLong(3) != 0)
                program = (PersistentProgramSGroup)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentMyBoolean finished = null;
            if (obj.getLong(5) != 0)
                finished = (PersistentMyBoolean)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            SubjInterface subService = null;
            if (obj.getLong(7) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentStudyGroup This = null;
            if (obj.getLong(9) != 0)
                This = (PersistentStudyGroup)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            StudyGroup result = new StudyGroup(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                               program,
                                               finished,
                                               subService,
                                               This,
                                               StudyGroupId);
            obj.close();
            callable.close();
            StudyGroupICProxi inCache = (StudyGroupICProxi)Cache.getTheCache().put(result);
            StudyGroup objectInCache = (StudyGroup)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.getClass(?); end;");
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
    public StudyGroupSearchList getStudyGroupByName(String name) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.getStdGrpByNm(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setString(2, name);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            StudyGroupSearchList result = new StudyGroupSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                PersistentStudyGroup proxi = (PersistentStudyGroup)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long StudyGroupId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpFacade.nmSet(?, ?); end;");
            callable.setLong(1, StudyGroupId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void programSet(long StudyGroupId, ProgramSGroup4Public programVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpFacade.prgrmSet(?, ?, ?); end;");
            callable.setLong(1, StudyGroupId);
            callable.setLong(2, programVal.getId());
            callable.setLong(3, programVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long studentsAdd(long StudyGroupId, Student4Public studentsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.stdntsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, StudyGroupId);
            callable.setLong(3, studentsVal.getId());
            callable.setLong(4, studentsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studentsRem(long studentsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpFacade.stdntsRem(?); end;");
            callable.setLong(1, studentsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public StudentList studentsGet(long StudyGroupId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.stdntsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyGroupId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            StudentList result = new StudentList();
            while (list.next()) {
                result.add((PersistentStudent)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void finishedSet(long StudyGroupId, MyBoolean4Public finishedVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpFacade.fnshdSet(?, ?, ?); end;");
            callable.setLong(1, StudyGroupId);
            callable.setLong(2, finishedVal.getId());
            callable.setLong(3, finishedVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long StudyGroupId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, StudyGroupId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long StudyGroupId, StudyGroup4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, StudyGroupId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public StudyGroupSearchList inverseGetStudents(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpFacade.iGetStdnts(?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            StudyGroupSearchList result = new StudyGroupSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentStudyGroup)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentStudyGroup)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

