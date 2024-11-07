package gui;

import dao.ThongKe_dao;
import java.awt.*;
import javax.swing.*;
import java.util.Calendar;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import java.text.DecimalFormat;

public class ThongKe_JPanel extends javax.swing.JPanel {
    private ThongKe_dao thongKeDao;
    private JComboBox<Integer> cbo_Nam;
    private DecimalFormat df = new DecimalFormat("#,###");

    public ThongKe_JPanel() {
    	   initComponents();
           setSize(1186, 748);  // Kích thước giống các panel khác
    	    thongKeDao = new ThongKe_dao();
    	    setBounds(0, 0, 1186, 748);
    	    setVisible(true); 
    	    setupComponents();
    	    loadData();
    	    
    	    validate();
    	    repaint();
    }

    private void setupComponents() {
        setLayout(new BorderLayout(0, 0));
        
        // Panel tiêu đề với gradient background
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
        JLabel lbl_TieuDe = new JLabel("THỐNG KÊ DOANH THU VÀ NHÂN VIÊN");
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
        pnl_ChonNam.add(cbo_Nam);

        // Panel chính với card layout
        JPanel pnl_Main = new JPanel(new GridLayout(2, 2, 15, 15));
        pnl_Main.setBackground(Color.WHITE);
        pnl_Main.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Các panel con với style mới
        JPanel[] subPanels = new JPanel[4];
        String[] titles = {
            "Thống kê vé đã bán",
            "Thống kê doanh thu",
            "Thống kê nhân viên",
            "Top 5 nhân viên xuất sắc"
        };
        
        for (int i = 0; i < 4; i++) {
            subPanels[i] = createStyledPanel(titles[i]);
        }
        
        // Thêm nội dung vào các panel
        subPanels[0].add(createVeChart(), BorderLayout.CENTER);
        subPanels[1].add(createDoanhThuChart(), BorderLayout.CENTER);
        subPanels[2].add(createNhanVienChart(), BorderLayout.CENTER);
        subPanels[3].add(new JScrollPane(createTop5NVTable()), BorderLayout.CENTER);
        
        // Thêm các panel vào panel chính
        for (JPanel panel : subPanels) {
            pnl_Main.add(panel);
        }

        // Panel content chính
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

    private ChartPanel createVeChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Thêm dữ liệu mẫu
        dataset.addValue(120, "Vé", "T1");
        dataset.addValue(150, "Vé", "T2");
        // ... thêm dữ liệu các tháng khác

        JFreeChart chart = ChartFactory.createBarChart(
            "Số vé đã bán theo tháng",
            "Tháng",
            "Số lượng",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );

        return new ChartPanel(chart);
    }

    private ChartPanel createDoanhThuChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Thêm dữ liệu mẫu
        dataset.addValue(50000000, "Doanh thu", "T1");
        dataset.addValue(75000000, "Doanh thu", "T2");
        // ... thêm dữ liệu các tháng khác

        JFreeChart chart = ChartFactory.createLineChart(
            "Doanh thu theo tháng",
            "Tháng",
            "Doanh thu (VNĐ)",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );

        return new ChartPanel(chart);
    }

    private ChartPanel createNhanVienChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Đang làm việc", "");
        dataset.addValue(2, "Đã nghỉ việc", "");

        JFreeChart chart = ChartFactory.createBarChart(
            "Thống kê trạng thái nhân viên",
            "",
            "Số lượng",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );

        return new ChartPanel(chart);
    }

    private JTable createTop5NVTable() {
        String[] columnNames = {"STT", "Mã NV", "Tên nhân viên", "Số vé đã bán", "Doanh thu"};
        Object[][] data = {
            {"1", "NV001", "Nguyễn Văn A", "50", "25,000,000"},
            {"2", "NV002", "Trần Thị B", "45", "22,500,000"},
            // ... thêm dữ liệu mẫu
        };

        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        table.setEnabled(false);
        return table;
    }

    private void loadData() {
        // TODO: Load dữ liệu thực từ database
        // Cập nhật các biểu đồ và bảng với dữ liệu mới
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        // Phần code tự động sinh bởi NetBeans
    }// </editor-fold>//GEN-END:initComponents
}