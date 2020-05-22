package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioArchivos;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
@RequestMapping(value="/perfil")
public class ControladorPerfil {
	
	private ServicioArchivos servicioArchivos;
	private ServicioLogin servicioLogin;

	@Autowired
	public ControladorPerfil(ServicioArchivos servicioArchivos, ServicioLogin servicioLogin){
		this.servicioLogin = servicioLogin;
		this.servicioArchivos = servicioArchivos;
	}
		 
	 @RequestMapping(path = "/cargar-foto", method = RequestMethod.GET)
		public ModelAndView irACargarFoto() {
			return new ModelAndView("perfil/cargar-foto");
		}


	 @RequestMapping(value = "/cargar-foto", method = RequestMethod.POST)
	 public ModelAndView cargarFoto(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
       
    	String path = request.getSession().getServletContext().getRealPath("/files/");
        System.out.println(path);          
        Usuario usuario = servicioLogin.obtenerUsuarioConectado(request);
        
        if (usuario != null) {
        	Album albumDePerfil = servicioArchivos.buscarOCrearAlbumDePerfil(usuario);
            
            if (albumDePerfil != null) {
            	if( servicioArchivos.guardarImagen(file, path, albumDePerfil) ) {
                	ModelMap modelo = new ModelMap();
        			modelo.put("msj","imagen cargada correctamente");
        			return new ModelAndView("perfil/cargar-foto",modelo);
                }        	
            }           	
        }            
        
    	ModelMap modelo = new ModelMap();
		modelo.put("msj","Error al cargar imagen");
		return new ModelAndView("perfil/cargar-foto",modelo);
	  
	 }
	 
	 
}
