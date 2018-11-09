package com.vims.rs.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustIdGenerator {

	public static int i=1;
	public static String sequenceGenerator(){
		FileReader fr=null;
		FileWriter fw=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		File f=new File("src/customerid.txt");
		try {
			 fr=new FileReader(f);
			 br=new BufferedReader(fr);
			 i=br.read();
			if(i==-1){
				i=1;
			}else{
				i++;
			}
		} catch (IOException e1) {
			System.out.println("file reader exception");
		}
		try {
			 fw=new FileWriter(f);
			 bw=new BufferedWriter(fw);
			 bw.write(i);
		} catch (IOException e) {
			System.out.println("file writer excpetion");
		}
		finally{try {
					br.close();bw.close();
				
			} catch (IOException e) {
				System.out.println("finally exception");
			}}
		
		Date d1=new Date();
		Calendar cal=Calendar.getInstance();
		cal.setTime(d1);
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String s=df.format(d1);
		
		String id1=Integer.toString(i);
		String split[]=s.split("-");
		StringBuffer sb=new StringBuffer();
		sb.append(split[0]);
		sb.append(split[1]);
		if(id1.length()==1){
			sb.append("000");
			sb.append(id1);
		}else if(id1.length()==2){
			sb.append("00");
			sb.append(id1);
		}else if(id1.length()==3){
			sb.append("0");
			sb.append(id1);
		}else if(id1.length()==4){
			sb.append(id1);
		}
		
		//System.out.println(i);
		return(sb.toString());
	}
}
