package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AccountManagerFacade{

	private String schemaName;
	private Connection con;

	public AccountManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAccountManager newAccountManager(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntMngrFacade.newAccntMngr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountManager result = new AccountManager(null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAccountManager)PersistentProxi.createProxi(id, 122);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAccountManager newDelayedAccountManager() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntMngrFacade.newDelayedAccntMngr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountManager result = new AccountManager(null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAccountManager)PersistentProxi.createProxi(id, 122);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountManager getAccountManager(long AccountManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntMngrFacade.getAccntMngr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AccountManagerId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAccountManager This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentAccountManager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            AccountManager result = new AccountManager(subService,
                                                       This,
                                                       AccountManagerId);
            obj.close();
            callable.close();
            AccountManagerICProxi inCache = (AccountManagerICProxi)Cache.getTheCache().put(result);
            AccountManager objectInCache = (AccountManager)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntMngrFacade.getClass(?); end;");
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
    public long currentAccountsAdd(long AccountManagerId, AccountHandle4Public currentAccountsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntMngrFacade.crrntAccntsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, AccountManagerId);
            callable.setLong(3, currentAccountsVal.getId());
            callable.setLong(4, currentAccountsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void currentAccountsRem(long currentAccountsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntMngrFacade.crrntAccntsRem(?); end;");
            callable.setLong(1, currentAccountsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AccountHandleList currentAccountsGet(long AccountManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntMngrFacade.crrntAccntsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AccountManagerId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            AccountHandleList result = new AccountHandleList();
            while (list.next()) {
                result.add((PersistentAccountHandle)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long AccountManagerId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntMngrFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, AccountManagerId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountManagerId, AccountManager4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

