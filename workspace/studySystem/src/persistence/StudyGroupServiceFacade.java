package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudyGroupServiceFacade{

	private String schemaName;
	private Connection con;

	public StudyGroupServiceFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudyGroupService newStudyGroupService(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpSrvcFacade.newStdGrpSrvc(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudyGroupService result = new StudyGroupService(null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentStudyGroupService)PersistentProxi.createProxi(id, -302);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentStudyGroupService newDelayedStudyGroupService() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpSrvcFacade.newDelayedStdGrpSrvc(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudyGroupService result = new StudyGroupService(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentStudyGroupService)PersistentProxi.createProxi(id, -302);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StudyGroupService getStudyGroupService(long StudyGroupServiceId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdGrpSrvcFacade.getStdGrpSrvc(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudyGroupServiceId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAdminService parentService = null;
            if (obj.getLong(2) != 0)
                parentService = (PersistentAdminService)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            SubjInterface subService = null;
            if (obj.getLong(4) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentsubAdminService This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentsubAdminService)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentStudyGroupServiceGroupManager groupManager = null;
            if (obj.getLong(8) != 0)
                groupManager = (PersistentStudyGroupServiceGroupManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            StudyGroupService result = new StudyGroupService(parentService,
                                                             subService,
                                                             This,
                                                             groupManager,
                                                             StudyGroupServiceId);
            obj.close();
            callable.close();
            StudyGroupServiceICProxi inCache = (StudyGroupServiceICProxi)Cache.getTheCache().put(result);
            StudyGroupService objectInCache = (StudyGroupService)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void groupManagerSet(long StudyGroupServiceId, StudyGroupServiceGroupManager4Public groupManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StdGrpSrvcFacade.grpMngrSet(?, ?, ?); end;");
            callable.setLong(1, StudyGroupServiceId);
            callable.setLong(2, groupManagerVal.getId());
            callable.setLong(3, groupManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

