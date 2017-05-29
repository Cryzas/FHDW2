package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ChangeContentsCommandFacade{

	private String schemaName;
	private Connection con;

	public ChangeContentsCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentChangeContentsCommand newChangeContentsCommand(String newContents,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngCntntsCMDFacade.newChngCntntsCMD(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setStringForClob(2, newContents);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeContentsCommand result = new ChangeContentsCommand(newContents,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentChangeContentsCommand)PersistentProxi.createProxi(id, 121);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentChangeContentsCommand newDelayedChangeContentsCommand(String newContents) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngCntntsCMDFacade.newDelayedChngCntntsCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeContentsCommand result = new ChangeContentsCommand(newContents,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentChangeContentsCommand)PersistentProxi.createProxi(id, 121);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeContentsCommand getChangeContentsCommand(long ChangeContentsCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngCntntsCMDFacade.getChngCntntsCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ChangeContentsCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            Invoker invoker = null;
            if (obj.getLong(3) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentFile commandReceiver = null;
            if (obj.getLong(5) != 0)
                commandReceiver = (PersistentFile)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(7) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            ChangeContentsCommand result = new ChangeContentsCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                     invoker,
                                                                     commandReceiver,
                                                                     myCommonDate,
                                                                     ChangeContentsCommandId);
            obj.close();
            callable.close();
            ChangeContentsCommandICProxi inCache = (ChangeContentsCommandICProxi)Cache.getTheCache().put(result);
            ChangeContentsCommand objectInCache = (ChangeContentsCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngCntntsCMDFacade.getClass(?); end;");
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
    public void newContentsSet(long ChangeContentsCommandId, String newContentsVal) throws PersistenceException {
        try{
            oracle.jdbc.OracleCallableStatement callable;
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin " + this.schemaName + ".ChngCntntsCMDFacade.nwCntntsSet(?, ?); end;");
            callable.setLong(1, ChangeContentsCommandId);
            callable.setStringForClob(2, newContentsVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ChangeContentsCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngCntntsCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ChangeContentsCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ChangeContentsCommandId, File4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngCntntsCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ChangeContentsCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ChangeContentsCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngCntntsCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ChangeContentsCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

