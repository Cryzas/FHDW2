package model.meta;

public interface FilledCBStateMssgs {
    void accept(FilledCBStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FilledCBStateDOWNMssgs extends ClipBoardStateDOWNMssgs, FilledCBStateMssgs{}
interface FilledCBStateUPMssgs extends Mssgs, FilledCBStateMssgs{}
