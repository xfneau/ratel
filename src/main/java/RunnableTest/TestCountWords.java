package RunnableTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * 统计大文件重读单词数量
 * 
 * @author Administrator
 * 
 */
public class TestCountWords {

	public static void main(String[] args) {

		File file = new File("F:\\123.txt");
		final CountWords cw1 = new CountWords(file, 0, file.length() / 2);
		final CountWords cw2 = new CountWords(file, file.length() / 2, file
				.length() / 2 + 1);
		// System.out.println("fileLength:"+file.length()+"  "+file.length()/2);
		final Thread t1 = new Thread(cw1);
		final Thread t2 = new Thread(cw2);

		t1.start();
		t2.start();

		Thread t = new Thread() {

			public void run() {
				while (true) {
					// 两个线程运行结束
					if (Thread.State.TERMINATED == t1.getState()
							&& Thread.State.TERMINATED == t2.getState()) {
						// 取各自处理结果
						HashMap<String, Integer> map1 = cw1.getResult();

						HashMap<String, Integer> map2 = cw2.getResult();
						// 使用TreeMap保证有序
						TreeMap<String, Integer> tMap = new TreeMap<String, Integer>();
						tMap.putAll(map1);

						// 打印结果
						for (Map.Entry<String, Integer> entry : map2.entrySet()) {
							String key = entry.getKey();
							int value = entry.getValue();
							if (map2.get(key) == null) {
								tMap.put(key, value);
							} else {
								tMap.put(key, tMap.get(key) + value);
							}
						}
						mapToFile(tMap, new File("F:\\1.txt"));
						return;
					}
				}
			}
		};
		t.start();
	}

	private static void mapToFile(Map<String, Integer> src, File dst) {
		try {
			FileWriter fileWriter = new FileWriter(dst, true);
			// 对将要写入的文件通道
			FileChannel fcout = new FileOutputStream(dst).getChannel();
			for (Map.Entry<String, Integer> entry : src.entrySet()) {
				String key = entry.getKey();
				int value = entry.getValue();
				// 将结果按照指定格式放到缓冲区中
				ByteBuffer bBuf = ByteBuffer.wrap((key + "\t" + value + "\r\n")
						.getBytes());
				// fcout.write(bBuf);
				fileWriter.write(key + "\t" + value + "\r\n");
				fileWriter.flush();
				// bBuf.clear();
			}
			fileWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
