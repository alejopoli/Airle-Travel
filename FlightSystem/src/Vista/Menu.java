package Vista;

import javax.swing.*;            // para los botones
import java.awt.*;               //Paquete que contiene imagenes y eventos "awt"
import java.awt.event.*;
import Vista.*;
import java.net.URL;

public class Menu extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    JLabel jlbAirlineTravel;
    JLabel jlbNombre, jlbCorreo, jlbimage;
    JLabel jlb_x1, jlb_x2;
    JButton jbtnInicio;
    JButton jbtnUsuarios;
    JButton jbtnAviones;
    JButton jbtnViajes;
    JButton jbtnVuelos;
    JButton jbtnReservas;
    JButton jbtnCerrarSesion;
    JButton jbtnPerfil;
    JButton jbtnAyuda;
    JPanel jpMovedor, jpInicio;
    Perfil jpPerfil = new Perfil();
    Usuarios jpUsuarios = new Usuarios();
    Aviones jpAviones = new Aviones();

    int x, y;
    Color a = Color.GRAY;
    Color b = Color.DARK_GRAY;
    Color c = Color.DARK_GRAY;
    Color d = Color.DARK_GRAY;
    Color e = Color.DARK_GRAY;
    Color f = Color.DARK_GRAY;
    Color g = Color.DARK_GRAY;
    Color h = Color.DARK_GRAY;

    MenuItem aboutItem, ayuda;
    MenuItem exitItem, exitItem2;
    MenuItem errorItem;
    MenuItem warningItem;
    MenuItem infoItem;
    MenuItem noneItem;
    PopupMenu displayMenu;

    ImageIcon image = new ImageIcon();

    PopupMenu popup = new PopupMenu();
    TrayIcon trayIcon = new TrayIcon(createImage("/Imagenes/icono.png", "tray icon"));
    SystemTray tray = SystemTray.getSystemTray();

    public Menu() {
        super.setTitle("Menu");
        super.setSize(882, 600);
        super.setLayout(null);
        super.setUndecorated(true);
        super.getContentPane().setBackground(Color.BLACK);
        super.setResizable(true);
        super.setLocationRelativeTo(null);
        super.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        this.setVisible(true);

        jlb_x1 = new JLabel("-");
        jlb_x1.setBounds(809, 20, 25, 25);
        jlb_x1.setForeground(Color.DARK_GRAY);
        jlb_x1.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        jlb_x1.addMouseListener(this);
        jlb_x1.setToolTipText("Minimizar");
        jlb_x1.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x1);

        jlb_x2 = new JLabel("x");
        jlb_x2.setBounds(839, 10, 20, 30);
        jlb_x2.setForeground(Color.DARK_GRAY);
        jlb_x2.setFont(new Font("Segoe UI", Font.PLAIN, 35));
        jlb_x2.addMouseListener(this);
        jlb_x2.setToolTipText("Cerrar");
        jlb_x2.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x2);

        jlbAirlineTravel = new JLabel("Airline Travel");
        jlbAirlineTravel.setBounds(290, 18, 150, 20);
        jlbAirlineTravel.setForeground(Color.BLACK);
        jlbAirlineTravel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        this.add(jlbAirlineTravel);

        jbtnInicio = new JButton("  Inicio");
        jbtnInicio.setBounds(0, 0, 180, 60);
        jbtnInicio.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Home-32.png")));
        jbtnInicio.setBorder(null);
        jbtnInicio.setBackground(a);
        jbtnInicio.setForeground(Color.WHITE);
        jbtnInicio.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnInicio.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnInicio.addMouseListener(this);
//        jbtnInicio.addActionListener(this);
        jbtnInicio.setFocusPainted(false);
        this.add(jbtnInicio);

        jbtnUsuarios = new JButton("  Usuarios");
        jbtnUsuarios.setBounds(0, 60, 180, 60);
        jbtnUsuarios.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/User-26.png")));
        jbtnUsuarios.setBorder(null);
        jbtnUsuarios.setBackground(b);
        jbtnUsuarios.setForeground(Color.WHITE);
        jbtnUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnUsuarios.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnUsuarios.addMouseListener(this);
//        jbtnUsuarios.addActionListener(this);
        jbtnUsuarios.setFocusPainted(false);
        this.add(jbtnUsuarios);

        jbtnAviones = new JButton("  Aviones");
        jbtnAviones.setBounds(0, 120, 180, 60);
        jbtnAviones.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Airport-26.png")));
        jbtnAviones.setBorder(null);
        jbtnAviones.setBackground(c);
        jbtnAviones.setForeground(Color.WHITE);
        jbtnAviones.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnAviones.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnAviones.addMouseListener(this);
//        jbtnAviones.addActionListener(this);
        jbtnAviones.setFocusPainted(false);
        this.add(jbtnAviones);

        jbtnViajes = new JButton("  Viajes");
        jbtnViajes.setBounds(0, 180, 180, 60);
        jbtnViajes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Trip-26.png")));
        jbtnViajes.setBorder(null);
        jbtnViajes.setBackground(d);
        jbtnViajes.setForeground(Color.WHITE);
        jbtnViajes.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnViajes.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnViajes.addMouseListener(this);
//        jbtnViajes.addActionListener(this);
        jbtnViajes.setFocusPainted(false);
        this.add(jbtnViajes);

        jbtnPerfil = new JButton("  Perfil");
        jbtnPerfil.setBounds(0, 180, 180, 60);
        jbtnPerfil.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Profile-26.png")));
        jbtnPerfil.setBorder(null);
        jbtnPerfil.setBackground(d);
        jbtnPerfil.setForeground(Color.WHITE);
        jbtnPerfil.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnPerfil.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnPerfil.addMouseListener(this);
        jbtnPerfil.setVisible(false);
//        jbtnViajes.addActionListener(this);
        jbtnPerfil.setFocusPainted(false);
        this.add(jbtnPerfil);

        jbtnVuelos = new JButton("  Vuelos");
        jbtnVuelos.setBounds(0, 240, 180, 60);
        jbtnVuelos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Flight-26.png")));
        jbtnVuelos.setBorder(null);
        jbtnVuelos.setBackground(e);
        jbtnVuelos.setForeground(Color.WHITE);
        jbtnVuelos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnVuelos.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnVuelos.addMouseListener(this);
//        jbtnVuelos.addActionListener(this);
        jbtnVuelos.setFocusPainted(false);
        this.add(jbtnVuelos);

        jbtnAyuda = new JButton("  Ayuda");
        jbtnAyuda.setBounds(0, 240, 180, 60);
        jbtnAyuda.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Help-26.png")));
        jbtnAyuda.setBorder(null);
        jbtnAyuda.setBackground(e);
        jbtnAyuda.setForeground(Color.WHITE);
        jbtnAyuda.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnAyuda.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnAyuda.addMouseListener(this);
        jbtnAyuda.setVisible(false);
//        jbtnVuelos.addActionListener(this);
        jbtnAyuda.setFocusPainted(false);
        this.add(jbtnAyuda);

        jbtnReservas = new JButton("  Reservas");
        jbtnReservas.setBounds(0, 300, 180, 60);
        jbtnReservas.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Reservation-26.png")));
        jbtnReservas.setBorder(null);
        jbtnReservas.setBackground(f);
        jbtnReservas.setForeground(Color.WHITE);
        jbtnReservas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnReservas.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnReservas.addMouseListener(this);
//        jbtnReservas.addActionListener(this);
        jbtnReservas.setFocusPainted(false);
        this.add(jbtnReservas);

        jbtnCerrarSesion = new JButton(" Cerrar Sesión");
        jbtnCerrarSesion.setBounds(0, 538, 180, 60);
        jbtnCerrarSesion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/Shutdown-26.png")));
        jbtnCerrarSesion.setBorder(null);
        jbtnCerrarSesion.setBackground(Color.DARK_GRAY);
        jbtnCerrarSesion.setForeground(Color.WHITE);
        jbtnCerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnCerrarSesion.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCerrarSesion.addMouseListener(this);
        jbtnCerrarSesion.addActionListener(this);
        jbtnCerrarSesion.setFocusPainted(false);
        this.add(jbtnCerrarSesion);

        JPanel jpBotones = new JPanel();
        jpBotones.setBackground(Color.DARK_GRAY);
        jpBotones.add(jbtnInicio);
        jpBotones.add(jbtnUsuarios);
        jpBotones.add(jbtnAviones);
        jpBotones.add(jbtnViajes);
        jpBotones.add(jbtnVuelos);
        jpBotones.add(jbtnReservas);
        jpBotones.add(jbtnCerrarSesion);
        jpBotones.add(jbtnPerfil);
        jpBotones.add(jbtnAyuda);
        jpBotones.setLayout(null);
        jpBotones.setBounds(1, 1, 180, 598);
        this.add(jpBotones);

        jpMovedor = new JPanel();
        jpMovedor.setOpaque(false);
        jpMovedor.setLayout(null);
        jpMovedor.add(jlb_x1);
        jpMovedor.add(jlb_x2);
        jpMovedor.add(jlbAirlineTravel);
        jpMovedor.setBounds(1, 1, 880, 60);
        jpMovedor.addMouseListener(this);
        jpMovedor.addMouseMotionListener(this);
        this.add(jpMovedor);

        jlbNombre = new JLabel("");
        jlbNombre.setBounds(222, 50, 300, 30);
        jlbNombre.setForeground(Color.BLACK);
        jlbNombre.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        this.add(jlbNombre);

        jlbCorreo = new JLabel("");
        jlbCorreo.setBounds(222, 80, 300, 30);
        jlbCorreo.setForeground(Color.BLACK);
        jlbCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.add(jlbCorreo);

        jlbimage = new JLabel("");
        jlbimage.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jlbimage.setBounds(55, 16, 150, 150);
        this.add(jlbimage);

        JLabel slider = new JLabel();
        slider.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        slider.setIcon(new ImageIcon(getClass().getResource("/Imagenes/slider.gif")));
        slider.setBounds(55, 210, 600, 300);
        this.add(slider);

        JLabel fondoI = new JLabel();
        fondoI.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wallpaper/Inicio.png")));
        fondoI.setBounds(0, 0, 700, 538);
        this.add(fondoI);

        jpInicio = new JPanel();
        jpInicio.setOpaque(false);
        jpInicio.setLayout(null);
        jpInicio.add(jlbNombre);
        jpInicio.add(jlbCorreo);
        jpInicio.add(jlbimage);
        jpInicio.add(slider);
        jpInicio.add(fondoI);
        jpInicio.setBounds(181, 61, 700, 538);
        this.add(jpInicio);

        this.add(jpUsuarios);
        this.add(jpAviones);
        this.add(jpPerfil);

        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wallpaper/Menu.png")));
        fondo.setBounds(0, 0, 882, 600);
        this.add(fondo);

        this.repaint();

        createSystemTray();
    }

    public static void main(String[] args) {
        Menu m = new Menu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtnCerrarSesion) {
            int i = JOptionPane.showConfirmDialog(null, "Esta seguro", "Cerrar Sesion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (JOptionPane.YES_OPTION == i) {
                this.setVisible(false);
                this.dispose();
                tray.remove(trayIcon);
                Login l = new Login();
            }
        }
        if (e.getSource() == aboutItem) {
            this.setVisible(true);
        }
        if (e.getSource() == trayIcon) {
            this.setVisible(true);
        }

        if (e.getSource() == exitItem2) {
            int i = JOptionPane.showConfirmDialog(null, "Esta seguro", "Cerrar Sesion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (JOptionPane.YES_OPTION == i) {
                this.setVisible(false);
                this.dispose();
                tray.remove(trayIcon);
                Login l = new Login();
            }
        }

        if (e.getSource() == exitItem) {
            int i = JOptionPane.showConfirmDialog(null, "Esta seguro", "Cerrar Aplicacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (JOptionPane.YES_OPTION == i) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        }
        if (e.getSource() == errorItem) {
            trayIcon.displayMessage("Flight System", "Memoria insuficiente", TrayIcon.MessageType.ERROR);
        }
        if (e.getSource() == warningItem) {
            trayIcon.displayMessage("Flight System", "This is a warning message", TrayIcon.MessageType.WARNING);
        }
        if (e.getSource() == infoItem) {
            trayIcon.displayMessage("Flight System", "Agregando nuevo Usuario", TrayIcon.MessageType.INFO);
        }
        if (e.getSource() == noneItem) {
            trayIcon.displayMessage("Flight System", "This is an ordinary message", TrayIcon.MessageType.NONE);
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if (arg0.getSource() == jpMovedor) {
            x = arg0.getX();
            y = arg0.getY();
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if (arg0.getSource() == jbtnInicio) {
            jbtnInicio.setBackground(a);
        }

        if (arg0.getSource() == jbtnUsuarios) {
            jbtnUsuarios.setBackground(b);
        }

        if (arg0.getSource() == jbtnAviones) {
            jbtnAviones.setBackground(c);
        }

        if (arg0.getSource() == jbtnViajes) {
            jbtnViajes.setBackground(d);
        }

        if (arg0.getSource() == jbtnVuelos) {
            jbtnVuelos.setBackground(e);
        }

        if (arg0.getSource() == jbtnReservas) {
            jbtnReservas.setBackground(f);
        }

        if (arg0.getSource() == jbtnPerfil) {
            jbtnPerfil.setBackground(g);
        }
        if (arg0.getSource() == jbtnAyuda) {
            jbtnAyuda.setBackground(h);
        }

        if (arg0.getSource() == jbtnCerrarSesion) {
            jbtnCerrarSesion.setBackground(Color.DARK_GRAY);
        }

        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(Color.DARK_GRAY);
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(Color.DARK_GRAY);
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        if (arg0.getSource() == jbtnInicio) {
            jbtnInicio.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnUsuarios) {
            jbtnUsuarios.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnAviones) {
            jbtnAviones.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnViajes) {
            jbtnViajes.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnVuelos) {
            jbtnVuelos.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnReservas) {
            jbtnReservas.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnPerfil) {
            jbtnPerfil.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnAyuda) {
            jbtnAyuda.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnCerrarSesion) {
            jbtnCerrarSesion.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(new Color(0, 154, 225));
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(new Color(0, 154, 225));
        }
    }

    @Override
    public void mouseClicked(MouseEvent ev) {
        if (ev.getSource() == jbtnInicio) {
            a = Color.GRAY;
            b = c = d = e = f = g = h = Color.DARK_GRAY;
            jbtnUsuarios.setBackground(b);
            jbtnAviones.setBackground(c);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnReservas.setBackground(f);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jpInicio.setVisible(true);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
        }

        if (ev.getSource() == jbtnUsuarios) {
            b = Color.GRAY;
            a = c = d = e = f = g = h = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnAviones.setBackground(c);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnReservas.setBackground(f);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jpInicio.setVisible(false);

            jpUsuarios.setVisible(true);
            jpUsuarios.LimpiarCampos();
            jpUsuarios.pnDatos.setVisible(false);
            jpUsuarios.jpBotones.setVisible(true);
            jpUsuarios.jpError.setVisible(true);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
        }

        if (ev.getSource() == jbtnAviones) {
            c = Color.GRAY;
            a = b = d = e = f = g = h = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnReservas.setBackground(f);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(true);
            
            jpAviones.LimpiarCampos();
            jpAviones.pnDatos.setVisible(false);
            jpAviones.jpBotones.setVisible(true);
            jpAviones.jpError.setVisible(true);
        }

        if (ev.getSource() == jbtnViajes) {
            d = Color.GRAY;
            a = b = c = e = f = g = h = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnAviones.setBackground(c);
            jbtnVuelos.setBackground(e);
            jbtnReservas.setBackground(f);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
        }

        if (ev.getSource() == jbtnVuelos) {
            e = Color.GRAY;
            a = b = c = d = f = g = h = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnViajes.setBackground(d);
            jbtnAviones.setBackground(c);
            jbtnReservas.setBackground(f);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
        }

        if (ev.getSource() == jbtnReservas) {
            f = Color.GRAY;
            a= b = c = d = e = g = h = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnAviones.setBackground(c);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnPerfil.setBackground(g);
            jbtnAyuda.setBackground(h);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
        }

        if (ev.getSource() == jbtnPerfil) {
            g = Color.GRAY;
            a= b = c = d = e = f = h = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnAviones.setBackground(c);
            jbtnReservas.setBackground(f);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnAyuda.setBackground(h);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(true);
            jpAviones.setVisible(false);
            jpPerfil.nombre.setText("Ninguna imagen seleccionada");
            jpPerfil.correo = jlbCorreo.getText();
        }

        if (ev.getSource() == jbtnAyuda) {
            h = Color.GRAY;
            a= b = c = d = e = f = g = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnAviones.setBackground(c);
            jbtnReservas.setBackground(f);
            jbtnViajes.setBackground(d);
            jbtnVuelos.setBackground(e);
            jbtnPerfil.setBackground(g);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpPerfil.setVisible(false);
            jpAviones.setVisible(false);
        }

        if (ev.getSource() == jlb_x1) {
            super.setState(JFrame.ICONIFIED);
        }

        if (ev.getSource() == jlb_x2) {
            super.setVisible(false);
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (me.getSource() == jpMovedor) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            this.setLocation(point.x - x, point.y - y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

    public void createSystemTray() {
        //si si soporta SystemTray
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
        } else {

            // Crear los componentes del popup menu
            aboutItem = new MenuItem("Abrir Interfaz de usuario de Flight System!");
            aboutItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
            aboutItem.addActionListener(this);

            exitItem2 = new MenuItem("Finalizar Sesion en Flight System");
            exitItem2.addActionListener(this);

            ayuda = new MenuItem("Ayuda");
            ayuda.addActionListener(this);

            exitItem = new MenuItem("Cerrar");
            exitItem.addActionListener(this);

            displayMenu = new PopupMenu("Mensajes");

            errorItem = new MenuItem("Error");
            errorItem.addActionListener(this);

            warningItem = new MenuItem("Warning");
            warningItem.addActionListener(this);

            infoItem = new MenuItem("Info");
            infoItem.addActionListener(this);

            noneItem = new MenuItem("None");
            noneItem.addActionListener(this);

            //añadimos los componentes popup menu
            popup.add(aboutItem);
            popup.add(exitItem2);
            popup.addSeparator();
            popup.add(displayMenu);
            displayMenu.add(errorItem);
            displayMenu.add(warningItem);
            displayMenu.add(infoItem);
            displayMenu.add(noneItem);
            popup.addSeparator();
            popup.add(ayuda);
            popup.add(exitItem);

            //propiedades del icono
            trayIcon.setPopupMenu(popup);
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Flight System");
            trayIcon.addActionListener(this);

            //verificar que si funcione
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.out.println("No se pudo agregar TrayIcon.");
                return;
            }
        }
    }

    //obtener la url de la image
    protected static Image createImage(String path, String description) {
        URL imageURL = Menu.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Imagen no encontrada: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }

}
