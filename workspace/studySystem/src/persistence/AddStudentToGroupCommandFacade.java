package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AddStudentToGroupCommandFacade{

	private String schemaName;
	private Connection con;

	public AddStudentToGroupCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAddStudentToGroupCommand newAddStudentToGroupCommand(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".Add_S2GCMDFacade.newAdd_S2GCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddStudentToGroupCommand result = new AddStudentToGroupCommand(null,null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentAddStudentToGroupCommand)PersistentProxi.createProxi(id, 203);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentAddStudentToGroupCommand newDelayedAddStudentToGroupCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".Add_S2GCMDFacade.newDelayedAdd_S2GCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddStudentToGroupCommand result = new AddStudentToGroupCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentAddStudentToGroupCommand)PersistentProxi.createProxi(id, 203);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddStudentToGroupCommand getAddStudentToGroupCommand(long AddStudentToGroupCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Add_S2GCMDFacade.getAdd_S2GCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AddStudentToGroupCommandId);
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
            PersistentStudent student = null;
            if (obj.getLong(4) != 0)
                student = (PersistentStudent)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentStudyGroupManager commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentStudyGroupManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            AddStudentToGroupCommand result = new AddStudentToGroupCommand(group,
                                                                           student,
                                                                           invoker,
                                                                           commandReceiver,
                                                                           myCommonDate,
                                                                           AddStudentToGroupCommandId);
            obj.close();
            callable.close();
            AddStudentToGroupCommandICProxi inCache = (AddStudentToGroupCommandICProxi)Cache.getTheCache().put(result);
            AddStudentToGroupCommand objectInCache = (AddStudentToGroupCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Add_S2GCMDFacade.getClass(?); end;");
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
    public void groupSet(long AddStudentToGroupCommandId, StudyGroup4Public groupVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".Add_S2GCMDFacade.grpSet(?, ?, ?); end;");
            callable.setLong(1, AddStudentToGroupCommandId);
            callable.setLong(2, groupVal.getId());
            callable.setLong(3, groupVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studentSet(long AddStudentToGroupCommandId, Student4Public studentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".Add_S2GCMDFacade.stdntSet(?, ?, ?); end;");
            callable.setLong(1, AddStudentToGroupCommandId);
            callable.setLong(2, studentVal.getId());
            callable.setLong(3, studentVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddStudentToGroupCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".Add_S2GCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddStudentToGroupCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddStudentToGroupCommandId, StudyGroupManager4Public commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".Add_S2GCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddStudentToGroupCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddStudentToGroupCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".Add_S2GCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddStudentToGroupCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

