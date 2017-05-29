package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class DeleteCommandFacade{

	private String schemaName;
	private Connection con;

	public DeleteCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentDeleteCommand newDeleteCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DltCMDFacade.newDltCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DeleteCommand result = new DeleteCommand(null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentDeleteCommand)PersistentProxi.createProxi(id, 125);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentDeleteCommand newDelayedDeleteCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DltCMDFacade.newDelayedDltCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DeleteCommand result = new DeleteCommand(null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentDeleteCommand)PersistentProxi.createProxi(id, 125);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DeleteCommand getDeleteCommand(long DeleteCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DltCMDFacade.getDltCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, DeleteCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            Invoker invoker = null;
            if (obj.getLong(2) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentContainee commandReceiver = null;
            if (obj.getLong(4) != 0)
                commandReceiver = (PersistentContainee)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(6) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            DeleteCommand result = new DeleteCommand(invoker,
                                                     commandReceiver,
                                                     myCommonDate,
                                                     DeleteCommandId);
            obj.close();
            callable.close();
            DeleteCommandICProxi inCache = (DeleteCommandICProxi)Cache.getTheCache().put(result);
            DeleteCommand objectInCache = (DeleteCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DltCMDFacade.getClass(?); end;");
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
    public void invokerSet(long DeleteCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DltCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, DeleteCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long DeleteCommandId, Containee4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DltCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, DeleteCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long DeleteCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DltCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, DeleteCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

