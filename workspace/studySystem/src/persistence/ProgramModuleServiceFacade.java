package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ProgramModuleServiceFacade{

	private String schemaName;
	private Connection con;

	public ProgramModuleServiceFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentProgramModuleService newProgramModuleService(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PMServiceFacade.newPMService(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ProgramModuleService result = new ProgramModuleService(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentProgramModuleService)PersistentProxi.createProxi(id, -305);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentProgramModuleService newDelayedProgramModuleService() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PMServiceFacade.newDelayedPMService(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ProgramModuleService result = new ProgramModuleService(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentProgramModuleService)PersistentProxi.createProxi(id, -305);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ProgramModuleService getProgramModuleService(long ProgramModuleServiceId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PMServiceFacade.getPMService(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ProgramModuleServiceId);
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
            PersistentProgramModuleServiceProgramManager programManager = null;
            if (obj.getLong(8) != 0)
                programManager = (PersistentProgramModuleServiceProgramManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentProgramModuleServiceModuleManager moduleManager = null;
            if (obj.getLong(10) != 0)
                moduleManager = (PersistentProgramModuleServiceModuleManager)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            ProgramModuleService result = new ProgramModuleService(parentService,
                                                                   subService,
                                                                   This,
                                                                   programManager,
                                                                   moduleManager,
                                                                   ProgramModuleServiceId);
            obj.close();
            callable.close();
            ProgramModuleServiceICProxi inCache = (ProgramModuleServiceICProxi)Cache.getTheCache().put(result);
            ProgramModuleService objectInCache = (ProgramModuleService)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void programManagerSet(long ProgramModuleServiceId, ProgramModuleServiceProgramManager4Public programManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PMServiceFacade.prgrmMngrSet(?, ?, ?); end;");
            callable.setLong(1, ProgramModuleServiceId);
            callable.setLong(2, programManagerVal.getId());
            callable.setLong(3, programManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleManagerSet(long ProgramModuleServiceId, ProgramModuleServiceModuleManager4Public moduleManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PMServiceFacade.mdlMngrSet(?, ?, ?); end;");
            callable.setLong(1, ProgramModuleServiceId);
            callable.setLong(2, moduleManagerVal.getId());
            callable.setLong(3, moduleManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

