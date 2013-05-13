package br.com.bike.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


/**
 * TODAS CLASSES DE IMPLEMENTAÇÃO REST. 
 * REGISTRANDO DESTA FORMA PARA QUE NÃO QUEBRE OS .HTML, .JPG(ARQUIVOS ESTATICOS)
 * @author Raffa
 *
 */
public class BikeRestApplication extends Application {

	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(GerenciadorPerfilBean.class);
        classes.add(GerenciadorRoteiroBean.class);
        return classes;
    }
}
