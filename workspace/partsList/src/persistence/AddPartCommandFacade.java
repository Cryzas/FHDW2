package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AddPartCommandFacade{

	private String schemaName;
	private Connection con;

	public AddPartCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAddPartCommand newAddPartCommand(long quantity,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddPrtCMDFacade.newAddPrtCMD(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, quantity);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddPartCommand result = new AddPartCommand(null,quantity,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAddPartCommand)PersistentProxi.createProxi(id, 120);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAddPartCommand newDelayedAddPartCommand(long quantity) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddPrtCMDFacade.newDelayedAddPrtCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddPartCommand result = new AddPartCommand(null,quantity,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAddPartCommand)PersistentProxi.createProxi(id, 120);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddPartCommand getAddPartCommand(long AddPartCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddPrtCMDFacade.getAddPrtCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AddPartCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentComponent component = null;
            if (obj.getLong(2) != 0)
                component = (PersistentComponent)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(5) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentProduct commandReceiver = null;
            if (obj.getLong(7) != 0)
                commandReceiver = (PersistentProduct)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(9) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            AddPartCommand result = new AddPartCommand(component,
                                                       obj.getLong(4),
                                                       invoker,
                                                       commandReceiver,
                                                       myCommonDate,
                                                       AddPartCommandId);
            obj.close();
            callable.close();
            AddPartCommandICProxi inCache = (AddPartCommandICProxi)Cache.getTheCache().put(result);
            AddPartCommand objectInCache = (AddPartCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddPrtCMDFacade.getClass(?); end;");
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
    public void componentSet(long AddPartCommandId, Component4Public componentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddPrtCMDFacade.cmpnntSet(?, ?, ?); end;");
            callable.setLong(1, AddPartCommandId);
            callable.setLong(2, componentVal.getId());
            callable.setLong(3, componentVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void quantitySet(long AddPartCommandId, long quantityVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddPrtCMDFacade.qnttSet(?, ?); end;");
            callable.setLong(1, AddPartCommandId);
            callable.setLong(2, quantityVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddPartCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddPrtCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddPartCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddPartCommandId, Product4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddPrtCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddPartCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddPartCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddPrtCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddPartCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

