package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AccountFacade{

	private String schemaName;
	private Connection con;

	public AccountFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAccount newAccount(String name,common.Fraction balance,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.newAccnt(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, balance.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Account result = new Account(null,null,name,balance,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAccount)PersistentProxi.createProxi(id, 115);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAccount newDelayedAccount(String name,common.Fraction balance) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.newDelayedAccnt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Account result = new Account(null,null,name,balance,id);
            Cache.getTheCache().put(result);
            return (PersistentAccount)PersistentProxi.createProxi(id, 115);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Account getAccount(long AccountId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.getAccnt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AccountId);
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
            PersistentAccountHandle This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentAccountHandle)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Account result = new Account(subService,
                                         This,
                                         obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                         (obj.getString(7) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(7))),
                                         AccountId);
            obj.close();
            callable.close();
            AccountICProxi inCache = (AccountICProxi)Cache.getTheCache().put(result);
            Account objectInCache = (Account)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AccountSearchList getAccountByName(String name) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.getAccntByNm(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setString(2, name);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            AccountSearchList result = new AccountSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                PersistentAccount proxi = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long AccountId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.nmSet(?, ?); end;");
            callable.setLong(1, AccountId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void balanceSet(long AccountId, common.Fraction balanceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.blncSet(?, ?); end;");
            callable.setLong(1, AccountId);
            callable.setString(2, balanceVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long entriesAdd(long AccountId, Entry4Public entriesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.entrsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, AccountId);
            callable.setLong(3, entriesVal.getId());
            callable.setLong(4, entriesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void entriesRem(long entriesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.entrsRem(?); end;");
            callable.setLong(1, entriesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public EntryList entriesGet(long AccountId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.entrsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AccountId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            EntryList result = new EntryList();
            while (list.next()) {
                result.add((PersistentEntry)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

