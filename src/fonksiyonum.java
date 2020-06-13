
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class fonksiyonum {
    public ImageIcon resimBoyutu(String resimPath, byte[] BLOBresim, int genislik, int yukseklik){
        ImageIcon icon;
        
        if(resimPath !=null){// atılan değer varsa
            icon = new ImageIcon(resimPath);// uzantıdaki resmi icon olarak al
        }
        else{
            icon = new ImageIcon(BLOBresim);//vt çekerken blob bite olarak çekecek
        }
        Image image = icon.getImage().getScaledInstance(genislik, yukseklik, Image.SCALE_SMOOTH);//iconun resmini al 
        ImageIcon resimim = new ImageIcon(image);
        
        return resimim;
        
    }
    public String resimSec(JLabel label){//resmin pathini dondurecek
        String path = "";
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("C:\\Users\\apoha\\Pictures\\Saved Pictures"));
        
        FileNameExtensionFilter fileNameExtensionFilter =new FileNameExtensionFilter("Resim", "jpg","png","gif");// uzantılar varsa görse
        chooser.addChoosableFileFilter(fileNameExtensionFilter);
        
        int i = chooser.showSaveDialog(null);
        
        if (i == JFileChooser.APPROVE_OPTION) {//seçilen değere eşitse
            File secilen = chooser.getSelectedFile();
            path=secilen.getAbsolutePath();
            
            label.setIcon(resimBoyutu(path, null, label.getWidth(), label.getHeight()));//path oldugu için zaten null döndürdük yükseklikve genislik aldık labela atadık
            
        }
        else if (i == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "HERHANGİ BİR RESİM SEÇİLMEDİ...");
        }
        return path;
    }
}
