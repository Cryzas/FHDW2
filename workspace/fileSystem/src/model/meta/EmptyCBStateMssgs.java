package model.meta;

public interface EmptyCBStateMssgs {
    void accept(EmptyCBStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface EmptyCBStateDOWNMssgs extends ClipBoardStateDOWNMssgs, EmptyCBStateMssgs{}
interface EmptyCBStateUPMssgs extends Mssgs, EmptyCBStateMssgs{}
