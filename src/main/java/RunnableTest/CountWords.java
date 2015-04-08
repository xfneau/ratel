package RunnableTest;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CountWords implements Runnable{

	private FileChannel fc;
	private FileLock fl;
	private MappedByteBuffer mbBuf;
	private HashMap<String,Integer> hm;
	
	public CountWords(File src, long start, long length){
		try {
			//得到当前文件的通道
			fc = new RandomAccessFile(src,"rw").getChannel();
			//锁定当前文件部分
			fl = fc.lock(start, length, false);
			//对当前文件片段简历内存映射，如果文件过大需要切割多个片段
			mbBuf = fc.map(FileChannel.MapMode.READ_WRITE, start, length);
			//创建HashMap存储结果
			hm = new HashMap<String,Integer>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String str = Charset.forName("UTF-8").decode(mbBuf).toString();
//		System.out.println(str);
		//使用StringTokenizer分析单词 
		StringTokenizer token = new StringTokenizer(str);
		String word;
		while( token.hasMoreTokens() ){
			//将处理结果放到一个HashMap中，考虑到存储速度 
			word = token.nextToken();
			if( null != hm.get(word) ){
				hm.put(word, hm.get(word)+1);
			}else{
				hm.put(word, 1);
			}
//			System.out.println(word+":"+hm.get(word));
		}
		try {
			fl.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
	}

	//获取当前执行结果
	public HashMap<String,Integer> getResult(){
		return hm;
	}
	
}
