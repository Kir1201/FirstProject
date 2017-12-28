import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Analyzer {
	public static void main(String[] args) {
		String file = "./src/essay.txt";
		String essay = readFile(file);
		String con = "[^a-zA-Z]+";
//		Pattern p = Pattern.compile(word);
		String test = "abel,kir,pistachio";
		essay = essay.toLowerCase();
		String[] fre = essay.split(con);
		HashMap<String,Integer> map = new HashMap();
		for (String a : fre) {
			if(map.containsKey(a)) {
				int value = map.get(a);				
				map.replace(a, ++value);
			}else {
				map.put(a, 1);
			}
		}
		System.out.println(map);
	}

	public static String readFile(String filename) {
		String s = null;
		StringBuffer sb = new StringBuffer();
		File f = new File(filename);
		if (f.exists()) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				while ((s = br.readLine()) != null) {
					sb.append(s);
					// sb.append("\n");
				}
				br.close();
				// System.out.println(sb);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("file does not exist!");
		}
		return sb.toString();
	}
	// System.out.println(sb);
	// String[] strs = sb.toString().split("\n");
	// char[][] maze = new char[strs.length][];
	// for (int i = 0; i < maze.length; i++) {
	// maze[i] = strs[i].toCharArray();
	// }
	// return maze;
	// }
	
	
}
