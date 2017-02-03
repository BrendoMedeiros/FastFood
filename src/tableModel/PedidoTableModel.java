package tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.PedidoModel;

public class PedidoTableModel extends AbstractTableModel {

    private ArrayList<PedidoModel> itens;
    private final String[] colunas = {"Código", "Cliente", "Status"};

    public PedidoTableModel() {
        this.itens = new ArrayList<PedidoModel>();
    }

    public PedidoTableModel(ArrayList<PedidoModel> i) {
        this.itens = i;
    }

    public void addRow(PedidoModel item) {
        this.itens.add(item);
        this.fireTableDataChanged();
    }

    public void removeRow(int index) {
        this.itens.remove(index);
        this.fireTableRowsDeleted(index, index);
    }

    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public String getColumnName(int num) {
        return this.colunas[num];
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    public void clear() {
        this.itens = new ArrayList<PedidoModel>();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return itens.get(rowIndex).getIdPedido();
            case 1:
                return itens.get(rowIndex).getCliente().getNome();
            case 2:
                return itens.get(rowIndex).getStatusPedido();
        }

        return null;
    }

    public ArrayList<PedidoModel> getItens() {
        return this.itens;
    }

    public PedidoModel get(int linha) {
        return this.itens.get(linha);
    }
}
