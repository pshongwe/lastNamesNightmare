package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static StringBuffer sbword = new StringBuffer();
	static String sb = new String();

	private static void writeToFile(String filename) throws IOException{
		try{
			File file1 = new File(filename);
			BufferedWriter bufwriter = new BufferedWriter(new FileWriter(file1));
			bufwriter.write(sbword.toString());
			bufwriter.close();

		}catch(Exception e){
			System.out.println("Error occurred while attempting to write to file: " +     e.getMessage());
		}

	}

	public static void main(String[] args) throws IOException {

		File [] files = new File("file/").listFiles();
		for(File file : files){
			readFile("file/"+file.getName()); 
			writeToFile("output/"+file.getName());
			sbword.setLength(0);
			sb = "";
		}

	}

	private static void readFile(String filename) throws IOException {
		BufferedReader br;
		String line;
		
		int fileLength = MyFileReader.fileLength(filename);


		try {
			br = new BufferedReader(new FileReader(filename));
			
			
			sbword.setLength(0);
			for(int i = 0; i < fileLength-1; i++){

				line = br.readLine();
				
				Pattern surname = Pattern.compile("(NTSHANGASE|NDZABANDZABA|NDABANDABA|BHEMBE|MAMBA|DLAMINI|LUKHELE|BORDIHN|ZIKALALA|CINDZI|SHIBA|DLADLA|DLUDLU|DUBE|DE BEER|FAKUDZE|MANGWE|GINA|GININDZA|GROENING|NGWENYA|GULE|GUMBI|HLATSHWAYO|KHUMALO|HLOPHE|ZWANE|KHANYILE|KHUMALO|KUNENE|SHONGWE|NKAMBULE|MALINGA|MSIBI|MABELESA|MABUZA|MADAU|MAGAGULA|MTHEMBU|MAGWAGWA|MAKHANYA|MAKHUBU|MANYATSI|MANZINI|MASEKO|MAVIMBELA|MAVUSO|MBULI|MDLULI|MDZINISO|METHULA|MGABHI|MHLANGA|MKHATSHWA|MKHABELA|MKHIZE|MKHONTA|MKHWANAZI|MNISI|MOKOENA|MOROLONG|MOTSA|MTHETHWA|MWELI|GUMBI|SIBANDZE|NDABA|NDLOVU|NDZIMANDZE|MSANE|NGUBENI|NGUBANE|NGWENYA|NHLAPHO|NHLENGETHWA|NKABINDE|NKOMO|NKWANYANA|NSIBANDE|NTJALINTJALI|NTJAKALA|NTSHAKALA|NXUMALO|NZIMA|SHABANGU|MURAWU|RADEBE|SEYAMA|SIBANYONI|SIBEKO|SIMELANE|MTHANDENI|DANIELS|TSABEDZE|TSELA|TSHABALALA|VILAKATI|VILANE|MADZINANE|NTSHALINTSHALI|ZIKALALA|ZWANE|FUNDZA|SIFUNDZA|GAMA|GININDZA|GULE|GWEBU|HLATSHWAKO|MATSEBULA|MAZIBUKO|MKHALIPHI|NDLANGAMANDLA|NDWANDWA|NDWANDWE|NHLABATSI|SHABALALA|XABA|SINKALA|GAMEDZE|GULE|HOWE|LUSHABA|MABASO|MADONSELA|MAFU|MATHONSI|MAKHATHINI|MANANA|MAPHALALA|MASONDO|MBUYISA|MNGOMEZULU|MTHUNZI|NGQOTHENI|NHLENGETHWA|MDLOVU|SIKHONDZE|SITHEBE|THRING|THWALA|ZONDO|DVUBA|HODGSON|LANGA|MALINDZISA|MACWELE|MAGONGO|MASANGANE|MASUKU|MATFUNYWA|MAZIYA|CHANG|MLOBOKAZANA|MNDZEBELE|MVUBU|NENE|NTIWANE|SACOLO|NDZABUKELWAKO|TFWALA|YENDE|AZANI|VRIEND|BANDA|ARVIN|BROSSY|LEIGH-POTGITER|BEZUIDENHOUT|BOSHOFF|BOSMAN|BROADWELL|BROOKSIDE|BUDD|BULAWAKO|CARMICHAEL|CARRINGTON|LYNETTE|CHIYA|COOKE|CUNNINGHAM|DHLAMINI|DU PLESSIS|DU PONT|GELDARD|WITBOOI|GEORGE|WILSON|JOHNSTON|JOSEPH|KATAMUZI|KABUYA|KHUMBANI|KUBHEKA|LITTLER|LORENTZ|MABILA|MALAZA|UYS|MATSE|MAYISELA|McHARDY|MCHUNU|MCLEOD|MHLONGO|MKHONTA|MKHIZE|MKOKO|MMEMA|MNDENI|MOORE|NKWENYANA|MSIMANGO|MTHOMBO|MUSHALA|MZILENI|SPANGENBERG|NKOMONYE|NKUMANE|MATHUNJWA|MATSENJWA|NYANDZA|SYLVIA|PATEL|REEZA|REILLY|SMITH|SUKATI|MATHE|NGCAMPHALALA|STEENKAMP|NERVES|HLATJWAKO|JELE|MLANGENI|LANGWENYA|MBHAMALI|LITCHFIELD|MABILISA|MADONDO|MAGWAZA|NUNES|MAPHANGA|THUMBELA|MOHALE|MORRIS|MNTAMBO|MTHUPHA|NDLELA|NGOZO|NTSANGASE|MAGWENYA|SIBIYA|ADAMS)");
				Matcher smatch = surname.matcher(line);
				
				if(smatch.find()){
					
					
					line = line.replaceAll(surname.toString(), "");
					sb += smatch.group(1)+" "+line+"\r\n";
				}
				else{
					//System.out.println(smatch.group(1)+smatch.group(2)+smatch.group(3));
					sb += line+"\r\n";
				}
				
			}
			sbword.append(sb);
			
			br.close();
			
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("File not found");
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}

	}



}
