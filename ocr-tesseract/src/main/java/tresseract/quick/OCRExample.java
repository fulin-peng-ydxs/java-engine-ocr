package tresseract.quick;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OCRExample {

    public static void main(String[] args) {
        // 创建 Tesseract OCR 实例
        Tesseract tesseract = new Tesseract();
        // 设置语言数据路径和语言
        tesseract.setDatapath("F:\\Tesserat_OCR\\tessdata"); // 替换为你的 tesseract引擎的数据安装路径
        tesseract.setLanguage("chi_sim+eng"); // 选择语言，如 "chi_sim" (简体中文).

        try {
            File imageFiles = new File("E:\\java-aspose\\src\\main\\resources\\quick");
            for (File file : imageFiles.listFiles()) {
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

}
