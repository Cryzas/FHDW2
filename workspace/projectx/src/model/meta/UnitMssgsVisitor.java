package model.meta;

public interface UnitMssgsVisitor extends UnitDOWNMssgsVisitor, UnitUPMssgsVisitor {}


interface UnitDOWNMssgsVisitor  {

    public void handleUnitChangeCPOnUnitFractionMssg(UnitChangeCPOnUnitFractionMssg event) throws persistence.PersistenceException;
    
}


interface UnitUPMssgsVisitor  {

    public void handleUnitChangeCPOnUnitFractionMssg(UnitChangeCPOnUnitFractionMssg event) throws persistence.PersistenceException;
    
}
