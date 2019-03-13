/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.LOencrypt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author UFG
 */
public class cArchive {
    
    String opFile=""; //Guarda ruta de apertura de archivo
    String svFile=""; //Guarda ruta de archivo guardado
    String rdFile=""; //Guarda datos de archivo leido
    String mfFile=""; //Guarda resultado de encriptado o desencriptado
    
    public void OpenArchive(){
        JFileChooser FC = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        
        int r = FC.showOpenDialog(null);
        
        if (r == JFileChooser.APPROVE_OPTION) {
            opFile = FC.getSelectedFile().getAbsolutePath();
        }
        else{
            opFile = "Ha ocurrido un error! Archivo no seleccionado";
        }   
    }
    
    public void SaveFile(){
        JFileChooser FC = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        
        int r = FC.showSaveDialog(null);
        
        if (r == JFileChooser.APPROVE_OPTION) {
            svFile = FC.getSelectedFile().getAbsolutePath();
        }
        else{
            svFile = "Ha ocurrido un error! Archivo no guardado";
        }   
    }

    public String getOpFile() {
        return opFile;
    }

    public void setOpFile(String opFile) {
        this.opFile = opFile;
    }

    public String getSvFile() {
        return svFile;
    }

    public void setSvFile(String svFile) {
        this.svFile = svFile;
    }

    public String getRdFile() {
        return rdFile;
    }

    public void setRdFile(String rdFile) {
        this.rdFile = rdFile;
    }

    public String getMfFile() {
        return mfFile;
    }

    public void setMfFile(String mfFile) {
        this.mfFile = mfFile;
    }
    
    public void ReadFile(){
        BufferedReader reader;
        try {
            Path path = Paths.get(opFile);
            reader = Files.newBufferedReader(path);
            
            StringBuilder sb = new StringBuilder (); // Concatenar lineas de archivo
            
            String line = reader.readLine(); //Lee la primera linea
            
            while ((line) != null){
                sb.append(line + " ");
                 
                line = reader.readLine();//Lea la siguiente linea
            }
            
            rdFile = sb.toString();
            rdFile = rdFile.substring(0, rdFile.length()-1); //Eliminar ultimo character que esta como espacio y no funciona con la decriptacion
            reader.close();
        } catch (IOException ex) {
            
        }
    }
    
    public void WriteFile(){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter (new FileWriter(svFile));
            writer.write(mfFile); //se selecciona el string que queremos escribir en el archivo.
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
