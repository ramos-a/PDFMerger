import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.*;

public class merge_window extends JFrame {
    private static File file1;
    private static File file2;
    private static File folder;

    public merge_window() {
        // creamos la ventana principal
        setTitle("Merge");
        setSize(600, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // new document title
        JLabel namelab = new JLabel("Name of the new file: ");
        JTextArea nameinp = new JTextArea();

        // directories
        // v1.0 TODO delete duplicated code
        // source directory 1
        JLabel sdir1lab = new JLabel("First file:");
        JLabel sdir1 = new JLabel();
        JButton sdir1but = new JButton("Choose file");
        sdir1but.addActionListener((event) -> {
            JFileChooser fileChooser = new JFileChooser(
                    // default directory when opening file chooser
            );
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int option = fileChooser.showOpenDialog(new JFrame());
            if(option == JFileChooser.APPROVE_OPTION) {
                file1 = fileChooser.getSelectedFile();
                sdir1.setText(file1.getPath());
            }
        });
        // source directory 2
        JLabel sdir2lab = new JLabel("Second file:");
        JLabel sdir2 = new JLabel();
        JButton sdir2but = new JButton("Choose file");
        sdir2but.addActionListener((event) -> {
            JFileChooser fileChooser = new JFileChooser(
                    // default directory when opening file chooser
            );
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int option = fileChooser.showOpenDialog(new JFrame());
            if(option == JFileChooser.APPROVE_OPTION) {
                file2 = fileChooser.getSelectedFile();
                sdir2.setText(file2.getPath());
            }
        });
        // target directory
        JLabel tdirlab = new JLabel("Target directory:");
        JLabel tdir = new JLabel();
        JButton tdirbut = new JButton("Choose folder");
        tdirbut.addActionListener((event) -> {
            JFileChooser fileChooser = new JFileChooser(
                    // default directory when opening file chooser
            );
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int option = fileChooser.showOpenDialog(new JFrame());
            if(option == JFileChooser.APPROVE_OPTION) {
                folder = fileChooser.getSelectedFile();
                tdir.setText(folder.getPath());
            }
        });

        // buttons
        JButton rtrn = new JButton("Return");
        rtrn.addActionListener((event) -> {
            setVisible(false);
            (new mwin()).setVisible(true);
        });
        JButton run = new JButton("Merge");
        run.addActionListener((event) -> pdf.mergePDF(file1, file2, folder, nameinp.getText()));

        // create layout
        JPanel basepanel = new JPanel();
        basepanel.setLayout(new BoxLayout(basepanel, BoxLayout.Y_AXIS));

        // name panel
        namelab.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));                             // setting the borders
        nameinp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));
        JPanel namepanel = new JPanel(new BorderLayout(10,25));                                                  // new panel
        namepanel.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        namepanel.setLayout(new BoxLayout(namepanel, BoxLayout.X_AXIS));
        namepanel.add(namelab);
        namepanel.add(nameinp);
        namepanel.setMaximumSize(new Dimension(500, 1));
        basepanel.add(namepanel);                                                                                        // add new panel to base

        // source directory 1 panel
        sdir1lab.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        sdir1but.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        JPanel sdir1panel = new JPanel(new BorderLayout(0,0));
        sdir1panel.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        sdir1panel.add(sdir1lab, BorderLayout.WEST);
        sdir1panel.add(sdir1);
        sdir1panel.add(sdir1but, BorderLayout.EAST);
        basepanel.add(sdir1panel);

        // source directory 2 panel
        sdir2lab.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        sdir2but.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        JPanel sdir2panel = new JPanel(new BorderLayout(0,0));
        sdir2panel.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        sdir2panel.add(sdir2lab, BorderLayout.WEST);
        sdir2panel.add(sdir2);
        sdir2panel.add(sdir2but, BorderLayout.EAST);
        basepanel.add(sdir2panel);

        // target directory panel
        tdirlab.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        tdirbut.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        JPanel tdirpanel = new JPanel(new BorderLayout(0,0));
        tdirpanel.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        tdirpanel.add(tdirlab, BorderLayout.WEST);
        tdirpanel.add(tdir);
        tdirpanel.add(tdirbut, BorderLayout.EAST);
        basepanel.add(tdirpanel);

        // button panel
        run.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        JPanel buttonpanel = new JPanel();
        buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.X_AXIS));
        buttonpanel.add(rtrn);
        buttonpanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonpanel.add(run);
        basepanel.add(buttonpanel);
        basepanel.add(Box.createRigidArea(new Dimension(0,15)));

        add(basepanel);
    }

//    public static void main(String[] args) { (new merge_window()).setVisible(true); }
}