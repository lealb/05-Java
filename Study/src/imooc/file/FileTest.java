package imooc.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * Description: 文件操作主类
 * Version:1.0
 * Created by leal
 * On 17-3-1:下午8:15.
 */
public class FileTest
{
    public static void main(String []args)throws IOException
    {
        FileTest fileTest =new FileTest();
//        fileTest.testEncoding();
        String fileName="1.txt";
//        fileTest.fileCreate(fileName);
        FileUtils fileUtils=new FileUtils();
        fileUtils.printHexByName("/home/leal/IdeaProjects/Study/res/1.txt");
//        try {
//            fileUtils.listDirectory(new File("/home/leal/IdeaProjects/Study"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
       // fileTest.testRandomAccessFile();
    }

    /**
     * 编码测试
     * 编码的字符序列和字符串转换编码须统一，否则乱码
     */
    public void testEncoding()
    {

        //UTF-8编码
        String string="李东岳abcABC";
        byte[] bytes=string.getBytes();//转换为默认编码字节序列
        for (byte b:bytes){
            //十六进制显示
            //UTF-8中文占3个字节 英文占1个字节
            System.out.print(Integer.toHexString(b & 0xff)+" ");//去掉高八位0
        }
        System.out.println("");

        //GBK编码<ANSI>
        //java双字节编码 utf-16be
        try {
            byte[] bytes1=string.getBytes("gbk");
            for (byte b:bytes1){
                //GBK中文占2个字节 英文占1个字节
                System.out.print(Integer.toHexString(b & 0xff)+" ");
            }

            System.out.println("");
            byte[] bytes2=string.getBytes("utf-16be");
            for (byte b:bytes2){
                //GBK中文占2个字节 英文占1个字节
                System.out.print(Integer.toHexString(b & 0xff)+" ");
            }

            System.out.println("");
            //字符序列统一
            System.out.println(new String(bytes2,"utf-16be"));
        }catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }

    }

    /**
     * 文件创建
     */
    public void fileCreate(String fileName){
        //不能写相对路径？
        File directory=new File("/home/leal/IdeaProjects/Study/res");
        if(!directory.exists()){
            directory.mkdir();//单级目录
        }
        File file=new File("/home/leal/IdeaProjects/Study/res",fileName);
        try {
            if(!file.exists()){
                file.createNewFile();
            }else{
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * RandomAccessFile 文件随机读写 访问任意位置
     * 1.java文件，模型(硬盘上文件以byte字节形式存储)
     * 2.rw 读写 r 只读 有文件指针
     * 3.写方法 只写一个字节(后8位),同时指向下一个位置
     * 4.读方法 读一个字节
     * 5.操作完记得关闭
     */
    public void testRandomAccessFile() throws IOException{
        //创建一个文件
        File file=new File("/home/leal/IdeaProjects/Study/res","1.dat");
        if(!file.exists()){
            file.createNewFile();
        }
        //文件操作
        RandomAccessFile raf=new RandomAccessFile(file,"rw");
        //指针的位置
        System.out.println(raf.getFilePointer());
        raf.write('A');//字符一个字节


        //每次只能一个字节,整数分四次
        int i=0x7fffffff;
        raf.write(i>>>24);//高八位
        raf.write(i>>>16);
        raf.write(i>>>8);
        raf.write(i);

        //等同下
        raf.writeInt(i);
        //中文
//        raf.write("我");
        System.out.println(raf.getFilePointer());
        //关闭文件
        raf.close();

    }
}
