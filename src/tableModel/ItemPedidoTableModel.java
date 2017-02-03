package tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.ItemPedidoModel;

public class ItemPedidoTableModel extends AbstractTableModel {

    private ArrayList<ItemPedidoModel> itens;
    private final String[] colunas = {"Código", "Descrição", "Quantidade", "Valor Unitário", "Subtotal"};

    public ItemPedidoTableModel() {
        this.itens = new ArrayList<ItemPedidoModel>();
    }

    public ItemPedidoTableModel(ArrayList<ItemPedidoModel> i) {
        this.itens = i;
    }

    public void addRow(ItemPedidoModel item) {
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
        this.itens = new ArrayList<ItemPedidoModel>();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return itens.get(rowIndex).getItemProdutoIdProduto().getIdProduto();
            case 1:
                return itens.get(rowIndex).getItemProdutoIdProduto().getNome();
            case 2:
                return itens.get(rowIndex).getItemProdutoQuantidade();
            case 3:
                return itens.get(rowIndex).getItemProdutoIdProduto().getPreco();
            case 4:
                return itens.get(rowIndex).getTotal();

        }

        return null;
    }

    public ArrayList<ItemPedidoModel> getItens() {
        return this.itens;
    }

    public ItemPedidoModel get(int linha) {
        return this.itens.get(linha);
    }
}
