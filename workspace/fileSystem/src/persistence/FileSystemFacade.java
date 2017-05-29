package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class FileSystemFacade{

	private String schemaName;
	private Connection con;

	public FileSystemFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentFileSystem getTheFileSystem() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FlSstmFacade.getTheFlSstm; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentFileSystem)PersistentProxi.createProxi(id, 114);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FileSystem getFileSystem(long FileSystemId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FlSstmFacade.getFlSstm(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, FileSystemId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentDirectory systemRoot = null;
            if (obj.getLong(2) != 0)
                systemRoot = (PersistentDirectory)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentClipBoard clipBoard = null;
            if (obj.getLong(4) != 0)
                clipBoard = (PersistentClipBoard)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentFileSystem This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentFileSystem)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            FileSystem result = new FileSystem(systemRoot,
                                               clipBoard,
                                               This,
                                               FileSystemId);
            obj.close();
            callable.close();
            FileSystemICProxi inCache = (FileSystemICProxi)Cache.getTheCache().put(result);
            FileSystem objectInCache = (FileSystem)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FlSstmFacade.getClass(?); end;");
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
    public void systemRootSet(long FileSystemId, Directory4Public systemRootVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FlSstmFacade.sstmRtSet(?, ?, ?); end;");
            callable.setLong(1, FileSystemId);
            callable.setLong(2, systemRootVal.getId());
            callable.setLong(3, systemRootVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void clipBoardSet(long FileSystemId, ClipBoard4Public clipBoardVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FlSstmFacade.clpBrdSet(?, ?, ?); end;");
            callable.setLong(1, FileSystemId);
            callable.setLong(2, clipBoardVal.getId());
            callable.setLong(3, clipBoardVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long FileSystemId, FileSystem4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FlSstmFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, FileSystemId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

