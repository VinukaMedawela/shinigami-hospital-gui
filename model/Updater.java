package model;

 
import java.util.*;
import java.util.LinkedList;

public class Updater {
    protected LinkedList<MyObserver> views = new LinkedList<>();

    public void attach(MyObserver o) {
        views.add(o);
    }

    public void detach(MyObserver o) {
        views.remove(o);
    }

    protected void updateViews() {
        for (MyObserver view : views)
            view.update();
    }
}

