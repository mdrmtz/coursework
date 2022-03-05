import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DesignerPDFViewerTest {

    @Test
    void designerPdfViewer() {
        int[] h = new int[]{1 ,3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] h2 = new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};

        Assertions.assertEquals(DesignerPDFViewer.designerPdfViewer(h, "abc"), 9);
        Assertions.assertEquals(DesignerPDFViewer.designerPdfViewer(h2, "zaba"), 28);
        Assertions.assertEquals(DesignerPDFViewer.designerPdfViewer(h2, "color"), 25);
        Assertions.assertEquals(DesignerPDFViewer.designerPdfViewer(h2, "foo"), 15);
    }
}