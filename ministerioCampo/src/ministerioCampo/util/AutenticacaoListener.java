package ministerioCampo.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.omnifaces.util.Faces;

import ministerioCampo.bean.AutenticacaoBean;
import ministerioCampo.dominio.Usuario;

@SuppressWarnings("serial")
public class AutenticacaoListener implements PhaseListener{

	@Override
	public void afterPhase(PhaseEvent event) {
		// depois
		String paginaActual = Faces.getViewId();
		
		boolean ehPaginaDeAutenticacao = paginaActual.contains("autenticacao.xhtml");
		
		if(!ehPaginaDeAutenticacao) {
			//Pega o managed bean
			AutenticacaoBean autenticacaoBean = Faces.getSessionAttribute("autenticacaoBean");
		
		if(autenticacaoBean == null) {
			Faces.navigate("/pages/autenticacao.xhtml");
			return;
			}
			Usuario uso = autenticacaoBean.getUsoLogado();
			if(uso == null) {
				Faces.navigate("/pages/autenticacao.xhtml");
				return;
			}
		}
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// 
		//System.out.println("ANTES DA FASE " + event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		// Qual a fase ESTA sendo ouvida
		return PhaseId.RESTORE_VIEW;
	}	

	
}
