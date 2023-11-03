package gr.atc.training.excelPrj;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List <PrefectureUnit> perfUnit;
		List <PrefectureUnit> tempPerfUnit;
		List <Municipality> municip;
		List <Municipality> tempMunicip;
		ReadFromExcel r = new ReadFromExcel("C:\\Users\\ivasili\\eclipse-workspace-new\\douleia\\excelPrj\\src\\main\\java\\excelPrj\\Καλλικρατικές_Δομές.xlsx");
		/*r.readFromSheet(0);
		System.out.println("------------------------------------------------------");
		r.readFromSheet(1);
		System.out.println("------------------------------------------------------");
		r.readFromSheet(2);
		System.out.println("------------------------------------------------------");
		r.readFromSheet(3);*/
		r.readFromSheetPrefecture();
		r.showPrefectures();
		perfUnit=r.readFromSheetPrefectureUnit();
		r.showPrefectureUnits();
		municip = r.readFromSheetMunicipality();
		r.closeFile();
		LocationService lS = new LocationService();
		lS.setPerfUnit(perfUnit);
		lS.setMunicip(municip);
		tempMunicip = lS.getMunicipalityByPrefectureUnit("1004");
		System.out.println("------------------------------------------------------");
		tempPerfUnit = lS.getPrefectureUnitByPrefecture("07");
		for (int i=0; i<tempPerfUnit.size(); i++) {
			System.out.println(tempPerfUnit.get(i).getCode()+"\t"+tempPerfUnit.get(i).getDescription()+"\t"+tempPerfUnit.get(i).getMasterCode());
		}
		System.out.println("------------------------------------------------------");
		for (int i=0; i<tempMunicip.size(); i++) {
			System.out.println(tempMunicip.get(i).getCode()+"\t"+tempMunicip.get(i).getDescription()+"\t"+tempMunicip.get(i).getMasterCode());
		}
		tempMunicip = lS.getMunicipalityByPrefectureUnit("1103");
		System.out.println("------------------------------------------------------");
		for (int i=0; i<tempMunicip.size(); i++) {
			System.out.println(tempMunicip.get(i).getCode()+"\t"+tempMunicip.get(i).getDescription()+"\t"+tempMunicip.get(i).getMasterCode());
		}
		tempMunicip = lS.getMunicipalityByPrefectureUnit("1301");
		System.out.println("------------------------------------------------------");
		for (int i=0; i<tempMunicip.size(); i++) {
			System.out.println(tempMunicip.get(i).getCode()+"\t"+tempMunicip.get(i).getDescription()+"\t"+tempMunicip.get(i).getMasterCode());
		}
	}

}
