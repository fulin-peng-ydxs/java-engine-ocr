package tresseract.quick;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OCRExample {

    public static void main(String[] args) {
        // 创建 Tesseract OCR 实例
        Tesseract tesseract = new Tesseract();
        // 设置语言数据路径和语言
        tesseract.setDatapath("F:\\Tesserat_OCR\\tessdata"); // 替换为你的 tesseract引擎的数据安装路径
        tesseract.setLanguage("chi_sim+eng"); // 选择语言，如 "chi_sim" (简体中文).

        try {
            List<File> files = getFilesByNameSort("E:\\java-aspose\\src\\main\\resources\\quick",false);
            for (File file : files) {
                if (file.getName().contains(".jpg")) {
                    String result = tesseract.doOCR(file);
                    System.out.println("识别结果: "+file.getName());
                    System.out.println(result+"\n");
                }
            }
        } catch (TesseractException e) {
            System.err.println("识别失败: " + e.getMessage());
        }
    }

    /**
     * 获取目录文件集: 根据文件名排序
     * @param path 目录路径
     * @param reversed 是否倒序
     * 2024/12/6 上午9:43
     * @author fulin-peng
     */
    public static List<File> getFilesByNameSort(String path,boolean reversed){
        List<File> files = getFiles(path);
        //根据名称排序
        if(files!=null){
            Comparator<File> comparing = Comparator.comparing(File::getName);
            files.sort(reversed?comparing.reversed():comparing);
        }
        return files;
    }

    /**
     * 获取目录文件集
     * 2024/12/6 上午9:43
     * @author fulin-peng
     */
    public static List<File> getFiles(String path){
        File file = new File(path);
        if(!file.exists())
            return null;
        File[] files = file.listFiles();
        return files==null?null: Arrays.asList(files);
    }

}
