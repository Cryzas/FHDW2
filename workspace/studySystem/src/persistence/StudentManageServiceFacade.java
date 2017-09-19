package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudentManageServiceFacade{

	private String schemaName;
	private Connection con;

	public StudentManageServiceFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudentManageService newStudentManageService(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StuMServiceFacade.newStuMService(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudentManageService result = new StudentManageService(null,null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentStudentManageService)PersistentProxi.createProxi(id, -303);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentStudentManageService newDelayedStudentManageService() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StuMServiceFacade.newDelayedStuMService(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudentManageService result = new StudentManageService(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentStudentManageService)PersistentProxi.createProxi(id, -303);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StudentManageService getStudentManageService(long StudentManageServiceId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StuMServiceFacade.getStuMService(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudentManageServiceId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAdminService parentService = null;
            if (obj.getLong(2) != 0)
                parentService = (PersistentAdminService)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            SubjInterface subService = null;
            if (obj.getLong(4) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentsubAdminService This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentsubAdminService)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentStudentManageServiceStudentManager studentManager = null;
            if (obj.getLong(8) != 0)
                studentManager = (PersistentStudentManageServiceStudentManager)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            StudentManageService result = new StudentManageService(parentService,
                                                                   subService,
                                                                   This,
                                                                   studentManager,
                                                                   StudentManageServiceId);
            obj.close();
            callable.close();
            StudentManageServiceICProxi inCache = (StudentManageServiceICProxi)Cache.getTheCache().put(result);
            StudentManageService objectInCache = (StudentManageService)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void studentManagerSet(long StudentManageServiceId, StudentManageServiceStudentManager4Public studentManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".StuMServiceFacade.stdntMngrSet(?, ?, ?); end;");
            callable.setLong(1, StudentManageServiceId);
            callable.setLong(2, studentManagerVal.getId());
            callable.setLong(3, studentManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

