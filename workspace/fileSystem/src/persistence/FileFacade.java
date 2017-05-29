package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class FileFacade{

	private String schemaName;
	private Connection con;

	public FileFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentFile newFile(String name,String contents,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FlFacade.newFl(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setStringForClob(3, contents);
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            File result = new File(name,null,contents,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentFile)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentFile newDelayedFile(String name,String contents) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FlFacade.newDelayedFl(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            File result = new File(name,null,contents,id);
            Cache.getTheCache().put(result);
            return (PersistentFile)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public File getFile(long FileId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FlFacade.getFl(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, FileId);
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
            File result = new File(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                   This,
                                   obj.getString(5) == null ? "" : obj.getString(5) /* In Oracle "" = null !!! */,
                                   FileId);
            obj.close();
            callable.close();
            FileICProxi inCache = (FileICProxi)Cache.getTheCache().put(result);
            File objectInCache = (File)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void contentsSet(long FileId, String contentsVal) throws PersistenceException {
        try{
            oracle.jdbc.OracleCallableStatement callable;
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin " + this.schemaName + ".FlFacade.cntntsSet(?, ?); end;");
            callable.setLong(1, FileId);
            callable.setStringForClob(2, contentsVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

