package log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		FileReader fileReader = null;
		FileWriter fileWriter = null;
		BufferedReader bufferedRead = null;
		if (args.length > 0 ) {
			File fileW = null;
			File fileR = new File(args[0]);
			if (fileR.exists()) {
				String temp = "", str = "";
				int begin, end;
				try {
					fileW = createFile(args[1]);//创建文件
					if( fileW != null ){
						fileReader = new FileReader(fileR);
						fileWriter = new FileWriter(fileW, true);
						bufferedRead = new BufferedReader(fileReader);
						while ( (temp = bufferedRead.readLine()) != null ) {
							begin = temp.indexOf("channelid\001");
							end = temp.lastIndexOf("\002");
							str = temp.substring(begin, end);
							System.out.println("str:"+str);
							fileWriter.write(temp.substring(0, begin)+str.replaceAll("/", "")+temp.substring(end, temp.length()));
							fileWriter.flush();
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
					try {
						fileReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						bufferedRead.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						fileWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}
	
	public static File createFile( String path ) throws IOException{
		if( path.contains("\\") ){
			int index = path.lastIndexOf("/");
			String dir = path.substring(0, index);
			File fileDir = new File(dir);
	        fileDir.mkdirs();
		}
        File fileW = new File(path);
        fileW.createNewFile();
        return fileW;
	}

}
