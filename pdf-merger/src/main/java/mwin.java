import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.*;

public class mwin extends JFrame {
    public mwin() {
        // main window creation
        setTitle("PDFMerger");
        setSize(280, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // merge button
        JButton merge = new JButton("Merge (2 files)");
        merge.addActionListener((event) -> {
            (new merge_window()).setVisible(true);
            setVisible(false);
        });

        // reorder button
        JButton reorder = new JButton("Reorder (1 file)");
        reorder.addActionListener((event) -> {
            (new reorder_window()).setVisible(true);
            setVisible(false);
        });

        // layout
        merge.setBorder(BorderFactory.createEmptyBorder(5,15,5,15));
        reorder.setBorder(BorderFactory.createEmptyBorder(5,15,5,15));
        JPanel basepanel = new JPanel();
        basepanel.setLayout(new BoxLayout(basepanel, BoxLayout.X_AXIS));
        // v1.0 TODO get the buttons to align horizontally no matter the size of the base panel
        basepanel.add(Box.createRigidArea(new Dimension(10, 0)));
        basepanel.add(merge, BorderLayout.WEST);
        basepanel.add(Box.createRigidArea(new Dimension(10, 0)));
        basepanel.add(reorder, BorderLayout.EAST);

        add(basepanel);
    }

    public static void main(String[] args) { (new mwin()).setVisible(true); }
}
