package tableModel;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.EstoqueModel;

public class RelatorioEstoqueTableModel extends AbstractTableModel {

    private ArrayList<EstoqueModel> itens;
    private final String[] colunas = {"Código", "Quantidade", "Unidade", "Data de Validade"};

    public RelatorioEstoqueTableModel() {
        this.itens = new ArrayList<EstoqueModel>();
    }

    public RelatorioEstoqueTableModel(ArrayList<EstoqueModel> i) {
        this.itens = i;
    }

    public void addRow(EstoqueModel item) {
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
        this.itens = new ArrayList<EstoqueModel>();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return itens.get(rowIndex).getIdEstoque();
            case 1:
                return itens.get(rowIndex).getQuantidade();
            case 2:
                return itens.get(rowIndex).getUnidade();
            case 3:
                return itens.get(rowIndex).getDataValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        }

        return null;
    }

    public ArrayList<EstoqueModel> getItens() {
        return this.itens;
    }

    public EstoqueModel get(int linha) {
        return this.itens.get(linha);
    }
}
