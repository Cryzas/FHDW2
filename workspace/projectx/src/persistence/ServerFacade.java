package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ServerFacade{

	private String schemaName;
	private Connection con;

	public ServerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentServer newServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvrFacade.newSrvr(?,?,?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, password);
            callable.setString(3, user);
            callable.setLong(4, hackCount);
            callable.setTimestamp(5, hackDelay);
            callable.setLong(6, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Server result = new Server(null,null,null,password,user,hackCount,hackDelay,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentServer)PersistentProxi.createProxi(id, -102);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentServer newDelayedServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvrFacade.newDelayedSrvr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Server result = new Server(null,null,null,password,user,hackCount,hackDelay,id);
            Cache.getTheCache().put(result);
            return (PersistentServer)PersistentProxi.createProxi(id, -102);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Server getServer(long ServerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvrFacade.getSrvr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ServerId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentProgramManager programManager = null;
            if (obj.getLong(2) != 0)
                programManager = (PersistentProgramManager)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentModuleManager moduleManager = null;
            if (obj.getLong(4) != 0)
                moduleManager = (PersistentModuleManager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentServer This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentServer)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            Server result = new Server(programManager,
                                       moduleManager,
                                       This,
                                       obj.getString(8) == null ? "" : obj.getString(8) /* In Oracle "" = null !!! */,
                                       obj.getString(9) == null ? "" : obj.getString(9) /* In Oracle "" = null !!! */,
                                       obj.getLong(10),
                                       obj.getTimestamp(11),
                                       ServerId);
            obj.close();
            callable.close();
            ServerICProxi inCache = (ServerICProxi)Cache.getTheCache().put(result);
            Server objectInCache = (Server)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvrFacade.getClass(?); end;");
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
    public ServerSearchList getServerByUser(String user) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvrFacade.getSrvrByUser(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setString(2, user);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            ServerSearchList result = new ServerSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                PersistentServer proxi = (PersistentServer)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void programManagerSet(long ServerId, ProgramManager4Public programManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.prgrmMngrSet(?, ?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setLong(2, programManagerVal.getId());
            callable.setLong(3, programManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moduleManagerSet(long ServerId, ModuleManager4Public moduleManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.mdlMngrSet(?, ?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setLong(2, moduleManagerVal.getId());
            callable.setLong(3, moduleManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ServerId, Server4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void passwordSet(long ServerId, String passwordVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.passwordSet(?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setString(2, passwordVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void userSet(long ServerId, String userVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.userSet(?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setString(2, userVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void hackCountSet(long ServerId, long hackCountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.hackCountSet(?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setLong(2, hackCountVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void hackDelaySet(long ServerId, java.sql.Timestamp hackDelayVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.hackDelaySet(?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setTimestamp(2, hackDelayVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

