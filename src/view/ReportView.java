package view;

import java.util.ArrayList;
import javax.swing.*;
import model.*;
import controller.ReportController;
import java.awt.Dimension;

/**
 *
 * @author Axell Silvano;
 */
public class ReportView {

    public ReportView() {

        ReportController controller = new ReportController();

        JFrame f = new JFrame("Report");
        f.setMinimumSize(new Dimension(432, 768));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            Header header = new Header(UserManager.getInstance().getUser().getNama(), "Report");
            f.add(header.getHeader());

            ArrayList<Kelas> reports = controller.getReportsFromDB();

            int tambah = 253;
            int tambahNilai = 277;
            for (int i = 0; i < reports.size(); i++) {
                JLabel kelas = new JLabel("Kelas " + reports.get(i).getNama());
                JLabel nilai = new JLabel("Nilai " + reports.get(i).getNa());
                kelas.setBounds(46, tambah, 108, 12);
                nilai.setBounds(70, tambahNilai, 235, 12);
                tambah += 60;
                tambahNilai += 60;
                f.add(kelas);
                f.add(nilai);

            }

            f.setLayout(null);
            f.setVisible(true);
        } catch (NullPointerException e) {
            e.printStackTrace();
            ErrorView.printError("No Data");
        }

    }

    public static void main(String[] args) {
        new ReportView();
    }

}
