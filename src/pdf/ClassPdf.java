/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pdf;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import entidades.Persona;
import java.io.File;
//import entidades.Persona;
//import entidades.Natural;

import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Jsmith
 */
public class ClassPdf {

    private String ruta;
    private ArrayList<Persona> personas;

    public ClassPdf(ArrayList<Persona> personas) {
        ruta = "personas.pdf";
        this.personas = personas;
    }
    
    public void crearPdf(){
        try {
            if(new File("personas.pdf").exists()){
                new File("personas.pdf").delete();
            }
            Document documento = new Document();

            PdfWriter.getInstance(documento, new FileOutputStream(getRuta()));

            Image header = Image.getInstance("src/imageness/header.png");
            header.scaleToFit(600, 900);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Formato creado por La Geekipedia de Jonathan © \n\n");
            parrafo.setFont(FontFactory.getFont("Sitka Text", 16, Font.BOLD, BaseColor.RED));
            parrafo.add("Reporte De Registros \n\n");
            parrafo.add("\n");
            documento.open();
            documento.add(header);

            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            //Datos del ancho de cada columna.
            tabla.setWidths(new float[]{25, 20, 12, 15, 33});
            Paragraph cabecera = new Paragraph("Apellido");
            cabecera.getFont().setColor(BaseColor.BLACK);
            cabecera.getFont().setStyle(Font.BOLD);
            cabecera.setAlignment(Paragraph.ALIGN_CENTER);
            
            tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(new Paragraph(cabecera));
           // tabla.addCell(new Paragraph("Apellido", FontFactory.getFont("Sitka Text", 14, Font.BOLD, BaseColor.BLACK)));
            tabla.addCell(new Paragraph("Nombre", FontFactory.getFont("Sitka Text", 14, Font.BOLD, BaseColor.BLACK)));
            tabla.addCell(new Paragraph("Tel.Fijo",FontFactory.getFont("Sitka Text", 14,Font.BOLD,BaseColor.BLACK)));
            tabla.addCell(new Paragraph("Tel.Celular",FontFactory.getFont("Sitka Text", 14,Font.BOLD,BaseColor.BLACK)));
            tabla.addCell(new Paragraph("Correo",FontFactory.getFont("Sitka Text", 14,Font.BOLD,BaseColor.BLACK)));
            
            for (int i = 0; i < personas.size(); i++) {

                    tabla.addCell(personas.get(i).getApellido());
                    tabla.addCell(personas.get(i).getNombre());
                    tabla.addCell(personas.get(i).getTelefonoFijo());
                    tabla.addCell(personas.get(i).getTelefonoCel());
                    tabla.addCell(personas.get(i).getCorreo());

            }
            documento.add(tabla);
            documento.close();
            JOptionPane.showMessageDialog(null, "Abriendo pdf...");
            String url = getRuta();
            ProcessBuilder p = new ProcessBuilder();
            p.command("cmd.exe", "/c", url);
            p.start();

        } catch (Exception e) {
            System.out.println(""+e);
        }

    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;

    }
    
}
