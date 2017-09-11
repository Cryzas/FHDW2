package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ChangeGradeCommandFacade{

	private String schemaName;
	private Connection con;

	public ChangeGradeCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentChangeGradeCommand newChangeGradeCommand(String grade,String comment,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngGrdCMDFacade.newChngGrdCMD(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, grade);
            callable.setString(3, comment);
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeGradeCommand result = new ChangeGradeCommand(null,grade,comment,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentChangeGradeCommand)PersistentProxi.createProxi(id, 275);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentChangeGradeCommand newDelayedChangeGradeCommand(String grade,String comment) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngGrdCMDFacade.newDelayedChngGrdCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeGradeCommand result = new ChangeGradeCommand(null,grade,comment,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentChangeGradeCommand)PersistentProxi.createProxi(id, 275);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeGradeCommand getChangeGradeCommand(long ChangeGradeCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngGrdCMDFacade.getChngGrdCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ChangeGradeCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            LectureWithGrade lecture = null;
            if (obj.getLong(2) != 0)
                lecture = (LectureWithGrade)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentStudentManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentStudentManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            ChangeGradeCommand result = new ChangeGradeCommand(lecture,
                                                               obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                               obj.getString(5) == null ? "" : obj.getString(5) /* In Oracle "" = null !!! */,
                                                               invoker,
                                                               commandReceiver,
                                                               myCommonDate,
                                                               ChangeGradeCommandId);
            obj.close();
            callable.close();
            ChangeGradeCommandICProxi inCache = (ChangeGradeCommandICProxi)Cache.getTheCache().put(result);
            ChangeGradeCommand objectInCache = (ChangeGradeCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngGrdCMDFacade.getClass(?); end;");
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
    public void lectureSet(long ChangeGradeCommandId, LectureWithGrade lectureVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngGrdCMDFacade.lctrSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeCommandId);
            callable.setLong(2, lectureVal.getId());
            callable.setLong(3, lectureVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void gradeSet(long ChangeGradeCommandId, String gradeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngGrdCMDFacade.grdSet(?, ?); end;");
            callable.setLong(1, ChangeGradeCommandId);
            callable.setString(2, gradeVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commentSet(long ChangeGradeCommandId, String commentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngGrdCMDFacade.cmmntSet(?, ?); end;");
            callable.setLong(1, ChangeGradeCommandId);
            callable.setString(2, commentVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ChangeGradeCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngGrdCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ChangeGradeCommandId, StudentManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngGrdCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ChangeGradeCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngGrdCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ChangeGradeCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

