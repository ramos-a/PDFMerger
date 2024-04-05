import java.io.File;

public class pdf_test {
    public static void main(String[] args) {
        File fldr = new File("C:\\Users\\albar\\Documents\\java projects\\PDFMerger\\pdf-merger\\src\\test\\pdf\\");

        // reorder
        File reorder_even = new File("C:\\Users\\albar\\Documents\\java projects\\PDFMerger\\pdf-merger\\src\\test\\pdf\\reorder even.pdf");
        File reorder_odd = new File("C:\\Users\\albar\\Documents\\java projects\\PDFMerger\\pdf-merger\\src\\test\\pdf\\reorder odd.pdf");

        // even
//        pdf.reorderPDF(reorder_even, fldr, "test_reorder");
        // odd
        pdf.reorderPDF(reorder_odd, fldr, "test_reorder");
        System.out.println(Math.ceil((double) 5/2) + "\n" + Math.ceil(2.5) + "\n" + (double) 5/2);

        // merge
        File merge_even = new File("C:\\Users\\albar\\Documents\\java projects\\PDFMerger\\pdf-merger\\src\\test\\pdf\\merge even.pdf");
        File merge_odd = new File("C:\\Users\\albar\\Documents\\java projects\\PDFMerger\\pdf-merger\\src\\test\\pdf\\merge odd.pdf");
        File merge = new File("C:\\Users\\albar\\Documents\\java projects\\PDFMerger\\pdf-merger\\src\\test\\pdf\\merge.pdf");

        // even
//        pdf.mergePDF(merge_even, merge, fldr, "test_merge");
        // odd
//        pdf.mergePDF(merge_odd, merge, fldr, "test_merge");
    }
}
