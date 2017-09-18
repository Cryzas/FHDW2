package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class DozentenServiceFacade{

	private String schemaName;
	private Connection con;

	public DozentenServiceFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentDozentenService newDozentenService(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DzntnSrvcFacade.newDzntnSrvc(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DozentenService result = new DozentenService(null,null,null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentDozentenService)PersistentProxi.createProxi(id, -287);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentDozentenService newDelayedDozentenService() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DzntnSrvcFacade.newDelayedDzntnSrvc(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DozentenService result = new DozentenService(null,null,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentDozentenService)PersistentProxi.createProxi(id, -287);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DozentenService getDozentenService(long DozentenServiceId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DzntnSrvcFacade.getDzntnSrvc(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, DozentenServiceId);
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
            PersistentProgramManager programManager = null;
            if (obj.getLong(8) != 0)
                programManager = (PersistentProgramManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentModuleManager moduleManager = null;
            if (obj.getLong(10) != 0)
                moduleManager = (PersistentModuleManager)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            PersistentStudyGroupManager groupManager = null;
            if (obj.getLong(12) != 0)
                groupManager = (PersistentStudyGroupManager)PersistentProxi.createProxi(obj.getLong(12), obj.getLong(13));
            PersistentStudentManager studentManager = null;
            if (obj.getLong(14) != 0)
                studentManager = (PersistentStudentManager)PersistentProxi.createProxi(obj.getLong(14), obj.getLong(15));
            DozentenService result = new DozentenService(parentService,
                                                         subService,
                                                         This,
                                                         programManager,
                                                         moduleManager,
                                                         groupManager,
                                                         studentManager,
                                                         DozentenServiceId);
            obj.close();
            callable.close();
            DozentenServiceICProxi inCache = (DozentenServiceICProxi)Cache.getTheCache().put(result);
            DozentenService objectInCache = (DozentenService)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void programManagerSet(long DozentenServiceId, ProgramManager4Public programManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DzntnSrvcFacade.prgrmMngrSet(?, ?, ?); end;");
            callable.setLong(1, DozentenServiceId);
            callable.setLong(2, programManagerVal.getId());
            callable.setLong(3, programManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleManagerSet(long DozentenServiceId, ModuleManager4Public moduleManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DzntnSrvcFacade.mdlMngrSet(?, ?, ?); end;");
            callable.setLong(1, DozentenServiceId);
            callable.setLong(2, moduleManagerVal.getId());
            callable.setLong(3, moduleManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void groupManagerSet(long DozentenServiceId, StudyGroupManager4Public groupManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DzntnSrvcFacade.grpMngrSet(?, ?, ?); end;");
            callable.setLong(1, DozentenServiceId);
            callable.setLong(2, groupManagerVal.getId());
            callable.setLong(3, groupManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studentManagerSet(long DozentenServiceId, StudentManager4Public studentManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DzntnSrvcFacade.stdntMngrSet(?, ?, ?); end;");
            callable.setLong(1, DozentenServiceId);
            callable.setLong(2, studentManagerVal.getId());
            callable.setLong(3, studentManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

