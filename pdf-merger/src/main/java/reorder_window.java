import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

public class reorder_window extends JFrame {
    private static File file;
    private static File folder;

    public reorder_window() {
        initUI();
    }

    private void initUI() {
        // creamos la ventana principal
        setTitle("Reorder");
        setSize(600, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // new document title
        JLabel namelab = new JLabel("Name of the new file: ");
        JTextArea nameinp = new JTextArea();

        // directories
        // source directory
        JLabel sdirlab = new JLabel("File:");
        JLabel sdir = new JLabel();
        JButton sdirbut = new JButton("Choose file");
        sdirbut.addActionListener((event) -> {
            JFileChooser fileChooser = new JFileChooser(
                    // default directory when opening file chooser
            );
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int option = fileChooser.showOpenDialog(new JFrame());
            if(option == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                sdir.setText(file.getPath());
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
        JButton run = new JButton("Reorder");
        run.addActionListener((event) -> pdf.reorderPDF(file, folder, nameinp.getText()));

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

        // source directory panel
        sdirlab.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        sdirbut.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        JPanel sdirpanel = new JPanel(new BorderLayout(0,0));
        sdirpanel.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        sdirpanel.add(sdirlab, BorderLayout.WEST);
        sdirpanel.add(sdir);
        sdirpanel.add(sdirbut, BorderLayout.EAST);
        basepanel.add(sdirpanel);

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
}
