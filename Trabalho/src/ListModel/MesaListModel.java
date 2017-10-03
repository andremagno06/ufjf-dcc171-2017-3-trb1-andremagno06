package ListModel;

import trabalho.Model.Mesa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class MesaListModel implements ListModel<Mesa> {

    private final List<Mesa> turmas;
    private final List<ListDataListener> dataListeners;

    public MesaListModel(List<Mesa> turmas) {
        this.turmas = turmas;
        this.dataListeners =  new ArrayList<>();
    }

    @Override
    public int getSize() {
        return turmas.size();
    }

    @Override
    public Mesa getElementAt(int index) {
        return turmas.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
}
