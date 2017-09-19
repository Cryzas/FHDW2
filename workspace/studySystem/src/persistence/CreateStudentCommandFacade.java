package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class CreateStudentCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateStudentCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCreateStudentCommand newCreateStudentCommand(String firstName,String lastName,java.sql.Date birthDate,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtStdntCMDFacade.newCrtStdntCMD(?,?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, firstName);
            callable.setString(3, lastName);
            callable.setDate(4, birthDate);
            callable.setLong(5, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateStudentCommand result = new CreateStudentCommand(null,firstName,lastName,birthDate,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentCreateStudentCommand)PersistentProxi.createProxi(id, 200);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentCreateStudentCommand newDelayedCreateStudentCommand(String firstName,String lastName,java.sql.Date birthDate) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtStdntCMDFacade.newDelayedCrtStdntCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateStudentCommand result = new CreateStudentCommand(null,firstName,lastName,birthDate,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentCreateStudentCommand)PersistentProxi.createProxi(id, 200);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateStudentCommand getCreateStudentCommand(long CreateStudentCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtStdntCMDFacade.getCrtStdntCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, CreateStudentCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentStudyGroup group = null;
            if (obj.getLong(2) != 0)
                group = (PersistentStudyGroup)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(7) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentStudyGroupManager commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentStudyGroupManager)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            CreateStudentCommand result = new CreateStudentCommand(group,
                                                                   obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                   obj.getString(5) == null ? "" : obj.getString(5) /* In Oracle "" = null !!! */,
                                                                   obj.getDate(6),
                                                                   invoker,
                                                                   commandReceiver,
                                                                   myCommonDate,
                                                                   CreateStudentCommandId);
            obj.close();
            callable.close();
            CreateStudentCommandICProxi inCache = (CreateStudentCommandICProxi)Cache.getTheCache().put(result);
            CreateStudentCommand objectInCache = (CreateStudentCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtStdntCMDFacade.getClass(?); end;");
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
    public void groupSet(long CreateStudentCommandId, StudyGroup4Public groupVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.grpSet(?, ?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setLong(2, groupVal.getId());
            callable.setLong(3, groupVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void firstNameSet(long CreateStudentCommandId, String firstNameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.frstNmSet(?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setString(2, firstNameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void lastNameSet(long CreateStudentCommandId, String lastNameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.lstNmSet(?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setString(2, lastNameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void birthDateSet(long CreateStudentCommandId, java.sql.Date birthDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.brthDtSet(?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setDate(2, birthDateVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateStudentCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateStudentCommandId, StudyGroupManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateStudentCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtStdntCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateStudentCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

