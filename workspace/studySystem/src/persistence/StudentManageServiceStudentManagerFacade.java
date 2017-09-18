package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudentManageServiceStudentManagerFacade{

	private String schemaName;
	private Connection con;

	public StudentManageServiceStudentManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudentManageServiceStudentManager newStudentManageServiceStudentManager(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StuMServiceStdntMngrFacade.newStuMServiceStdntMngr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudentManageServiceStudentManager result = new StudentManageServiceStudentManager(null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentStudentManageServiceStudentManager)PersistentProxi.createProxi(id, 311);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentStudentManageServiceStudentManager newDelayedStudentManageServiceStudentManager() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StuMServiceStdntMngrFacade.newDelayedStuMServiceStdntMngr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudentManageServiceStudentManager result = new StudentManageServiceStudentManager(null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentStudentManageServiceStudentManager)PersistentProxi.createProxi(id, 311);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StudentManageServiceStudentManager getStudentManageServiceStudentManager(long StudentManageServiceStudentManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StuMServiceStdntMngrFacade.getStuMServiceStdntMngr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudentManageServiceStudentManagerId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentStudentManageService observer = null;
            if (obj.getLong(2) != 0)
                observer = (PersistentStudentManageService)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentStudentManager observee = null;
            if (obj.getLong(4) != 0)
                observee = (PersistentStudentManager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentStudentManageServiceStudentManager This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentStudentManageServiceStudentManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            StudentManageServiceStudentManager result = new StudentManageServiceStudentManager(observer,
                                                                                               observee,
                                                                                               This,
                                                                                               StudentManageServiceStudentManagerId);
            obj.close();
            callable.close();
            StudentManageServiceStudentManagerICProxi inCache = (StudentManageServiceStudentManagerICProxi)Cache.getTheCache().put(result);
            StudentManageServiceStudentManager objectInCache = (StudentManageServiceStudentManager)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StuMServiceStdntMngrFacade.getClass(?); end;");
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
    public void observerSet(long StudentManageServiceStudentManagerId, StudentManageService4Public observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StuMServiceStdntMngrFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, StudentManageServiceStudentManagerId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long StudentManageServiceStudentManagerId, StudentManager4Public observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StuMServiceStdntMngrFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, StudentManageServiceStudentManagerId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long StudentManageServiceStudentManagerId, StudentManageServiceStudentManager4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StuMServiceStdntMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, StudentManageServiceStudentManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

