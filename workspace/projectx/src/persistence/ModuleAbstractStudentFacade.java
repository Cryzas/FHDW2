package persistence;



import java.sql.*;
//import oracle.jdbc.*;

public class ModuleAbstractStudentFacade{

	private String schemaName;
	private Connection con;

	public ModuleAbstractStudentFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".m_abstr_stFacade.getClass(?); end;");
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
    public void moduleCopySet(long ModuleAbstractStudentId, ModuleAbstractSGroup4Public moduleCopyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".m_abstr_stFacade.mdlCpSet(?, ?, ?); end;");
            callable.setLong(1, ModuleAbstractStudentId);
            callable.setLong(2, moduleCopyVal.getId());
            callable.setLong(3, moduleCopyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ModuleAbstractStudentId, ModuleAbstractStudent4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".m_abstr_stFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ModuleAbstractStudentId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

