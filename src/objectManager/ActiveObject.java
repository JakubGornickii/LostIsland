package objectManager;

import entity.Entity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ActiveObject {
    public static final List<Entity> objects = new CopyOnWriteArrayList<Entity>();
}
