package excelPrj;

import java.util.ArrayList;
import java.util.List;

public class LocationService {
	List <PrefectureUnit> perfUnit;
	List <Municipality> municip;
	
	public void setPerfUnit(List<PrefectureUnit> perfUnit) {
		this.perfUnit = perfUnit;
	}


	public void setMunicip(List<Municipality> municip) {
		this.municip = municip;
	}


	List<PrefectureUnit> getPrefectureUnitByPrefecture(String prefectureCode){
		List<PrefectureUnit> tempPerfUnit = new ArrayList<>();
		for (int i=0; i<perfUnit.size(); i++) {
			if (perfUnit.get(i).getMasterCode().equals(prefectureCode)) {
				tempPerfUnit.add(perfUnit.get(i));
			}
		}
		return tempPerfUnit;
	}

	List<Municipality> getMunicipalityByPrefectureUnit(String prefectureUnitCode){
		List<Municipality> tempMunicip= new ArrayList<>();
		for (int i=0; i<municip.size(); i++) {
			if (municip.get(i).getMasterCode().equals(prefectureUnitCode)) {
				tempMunicip.add(municip.get(i));
			}
		}
		return tempMunicip;
	}
}
