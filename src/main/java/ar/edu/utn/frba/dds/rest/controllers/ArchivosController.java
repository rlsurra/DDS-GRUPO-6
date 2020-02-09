package ar.edu.utn.frba.dds.rest.controllers;

import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.utn.frba.dds.Autenticacion.Autenticacion;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import ar.edu.utn.frba.dds.exceptions.UserNotLoggedException;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping(path = "archivos")
public class ArchivosController {
	@PostMapping(consumes = "multipart/form-data")
	public void uploadFile(@RequestHeader("Authorization") String token,
			@RequestParam("prendaId") Integer prendaId,
			@RequestParam("photo") MultipartFile archivo) throws IOException, UserNotLoggedException {
		Autenticacion.getSession(token);
		if (archivo == null) {
			throw new ParametrosInvalidosException("Archivo de imagen no válido");
		}
		
		String[] splitNombre = archivo.getOriginalFilename().split("\\.");
		if(splitNombre.length < 2) {
			throw new ParametrosInvalidosException("Extensión de archivo inválida");
		}
		String serverFileName = "/public_html/img/" + prendaId + "." + splitNombre[splitNombre.length-1];
		System.out.println("Subiendo archivo: " + archivo.getOriginalFilename() + " como " + serverFileName);

		String server = "files.000webhost.com";
		int port = 21;
		String user = "ddsgrupo6";
		String pass = "grupo62019";

		FTPClient ftpClient = new FTPClient();

		try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
 
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            boolean done = ftpClient.storeFile(serverFileName, archivo.getInputStream());
            archivo.getInputStream().close();
            if (done) {
                System.out.println("Archivo subido correctamente.");
            }
            
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
