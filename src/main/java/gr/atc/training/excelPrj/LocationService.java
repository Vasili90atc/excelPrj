package gr.atc.training.excelPrj;

import java.util.ArrayList;
import java.util.List;

public class LocationService {
	List <PrefectureUnit> prefectureUnits;
	List <Municipality> municipalities;
	List <Prefecture> prefectures;
	List <MunicipalityUnit> municipalityUnits;
	
	
	public void setPrefectureUnits(List<PrefectureUnit> prefectureUnits) {
		this.prefectureUnits = prefectureUnits;
	}


	public void setMunicipalities(List<Municipality> municipalities) {
		this.municipalities = municipalities;
	}


	public void setPrefectures(List<Prefecture> prefectures) {
		this.prefectures = prefectures;
	}


	public void setMunicipalityUnits(List<MunicipalityUnit> municipalityUnits) {
		this.municipalityUnits = municipalityUnits;
	}
	

	List<PrefectureUnit> getPrefectureUnitsByPrefecture(String prefectureCode){
		List<PrefectureUnit> returnedPrefUnits = new ArrayList<PrefectureUnit>();
		for (int i=0; i<prefectureUnits.size(); i++) {
			if (prefectureUnits.get(i).getPrefectureCode().equals(prefectureCode)) {
				returnedPrefUnits.add(prefectureUnits.get(i));
			}
		}
		return returnedPrefUnits;
	}

	List<Municipality> getMunicipalitiesByPrefectureUnit(String prefectureUnitCode){
		// Vres tous dimous stous opoious anikei h dimotiki enotita
		List<Prefecture> dimoi_tis_dim_enotitas = new ArrayList<Prefecture>();
		for (int i=0; i<prefectures.size();i++) {
			if (prefectures.get(i).getPrefectureCode().equals(prefectureUnitCode)) {
				dimoi_tis_dim_enotitas.add(prefectures.get(i));
			}
		}
		// Vres tis perifereiakes enotites stis opoies anikoun oi parapano dimoi kai ara i dimotiki enotita pou mas edosan
		List<MunicipalityUnit> perif_enotites_tis_dim_enotitas = new ArrayList<MunicipalityUnit>();
		for (int i=0; i>municipalityUnits.size(); i++) {
			String kodikos_perif_enotitas = municipalityUnits.get(i).getMunicipalityUnitCode();
			for (int j=0; j<dimoi_tis_dim_enotitas.size();j++) {
				String kod_perif_enotitas_tou_dimou = dimoi_tis_dim_enotitas.get(i).getMunicipalityUnitCode();
				if (kodikos_perif_enotitas.equals(kod_perif_enotitas_tou_dimou)) {
					perif_enotites_tis_dim_enotitas.add(municipalityUnits.get(i));
				}
			}
		}
		
		// Vres tis perifereis
		List<Municipality> returnedMunicipalities = new ArrayList<>();
		for (int i=0; i<municipalities.size(); i++) {
			String kod_perif = municipalities.get(i).getCode();
			for (int j=0; j<perif_enotites_tis_dim_enotitas.size(); j++) {
				String kod_perif_periferiakis_enotitas = perif_enotites_tis_dim_enotitas.get(j).getMunicipalityCode();
				if (kod_perif_periferiakis_enotitas.equals(kod_perif)) {
					returnedMunicipalities.add(municipalities.get(i));
				}
			}
		}
		
		return returnedMunicipalities;
	}


	public List<MunicipalityUnit> getMunicipalityUnitsByMunicipality(String municipalityCode) {
		List<MunicipalityUnit> returendMunicipalityUnits= new ArrayList<>();
		for (int i=0; i<municipalityUnits.size(); i++) {
			if (municipalityUnits.get(i).getMunicipalityCode().equals(municipalityCode)) {
				returendMunicipalityUnits.add(municipalityUnits.get(i));
			}
		}
		return returendMunicipalityUnits;
	}
}
