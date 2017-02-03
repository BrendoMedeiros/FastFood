package tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.IngredienteDaReceitaModel;

public class ReceitaTableModel extends AbstractTableModel {

    private ArrayList<IngredienteDaReceitaModel> itens;
    private final String[] colunas = {"Ingrediente", "Quantidade"};

    public ReceitaTableModel() {
        this.itens = new ArrayList<IngredienteDaReceitaModel>();
    }

    public ReceitaTableModel(ArrayList<IngredienteDaReceitaModel> i) {
        this.itens = i;
    }

    public void addRow(IngredienteDaReceitaModel item) {
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
        this.itens = new ArrayList<IngredienteDaReceitaModel>();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return itens.get(rowIndex).getReceitaIngredienteIdIngrediente().getDescricao();
            case 1:
                return itens.get(rowIndex).getQuantidade();

        }

        return null;
    }

    public ArrayList<IngredienteDaReceitaModel> getItens() {
        return this.itens;
    }

    public IngredienteDaReceitaModel get(int linha) {
        return this.itens.get(linha);
    }
}
