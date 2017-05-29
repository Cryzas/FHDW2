package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class DirectoryFacade{

	private String schemaName;
	private Connection con;

	public DirectoryFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentDirectory newDirectory(String name,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DrctrFacade.newDrctr(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Directory result = new Directory(name,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentDirectory)PersistentProxi.createProxi(id, 117);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentDirectory newDelayedDirectory(String name) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DrctrFacade.newDelayedDrctr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Directory result = new Directory(name,null,id);
            Cache.getTheCache().put(result);
            return (PersistentDirectory)PersistentProxi.createProxi(id, 117);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Directory getDirectory(long DirectoryId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DrctrFacade.getDrctr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, DirectoryId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentContainee This = null;
            if (obj.getLong(3) != 0)
                This = (PersistentContainee)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            Directory result = new Directory(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                             This,
                                             DirectoryId);
            obj.close();
            callable.close();
            DirectoryICProxi inCache = (DirectoryICProxi)Cache.getTheCache().put(result);
            Directory objectInCache = (Directory)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentContainee contentsAdd(long DirectoryId, String indxxVal, Containee4Public contentsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DrctrFacade.cntntsAdd(?, ?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, DirectoryId);
            callable.setString(3, indxxVal);
            callable.setLong(4, contentsVal.getId());
            callable.setLong(5, contentsVal.getClassId());
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PersistentContainee result = null;
            if (list.next()) result = (PersistentContainee)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentContainee contentsRem(long DirectoryId, String indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DrctrFacade.cntntsRem(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, DirectoryId);
            callable.setString(3, indxxVal);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PersistentContainee result = null;
            if (list.next()) result = (PersistentContainee)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void contentsRemEntr(long contentsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DrctrFacade.cntntsRemEntr(?); end;");
            callable.setLong(1, contentsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentContainee contentsGet(long DirectoryId, String indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DrctrFacade.cntntsGet(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, DirectoryId);
            callable.setString(3, indxxVal);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            PersistentContainee result = null;
            if (list.next()) result = (PersistentContainee)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public java.util.Hashtable<String,Containee4Public> contentsGetValues(long DirectoryId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DrctrFacade.cntntsGetValues(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, DirectoryId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            java.util.Hashtable<String,Containee4Public> result = new java.util.Hashtable<String,Containee4Public>();
            while (list.next()) {
                Containee4Public value = (Containee4Public)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
                String key = list.getString(4);
                result.put(key,value);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DirectorySearchList inverseGetContents(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DrctrFacade.iGetCntnts(?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            DirectorySearchList result = new DirectorySearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentDirectory)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentDirectory)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

