package imooc.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description:文件工具类
 * Version:1.0
 * Created by leal
 * On 17-3-1:下午10:18.
 */
public class FileUtils
{
    /**
     * 列出指定目录的文件
     * @param dir
     * @throws IOException
     */
    public  void listDirectory(File dir)throws IOException{
        if(!dir.exists()){
            throw new IllegalArgumentException("目录:"+dir+"不存在.");
        }
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录");
        }
        File[] files=dir.listFiles();//列出当前目录下的子目录和文件
        if (files!=null && files.length>0){
            for (File file:files){
                if(file.isDirectory()){
                    //递归
                    listDirectory(file);
                }else{
                    System.out.println(file);
                }
            }
        }
    }

    /**
     * 读取指定文件名的文件
     * @param fileName 文件名称
     * @throws IOException
     */
    public void printHexByName(String fileName)throws IOException{
        InputStream in=new FileInputStream(fileName);
        //单个存储
        int b;//存储字节
        int i=1;//换行
        while((b=in.read())!=-1){
            if(b<=0xf){
                //补0
                System.out.print(0);
            }
            System.out.print(Integer.toHexString(b)+" ");
            if((i++)%10==0){
                System.out.println();
            }
        }

        //存储字节数组
        byte[]buf=new byte[8*1024];
        //批量读取字节
        int bytes=0;
        int j=1;
        while ((bytes=in.read(buf,0,buf.length))!=-1){
            for (int k=0;k<bytes;k++){
                //避免类型转换错误，清零(int 4字节 byte 1字节)
                System.out.print(Integer.toHexString(buf[k] & 0xff)+" ");
                if(j++%10==0){
                    System.out.println();
                }
            }
        }

        in.close();
    }
}
