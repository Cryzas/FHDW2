package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AnswerAllCommandFacade{

	private String schemaName;
	private Connection con;

	public AnswerAllCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAnswerAllCommand newAnswerAllCommand(String subject,String text,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AnswrAllCMDFacade.newAnswrAllCMD(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, subject);
            callable.setString(3, text);
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AnswerAllCommand result = new AnswerAllCommand(null,subject,text,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAnswerAllCommand)PersistentProxi.createProxi(id, 142);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAnswerAllCommand newDelayedAnswerAllCommand(String subject,String text) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AnswrAllCMDFacade.newDelayedAnswrAllCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AnswerAllCommand result = new AnswerAllCommand(null,subject,text,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAnswerAllCommand)PersistentProxi.createProxi(id, 142);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AnswerAllCommand getAnswerAllCommand(long AnswerAllCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AnswrAllCMDFacade.getAnswrAllCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AnswerAllCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMailEntry mail = null;
            if (obj.getLong(2) != 0)
                mail = (PersistentMailEntry)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentAccountManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentAccountManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            AnswerAllCommand result = new AnswerAllCommand(mail,
                                                           obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                           obj.getString(5) == null ? "" : obj.getString(5) /* In Oracle "" = null !!! */,
                                                           invoker,
                                                           commandReceiver,
                                                           myCommonDate,
                                                           AnswerAllCommandId);
            obj.close();
            callable.close();
            AnswerAllCommandICProxi inCache = (AnswerAllCommandICProxi)Cache.getTheCache().put(result);
            AnswerAllCommand objectInCache = (AnswerAllCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AnswrAllCMDFacade.getClass(?); end;");
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
    public void mailSet(long AnswerAllCommandId, MailEntry4Public mailVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AnswrAllCMDFacade.mlSet(?, ?, ?); end;");
            callable.setLong(1, AnswerAllCommandId);
            callable.setLong(2, mailVal.getId());
            callable.setLong(3, mailVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subjectSet(long AnswerAllCommandId, String subjectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AnswrAllCMDFacade.sbjctSet(?, ?); end;");
            callable.setLong(1, AnswerAllCommandId);
            callable.setString(2, subjectVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void textSet(long AnswerAllCommandId, String textVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AnswrAllCMDFacade.txtSet(?, ?); end;");
            callable.setLong(1, AnswerAllCommandId);
            callable.setString(2, textVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AnswerAllCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AnswrAllCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AnswerAllCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AnswerAllCommandId, AccountManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AnswrAllCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AnswerAllCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AnswerAllCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AnswrAllCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AnswerAllCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

