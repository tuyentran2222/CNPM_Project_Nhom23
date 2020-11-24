
package utility;

import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.PhanAnh;

/**
 *
 * @author ADMIN
 */
public class ClassTableModel {
   
    public DefaultTableModel setPhanAnhTable(List<PhanAnh> listPhanAnh, JTable phanAnhTable) {
        
        DefaultTableModel dtm = (DefaultTableModel) phanAnhTable.getModel();
        dtm.setRowCount(0);
        dtm.setColumnIdentifiers(new Object[] {
            "STT", "Người phản ánh", "Ngày", "Nội dung", "Lĩnh vực", "Trạng thái"
        });
        
        for(int i = 0; i < listPhanAnh.size(); i++) {
            PhanAnh phanAnh = listPhanAnh.get(i);
            dtm.addRow(new Object[]{
                i+1, phanAnh.getName(), phanAnh.getDate(), phanAnh.getContent(), phanAnh.getType(), phanAnh.getState()
            });
        }
        
        return dtm;
    }
}
