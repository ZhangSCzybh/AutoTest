package com.yolocast.qa.zsc.others;

import java.io.*;
import java.util.Scanner;

/**
 * @author zhangsc
 * @date 2022-07-06 上午11:14
 */
public class ExtractFieldValues {

    public static String oldFile = "/Users/zhangshichao/Downloads/stream_log/2022070517-stream-pull-test.yololiv.com";
    public static String newFile = "/Users/zhangshichao/Downloads/stream_log/streamfilter.txt";

    public static String m3u8File = "/Users/zhangshichao/Downloads/stream_log/m3u8filter.txt";
    public static String m3u8FileData = "/Users/zhangshichao/Downloads/stream_log/m3u8data.txt";
    public static String tsFile = "/Users/zhangshichao/Downloads/stream_log/tsfilter.txt";
    public static String tsFileData = "/Users/zhangshichao/Downloads/stream_log/tsdata.txt";

    public static void main(String[] args) throws IOException {
        //根据流id 查询数据 908224694543454209
        streamFileter();

        //根据m3u8/ts格式统计数据
        //fileterData();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(tsFile), "GB2312"));
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(m3u8File), "GB2312"));
        BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream(newFile), "GB2312"));

        System.out.print("选择需要计算流量的类型:" + "ts格式输入:1 || m3u8flv格式输入:2 ||总流量输入：3 -->请输入：");
        int streamType = (new Scanner(System.in)).nextInt();

        switch (streamType){
            case 1:
                String line = "";
                int sum = 0;
                while(line != null){
                    line = bufferedReader.readLine();
                    //split返回的是一个数组，将line 切割传给每个数组下标
                    String pp [] = new String[5];
                    //这里注意split会空指针异常，这里得加个判断
                    if(line ==null ){
                        break;
                    }
                    pp = line.split(" ");
                    //Integer包装类，将split返回的数组pp[5]
                    System.out.println("ts流量：" + pp[4].substring(0));
                    Integer year = Integer.valueOf(pp[4].substring(0));

                    sum += year.intValue();
                }
                System.out.println("ts流量总和:"+sum);
                break;

            case 2:
                String line1 = "";
                int m3u8Sum = 0;
                while(line1 != null){
                    line1 = bufferedReader2.readLine();
                    //split返回的是一个数组，将line 切割传给每个数组下标
                    String pp [] = new String[5];
                    //这里注意split会空指针异常，这里得加个判断
                    if(line1 ==null ){
                        break;
                    }
                    pp = line1.split(" ");
                    //Integer包装类，将split返回的数组pp[5]
                    System.out.println("m3u8&flv流量：" + pp[4].substring(0));
                    Integer year = Integer.valueOf(pp[4].substring(0));
                    m3u8Sum += year.intValue();
                }
                System.out.println("m3u8&flv流量总和:"+m3u8Sum);
                break;

            case 3:
                String line3 = "";
                int Sum = 0;
                while(line3 != null){
                    line3 = bufferedReader3.readLine();
                    //split返回的是一个数组，将line 切割传给每个数组下标
                    String pp [] = new String[5];
                    //这里注意split会空指针异常，这里得加个判断
                    if(line3 ==null ){
                        break;
                    }
                    pp = line3.split(" ");
                    //Integer包装类，将split返回的数组pp[5]
                    System.out.println("所有流量：" + pp[4].substring(0));
                    Integer year = Integer.valueOf(pp[4].substring(0));
                    Sum += year.intValue();
                }
                System.out.println("所有流量总和:"+Sum);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + streamType);
        }

        bufferedReader.close();
        bufferedReader2.close();

        }



    public static void streamFileter() throws IOException {
        System.out.print("输入流id：");
        String str = (new Scanner(System.in)).next();

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(oldFile), "utf-8"));
        BufferedWriter ou = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "utf-8"));

        BufferedReader in1 = new BufferedReader(new InputStreamReader(new FileInputStream(newFile), "utf-8"));
        BufferedWriter ou1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tsFile), "utf-8"));

        BufferedReader in2 = new BufferedReader(new InputStreamReader(new FileInputStream(newFile), "utf-8"));
        BufferedWriter ou2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(m3u8File), "utf-8"));

        String line;
        while ((line = in.readLine()) != null) {
            if (line.indexOf(str) > 0) {
                ou.write(line + "\n");
            }
        }
        in.close();
        ou.close();
        System.out.println("streamfilter筛选成功！");

        System.out.print("选择需要筛选的格式：ts格式输入:txspiseq ｜｜ m3u8、flv格式输入:txSecret ｜｜ 所有格式输入任意回车！ -->请输入：");
        String streamType = (new Scanner(System.in)).next();

        switch (streamType){
            case "txspiseq":
                while ((line = in1.readLine()) != null) {
                    if (line.indexOf(streamType) > 0) {
                        ou1.write(line + "\n");
                    }
                }
                in1.close();
                ou1.close();
                System.out.println("ts文件筛选成功");
                break;

            case "txSecret":
                while ((line = in2.readLine()) != null) {
                    if (line.indexOf(streamType) > 0) {
                        ou2.write(line + "\n");
                    }
                }
                in2.close();
                ou2.close();
                System.out.println("m3u8文件筛选成功");
                break;
            default:

        }

    }

    public static void fileterData(){

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(m3u8File), "GB2312"));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(tsFile), "GB2312"));

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(m3u8FileData), "GB2312"));
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tsFileData), "GB2312"));

            StringBuffer sb = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();

            String b = "";
            String b2 = "";

            String key = "txTime=";
            String key2 = "txspiseq=";
            try {
                while ((b = br.readLine()) != null ) {
                    sb.append(b);
                    String strOld = sb.toString();
                    //截取从每行起始位置到结束标识的字符串
                    String m3u8flv = strOld.substring(strOld.indexOf(key) + key.length(), strOld.length());
                    String m3u8flvStreamData = m3u8flv.substring(8, m3u8flv.indexOf("\""));
                    System.out.println(m3u8flvStreamData);
                    bw.write(m3u8flvStreamData + "\n");
                    //清空数据
                    //sb.delete(0, sb.length());
                }
                while ((b2 = br2.readLine()) != null ) {
                    sb2.append(b2);
                    String strOld2 = sb2.toString();
                    //截取从每行起始位置到结束标识的字符串
                    String ts = strOld2.substring(strOld2.indexOf(key2) + key2.length(), strOld2.length());
                    String tsStreamData = ts.substring(21, ts.indexOf("\""));
                    System.out.println(tsStreamData);
                    bw2.write(tsStreamData + "\n");
                    //清空数据
                    //sb2.delete(0, sb2.length());
                }
                bw.flush();
                bw2.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
                br2.close();
                bw.close();
                bw2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
