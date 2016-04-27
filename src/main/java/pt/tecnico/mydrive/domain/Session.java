package pt.tecnico.mydrive.domain;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.joda.time.*;

import pt.tecnico.mydrive.exception.*;


public class Session extends Session_Base {
 
	//ir para o dml
	private Map<String, String> env;
    
    public Session() {
        super();
		env = new HashMap<String, String>();
    }    
    
    /**
     * Funcao que verifica se a sessao e valida, ao verificar se a
     * data de inicio do TokenAcesso dado esta compreendida no intervalo
     * da data imediata (agora) e ha duas horas atras (agora -2 horas)
     * @param token
     * @return
     */
   
   public boolean validSession(MyToken token){
	   DateTime now = new DateTime();
		if (token.getInitialDate().isAfter(now.minusHours(2)))	
			return true;
		else
			return false;
   }
   
   /**
    * Funcao que verifica se um determinado utilizador, dado o seu token,
    * esta ainda em sessao, verificando se esta registado na sessao e se 
    * nao passaram 2 horas desde o seu ultimo acesso
    * @param token
    */
   public boolean inSessao(long token)
   {
   	for(MyToken mt : getMytokenSet())
   	{
   		if(mt.getToken() == (token))
   		{
   			if (validSession(mt))
   			{
   				mt.setInitialDate(new DateTime());
   				return true;
   			}
   			else
   				return false;
   		}
   	}
   	return false;
   }
   
   
   /**
    * Funcao que verifica se um determinado utilizador,
    * tem a sessao valida, verificando se esta registado na sessao e se 
    * nao passaram 2 horas desde o seu ultimo acesso
    * @param username
   */
   	public boolean inSession(User user) {
   		MyToken mt = user.getMytoken();
   		return validSession(mt);
  	}
   	
    public long createToken() {
    	return new BigInteger(64, new Random()).longValue();
    }
    
    
    /**
     * Cria uma sessao caso o username e a password estejam corretas.
     * @param username, password
     * @return
     */
    
    public MyToken createSession(String username, String password) throws WrongPasswordException {
	User user = getMyDrive().getUser(username);
	
	if(user.getPassword().equals(password)) {
		long token = createToken();
		MyToken mt = new MyToken(token, user);
		addMytoken(mt);
		env.put("user", getUserFromToken(token).getName());
		return mt;
	}
	else
	{
		throw new WrongPasswordException();
	}
	}

    /**
     * Dado um token, elimina a sessao correspondente a esse token.
     * @param token
     */
    public void removeSession(long token) {
    	for(MyToken mt : getMytokenSet()) {
    		if(mt.getToken() == token) {
    			mt.delete();
    			break;
    		}
    	}
    }
    
    /**
     * Esta funcao serve para eliminar da sessao todos os utilizadores 
     * que estao inactivos ha mais de duas horas
     */
    public void removeInactives() {
    	for(MyToken mt : getMytokenSet()) {
    		if(!validSession(mt)) {
    			mt.delete();
    		}
    	}
    }
    
    /**
     * Retorna um utilizador a partir do token correspondente a sua sessao. 
     * @param token
     * @return
     */
    public User getUserFromToken(long token) {
    	for(MyToken mt : getMytokenSet()) {
    		if(mt.getToken() == token && validSession(mt))
    			return mt.getUser();
    	}
    	return null;
    }
    
    public Directory getWorkDir(){ 
    	Directory dir = this.getWorkingdirectory();
    	return dir;
    }
    public Directory getDirectoryByPath(String path){ 
    	return getUserInSession().getMydrive().getDirectory().getDirectoryByPath(path);
    }
}
