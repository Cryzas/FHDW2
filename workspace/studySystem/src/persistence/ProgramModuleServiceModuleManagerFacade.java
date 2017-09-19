package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ProgramModuleServiceModuleManagerFacade{

	private String schemaName;
	private Connection con;

	public ProgramModuleServiceModuleManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentProgramModuleServiceModuleManager newProgramModuleServiceModuleManager(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PMServiceMdlMngrFacade.newPMServiceMdlMngr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ProgramModuleServiceModuleManager result = new ProgramModuleServiceModuleManager(null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentProgramModuleServiceModuleManager)PersistentProxi.createProxi(id, 310);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentProgramModuleServiceModuleManager newDelayedProgramModuleServiceModuleManager() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PMServiceMdlMngrFacade.newDelayedPMServiceMdlMngr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ProgramModuleServiceModuleManager result = new ProgramModuleServiceModuleManager(null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentProgramModuleServiceModuleManager)PersistentProxi.createProxi(id, 310);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ProgramModuleServiceModuleManager getProgramModuleServiceModuleManager(long ProgramModuleServiceModuleManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PMServiceMdlMngrFacade.getPMServiceMdlMngr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ProgramModuleServiceModuleManagerId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentProgramModuleService observer = null;
            if (obj.getLong(2) != 0)
                observer = (PersistentProgramModuleService)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentModuleManager observee = null;
            if (obj.getLong(4) != 0)
                observee = (PersistentModuleManager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentProgramModuleServiceModuleManager This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentProgramModuleServiceModuleManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            ProgramModuleServiceModuleManager result = new ProgramModuleServiceModuleManager(observer,
                                                                                             observee,
                                                                                             This,
                                                                                             ProgramModuleServiceModuleManagerId);
            obj.close();
            callable.close();
            ProgramModuleServiceModuleManagerICProxi inCache = (ProgramModuleServiceModuleManagerICProxi)Cache.getTheCache().put(result);
            ProgramModuleServiceModuleManager objectInCache = (ProgramModuleServiceModuleManager)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PMServiceMdlMngrFacade.getClass(?); end;");
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
    public void observerSet(long ProgramModuleServiceModuleManagerId, ProgramModuleService4Public observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PMServiceMdlMngrFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, ProgramModuleServiceModuleManagerId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long ProgramModuleServiceModuleManagerId, ModuleManager4Public observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PMServiceMdlMngrFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, ProgramModuleServiceModuleManagerId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ProgramModuleServiceModuleManagerId, ProgramModuleServiceModuleManager4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PMServiceMdlMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ProgramModuleServiceModuleManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

