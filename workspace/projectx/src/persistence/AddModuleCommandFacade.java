package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AddModuleCommandFacade{

	private String schemaName;
	private Connection con;

	public AddModuleCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAddModuleCommand newAddModuleCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddMdlCMDFacade.newAddMdlCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddModuleCommand result = new AddModuleCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAddModuleCommand)PersistentProxi.createProxi(id, 160);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAddModuleCommand newDelayedAddModuleCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddMdlCMDFacade.newDelayedAddMdlCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddModuleCommand result = new AddModuleCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAddModuleCommand)PersistentProxi.createProxi(id, 160);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddModuleCommand getAddModuleCommand(long AddModuleCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddMdlCMDFacade.getAddMdlCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AddModuleCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentProgram program = null;
            if (obj.getLong(2) != 0)
                program = (PersistentProgram)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentModuleAbstract module = null;
            if (obj.getLong(4) != 0)
                module = (PersistentModuleAbstract)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentProgramManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentProgramManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            AddModuleCommand result = new AddModuleCommand(program,
                                                           module,
                                                           invoker,
                                                           commandReceiver,
                                                           myCommonDate,
                                                           AddModuleCommandId);
            obj.close();
            callable.close();
            AddModuleCommandICProxi inCache = (AddModuleCommandICProxi)Cache.getTheCache().put(result);
            AddModuleCommand objectInCache = (AddModuleCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddMdlCMDFacade.getClass(?); end;");
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
    public void programSet(long AddModuleCommandId, Program4Public programVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMdlCMDFacade.prgrmSet(?, ?, ?); end;");
            callable.setLong(1, AddModuleCommandId);
            callable.setLong(2, programVal.getId());
            callable.setLong(3, programVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleSet(long AddModuleCommandId, ModuleAbstract4Public moduleVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMdlCMDFacade.mdlSet(?, ?, ?); end;");
            callable.setLong(1, AddModuleCommandId);
            callable.setLong(2, moduleVal.getId());
            callable.setLong(3, moduleVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddModuleCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMdlCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddModuleCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddModuleCommandId, ProgramManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMdlCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddModuleCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddModuleCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMdlCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddModuleCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

