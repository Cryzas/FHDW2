package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StartStudyGroupCommandFacade{

	private String schemaName;
	private Connection con;

	public StartStudyGroupCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStartStudyGroupCommand newStartStudyGroupCommand(String name,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StrtStdGrpCMDFacade.newStrtStdGrpCMD(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StartStudyGroupCommand result = new StartStudyGroupCommand(null,name,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentStartStudyGroupCommand)PersistentProxi.createProxi(id, 185);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentStartStudyGroupCommand newDelayedStartStudyGroupCommand(String name) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StrtStdGrpCMDFacade.newDelayedStrtStdGrpCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StartStudyGroupCommand result = new StartStudyGroupCommand(null,name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentStartStudyGroupCommand)PersistentProxi.createProxi(id, 185);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StartStudyGroupCommand getStartStudyGroupCommand(long StartStudyGroupCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StrtStdGrpCMDFacade.getStrtStdGrpCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StartStudyGroupCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentProgram program = null;
            if (obj.getLong(2) != 0)
                program = (PersistentProgram)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(5) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentStudyGroupManager commandReceiver = null;
            if (obj.getLong(7) != 0)
                commandReceiver = (PersistentStudyGroupManager)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(9) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            StartStudyGroupCommand result = new StartStudyGroupCommand(program,
                                                                       obj.getString(4) == null ? "" : obj.getString(4) /* In Oracle "" = null !!! */,
                                                                       invoker,
                                                                       commandReceiver,
                                                                       myCommonDate,
                                                                       StartStudyGroupCommandId);
            obj.close();
            callable.close();
            StartStudyGroupCommandICProxi inCache = (StartStudyGroupCommandICProxi)Cache.getTheCache().put(result);
            StartStudyGroupCommand objectInCache = (StartStudyGroupCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StrtStdGrpCMDFacade.getClass(?); end;");
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
    public void programSet(long StartStudyGroupCommandId, Program4Public programVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StrtStdGrpCMDFacade.prgrmSet(?, ?, ?); end;");
            callable.setLong(1, StartStudyGroupCommandId);
            callable.setLong(2, programVal.getId());
            callable.setLong(3, programVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long StartStudyGroupCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StrtStdGrpCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, StartStudyGroupCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long StartStudyGroupCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StrtStdGrpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, StartStudyGroupCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long StartStudyGroupCommandId, StudyGroupManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StrtStdGrpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, StartStudyGroupCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long StartStudyGroupCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StrtStdGrpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, StartStudyGroupCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

