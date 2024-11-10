package gui;

import bus.ThongKe_bus;
import java.awt.*;
import javax.swing.*;
import java.util.Calendar;
import java.util.ArrayList;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PlotOrientation;
import java.text.DecimalFormat;

public class ThongKe_JPanel extends javax.swing.JPanel {
    private ThongKe_bus thongKeBus;
    private JComboBox<Integer> cbo_Nam;
    private DecimalFormat df = new DecimalFormat("#,###");
    
    public ThongKe_JPanel() {
        initComponents();
        setSize(1186, 748); 
        thongKeBus = new ThongKe_bus();
        setBounds(0, 0, 1186, 748);
        setVisible(true); 
        setupComponents();
        loadData();
    }

    private void setupComponents() {
        setLayout(new BorderLayout(0, 0));
        JPanel pnl_TieuDe = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 128, 128), w, h, new Color(0, 77, 77));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        pnl_TieuDe.setPreferredSize(new Dimension(1186, 60));
        JLabel lbl_TieuDe = new JLabel("THỐNG KÊ VÉ VÀ NHÂN VIÊN");
        lbl_TieuDe.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lbl_TieuDe.setForeground(Color.WHITE);
        pnl_TieuDe.add(lbl_TieuDe);
        add(pnl_TieuDe, BorderLayout.NORTH);

        // Panel chọn năm với style mới
        JPanel pnl_ChonNam = new JPanel();
        pnl_ChonNam.setBackground(new Color(240, 240, 240));
        pnl_ChonNam.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JLabel lbl_Nam = new JLabel("Năm thống kê:");
        lbl_Nam.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        cbo_Nam = new JComboBox<>();
        cbo_Nam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cbo_Nam.setPreferredSize(new Dimension(120, 30));
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for(int i = currentYear; i >= currentYear-5; i--) {
            cbo_Nam.addItem(i);
        }
        cbo_Nam.setPreferredSize(new Dimension(100, 25));
        cbo_Nam.addActionListener(e -> loadData());
        pnl_ChonNam.add(lbl_Nam);
        pnl_ChonNam.add(cbo_Nam);

        // Panel chính với card layout
        JPanel pnl_Main = new JPanel(new GridLayout(2, 2, 15, 15));
        pnl_Main.setBackground(Color.WHITE);
        pnl_Main.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Các panel con với style mới
        JPanel[] subPanels = new JPanel[4];
        String[] titles = {
            "Thống kê vé theo tàu",
            "Thống kê vé theo nhân viên",
            "Thống kê trạng thái nhân viên",
            "Top 5 nhân viên xuất sắc"
        };
        
        for (int i = 0; i < 4; i++) {
            subPanels[i] = createStyledPanel(titles[i]);
        }
        
        subPanels[0].add(createVeTheoTauChart(), BorderLayout.CENTER);
        subPanels[1].add(createVeTheoNhanVienChart(), BorderLayout.CENTER);
        subPanels[2].add(createNhanVienChart(), BorderLayout.CENTER);
        subPanels[3].add(new JScrollPane(createTop5NVTable()), BorderLayout.CENTER);
        
        for (JPanel panel : subPanels) {
            pnl_Main.add(panel);
        }

        JPanel pnl_Content = new JPanel(new BorderLayout());
        pnl_Content.setBackground(Color.WHITE);
        pnl_Content.add(pnl_ChonNam, BorderLayout.NORTH);
        pnl_Content.add(pnl_Main, BorderLayout.CENTER);
        
        add(pnl_Content, BorderLayout.CENTER);
    }

    // Helper method để tạo panel con với style thống nhất
    private JPanel createStyledPanel(String title) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        // Tiêu đề panel
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        titleLabel.setForeground(new Color(0, 102, 102));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        panel.add(titleLabel, BorderLayout.NORTH);
        return panel;
    }

    private ChartPanel createVeTheoTauChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String nam = cbo_Nam.getSelectedItem().toString();
        ArrayList<Object[]> data = thongKeBus.thongKeVeTheoTau(nam);
        for (Object[] row : data) {
            dataset.addValue((Number) row[2], "Vé", row[1].toString());
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "Số vé đã bán theo tàu",
            "Tàu",
            "Số lượng",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );

        return new ChartPanel(chart);
    }

    private ChartPanel createVeTheoNhanVienChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String nam = cbo_Nam.getSelectedItem().toString();
        ArrayList<Object[]> data = thongKeBus.thongKeVeTheoNhanVien(nam);
        for (Object[] row : data) {
            dataset.addValue((Number) row[2], "Vé", row[1].toString());
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "Số vé đã bán theo nhân viên",
            "Nhân viên",
            "Số lượng",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );

        return new ChartPanel(chart);
    }

    private ChartPanel createNhanVienChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        ArrayList<Object[]> data = thongKeBus.thongKeNhanVien();
        for (Object[] row : data) {
            dataset.setValue(row[0].toString(), (Number) row[1]);
        }

        JFreeChart chart = ChartFactory.createPieChart(
            "Thống kê trạng thái nhân viên",
            dataset,
            true, true, false
        );

        return new ChartPanel(chart);
    }

    private JTable createTop5NVTable() {
        String[] columnNames = {"STT", "Mã NV", "Tên nhân viên", "Số vé đã bán"};
        String nam = cbo_Nam.getSelectedItem().toString();
        String thang = ""; // Có thể thêm combobox chọn tháng nếu cần
        ArrayList<Object[]> data = thongKeBus.thongKeTop5NhanVien(thang, nam);
        Object[][] tableData = new Object[data.size()][4];
        for (int i = 0; i < data.size(); i++) {
            Object[] row = data.get(i);
            tableData[i][0] = i + 1;
            tableData[i][1] = row[0];
            tableData[i][2] = row[1];
            tableData[i][3] = row[2];
        }

        JTable table = new JTable(tableData, columnNames);
        table.setFillsViewportHeight(true);
        table.setEnabled(false);
        return table;
    }

    private void loadData() {
        // Cập nhật dữ liệu cho tất cả các biểu đồ và bảng
        createVeTheoTauChart();
        createVeTheoNhanVienChart();
        createNhanVienChart();
        createTop5NVTable();
        revalidate();
        repaint();
    }

    private void initComponents() {
        // Phần code tự động sinh bởi NetBeans
    }// </editor-fold>//GEN-END:initComponents

}