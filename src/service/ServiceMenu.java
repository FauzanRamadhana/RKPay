
package service;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public interface ServiceMenu {
    public void loadData(DefaultTableModel table);
    public int addData(String nama, int stok, int harga, String kategori);
    public int updateData(String nama, int stok, int harga, int id);
    public void deleteData(int index);
}
