package com.bancoazteca.planlealtadweb.mercancias;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;
import org.apache.log4j.Logger;

public final class SambaFile {

	private static Logger log = Logger.getLogger(SambaFile.class);

	public static void subirArchivo(String remoteUrl,String localFilePath,String dominio,String usuario,String pass) {
		InputStream in = null;
		OutputStream out = null;
		try {
			File localFile = new File(localFilePath);
			String fileName = localFile.getName();
			NtlmPasswordAuthentication auth =null;

			auth = new NtlmPasswordAuthentication(dominio, usuario,pass);
			SmbFile remoteFile = new SmbFile(remoteUrl+"/"+fileName, auth);
			log.info(remoteFile);

			in = new BufferedInputStream(new FileInputStream(localFile));
			out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));
			byte[] buffer = new byte[1024];
			while(in.read(buffer)!=-1){
				out.write(buffer);
				buffer = new byte[1024];
			}
		} catch (Exception e) {

			log.error("Error al cerrar la conexion.", e);
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				log.error("Error al cerrar la conexion.", e);
				e.printStackTrace();
			}
		}
	}

	public static void eliminarArchivo(String remoteUrl,String localFilePath,String dominio,String usuario,String pass) {
		try {
			File localFile = new File(localFilePath);
			String fileName = localFile.getName();
			NtlmPasswordAuthentication auth =null;

			auth = new NtlmPasswordAuthentication(dominio, usuario,pass);
			SmbFile remoteFile = new SmbFile(remoteUrl+"/"+fileName, auth);
			remoteFile.delete();
		} catch (Exception e) {
			log.error("Error al cerrar la conexion.", e);
			e.printStackTrace();
		}
	}

	public static String listarArchivos(String remoteUrl,String dominio,String usuario,String pass){
		SmbFile[] lista=null;
		try {
			NtlmPasswordAuthentication auth =null;
			auth = new NtlmPasswordAuthentication(dominio, usuario,pass);
			SmbFile remoteFile = new SmbFile(remoteUrl, auth);
			lista = remoteFile.listFiles();
		} catch (SmbException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		String listaArchivos="";
		for(int ubicacion=0; ubicacion<lista.length; ubicacion++){
			listaArchivos+= lista[ubicacion].getName()+"\n";
		}
		return listaArchivos;
	}

	public InputStream bajarArchivo(String remoteUrl,String dominio,String usuario,String pass)throws FileNotFoundException,UnknownHostException{
		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(dominio,usuario,pass);
		SmbFile smbfile;
		try {
			smbfile = new SmbFile(remoteUrl, auth);
			try {
				InputStream inputStream=new SmbFileInputStream(smbfile);				
				return inputStream;
			}catch(SmbException e){
				log.info("No se encuentra el archivo.........."+e.getMessage());
				throw new FileNotFoundException("No se a podido encontrar el archivo: "+remoteUrl);
			}
		} catch (MalformedURLException e1){
			e1.printStackTrace();
		}
		return null;
	}
	
	public boolean comprobarArchivo(String remoteUrl,String dominio,String usuario,String pass)throws FileNotFoundException,UnknownHostException{
		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(dominio,usuario,pass);
		SmbFile smbfile;
		try {
			smbfile = new SmbFile(remoteUrl, auth);
			return smbfile.exists();
		} catch (MalformedURLException e1){
			e1.printStackTrace();
		}catch (SmbException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
