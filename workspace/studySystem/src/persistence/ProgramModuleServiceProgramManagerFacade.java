package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ProgramModuleServiceProgramManagerFacade{

	private String schemaName;
	private Connection con;

	public ProgramModuleServiceProgramManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentProgramModuleServiceProgramManager newProgramModuleServiceProgramManager(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PMServicePrgrmMngrFacade.newPMServicePrgrmMngr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ProgramModuleServiceProgramManager result = new ProgramModuleServiceProgramManager(null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentProgramModuleServiceProgramManager)PersistentProxi.createProxi(id, 309);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentProgramModuleServiceProgramManager newDelayedProgramModuleServiceProgramManager() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PMServicePrgrmMngrFacade.newDelayedPMServicePrgrmMngr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ProgramModuleServiceProgramManager result = new ProgramModuleServiceProgramManager(null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentProgramModuleServiceProgramManager)PersistentProxi.createProxi(id, 309);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ProgramModuleServiceProgramManager getProgramModuleServiceProgramManager(long ProgramModuleServiceProgramManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PMServicePrgrmMngrFacade.getPMServicePrgrmMngr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ProgramModuleServiceProgramManagerId);
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
            PersistentProgramManager observee = null;
            if (obj.getLong(4) != 0)
                observee = (PersistentProgramManager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentProgramModuleServiceProgramManager This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentProgramModuleServiceProgramManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            ProgramModuleServiceProgramManager result = new ProgramModuleServiceProgramManager(observer,
                                                                                               observee,
                                                                                               This,
                                                                                               ProgramModuleServiceProgramManagerId);
            obj.close();
            callable.close();
            ProgramModuleServiceProgramManagerICProxi inCache = (ProgramModuleServiceProgramManagerICProxi)Cache.getTheCache().put(result);
            ProgramModuleServiceProgramManager objectInCache = (ProgramModuleServiceProgramManager)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PMServicePrgrmMngrFacade.getClass(?); end;");
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
    public void observerSet(long ProgramModuleServiceProgramManagerId, ProgramModuleService4Public observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PMServicePrgrmMngrFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, ProgramModuleServiceProgramManagerId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long ProgramModuleServiceProgramManagerId, ProgramManager4Public observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PMServicePrgrmMngrFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, ProgramModuleServiceProgramManagerId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ProgramModuleServiceProgramManagerId, ProgramModuleServiceProgramManager4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PMServicePrgrmMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ProgramModuleServiceProgramManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

