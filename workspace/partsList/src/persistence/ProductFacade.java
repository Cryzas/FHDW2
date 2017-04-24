package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ProductFacade{

	private String schemaName;
	private Connection con;

	public ProductFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentProduct newProduct(String name,common.Fraction price,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.newPrdct(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, price.toString());
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Product result = new Product(name,price,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentProduct)PersistentProxi.createProxi(id, 115);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentProduct newDelayedProduct(String name,common.Fraction price) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.newDelayedPrdct(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Product result = new Product(name,price,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentProduct)PersistentProxi.createProxi(id, 115);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Product getProduct(long ProductId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.getPrdct(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ProductId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentComponent This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentComponent)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentComponentLst components = null;
            if (obj.getLong(6) != 0)
                components = (PersistentComponentLst)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            Product result = new Product(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                         (obj.getString(3) == null ? common.Fraction.Null : common.Fraction.parse(obj.getString(3))),
                                         This,
                                         components,
                                         ProductId);
            obj.close();
            callable.close();
            ProductICProxi inCache = (ProductICProxi)Cache.getTheCache().put(result);
            Product objectInCache = (Product)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void componentsSet(long ProductId, ComponentLst4Public componentsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrdctFacade.cmpnntsSet(?, ?, ?); end;");
            callable.setLong(1, ProductId);
            callable.setLong(2, componentsVal.getId());
            callable.setLong(3, componentsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

