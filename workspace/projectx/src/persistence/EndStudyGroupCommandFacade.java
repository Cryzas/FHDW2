package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class EndStudyGroupCommandFacade{

	private String schemaName;
	private Connection con;

	public EndStudyGroupCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentEndStudyGroupCommand newEndStudyGroupCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".EndStdGrpCMDFacade.newEndStdGrpCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            EndStudyGroupCommand result = new EndStudyGroupCommand(null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentEndStudyGroupCommand)PersistentProxi.createProxi(id, 284);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentEndStudyGroupCommand newDelayedEndStudyGroupCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".EndStdGrpCMDFacade.newDelayedEndStdGrpCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            EndStudyGroupCommand result = new EndStudyGroupCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentEndStudyGroupCommand)PersistentProxi.createProxi(id, 284);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public EndStudyGroupCommand getEndStudyGroupCommand(long EndStudyGroupCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".EndStdGrpCMDFacade.getEndStdGrpCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, EndStudyGroupCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentStudyGroup studyGroup = null;
            if (obj.getLong(2) != 0)
                studyGroup = (PersistentStudyGroup)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentStudyGroupManager commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentStudyGroupManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            EndStudyGroupCommand result = new EndStudyGroupCommand(studyGroup,
                                                                   invoker,
                                                                   commandReceiver,
                                                                   myCommonDate,
                                                                   EndStudyGroupCommandId);
            obj.close();
            callable.close();
            EndStudyGroupCommandICProxi inCache = (EndStudyGroupCommandICProxi)Cache.getTheCache().put(result);
            EndStudyGroupCommand objectInCache = (EndStudyGroupCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".EndStdGrpCMDFacade.getClass(?); end;");
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
    public void studyGroupSet(long EndStudyGroupCommandId, StudyGroup4Public studyGroupVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".EndStdGrpCMDFacade.stdGrpSet(?, ?, ?); end;");
            callable.setLong(1, EndStudyGroupCommandId);
            callable.setLong(2, studyGroupVal.getId());
            callable.setLong(3, studyGroupVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long EndStudyGroupCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".EndStdGrpCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, EndStudyGroupCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long EndStudyGroupCommandId, StudyGroupManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".EndStdGrpCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, EndStudyGroupCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long EndStudyGroupCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".EndStdGrpCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, EndStudyGroupCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

