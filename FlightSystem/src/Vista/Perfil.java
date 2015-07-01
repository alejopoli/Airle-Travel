package Vista;

import Entidades.UsuarioEnt;
import Negocio.UsuarioNg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Perfil extends JPanel implements ActionListener {

    JButton jbtnGuardar, jbtnCargarI, jbtnQuitarI;
    JLabel jlbimage, nombre;
    String x = null;
    String correo;
    BufferedImage bmp = null, algo;
    ImageIcon image = new ImageIcon();
    
    public Perfil() {
        super.setBounds(181, 61, 700, 538);  //(ancho,alto)
        super.setLayout(null);
        super.setOpaque(false);
        super.setVisible(false);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        jbtnGuardar = new JButton("Guardar Cambios");
        jbtnGuardar.setBounds(55, 457, 150, 40);
        jbtnGuardar.addActionListener(this);
        jbtnGuardar.setBorder(null);
        jbtnGuardar.setBackground(new Color(0, 154, 225));
        jbtnGuardar.setForeground(Color.WHITE);
        jbtnGuardar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jbtnGuardar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnGuardar.setFocusPainted(false);
        this.add(jbtnGuardar);

        nombre = new JLabel("Ninguna imagen seleccionada");
        nombre.setBounds(210, 250, 200, 40);
        nombre.setForeground(Color.GRAY);
        this.add(nombre);

        jbtnCargarI = new JButton("Cargar imagen");
        jbtnCargarI.setBounds(55, 250, 150, 40);
        jbtnCargarI.addActionListener(this);
        jbtnCargarI.setBorder(null);
        jbtnCargarI.setBackground(new Color(0, 154, 225));
        jbtnCargarI.setForeground(Color.WHITE);
        jbtnCargarI.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jbtnCargarI.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCargarI.setFocusPainted(false);
        this.add(jbtnCargarI);

        jbtnQuitarI = new JButton("Quitar imagen");
        jbtnQuitarI.setBounds(55, 186, 150, 40);
        jbtnQuitarI.addActionListener(this);
        jbtnQuitarI.setBorder(null);
        jbtnQuitarI.setBackground(new Color(0, 154, 225));
        jbtnQuitarI.setForeground(Color.WHITE);
        jbtnQuitarI.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jbtnQuitarI.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnQuitarI.setFocusPainted(false);
        this.add(jbtnQuitarI);

        jlbimage = new JLabel();
        jlbimage.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jlbimage.setBounds(55, 46, 150, 150);
        this.add(jlbimage);

        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbtnCargarI) {

            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                System.err.println(ex);
            }

            //Creamos un nuevo cuadro de diálogo para seleccionar imagen
            JFileChooser selector = new JFileChooser();
            //Le damos un título
            selector.setDialogTitle("Seleccione una imagen");
            //Filtramos los tipos de archivos
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
            selector.setFileFilter(filtroImagen);
            //Abrimos el cuadro de diálog
            int flag = selector.showOpenDialog(null);
            //Comprobamos que pulse en aceptar
            if (flag == JFileChooser.APPROVE_OPTION) {
                try {
                    //Devuelve el fichero seleccionado
                    File imagenSeleccionada = selector.getSelectedFile();
                    //sacamos el nombre de la imagen
                    x = imagenSeleccionada.getName();
                    //Asignamos a la variable bmp la imagen leida
                    bmp = ImageIO.read(imagenSeleccionada);
                } catch (Exception e) {
                    System.out.print("El error es: " + e);
                }
                image.setImage(bmp);
                jlbimage.setIcon(new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
                nombre.setText(x);
            }

            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        if (ae.getSource() == jbtnGuardar) {
            UsuarioEnt usuarioE = new UsuarioEnt();
            UsuarioNg usuarioN = new UsuarioNg();
            usuarioE.setDocumento(correo);
            usuarioE.setImage(bmp);
            boolean respuesta = usuarioN.modificarImagen(usuarioE);
            if (respuesta) {
                nombre.setText("Ninguna imagen seleccionada");
                JOptionPane.showMessageDialog(null, "Se guardo la imagen", "Airline Travel", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (ae.getSource() == jbtnQuitarI) {
            jlbimage.setIcon(new ImageIcon(getClass().getResource("/Imagenes/defecto.png")));
            bmp = null;
            nombre.setText("Ninguna imagen seleccionada");
            x = null;
        }

    }

}
