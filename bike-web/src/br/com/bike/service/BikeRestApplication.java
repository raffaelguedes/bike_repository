package br.com.bike.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.bike.service.perfil.GerenciadorPerfilBean;

/**
 * TODAS CLASSES DE IMPLEMENTA��O REST. 
 * REGISTRANDO DESTA FORMA PARA QUE N�O QUEBRE OS .HTML, .JPG(ARQUIVOS ESTATICOS)
 * @author Raffa
 *
 */
public class BikeRestApplication extends Application {

	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(GerenciadorPerfilBean.class);
        return classes;
    }
}
