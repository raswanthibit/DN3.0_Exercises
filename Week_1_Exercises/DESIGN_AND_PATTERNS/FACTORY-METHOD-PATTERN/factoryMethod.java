
public abstract class Document {
    public abstract void open();
}

// Concrete Word document class
public class WordDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening a Word document.");
    }
}

// Concrete PDF document class
public class PdfDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening a PDF document.");
    }
}


public class ExcelDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening an Excel document.");
    }
}

public abstract class DocumentFactory {
    public abstract Document createDocument();
}


public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}


public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}


public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethodTest {
    public static void main(String[] args) {
        // Create a Word document using the factory method
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();  
        
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();  

       
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();  
    }
}
