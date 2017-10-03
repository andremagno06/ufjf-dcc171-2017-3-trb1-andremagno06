package ListModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import trabalho.Model.Pedido;

public class PedidoListModel implements ListModel<Pedido> {

    private final List<Pedido> pedidos;
    private final List<ListDataListener> dataListeners;

    public PedidoListModel() {
        this.pedidos = null;
        this.dataListeners = null;

    }
    public PedidoListModel(List<Pedido> pedido) {
        this.pedidos = pedido;
        this.dataListeners =  new ArrayList<>();
    }

  
    
    public int getSize() {
        return pedidos.size();
    }

    
    public Pedido getElementAt(int index) {
        return pedidos.get(index);
    }

    
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

 
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
}
