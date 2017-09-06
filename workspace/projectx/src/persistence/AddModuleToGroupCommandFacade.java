package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AddModuleToGroupCommandFacade{

	private String schemaName;
	private Connection con;

	public AddModuleToGroupCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAddModuleToGroupCommand newAddModuleToGroupCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddMdlTGrpCMDFacade.newAddMdlTGrpCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddModuleToGroupCommand result = new AddModuleToGroupCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAddModuleToGroupCommand)PersistentProxi.createProxi(id, 169);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAddModuleToGroupCommand newDelayedAddModuleToGroupCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddMdlTGrpCMDFacade.newDelayedAddMdlTGrpCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddModuleToGroupCommand result = new AddModuleToGroupCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAddModuleToGroupCommand)PersistentProxi.createProxi(id, 169);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddModuleToGroupCommand getAddModuleToGroupCommand(long AddModuleToGroupCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddMdlTGrpCMDFacade.getAddMdlTGrpCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AddModuleToGroupCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentModuleGroup group = null;
            if (obj.getLong(2) != 0)
                group = (PersistentModuleGroup)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentModuleAbstract module = null;
            if (obj.getLong(4) != 0)
                module = (PersistentModuleAbstract)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentModuleManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentModuleManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            AddModuleToGroupCommand result = new AddModuleToGroupCommand(group,
                                                                         module,
                                                                         invoker,
                                                                         commandReceiver,
                                                                         myCommonDate,
                                                                         AddModuleToGroupCommandId);
            obj.close();
            callable.close();
            AddModuleToGroupCommandICProxi inCache = (AddModuleToGroupCommandICProxi)Cache.getTheCache().put(result);
            AddModuleToGroupCommand objectInCache = (AddModuleToGroupCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddMdlTGrpCMDFacade.getClass(?); end;");
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
    public void groupSet(long AddModuleToGroupCommandId, ModuleGroup4Public groupVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMdlTGrpCMDFacade.grpSet(?, ?, ?); end;");
            callable.setLong(1, AddModuleToGroupCommandId);
            callable.setLong(2, groupVal.getId());
            callable.setLong(3, groupVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleSet(long AddModuleToGroupCommandId, ModuleAbstract4Public moduleVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMdlTGrpCMDFacade.mdlSet(?, ?, ?); end;");
            callable.setLong(1, AddModuleToGroupCommandId);
            callable.setLong(2, moduleVal.getId());
            callable.setLong(3, moduleVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddModuleToGroupCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMdlTGrpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddModuleToGroupCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddModuleToGroupCommandId, ModuleManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMdlTGrpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddModuleToGroupCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddModuleToGroupCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddMdlTGrpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddModuleToGroupCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

