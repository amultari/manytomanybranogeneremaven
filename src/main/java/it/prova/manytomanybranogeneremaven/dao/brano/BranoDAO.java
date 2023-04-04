package it.prova.manytomanybranogeneremaven.dao.brano;

import java.util.List;

import it.prova.manytomanybranogeneremaven.dao.IBaseDAO;
import it.prova.manytomanybranogeneremaven.model.Brano;

public interface BranoDAO extends IBaseDAO<Brano>{
	
	public Brano findByIdFetchingGeneri(Long id) throws Exception;
	public List<String> loadListaDescrizioneGeneriAssociateAdUnGenere(Long idGenereInput) throws Exception;
	public void deleteGenereAndUnlinkGeneri(Long idGenereInput) throws Exception;

}
