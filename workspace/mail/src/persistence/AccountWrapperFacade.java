package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AccountWrapperFacade{

	private String schemaName;
	private Connection con;

	public AccountWrapperFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAccountWrapper newAccountWrapper(String name,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntWrpprFacade.newAccntWrppr(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountWrapper result = new AccountWrapper(name,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAccountWrapper)PersistentProxi.createProxi(id, 139);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAccountWrapper newDelayedAccountWrapper(String name) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntWrpprFacade.newDelayedAccntWrppr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountWrapper result = new AccountWrapper(name,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAccountWrapper)PersistentProxi.createProxi(id, 139);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountWrapper getAccountWrapper(long AccountWrapperId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntWrpprFacade.getAccntWrppr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AccountWrapperId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentabstractAcc This = null;
            if (obj.getLong(3) != 0)
                This = (PersistentabstractAcc)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentAccount wrapped = null;
            if (obj.getLong(5) != 0)
                wrapped = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            AccountWrapper result = new AccountWrapper(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                       This,
                                                       wrapped,
                                                       AccountWrapperId);
            obj.close();
            callable.close();
            AccountWrapperICProxi inCache = (AccountWrapperICProxi)Cache.getTheCache().put(result);
            AccountWrapper objectInCache = (AccountWrapper)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void wrappedSet(long AccountWrapperId, Account4Public wrappedVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntWrpprFacade.wrppdSet(?, ?, ?); end;");
            callable.setLong(1, AccountWrapperId);
            callable.setLong(2, wrappedVal.getId());
            callable.setLong(3, wrappedVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

