package model.meta;

public interface ClipBoardStateMssgs {
    void accept(ClipBoardStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ClipBoardStateDOWNMssgs extends Mssgs, ClipBoardStateMssgs{}
interface ClipBoardStateUPMssgs extends FilledCBStateUPMssgs, EmptyCBStateUPMssgs, ClipBoardStateMssgs{}
