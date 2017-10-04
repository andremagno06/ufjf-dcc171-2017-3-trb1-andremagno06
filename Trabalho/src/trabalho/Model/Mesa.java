package trabalho.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mesa {
    private String codigo;
    private List<Pedido> pedido ;
    private String aberto;
    private String fechado;
    private int estado;

    public Mesa(String codigo) {
        
        this.codigo = codigo;
        this.pedido = new ArrayList<>();
        this.aberto = null;
        this.fechado = null;
        this.estado = 0;
    }

    public String getAberto() {
        return aberto;
    }

    public void setAberto(String aberto) {
        this.aberto = aberto;
    }

    public String getFechado() {
        return fechado;
    }

    public void setFechado(String fechado) {
        this.fechado = fechado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    

    public Mesa() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }
    
    

    @Override
    public String toString() {
        
        if(estado==0){
            return  ""+this.codigo+"  |  Disponivel";
        }else if(estado==1){
            return ""+this.codigo+"  |   Aberto: "+aberto;
         
        }else if(estado==2){
            return ""+this.codigo+"  |   Aberto: "+aberto+" |  Fechado: "+fechado;
        }
        return codigo;
    }
    
    
}

