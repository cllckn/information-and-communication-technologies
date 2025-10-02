package cc.ku.ict.modul4.interfaces;

interface IDatabaseRepository {
    public void connect();

    public void executeQuery();

    public void closeConnection();
}
