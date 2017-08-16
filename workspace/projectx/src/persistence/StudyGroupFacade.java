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
            StudyGroup result = new StudyGroup(name,null,null,id);
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
            StudyGroup result = new StudyGroup(name,null,null,id);
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
            PersistentStudyGroup This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentStudyGroup)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            StudyGroup result = new StudyGroup(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                               program,
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

}
