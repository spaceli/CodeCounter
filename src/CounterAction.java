import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.table.DefaultTableModel;


public class CounterAction {
	
	public List<File> getFiles(File[] files,String suffix){
		List<File> fileList = new ArrayList<File>();
		
		for (File f : files) {
			fileList.addAll(getChild(f,suffix));
		}
		
		return fileList;
	}
	private List<File> getChild(File f,String pattern){
		List<File> fileList = new ArrayList<File>();
		if(!f.isDirectory()){
			if(f.getName().matches(pattern)){
				fileList.add(f);
			}
		}else{
			File[] childs = f.listFiles();
			for(File c : childs){
				fileList.addAll(getChild(c,pattern));
			}
		}
		return fileList;
	}
	
	public void count(List<File> fl,DefaultTableModel singleTableModel,DefaultTableModel totalTableModel){
		Map<String,long[]> eachTypeMap = new HashMap<String, long[]>();
		long[] total = new long[3];

		int fileAmount = 0;
		for(Iterator<File> it = fl.iterator();it.hasNext();){
			fileAmount++;
			long[] eachType = null;
			File f = it.next();
			
			String type = f.getName().substring(f.getName().lastIndexOf(".")+1);
			if((eachType = eachTypeMap.get(type)) == null) {
				eachType = new long[4];
			}
			
			long[] eachFile = parse(f);
			singleTableModel.addRow(new String[]{
					"("+fileAmount+")" + f.getName(),
					Math.round(eachFile[0]/1024.0)+"KB",
					String.valueOf(eachFile[1]),
					String.valueOf(eachFile[2])}
			);
			
			for(int i=0;i<eachFile.length;i++){
				eachType[i] += eachFile[i];
				total[i] += eachFile[i];			
			}
			eachType[3] ++;
			
			eachTypeMap.put(type, eachType);
		}
		
		Set<String> keys = eachTypeMap.keySet();
		for(Iterator<String> it = keys.iterator();it.hasNext();){
			String type = it.next();
			long eachType[] = eachTypeMap.get(type);
			
			totalTableModel.addRow(
					new String[]{type,String.valueOf(eachType[3]),Math.round(eachType[0]/1024.0)+"KB",String.valueOf(eachType[1]),String.valueOf(eachType[2])});
		}
		totalTableModel.addRow(new String[4]);
		
		
//		for(Iterator<File> it = fl.iterator();it.hasNext();){
//			File f = it.next();
//			String newType = f.getName().substring(f.getName().lastIndexOf(".")+1);
//			if((eachType = totalMap.get(newType)) == null) eachType = new long[3];
//			if(!type.equals(newType)){
//				if(!"".equals(type)){
//					totalMap.put(type, eachType);
//					totalTableModel.addRow(
//							new String[]{type,Math.round(eachType[0]/1024.0)+"KB",String.valueOf(eachType[1]),String.valueOf(eachType[2])});
//					for(int i=0;i<total.length;i++){
//						total[i]+=eachType[i];
//						eachType[i]=0;
//					}
//				}
//				type = newType;
//			}
//			
//			long[] a = parse(f);			
//			singleTableModel.addRow(new String[]{
//					f.getName(),Math.round(a[0]/1024.0)+"KB",String.valueOf(a[1]),String.valueOf(a[2])});
//			for(int i=0;i<eachType.length;i++){
//				eachType[i]+=a[i];
//			}
//			
//		}
//		for(int i=0;i<total.length;i++){
//			total[i]+=eachType[i];
//		}
//		if(!"".equals(type)){
//			totalTableModel.addRow(
//					new String[]{type,Math.round(eachType[0]/1024.0)+"KB",String.valueOf(eachType[1]),String.valueOf(eachType[2])});
//			totalTableModel.addRow(new String[4]);
//		}
		totalTableModel.addRow(
				new String[]{"Total:",String.valueOf(fileAmount),Math.round(total[0]/1024.0)+"KB",String.valueOf(total[1]),String.valueOf(total[2])});
	}
	
	public long[] parse(File f){
		long[] a = new long[3];
		a[0] = f.length();
		BufferedReader br = null;
		boolean comment = false;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = "";
			while((line = br.readLine())!=null){
				line=line.trim();
				if(line.startsWith("/*")&&!line.endsWith("*/")){
					a[2]++;
					comment = true;
				}else if(true ==comment){
					a[2]++;
					if(line.endsWith("*/")){
						comment=false;
					}
				}else if(line.startsWith("//")){
					a[2]++;
				}else if(line.startsWith("/*")&&line.endsWith("*/")){
					a[2]++;
				}else if(!"".equals(line)){
					a[1]++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br!=null){
				try{
					br.close();
					br = null;
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return a;
	}
}
