package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudyGroupServiceGroupManagerFacade{

	private String schemaName;
	private Connection con;

	public StudyGroupServiceGroupManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudyGroupServiceGroupManager newStudyGroupServiceGroupManager(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpSrvcGrpMngrFacade.newStdGrpSrvcGrpMngr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudyGroupServiceGroupManager result = new StudyGroupServiceGroupManager(null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentStudyGroupServiceGroupManager)PersistentProxi.createProxi(id, 308);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentStudyGroupServiceGroupManager newDelayedStudyGroupServiceGroupManager() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpSrvcGrpMngrFacade.newDelayedStdGrpSrvcGrpMngr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudyGroupServiceGroupManager result = new StudyGroupServiceGroupManager(null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentStudyGroupServiceGroupManager)PersistentProxi.createProxi(id, 308);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StudyGroupServiceGroupManager getStudyGroupServiceGroupManager(long StudyGroupServiceGroupManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpSrvcGrpMngrFacade.getStdGrpSrvcGrpMngr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyGroupServiceGroupManagerId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentStudyGroupService observer = null;
            if (obj.getLong(2) != 0)
                observer = (PersistentStudyGroupService)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentStudyGroupManager observee = null;
            if (obj.getLong(4) != 0)
                observee = (PersistentStudyGroupManager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentStudyGroupServiceGroupManager This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentStudyGroupServiceGroupManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            StudyGroupServiceGroupManager result = new StudyGroupServiceGroupManager(observer,
                                                                                     observee,
                                                                                     This,
                                                                                     StudyGroupServiceGroupManagerId);
            obj.close();
            callable.close();
            StudyGroupServiceGroupManagerICProxi inCache = (StudyGroupServiceGroupManagerICProxi)Cache.getTheCache().put(result);
            StudyGroupServiceGroupManager objectInCache = (StudyGroupServiceGroupManager)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpSrvcGrpMngrFacade.getClass(?); end;");
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
    public void observerSet(long StudyGroupServiceGroupManagerId, StudyGroupService4Public observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpSrvcGrpMngrFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, StudyGroupServiceGroupManagerId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long StudyGroupServiceGroupManagerId, StudyGroupManager4Public observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpSrvcGrpMngrFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, StudyGroupServiceGroupManagerId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long StudyGroupServiceGroupManagerId, StudyGroupServiceGroupManager4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpSrvcGrpMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, StudyGroupServiceGroupManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

