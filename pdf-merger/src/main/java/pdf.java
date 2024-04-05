import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.swing.JOptionPane;
import java.io.File;
import java.time.LocalDateTime;

public class pdf {
    public static void mergePDF(File f1, File f2, File fl, String n) {
        if (f1 == null || f2 == null || fl == null) {
            JOptionPane.showMessageDialog(null,
                    "Archivo y/o carpetas no seleccionados.",
                    "Error de directorio",
                    JOptionPane.ERROR_MESSAGE);
        } else if (!f1.getAbsolutePath().endsWith(".pdf") || !f2.getAbsolutePath().endsWith(".pdf")) {
            JOptionPane.showMessageDialog(null,
                    "Formato de archivo no permitido.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            mergePDF_private(f1, f2, fl, n);
        }
    }

    private static void mergePDF_private(File f1, File f2, File fl, String n) {
        try {
            // create pdf variables
            PDDocument newdoc = new PDDocument();
            PDDocument pdf1 = PDDocument.load(f1);
            PDDocument pdf2 = PDDocument.load(f2);

            // loop: add pages
            for (int i = 0; i < pdf1.getNumberOfPages(); i++) {
                newdoc.importPage(pdf1.getPage(i));
                if (i == pdf1.getNumberOfPages()-1 && i == pdf2.getNumberOfPages()) { break; }
                PDPage np = pdf2.getPage(i);
                newdoc.importPage(np);
            }

            // save the new merged document to the indicated directory with the indicated name
            String name = n;
            if (name == null || n.equals("")) { name = LocalDateTime.now().toString(); }
            name = name.replace(":", "-");
            String dir = fl.getAbsolutePath();
            if (!dir.endsWith("\\")) { dir = dir + "\\"; }
            newdoc.save(dir + name + ".pdf");
            newdoc.close();

            // convert succesfull -> show dialog
            JOptionPane.showMessageDialog(null,
                    "Archivo creado con éxito.",
                    "Archivo creado con éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Error al crear el archivo.\nIntente de nuevo.",
                    "Error al crear el archivo",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void reorderPDF(File f, File fl, String n) {
        if (f == null || fl == null) {
            JOptionPane.showMessageDialog(null,
                    "Archivo y/o carpetas no seleccionados.",
                    "Error de directorio",
                    JOptionPane.ERROR_MESSAGE);
        } else if (!f.getAbsolutePath().endsWith(".pdf")) {
            JOptionPane.showMessageDialog(null,
                    "Formato de archivo no permitido.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            reorderPDF_private(f, fl, n);
        }
    }

    private static void reorderPDF_private(File f, File fl, String n) {
        try {
            // pdf variables
            PDDocument newdoc = new PDDocument();
            PDDocument pdf = PDDocument.load(f);

            // loop: copying pages in the correct order
            Integer mid = (int) Math.ceil((double) pdf.getNumberOfPages()/2);
            Integer np = pdf.getNumberOfPages();
            for (int i = 0; i <= mid; i++) {
                if (i == mid && pdf.getNumberOfPages()%2 == 0) { break; }
                newdoc.importPage(pdf.getPage(i));
                if (mid+i > pdf.getNumberOfPages()-1) { break; }
                newdoc.importPage(pdf.getPage(mid+i));
            }

            // save new reordered pdf to the designated folder with the designated name
            String name = n;
            if (name == null || n.equals("")) { name = LocalDateTime.now().toString(); }
            name = name.replace(":", "-");
            String dir = fl.getAbsolutePath();
            if (!dir.endsWith("\\")) { dir = dir + "\\"; }
            newdoc.save(dir + name + ".pdf");
            newdoc.close();

            // convert succesfull -> show dialog
            JOptionPane.showMessageDialog(null,
                    "Archivo creado con éxito.",
                    "Archivo creado con éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Error al crear el archivo.\nIntente de nuevo.",
                    "Error al crear el archivo",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
