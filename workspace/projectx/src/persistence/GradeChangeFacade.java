package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class GradeChangeFacade{

	private String schemaName;
	private Connection con;

	public GradeChangeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentGradeChange newGradeChange(java.sql.Date dateOfChange,String comment,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".GrdChngFacade.newGrdChng(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setDate(2, dateOfChange);
            callable.setString(3, comment);
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            GradeChange result = new GradeChange(null,null,dateOfChange,comment,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentGradeChange)PersistentProxi.createProxi(id, 276);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentGradeChange newDelayedGradeChange(java.sql.Date dateOfChange,String comment) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".GrdChngFacade.newDelayedGrdChng(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            GradeChange result = new GradeChange(null,null,dateOfChange,comment,null,id);
            Cache.getTheCache().put(result);
            return (PersistentGradeChange)PersistentProxi.createProxi(id, 276);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public GradeChange getGradeChange(long GradeChangeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".GrdChngFacade.getGrdChng(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, GradeChangeId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentGrade fromGrade = null;
            if (obj.getLong(2) != 0)
                fromGrade = (PersistentGrade)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentGrade toGrade = null;
            if (obj.getLong(4) != 0)
                toGrade = (PersistentGrade)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentGradeChange This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentGradeChange)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            GradeChange result = new GradeChange(fromGrade,
                                                 toGrade,
                                                 obj.getDate(6),
                                                 obj.getString(7) == null ? "" : obj.getString(7) /* In Oracle "" = null !!! */,
                                                 This,
                                                 GradeChangeId);
            obj.close();
            callable.close();
            GradeChangeICProxi inCache = (GradeChangeICProxi)Cache.getTheCache().put(result);
            GradeChange objectInCache = (GradeChange)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".GrdChngFacade.getClass(?); end;");
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
    public void fromGradeSet(long GradeChangeId, Grade4Public fromGradeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".GrdChngFacade.frmGrdSet(?, ?, ?); end;");
            callable.setLong(1, GradeChangeId);
            callable.setLong(2, fromGradeVal.getId());
            callable.setLong(3, fromGradeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void toGradeSet(long GradeChangeId, Grade4Public toGradeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".GrdChngFacade.tGrdSet(?, ?, ?); end;");
            callable.setLong(1, GradeChangeId);
            callable.setLong(2, toGradeVal.getId());
            callable.setLong(3, toGradeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void dateOfChangeSet(long GradeChangeId, java.sql.Date dateOfChangeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".GrdChngFacade.dtOfChngSet(?, ?); end;");
            callable.setLong(1, GradeChangeId);
            callable.setDate(2, dateOfChangeVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commentSet(long GradeChangeId, String commentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".GrdChngFacade.cmmntSet(?, ?); end;");
            callable.setLong(1, GradeChangeId);
            callable.setString(2, commentVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long GradeChangeId, GradeChange4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".GrdChngFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, GradeChangeId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

