package DtoResponse;

import java.util.List;

public class CategoriaDTO {
	String nome;
	List<SottoCategoriaDTO> stcgDTO;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<SottoCategoriaDTO> getStcgDTO() {
		return stcgDTO;
	}
	public void setStcgDTO(List<SottoCategoriaDTO> stcgDTO) {
		this.stcgDTO = stcgDTO;
	}
	
	
}

