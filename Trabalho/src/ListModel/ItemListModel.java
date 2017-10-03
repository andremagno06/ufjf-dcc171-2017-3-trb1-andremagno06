package ListModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import trabalho.Model.Item;


public class ItemListModel implements ListModel<Item> {

    private final List<Item> itens;
    private final List<ListDataListener> dataListeners;

    public ItemListModel() {
        this.itens = null;
        this.dataListeners = null;

    }
    public ItemListModel(List<Item> itens) {
        this.itens = itens;
        this.dataListeners =  new ArrayList<>();
    }

    
  
    
    public int getSize() {
        return itens.size();
    }

    
    public Item getElementAt(int index) {
        return itens.get(index);
    }

    
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

 
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
}
