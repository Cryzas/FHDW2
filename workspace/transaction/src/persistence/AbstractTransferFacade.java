package persistence;



import java.sql.*;
//import oracle.jdbc.*;

public class AbstractTransferFacade{

	private String schemaName;
	private Connection con;

	public AbstractTransferFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AbstrTrnsfrFacade.getClass(?); end;");
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
    public void subjectSet(long AbstractTransferId, String subjectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AbstrTrnsfrFacade.sbjctSet(?, ?); end;");
            callable.setLong(1, AbstractTransferId);
            callable.setString(2, subjectVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long AbstractTransferId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AbstrTrnsfrFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, AbstractTransferId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AbstractTransferId, AbstractTransfer4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AbstrTrnsfrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AbstractTransferId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

