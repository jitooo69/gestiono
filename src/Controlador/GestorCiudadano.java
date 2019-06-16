package Controlador;

import Model.Tramite;
import Vista.LoginView;
import java.net.Socket;
import javax.swing.JOptionPane;
import Model.Tupla;
import Model.Usuario;
import Vista.ListaTramitesView;
import com.google.gson.Gson;
import Vista.RegistroView;
import Vista.TramiteView;
import Vista.Vista;
import java.awt.List;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.json.JSONArray;
import org.json.JSONException;

public class GestorCiudadano implements OyenteVista{
    
    private LoginView loginView;
    private RegistroView registroView;
    private TramiteView tramiteView;
    private Socket socket;
    private Conexion con;
    private String user, password, nombre, apellidos, email, dni;
    private Gson gson;
    private Vista vistaActual;
    private ListaTramitesView listaTramitesView;
    private Usuario usuario;
    private PublicKey publicKey;
		
        public GestorCiudadano(String[] args) {
            con = new Conexion();
            gson = new Gson();
            
            cambiarVista(1); //CAMBIAR LUEGO A 11111111111111111111111
            //loginView = new LoginView(this);
            //Si no tiene conexion ni entra, finaliza.
            if (!con.estado()){
               JOptionPane.showMessageDialog(null, "Error de conexión.");
               //System.exit(0);
            }
        }
        
        public void generarParClaves() throws NoSuchAlgorithmException, 
                NoSuchProviderException, IOException, SignatureException, InvalidKeyException{
            
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(1024, random);

            /* GENERAMOS EL PAR DE LLAVES PÚBLICA Y PRIVADA */
            KeyPair pair = keyGen.generateKeyPair();
            
            PrivateKey privateKey = pair.getPrivate();
            publicKey = pair.getPublic();
            Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");

            dsa.initSign(privateKey);

            /* Guardamos la llave pública en un fichero */
            byte[] key = publicKey.getEncoded();
            FileOutputStream fileKeyOut = new FileOutputStream("publicKey");
            fileKeyOut.write(key);
            fileKeyOut.close();
            System.out.println(base64(new File("key")));

            /* Guardamos llave privada */
            byte[] privateKeyBytes = privateKey.getEncoded();
            FileOutputStream fileKeyPrivOut = new FileOutputStream("privateKey");
            fileKeyPrivOut.write(privateKeyBytes);
            fileKeyPrivOut.close();
            System.out.println(base64(new File("privateKey")));
            
            /* FIRMA */
            byte[] dsaBytes = privateKey.getEncoded();
            FileOutputStream fileKeyDsaOut = new FileOutputStream("dsa");
            fileKeyDsaOut.write(dsaBytes);
            fileKeyDsaOut.close();
            System.out.println(base64(new File("privateKey")));
        }
        
        //PARA PASAR A BASE64
        private String base64(File fichero) {

            try(FileReader fr = new FileReader(fichero)){
                String cadena="";
                int valor = fr.read();
                while(valor != -1){
                    cadena = cadena+(char)valor;
                    valor = fr.read();
                }
                //jLabel7.setText(fichero.getName());//Set name to label
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return toBase64(fichero);
        }
        
      private String toBase64(File file) {
        
        byte[] fileArray = new byte[(int) file.length()];
        InputStream inputStream;
        String encodedFile = "";
        String encoded = null;
                
        try {
            inputStream = new FileInputStream(file);
            inputStream.read(fileArray);
            encoded = Base64.getEncoder().encodeToString(fileArray);
        } catch (Exception e) {}
        //System.out.println(encoded);

        return encoded;
    }
        
         private void cambiarVista(int numVista){
             if(vistaActual != null){
                 vistaActual.ocultar();
             }

             switch(numVista){
                 case 1: //Pantalla de login
                     loginView = new LoginView(this);
                     vistaActual = loginView;
                     break;
                 case 2: //Registrar
                     registroView = new RegistroView(this);
                     vistaActual = registroView;
                     break;
                 case 3: //Nuevo tramite View
                     tramiteView = new TramiteView(this);
                     vistaActual = tramiteView;
                     break;
                 case 4: //Lista de trámites
                     System.out.println("0");
                     listaTramitesView = new ListaTramitesView(this);
                     vistaActual = listaTramitesView;
                     recibirDatosTabla();
                     listaTramitesView.mostrar();
                     System.out.println("EA");
                     break;
             }
         }
         
private void recibirDatosTabla() {
    con.enviar("LISTAR_TRAMITES");
    //con.enviar(gson.toJson(usuario));
    con.enviar("");//True
    String respuesta = con.respuesta();
    
    //System.out.println("RESP "+respuesta);
    
    
    //Gson test = new Gson();
    
    ArrayList<Tramite> lista = new ArrayList<>();//= .fromJson(respuesta, ArrayList.class);
    
    //System.out.println("ATRRAY "+lista);
    
    JSONArray arr = null;
    String asunto = "", departamento = "", fecha = "";
    int id_tramite = 0, estado = 0;
        try {
            arr = new JSONArray(respuesta);
        } catch (JSONException ex) {
            Logger.getLogger(GestorCiudadano.class.getName()).log(Level.SEVERE, null, ex);
        }
    ArrayList<Tramite> list = new ArrayList<>();
    
    for(int i = 0; i < arr.length(); i++){
        try {
            id_tramite = (int)arr.getJSONObject(i).get("id_tramite");
            asunto = (String)arr.getJSONObject(i).get("asunto");
            departamento = (String)arr.getJSONObject(i).get("departamento");
            fecha = (String)arr.getJSONObject(i).get("fecha");
            estado = (int)arr.getJSONObject(i).get("asignado");
        } catch (JSONException ex) {
            Logger.getLogger(GestorCiudadano.class.getName()).log(Level.SEVERE, null, ex);
        }
        lista.add(new Tramite(id_tramite, asunto, departamento, fecha, estado));
    }
    
    listaTramitesView.construirTabla(lista);
}
public String login(String usr, String password){
    con.enviar("LOGIN");
    usuario = new Usuario(usr, password, 1); //1 -> Ciudadano
    String datosLogin = gson.toJson(usuario);
    con.enviar(datosLogin);
    
    return con.respuesta();
}

public boolean registro(String nombre, String apellidos, String DNI, String contrasenya, String email){
    con.enviar("REGISTRO");
    Usuario user = new Usuario(nombre, apellidos, DNI, contrasenya, email);//Nuevo Ciudadano
    String datosRegistro = gson.toJson(user);
    con.enviar(datosRegistro);
    //Recibimos la firma y la clave privada del usuario que se acaba de registrar
    
    return Boolean.parseBoolean(con.respuesta());
}

public boolean registrarTramite(int id_tramite, String dni_ciudadano, String asunto, String descripcion, String departamento,
            String fecha, int asignado, String[] adjuntos) {
    con.enviar("INICIAR_TRAMITE");
    Tramite tramite = new Tramite(id_tramite, dni_ciudadano, asunto, descripcion, departamento, fecha.toString(), 0, adjuntos);//Nuevo Ciudadano
    String datosTramite = gson.toJson(tramite);
    con.enviar(datosTramite);
    //Recibimos la firma y la clave privada del usuario que se acaba de registrar
    
    return Boolean.parseBoolean(con.respuesta());
}

public void notificacion(Evento evento, Object obj) {
	switch (evento) {
		case LOGIN: 
			    user = (String)((Tupla) obj).a;
			    password = (String)((Tupla) obj).b;
                            if(login(user, password).equals("true")){
                                loginView.ocultar();
                                cambiarVista(4);//Nuevo Trámite View
                            } 
                            //cambiarVista(3);//QUITAR DESPUES
                	    break;
                	    
		case REGISTRO:
		    		cambiarVista(2);//Registro View
		    		break;
                                
                case NUEVO_REGISTRO_USUARIO:
                                nombre = (String)((Tupla) obj).a;
                                apellidos = (String)((Tupla) obj).b;
                                dni = (String)((Tupla) obj).c;
                                email = (String)((Tupla) obj).d;
                                password = (String)((Tupla) obj).e;
                                
                                if(registro(nombre, apellidos, dni, password, email)) {
                                    //GENERAR CLAVES
                                    try {
                                        generarParClaves();
                                    } catch (NoSuchAlgorithmException ex) {
                                        Logger.getLogger(GestorCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (NoSuchProviderException ex) {
                                        Logger.getLogger(GestorCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(GestorCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SignatureException ex) {
                                        Logger.getLogger(GestorCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (InvalidKeyException ex) {
                                        Logger.getLogger(GestorCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    
                                    JOptionPane.showMessageDialog(null, "Registro completado con éxito.");
                                    vistaActual.ocultar();
                                    cambiarVista(1);//Una vez registrado a pantalla login
                                } else {
                                    JOptionPane.showMessageDialog(null, "Usuario ya existente.");
                                }
                                break;
                case EXIT: 
                                System.exit(0);
                                
                case PANTALLA_LOGIN: vistaActual.ocultar();
                                     cambiarVista(1);
                                     break;
                                     
                case REGISTRAR_TRAMITE: 
                                    vistaActual.ocultar();
                                    cambiarVista(3);
                                    String asunto = (String)((Tupla) obj).a;
                                    String descripcion = (String)((Tupla) obj).b;
                                    String departamento = (String)((Tupla) obj).c;
                                    String[] adjuntos = new String[4];
                                    //adjuntos = (String[])((Tupla) obj).d;
                                    adjuntos[0] = null;adjuntos[1] = null;adjuntos[2] = null;adjuntos[3] = null;
                                    Date fecha = new Date();
                                    
                                    if(registrarTramite(0, "", asunto, descripcion, 
                                            departamento, fecha.toString(), 0, adjuntos)) {
                                        JOptionPane.showMessageDialog(null, "Trámite registrado con éxito.");
                                        //cambiarVista(X);
                                    }
                                    JOptionPane.showMessageDialog(null, "Error al registrar el trámite.");
                                     break;
	}
	
    }

    public static void main(String[] args) {
        new GestorCiudadano(args);
    }

}
