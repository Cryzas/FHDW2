package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class PartsListManagerFacade{

	private String schemaName;
	private Connection con;

	public PartsListManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentPartsListManager newPartsListManager(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrtsLstMngrFacade.newPrtsLstMngr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            PartsListManager result = new PartsListManager(null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentPartsListManager)PersistentProxi.createProxi(id, 124);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentPartsListManager newDelayedPartsListManager() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrtsLstMngrFacade.newDelayedPrtsLstMngr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            PartsListManager result = new PartsListManager(null,id);
            Cache.getTheCache().put(result);
            return (PersistentPartsListManager)PersistentProxi.createProxi(id, 124);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PartsListManager getPartsListManager(long PartsListManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrtsLstMngrFacade.getPrtsLstMngr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, PartsListManagerId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentPartsListManager This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentPartsListManager)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PartsListManager result = new PartsListManager(This,
                                                           PartsListManagerId);
            obj.close();
            callable.close();
            PartsListManagerICProxi inCache = (PartsListManagerICProxi)Cache.getTheCache().put(result);
            PartsListManager objectInCache = (PartsListManager)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrtsLstMngrFacade.getClass(?); end;");
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
    public PersistentComponent currentComponentsAdd(long PartsListManagerId, String indxxVal, Component4Public currentComponentsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrtsLstMngrFacade.currCompsAdd(?, ?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, PartsListManagerId);
            callable.setString(3, indxxVal);
            callable.setLong(4, currentComponentsVal.getId());
            callable.setLong(5, currentComponentsVal.getClassId());
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PersistentComponent result = null;
            if (list.next()) result = (PersistentComponent)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentComponent currentComponentsRem(long PartsListManagerId, String indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrtsLstMngrFacade.currCompsRem(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, PartsListManagerId);
            callable.setString(3, indxxVal);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PersistentComponent result = null;
            if (list.next()) result = (PersistentComponent)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentComponent currentComponentsGet(long PartsListManagerId, String indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrtsLstMngrFacade.currCompsGet(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, PartsListManagerId);
            callable.setString(3, indxxVal);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PersistentComponent result = null;
            if (list.next()) result = (PersistentComponent)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ComponentSearchList currentComponentsGetValues(long PartsListManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrtsLstMngrFacade.currCompsGetValues(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, PartsListManagerId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ComponentSearchList result = new ComponentSearchList();
            while (list.next()) {
                result.add((PersistentComponent)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long PartsListManagerId, PartsListManager4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrtsLstMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, PartsListManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

