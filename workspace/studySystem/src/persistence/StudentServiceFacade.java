package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class StudentServiceFacade{

	private String schemaName;
	private Connection con;

	public StudentServiceFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudentService newStudentService(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvcFacade.newStdntSrvc(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudentService result = new StudentService(null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentStudentService)PersistentProxi.createProxi(id, -286);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentStudentService newDelayedStudentService() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvcFacade.newDelayedStdntSrvc(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            StudentService result = new StudentService(null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentStudentService)PersistentProxi.createProxi(id, -286);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public StudentService getStudentService(long StudentServiceId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".StdntSrvcFacade.getStdntSrvc(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, StudentServiceId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentService This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentService)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            StudentService result = new StudentService(subService,
                                                       This,
                                                       StudentServiceId);
            obj.close();
            callable.close();
            StudentServiceICProxi inCache = (StudentServiceICProxi)Cache.getTheCache().put(result);
            StudentService objectInCache = (StudentService)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

