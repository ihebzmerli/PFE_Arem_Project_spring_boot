package com.loizenai.jwtauthentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {
	
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/acheteur")
	@PreAuthorize("hasRole('ACHETEUR') or hasRole('ADMIN')")
	public String AcheteurManagementAccess() {
		return ">>> ACHETEUR Board";
	}
	
	@GetMapping("/api/test/transitaire")
	@PreAuthorize("hasRole('TRANSITAIRE') or hasRole('ADMIN')")
	public String TransitaireManagementAccess() {
		return ">>> Transitaire Management Board";
	}
	@GetMapping("/api/test/client")
	@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN')")
	public String ClientManagementAccess() {
		return ">>> Client Management Board";
	}
	@GetMapping("/api/test/vendeur")
	@PreAuthorize("hasRole('VENDEUR') or hasRole('ADMIN')")
	public String VendeurManagementAccess() {
		return ">>> Vendeur Management Board";
	}
	@GetMapping("/api/test/decideur_bp")
	@PreAuthorize("hasRole('DECIDEUR_BP') or hasRole('ADMIN')")
	public String Decideur_bpManagementAccess() {
		return ">>> Decideur_bp Management Board";
	}
	@GetMapping("/api/test/agent_cab")
	@PreAuthorize("hasRole('AGENT_CAB') or hasRole('ADMIN')")
	public String Agent_cabManagementAccess() {
		return ">>> Agent_cab Management Board";
	}
	@GetMapping("/api/test/pm")
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
	public String ProjectManagementAccess() {
		return ">>> Project Management Board";
	}
	@GetMapping("/api/test/preparateur_br")
	@PreAuthorize("hasRole('PREPARATEUR_BR') or hasRole('ADMIN')")
	public String Preparateur_brManagementAccess() {
		return ">>> Preparateur_br Management Board";
	}
	@GetMapping("/api/test/responsable_dispatching_bp")
	@PreAuthorize("hasRole('RESPONSABLE_DISPATCHING_BP') or hasRole('ADMIN')")
	public String Responsable_dispatching_bpManagementAccess() {
		return ">>> Responsable_dispatching_bp Management Board";
	}
	@GetMapping("/api/test/preparateur")
	@PreAuthorize("hasRole('PREPARATEUR') or hasRole('ADMIN')")
	public String PreparateurManagementAccess() {
		return ">>> Preparateur Management Board";
	}
	@GetMapping("/api/test/validateur_de_chariot")
	@PreAuthorize("hasRole('VALIDATEUR_DE_CHARIOT') or hasRole('ADMIN')")
	public String Validateur_de_chariotManagementAccess() {
		return ">>> Validateur_de_chariot Management Board";
	}
	@GetMapping("/api/test/responsable_pointage")
	@PreAuthorize("hasRole('RESPONSABLE_POINTAGE') or hasRole('ADMIN')")
	public String Responsable_pointageManagementAccess() {
		return ">>> Responsable_pointage Management Board";
	}
	@GetMapping("/api/test/emballeur")
	@PreAuthorize("hasRole('EMBALLEUR') or hasRole('ADMIN')")
	public String EmballeurManagementAccess() {
		return ">>> Emballeur Management Board";
	}
	@GetMapping("/api/test/expediteur")
	@PreAuthorize("hasRole('EXPEDITEUR') or hasRole('ADMIN')")
	public String ExpediteurManagementAccess() {
		return ">>> Expediteur Management Board";
	}
	@GetMapping("/api/test/agent_saisie_reg")
	@PreAuthorize("hasRole('AGENT_SAISIE_REG') or hasRole('ADMIN')")
	public String Agent_saisie_regManagementAccess() {
		return ">>> Agent_saisie_reg Management Board";
	}
	@GetMapping("/api/test/caissier")
	@PreAuthorize("hasRole('CAISSIER') or hasRole('ADMIN')")
	public String CaissierManagementAccess() {
		return ">>> Caissier Management Board";
	}
	@GetMapping("/api/test/responsable_service_frs_etranger")
	@PreAuthorize("hasRole('RESPONSABLE_SERVICE_FRS_ETRANGER') or hasRole('ADMIN')")
	public String Responsable_service_frs_etrangerManagementAccess() {
		return ">>> Responsable_service_frs_etranger Management Board";
	}
	@GetMapping("/api/test/responsable_service_frs_local")
	@PreAuthorize("hasRole('RESPONSABLE_SERVICE_FRS_LOCAL') or hasRole('ADMIN')")
	public String Responsable_service_frs_localManagementAccess() {
		return ">>> Responsable_service_frs_local Management Board";
	}
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}
}