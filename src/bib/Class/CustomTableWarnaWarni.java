package bib.Class;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author echo
 */
public class CustomTableWarnaWarni extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 47612794125L;

    // warna background untuk baris ganjil
    private Color ganjil;

    // warna background untuk baris genap
    private Color genap;

    /**
     * membuat RenderWarnaWarni baru dengan menantukan warna backgroundnya
     *
     * @param ganjil warna ganjil
     * @param genap warna genap
     */
    public CustomTableWarnaWarni(Color ganjil, Color genap) {
        this.ganjil = ganjil;
        this.genap = genap;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int rowIndex, int columnIndex) {
        // mendapatkan component superclass
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, rowIndex, columnIndex);
        Object objek = table.getModel().getValueAt(rowIndex, 2);
        // cek ganjil ato genap
        if (objek.equals("Masuk")) {
            component.setForeground(Color.RED);
        } else if (objek.equals("Proses")) {
            component.setForeground(Color.CYAN);
        } else if (objek.equals("Selesai")) {
            component.setForeground(Color.lightGray);

        }
        return component;

    }
}
