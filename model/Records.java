package model;
import java.util.LinkedList;

public abstract class Records extends Updater {//step 1 of MVC
    protected LinkedList<Record> records = new LinkedList<>();
    protected int id = 0;

    protected Record find(int id) {
        for (Record record : records) {
            if (record.matches(id)) {
                return record;
            }
        }
        return null;
    }

    public void add(Record record) {
        records.add(record);
        updateViews();//step 1 of MVC
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Record record : records) {
            str.append(record.toString()).append("\n");
        }
        return str.toString();
    }
}
