package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class UserManagerServiceFacade{

	private String schemaName;
	private Connection con;

	public UserManagerServiceFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentUserManagerService newUserManagerService(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UsrMngrSrvcFacade.newUsrMngrSrvc(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            UserManagerService result = new UserManagerService(null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentUserManagerService)PersistentProxi.createProxi(id, -290);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentUserManagerService newDelayedUserManagerService() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UsrMngrSrvcFacade.newDelayedUsrMngrSrvc(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            UserManagerService result = new UserManagerService(null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentUserManagerService)PersistentProxi.createProxi(id, -290);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public UserManagerService getUserManagerService(long UserManagerServiceId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UsrMngrSrvcFacade.getUsrMngrSrvc(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, UserManagerServiceId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAdminService parentService = null;
            if (obj.getLong(2) != 0)
                parentService = (PersistentAdminService)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            SubjInterface subService = null;
            if (obj.getLong(4) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentsubAdminService This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentsubAdminService)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            UserManagerService result = new UserManagerService(parentService,
                                                               subService,
                                                               This,
                                                               UserManagerServiceId);
            obj.close();
            callable.close();
            UserManagerServiceICProxi inCache = (UserManagerServiceICProxi)Cache.getTheCache().put(result);
            UserManagerService objectInCache = (UserManagerService)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long usersAdd(long UserManagerServiceId, Server4Public usersVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UsrMngrSrvcFacade.usrsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, UserManagerServiceId);
            callable.setLong(3, usersVal.getId());
            callable.setLong(4, usersVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void usersRem(long usersId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UsrMngrSrvcFacade.usrsRem(?); end;");
            callable.setLong(1, usersId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ServerList usersGet(long UserManagerServiceId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UsrMngrSrvcFacade.usrsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, UserManagerServiceId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ServerList result = new ServerList();
            while (list.next()) {
                result.add((PersistentServer)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

