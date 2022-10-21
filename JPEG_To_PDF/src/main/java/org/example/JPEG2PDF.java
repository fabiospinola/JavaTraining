package org.example;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class JPEG2PDF {
    public static void main(String arg[]) throws Exception {
        File root = new File("images"); //pasta que contem as imagens para converter
        String outputFile = "output.pdf"; //ficheiro pdf vai ficar na mesma pasta
        List<String> files = new ArrayList<String>();

        //apenas faz a conversao de 3 imagens, têm de ter estes nomes estar dentro da pasta images
        files.add("page1.jpg");
        files.add("page2.jpg");
        files.add("page3.jpg");

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(new File(root, outputFile)));
        document.open();
        for (String f : files) {
            document.newPage();
            Image image = Image.getInstance(new File(root, f).getAbsolutePath());
            image.setAbsolutePosition(0, 0);
            image.setBorderWidth(0);
            image.scaleAbsolute(PageSize.A4);
            document.add(image);
        }
        document.close();
    }
}