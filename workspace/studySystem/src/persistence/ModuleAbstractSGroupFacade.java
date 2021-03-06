package persistence;



import java.sql.*;
//import oracle.jdbc.*;

public class ModuleAbstractSGroupFacade{

	private String schemaName;
	private Connection con;

	public ModuleAbstractSGroupFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".m_abstr_grFacade.getClass(?); end;");
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
    public void moduleCopySet(long ModuleAbstractSGroupId, ModuleAbstract4Public moduleCopyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".m_abstr_grFacade.mdlCpSet(?, ?, ?); end;");
            callable.setLong(1, ModuleAbstractSGroupId);
            callable.setLong(2, moduleCopyVal.getId());
            callable.setLong(3, moduleCopyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void finishedSet(long ModuleAbstractSGroupId, MyBoolean4Public finishedVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".m_abstr_grFacade.fnshdSet(?, ?, ?); end;");
            callable.setLong(1, ModuleAbstractSGroupId);
            callable.setLong(2, finishedVal.getId());
            callable.setLong(3, finishedVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long ModuleAbstractSGroupId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".m_abstr_grFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, ModuleAbstractSGroupId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ModuleAbstractSGroupId, ModuleAbstractSGroup4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".m_abstr_grFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ModuleAbstractSGroupId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

